using System;
using System.Collections.Generic;
using System.Text;

namespace Zabawki
{
    class Car:ISpeed
    {
        static int number=1;
        String name;
        int speed=0;

        public Car()
        {
            name = "Car" + number.ToString();
            number++;
        }

        public void setSpeed(int v)
        {
            speed = v;
        }
        
        public int getSpeed()
        {
            return speed;
        }

        public void upSpeed()
        {
            speed++;
        }

        public void downSpeed()
        {
            if(speed>0)
            speed--;
        }

        public override string ToString()
        {
            return name;
        }
    }
}
