#include <avr/io.h>
#include "peri.h"

#define RED    PC0
#define YELLOW PC1
#define GREEN  PC2
#define ON     1
#define OFF    0

void init_peripheral()
{
    DDRC |= (1<<PC0) | (1<<PC1) | (1<<PC2);
	PORTC &= ~((1<<PC0) | (1<<PC1) | (1<<PC2));

	DDRC &= ~(1<<PC2);
	PORTC |= (1<<PC2);

	DDRC &= ~(1<<PC3);
	PORTC |= (1<<PC3);
	DDRC &= ~(1<<PC4);
	PORTC |= ~(1<<PC4); 
	DDRC &= ~(1<<PC5);
	PORTC |= ~(1<<PC5);
}

void set_led(uint8_t pin, uint8_t state)
{
    if(state == 1)
	{
 		PORTC |= (1<<pin);
	}
	else 
	{
 		PORTC &= ~(1<<pin);
	}
}

void set_led_value(uint8_t value)
{
    PORTC &= (0b11111000) | value;
	PORTC |= ~(0b11111000) & value;
}

uint16_t read_adc(uint8_t channel)
{
    ADMUX = (0<<REFS1)| (1<<REFS0) | (0<<ADLAR)|(channel&0b1111);
	ADCSRA = (1<<ADEN) | (1<<ADPS2)|(1<<ADPS1)|(1<<ADPS0)| (1<<ADSC);
	while((ADCSRA&(1<<ADSC))) ;
	return ADCL+ADCH*256;
}

uint16_t get_light()
{
    return read_adc(PC0);
}

uint16_t get_accelero_X()
{
	return read_adc(PC3);
}

uint16_t get_accelero_Y()
{
	return read_adc(PC4);
}

uint16_t get_accelero_Z()
{
	return read_adc(PC5);
}
