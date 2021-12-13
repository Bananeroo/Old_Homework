using System;
using System.Collections.Generic;
using System.Text;

namespace Zabawki
{
    class Submarine:IDive
    {
        static int number = 1;
        String name;
        int dive = 0;
        public Submarine()
        {
            name = "Submarine" + number.ToString();
            number++;
        }

        public override string ToString()
        {
            return name;
        }

        public int getDive()
        {
            return dive;
        }

        public void setDive(int d)
        {
            dive = d;
        }
        public void upDive()
        {
            dive++;
        }

        public void downDive()
        {
            if(dive>0)
                dive--;
        }

    }
}
