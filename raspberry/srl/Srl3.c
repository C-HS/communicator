#include <stdio.h>

#include <lgpio.h>

int main(void)
{

  const char *serDev = "/dev/ttyUSB0";

  int handle =  lgSerialOpen(serDev, 230400,0);

   printf("handle %d ",handle);

   return 0;
}
