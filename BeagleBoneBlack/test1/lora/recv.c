#include <stdio.h>
#include <string.h>

// Linux headers
#include <fcntl.h> // Contains file controls like O_RDWR
#include <errno.h> // Error integer and strerror() function
#include <termios.h> // Contains POSIX terminal control definitions
#include <unistd.h> // write(), read(), close()

#include <lgpio.h>

#include "MQTTClient.h"

#define ADDRESS     "tcp://192.168.0.108:1883"
#define CLIENTID    "ExampleClientPub"
#define TOPIC       "test"
#define PAYLOAD     "Hello World!"
#define QOS         2
#define TIMEOUT     10000L

#define IN 20
#define E61_M0 4
#define E61_M1 5
#define ALERT 46

MQTTClient client;
MQTTClient_connectOptions conn_opts = MQTTClient_connectOptions_initializer;
MQTTClient_message pubmsg = MQTTClient_message_initializer;
MQTTClient_deliveryToken token;

uint8_t cmd_readParam[]={0xC1,0xC1,0xC1};
uint8_t cmd_readVerParam[]={0xC3,0xC3,0xC3};
uint8_t cmd_writeParam[]={0xC0,0x01,0x00,0x1B,0x06,0x44};

int connectMQTT()
{

   /* MQTTClient client;
    MQTTClient_connectOptions conn_opts = MQTTClient_connectOptions_initializer;
    MQTTClient_message pubmsg = MQTTClient_message_initializer;
    MQTTClient_deliveryToken token;*/
    int rc;

    MQTTClient_create(&client, ADDRESS, CLIENTID, MQTTCLIENT_PERSISTENCE_NONE, NULL);
    conn_opts.keepAliveInterval = 20;
    conn_opts.cleansession = 1;

    if ((rc = MQTTClient_connect(client, &conn_opts)) != MQTTCLIENT_SUCCESS)
    {
        printf("Failed to connect, return code %d\n", rc);
       // exit(-1);
	return -1;
    }
   return 0;
}

void publishMQTT(char read_buf[])
{
    int rc;
    pubmsg.payload = read_buf;
    pubmsg.payloadlen = strlen(read_buf);
    pubmsg.qos = QOS;
    pubmsg.retained = 0;
    MQTTClient_publishMessage(client, TOPIC, &pubmsg, &token);
  //  printf("Waiting for up to %d seconds for publication of %s\non topic %s for client with ClientID: %s\n", (int)(TIMEOUT/1000), PAYLOAD, TOPIC, CLIENTID);
    rc = MQTTClient_waitForCompletion(client, token, TIMEOUT);
   // printf("Message with delivery token %d delivered\n", token);
   // MQTTClient_disconnect(client, 10000);
   // MQTTClient_destroy(&client);
}


void disconnectMQTT()
{
MQTTClient_disconnect(client, 10000);
MQTTClient_destroy(&client);
}

void setOutputGPIO(int h, int lFlags){
   
     lgGpioClaimOutput(h, lFlags,E61_M0, 0); /* initial level 0 */
     lgGpioClaimOutput(h, lFlags, E61_M1, 0); /* initial level 0 */
}

void sleepMode(int h){
     lgGpioWrite(h, E61_M0, 1);
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


int main(int argc, char *argv[])
{
   int h;
   int lFlags = 0; /* default line flags */

   /* get a handle to the GPIO */
   h = lgGpiochipOpen(0);

  setOutputGPIO(h, lFlags);

   sleepMode(h);

   char loraRSerialPort[] ="/dev/ttyO2";

   int lora_r_serial_port = connectSerial(loraRSerialPort,O_RDWR);

   if(lora_r_serial_port!=1)
     {
        write(lora_r_serial_port, cmd_writeParam, sizeof(cmd_writeParam));	
        lguSleep(0.5);

         read_serial(lora_r_serial_port, 0);
         printf("\n");

       write(lora_r_serial_port, cmd_readVerParam, sizeof(cmd_readVerParam));     
        lguSleep(0.5);

    int flagV = read_serial(lora_r_serial_port, 1);
    printf("flagV=%02x \n",flagV);


     // write(lora_r_serial_port, cmd_readParam, sizeof(cmd_readParam));
       // lguSleep(0.5);

     // read_serial(lora_r_serial_port, 0);
   //      printf("\n");


     if(flagV==69)
	{
	 normalMode(h);

   int v=-1;
	v = lgGpioRead(h,E61_M0);

	printf("GPIO%d is %d now \n",E61_M0, v);


        v=-1;
        v = lgGpioRead(h,E61_M1);

        printf("GPIO%d is %d now \n",E61_M1, v);


   if(connectMQTT()==0)
    {
       // unsigned char read_buf [1024];
       // memset(&read_buf, '\0', sizeof(read_buf));

        int num_bytes=0;

//	char ms[]="hello123";

  printf("Before While\n");

        unsigned char read_buf [66];
        memset(&read_buf, '\0', sizeof(read_buf));

         while(1) // Receiving Data from LORA
         {

	       // printf("Start");
                num_bytes=read(lora_r_serial_port, &read_buf, sizeof(read_buf));
               // write(lora_r_serial_port, read_buf, num_bytes);
		//int i=0;
		/*for(i=0;i<num_bytes;i++)
		   {
			printf("%c\n",read_buf[i]);

                   }*/
		//fflush(stdout);
              if(num_bytes>0){
		//publishMQTT(read_buf);
               // fflush(stdout);
       		printf("%s\n",read_buf);
             // fflush(stdout);
               // publishMQTT(read_buf);
                memset(&read_buf, '\0', sizeof(read_buf));
                }

	        lguSleep(1.0);
 		// write(lora_r_serial_port, ms , sizeof(ms));
           // printf("end\n");
               // memset(&read_buf, '\0', sizeof(read_buf));
          }
          close(lora_r_serial_port);

          printf("Port Closed\n");

	//  disconnectMQTT();

	  printf("MQTT Disconnected\n");
        }
     }

    }
}

int main123456(int argc, char *argv[])
{

  if(connectMQTT()==0)
    {
        unsigned char read_buf[]="Hello World!";

      int i=0;

         while(i<50) // Receiving Data from LORA
         {
                publishMQTT(read_buf);
		i++;
          }

          printf("Port Closed\n");

          disconnectMQTT();

          printf("MQTT Disconnected\n");
     }
}


