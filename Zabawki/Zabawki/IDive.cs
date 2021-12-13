using System;
using System.Collections.Generic;
using System.Text;

namespace Zabawki
{
    interface IDive
    {
        public void setDive(int d);

        public int getDive();

        public void upDive();
        public void downDive();
    }
}
