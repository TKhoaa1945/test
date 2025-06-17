#include "xparameters.h"
#include "xgpio.h"
#include "xuartlite.h"
#include "xil_printf.h"

#define GPIO_DEVICE_ID  XPAR_DIP_DEVICE_ID
#define GPIO_CHANNEL    1

XGpio Gpio;

int main() {
    int sw_value;

    XGpio_Initialize(&Gpio, GPIO_DEVICE_ID);
    XGpio_SetDataDirection(&Gpio, GPIO_CHANNEL, 0xFF);

    xil_printf("Dang cho nhan...\r\n");

    while (1) {
        sw_value = XGpio_DiscreteRead(&Gpio, GPIO_CHANNEL);

        if (sw_value & 0x01) {
            xil_printf("Hello!\r\n");
            while (XGpio_DiscreteRead(&Gpio, GPIO_CHANNEL) & 0x01);
        }
    }

    return 0;
}
