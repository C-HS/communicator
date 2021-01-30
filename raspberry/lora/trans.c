#include <stdio.h>
#include <string.h>

// Linux headers
#include <fcntl.h> // Contains file controls like O_RDWR
#include <errno.h> // Error integer and strerror() function
#include <termios.h> // Contains POSIX terminal control definitions
#include <unistd.h> // write(), read(), close()

#include <lgpio.h>

//#include <sys/file.h>
//#include <pthread.h>

#define IN 20
#define E61_M0 13
#define E61_M1 19
#define ALERT 23

uint8_t cmd_readParam[]={0xC1,0xC1,0xC1};
uint8_t cmd_readVerParam[]={0xC3,0xC3,0xC3};
uint8_t cmd_writeParam[]={0xC0,0x00,0x00,0x18,0x50,0x50};


void setOutputGPIO(int h, int lFlags){
   
     lgGpioClaimOutput(h, lFlags,E61_M0, 0); /* initial level 0 */
     lgGpioClaimOutput(h, lFlags, E61_M1, 0); /* initial level 0 */
}

void commandMode(int h){
     lgGpioWrite(h, E61_M0, 0);
     lgGpioWrite(h, E61_M1, 1);

     lguSleep(4);
}

void normalMode(int h){

     lgGpioWrite(h, E61_M0, 0);
     lgGpioWrite(h, E61_M1, 0); 
     lguSleep(4);
}

int connectSerial(char *port, int mode)
{

 // int serial_port = open("/dev/ttyUSB0", O_RDWR);

 int serial_port = open(port, mode);


  // Create new termios struc, we call it 'tty' for convention
  struct termios tty;

  // Read in existing settings, and handle any error
  if(tcgetattr(serial_port, &tty) != 0) {
      printf("Error %i from tcgetattr: %s\n", errno, strerror(errno));
      return 1;
  }

  tty.c_cflag &= ~PARENB; // Clear parity bit, disabling parity (most common)
  tty.c_cflag &= ~CSTOPB; // Clear stop field, only one stop bit used in communication (most common)
  tty.c_cflag &= ~CSIZE; // Clear all bits that set the data size 
  tty.c_cflag |= CS8; // 8 bits per byte (most common)
  tty.c_cflag &= ~CRTSCTS; // Disable RTS/CTS hardware flow control (most common)
  tty.c_cflag |= CREAD | CLOCAL; // Turn on READ & ignore ctrl lines (CLOCAL = 1)

  tty.c_lflag &= ~ICANON;
  tty.c_lflag &= ~ECHO; // Disable echo
  tty.c_lflag &= ~ECHOE; // Disable erasure
  tty.c_lflag &= ~ECHONL; // Disable new-line echo
  tty.c_lflag &= ~ISIG; // Disable interpretation of INTR, QUIT and SUSP
  tty.c_iflag &= ~(IXON | IXOFF | IXANY); // Turn off s/w flow ctrl
  tty.c_iflag &= ~(IGNBRK|BRKINT|PARMRK|ISTRIP|INLCR|IGNCR|ICRNL); // Disable any special handling of received bytes

  tty.c_oflag &= ~OPOST; // Prevent special interpretation of output bytes (e.g. newline chars)
  tty.c_oflag &= ~ONLCR; // Prevent conversion of newline to carriage return/line feed
  // tty.c_oflag &= ~OXTABS; // Prevent conversion of tabs to spaces (NOT PRESENT ON LINUX)
  // tty.c_oflag &= ~ONOEOT; // Prevent removal of C-d chars (0x004) in output (NOT PRESENT ON LINUX)

  tty.c_cc[VTIME] = 10;    // Wait for up to 1s (10 deciseconds), returning as soon as any data is received.
  tty.c_cc[VMIN] = 0;

  // Set in/out baud rate to be 9600
  cfsetispeed(&tty, B9600);
  cfsetospeed(&tty, B9600);

  // Save tty settings, also checking for error
  if (tcsetattr(serial_port, TCSANOW, &tty) != 0) {
      printf("Error %i from tcsetattr: %s\n", errno, strerror(errno));
      return 1;
  }

  return serial_port;
}


  int read_serial(int serial_port, int test)
  {
        char read_buf [1];      

     int num_bytes=0;

     int flagV=0;

    int count=0;

    while((num_bytes=read(serial_port, &read_buf, sizeof(read_buf)))>0)
         {
           int i=0;
           for(i=0; i<num_bytes;i++)
           {
             if(count==1 && test==1)
	      {
		printf("%02x", read_buf[i]);
   		flagV=read_buf[i];
              }
             else
             {
		printf("%02x", read_buf[i]);
             }
           }
           memset(&read_buf, '\0', sizeof(read_buf));
	  count++;
         }

      return flagV;
  }

/*
int set_interface_attribs (int fd, int speed, int parity)
{
        struct termios tty;
        if (tcgetattr (fd, &tty) != 0)
        {
                printf("error %d from tcgetattr", errno);
                return -1;
        }

        cfsetospeed (&tty, speed);
        cfsetispeed (&tty, speed);

        tty.c_cflag = (tty.c_cflag & ~CSIZE) | CS8;     // 8-bit chars
        // disable IGNBRK for mismatched speed tests; otherwise receive break
        // as \000 chars
        tty.c_iflag &= ~IGNBRK;         // disable break processing
        tty.c_lflag = 0;                // no signaling chars, no echo,
                                        // no canonical processing
        tty.c_oflag = 0;                // no remapping, no delays
        tty.c_cc[VMIN]  = 0;            // read doesn't block
        tty.c_cc[VTIME] = 5;            // 0.5 seconds read timeout

        tty.c_iflag &= ~(IXON | IXOFF | IXANY); // shut off xon/xoff ctrl

        tty.c_cflag |= (CLOCAL | CREAD);// ignore modem controls,
                                        // enable reading
        tty.c_cflag &= ~(PARENB | PARODD);      // shut off parity
        tty.c_cflag |= parity;
        tty.c_cflag &= ~CSTOPB;
        tty.c_cflag &= ~CRTSCTS;

        if (tcsetattr (fd, TCSANOW, &tty) != 0)
        {
                printf("error %d from tcsetattr", errno);
                return -1;
        }
        return 0;
}


void set_blocking (int fd, int should_block)
{
        struct termios tty;
        memset (&tty, 0, sizeof tty);
        if (tcgetattr (fd, &tty) != 0)
        {
                printf("error %d from tggetattr", errno);
                return;
        }

        tty.c_cc[VMIN]  = should_block ? 1 : 0;
        tty.c_cc[VTIME] = 5;            // 0.5 seconds read timeout

        if (tcsetattr (fd, TCSANOW, &tty) != 0)
                printf("error %d setting term attributes", errno);
}*/


int lora_t_serial_port;
int rtk_r_serial_port;
unsigned char read_buf1[]="HELLO From Raspberry";
/*
void *readFromRTK(void *vargp)
{

  unsigned char read_buf [1024];
  memset(&read_buf, '\0', sizeof(read_buf));
   int num_bytes=0;

  int i=0;
    while(1) // Receiving Data from RTK
         {
            num_bytes=read(rtk_r_serial_port, &read_buf, sizeof(read_buf));
            i=0;
            for(i=0;i<num_bytes;i++ )
             {
                printf(" %02x", read_buf[i]);
              }
	    memset(&read_buf, '\0', sizeof(read_buf));
         }
  //  return NULL;
   pthread_exit(NULL);
}
*/
/*
void *writeToLORA(void *vargp)
{
  int i=0;
 for(i=0;i<100;i++)
 {
  write(lora_t_serial_port, read_buf1, sizeof(read_buf1));
 }
  //  return NULL;
   pthread_exit(NULL);
}*/



int main(int argc, char *argv[])
{
   int h;
   int lFlags = 0; /* default line flags */

   /* get a handle to the GPIO */
   h = lgGpiochipOpen(0);

   setOutputGPIO(h, lFlags);

   commandMode(h);

    char rtkRSerialPort[] ="/dev/ttyUSB2";

    int rtk_r_serial_port = connectSerial(rtkRSerialPort,O_RDONLY);

   char loraTSerialPort[] ="/dev/ttyUSB1";


   int lora_t_serial_port = connectSerial(loraTSerialPort, O_RDWR);

   if(rtk_r_serial_port!=1 && lora_t_serial_port!=1)
     {

        write(lora_t_serial_port, cmd_writeParam, sizeof(cmd_writeParam));
        lguSleep(0.5);

         read_serial(lora_t_serial_port, 0);
         printf("\n");

         write(lora_t_serial_port, cmd_readVerParam, sizeof(cmd_readVerParam));
        lguSleep(0.5);

        int flagV = read_serial(lora_t_serial_port, 1);
        printf("flagV=%02x \n",flagV);


        write(lora_t_serial_port, cmd_readParam, sizeof(cmd_readParam));
         lguSleep(0.5);

       read_serial(lora_t_serial_port, 0);
        printf("\n");


     if(flagV==97)
	{
	 normalMode(h);

   int v=-1;
	v = lgGpioRead(h,E61_M0);

	printf("GPIO%d is %d now \n",E61_M0, v);


        v=-1;
        v = lgGpioRead(h,E61_M1);

        printf("GPIO%d is %d now \n",E61_M1, v);


	 // char rtkRSerialPort[] ="/dev/ttyUSB1";

        // int rtk_r_serial_port = connectSerial(rtkRSerialPort,O_RDONLY);

        // printf("start rtk_r_serial_port= %d",rtk_r_serial_port );
  	// if(rtk_r_serial_port!=1)
	   //{
		//printf("rtk_r_serial_port= %d",rtk_r_serial_port 


              // unsigned char read_buf [1]={'0'};
  unsigned char read_buf [1024];
  memset(&read_buf, '\0', sizeof(read_buf));
//close(lora_t_serial_port);
//lora_t_serial_port = connectSerial(loraTSerialPort,O_WRONLY);

   // unsigned char read_buf [2]={'0','0'};

//unsigned char read_buf1[]="HELLO From Raspberry";

   int num_bytes=0;

//unsigned char test[] ="ABC";


//pthread_t writeThread;

// pthread_create(&readThread, NULL, readFromRTK, (void *)1);
// pthread_create(&writeThread, NULL, writeToLORA, NULL);
// pthread_join(readThread, NULL);
// pthread_join(writeThread, NULL);

    while(1) // Receiving Data from RTK
      {
 // int i=0;
       // for(i=0;i<100;i++) 
       //{

	   //write(lora_t_serial_port, read_buf1, sizeof(read_buf1));
           // printf("send");
            num_bytes=read(rtk_r_serial_port, &read_buf, sizeof(read_buf));
             // unsigned char write_buf [num_bytes];
             // memset(&write_buf, '\0', sizeof(write_buf));
            int i=0;
            for(i=0;i<num_bytes;i++ )
             {
                printf(" %02x", read_buf[i]);
	       // write(lora_t_serial_port, read_buf, num_bytes);
                //write_buf[i]=read_buf[i];
              }
		//write(lora_t_serial_port, read_buf, sizeof(read_buf));
              if(num_bytes>0)
                {
		//pthread_create(&thread1, NULL, myThread1, (void *)1);
		//pthread_join(thread1, NULL);
		//write(lora_t_serial_port, read_buf1, sizeof(read_buf1));
              // lguSleep(0.5);
               // read(lora_t_serial_port, &test, sizeof(test));
                 write(rtk_r_serial_port, read_buf1, sizeof(read_buf1));
                memset(&read_buf, '\0', sizeof(read_buf));
		}
	//	printf("numbytes=%d \n",num_bytes);

	//	memset(&write_buf, '\0', sizeof(write_buf));
	     // lguSleep(5);
		//usleep(1000);
		//fflush(stdout);
		//fflush(stdin);

          }
          close(lora_t_serial_port);
          close(rtk_r_serial_port);

	  printf("Port Closed");
	}
     }
}

