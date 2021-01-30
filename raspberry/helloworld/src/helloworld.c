/*
 ============================================================================
 Name        : helloworld.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

extern void callTest1(void);

int main(void) {
	printf("!!!Hello World!!!\n"); /* prints !!!Hello World!!! */

	callTest1();


	return EXIT_SUCCESS;
}
