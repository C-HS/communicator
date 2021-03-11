#include <stdio.h>

#include <lgpio.h>

#define IN 20
//#define OUT1 13
//#define OUT2 12
#define OUT1 22  // power on
#define OUT2 29


int main(int argc, char *argv[])
{
   int h1,h2;

   int lFlags1,lFlags2 = 0; /* default line flags */

   /* get a handle to the GPIO */
   //h = lgGpiochipOpen(1);
   h1 = lgGpiochipOpen(0);
   h2 = lgGpiochipOpen(1);

    printf("openChip %d\n",h1);


   /* claim a GPIO for INPUT */
 //  lgGpioClaimInput(h, lFlags, IN);

   /* claim some GPIO for OUTPUT */
   lgGpioClaimOutput(h1, lFlags1, OUT1, 1); /* initial level 0 */
   lgGpioClaimOutput(h2, lFlags1, OUT2, 1); /* initial level 1 */

   /* claim a GPIO for ALERTS */
  // lgGpioClaimAlert(h, lFlags, LG_BOTH_EDGES, ALERT, -1);

   /* set up a callback for the alerts */
  // lgGpioSetAlertsFunc(h, ALERT, cbf, NULL);

   /* output 1000 cycles of PWM: frequency=20 dutycycle=35 */
  // lgTxPwm(h, OUT2, 20.0, 35.0, 0, 1000);

int v;
      while(1)
      {
            lgGpioWrite(h1, OUT1, 1);

	v = lgGpioRead(h1,OUT1);

	printf("GPIO%d is %d now \n",OUT1, v);

         lguSleep(1.0);
         lgGpioWrite(h1, OUT1, 0);

	v = lgGpioRead(h1,OUT1);

        printf("GPIO%d is %d now \n",OUT1, v);
         lguSleep(1.0);
        // printf("GPIO %d now \n", OUT1);
     }
}
