#include "rejestry.h"

void LED_Init (void)
{
    PB_PER |= (A|B|C|D|E|F|G|P|FIRST|SECOND);
	 	PB_OER |= (A|B|C|D|E|F|G|P|FIRST|SECOND);
}
uint32_t LED_decode (uint8_t digit)
{
    switch(digit)
    {
    case 0:
        return A|B|C|D|E|F;
        break;
    case 1:
        return B|C;
        break;
    case 2:
        return A|B|G|D|E;
        break;
    case 3:
        return A|B|C|G|D;
        break;
    case 4:
        return F|G|B|C;
        break;
    case 5:
        return A|F|G|C|D;
        break;
    case 6:
        return A|F|E|D|C|G;
        break;
    case 7:
        return A|B|C;
        break;
    case 8:
        return A|B|C|D|E|F|G;
        break;
   	default:
        return A|F|G|B|C|D;
    }
}
void LED_display_digit(uint8_t digit, uint8_t pos)
{
     switch(pos)
    {
		case 1:
        PB_SODR |= FIRST; 					 //Wyłącz
        PB_CODR |= SECOND;					 //Włącz
        PB_SODR = LED_decode(digit);//Wyświetl
    		break;
		default:
        PB_SODR |= SECOND;
        PB_CODR |= FIRST;
        PB_SODR = LED_decode(digit);
				break;		
		}    
	 delay(100);
}
void LED_display_number(uint8_t number)
{
		int reszta=number/10;
		int mod=number%10;
    while(1){
        LED_display_digit(reszta, 1);
        delay(10);
        LED_display_digit(mod, 2);
    }
}
int main(void)
{
		LED_Init ();
		LED_display_number(17);
 
}
