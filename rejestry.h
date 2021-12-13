#include <stdint.h>
#ifndef _MAINE
#define _MAINE

void LED_Init (void);
uint32_t LED_decode (uint8_t digit);
void LED_display_digit(uint8_t digit, uint8_t pos);
void LED_display_number(uint8_t number);

#define PB_PER		(*((volatile uint32_t*)0xFFFFF400))
#define PB_OER		(*((volatile uint32_t*)0xFFFFF410))

#define PB_SODR		(*((volatile uint32_t*)0xFFFFF430))
#define PB_CODR		(*((volatile uint32_t*)0xFFFFF434))

#define FIRST 1<<28
#define SECOND 1<<30


#define E 1<<20
#define D 1<<21
#define C 1<<22
#define P 1<<23
#define B 1<<24
#define A 1<<25
#define G 1<<26
#define F 1<<27

#define delay(x) for(int i = 0; i < 100000 * x; i++); 

#endif
