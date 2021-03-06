// C library headers
#include <stdio.h>
#include <string.h>

// Linux headers
#include <fcntl.h> // Contains file controls like O_RDWR
#include <errno.h> // Error integer and strerror() function
#include <termios.h> // Contains POSIX terminal control definitions
#include <unistd.h> // write(), read(), close()

int main(void)
{
 int serial_port = open("/dev/sda1", O_RDWR);

// Check for errors
if (serial_port < 0) {
    printf("Error %i from open: %s\n", errno, strerror(errno));
}
else
{
 
 printf("Hurray\n");
close(serial_port);
}

return 0;
}
