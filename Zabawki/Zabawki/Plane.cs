using System;
using System.Collections.Generic;
using System.Text;

namespace Zabawki
{
    class Plane:ISpeed,IRise
    {

        static int number = 1;
        String name;
        int speed = 0;
        int rise = 0;
        public Plane()
        {
            name = "Plane" + number.ToString();
            number++;
        }

        public override string ToString()
        {
            return name;
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
            if (speed > 0)
                speed--;
        }

        public void setRise(int v)
        {
            rise = v;
        }

        public int getRise()
        {
            return rise;
        }

        public void upRise()
        {
            rise++;
        }

        public void downRise()
        {
            if (rise > 0)
                rise--;
        }

    }
}
