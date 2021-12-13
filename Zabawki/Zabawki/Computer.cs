using System;
using System.Collections.Generic;
using System.Text;

namespace Zabawki
{
    class Computer
    {
        static int number = 1;
        String name;
        public Computer()
        {
            name = "Computer" + number.ToString();
            number++;
        }

        public override string ToString()
        {
            return name;
        }
    }
}
