using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Zabawki
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void addButton_Click(object sender, EventArgs e)
        {
            switch (categoriesBox.SelectedItem.ToString())
            {
                case "Car": 
                    Car car = new Car();
                    toyslistBox.Items.Add(car);
                    break;
                case "Plane":
                    Plane plane = new Plane();
                    toyslistBox.Items.Add(plane);
                    break;
                case "Submarine":
                    Submarine submarine = new Submarine();
                    toyslistBox.Items.Add(submarine);
                    break;
                case "Computer":
                    Computer computer = new Computer();
                    toyslistBox.Items.Add(computer);
                    break;
            }
        }

        private void toyslistBox_SelectedIndexChanged(object sender, EventArgs e)
        {
            speedGroupBox.Visible = false;
            diveGroupBox.Visible = false;
            riseGroupBox.Visible = false;
            Object obj = toyslistBox.SelectedItem;
            if(obj is ISpeed)
            {
                ISpeed car = (ISpeed)obj;
                speedGroupBox.Visible = true;
                riseGroupBox.Visible = false;
                diveGroupBox.Visible = false;
                speedTextBox.Text = car.getSpeed().ToString();

            }
            if(obj is IRise)
            {
                IRise plane = (IRise)obj;
                speedGroupBox.Visible = true;
                riseGroupBox.Visible = true;
                diveGroupBox.Visible = false;
                riseTextBox.Text = plane.getRise().ToString();
            }
            if (obj is IDive)
            {
                IDive submarine = (IDive)obj;
                speedGroupBox.Visible = false;
                riseGroupBox.Visible = false;
                diveGroupBox.Visible = true;
                diveTextBox.Text = submarine.getDive().ToString();

            }

        }

        private void removeButton_Click(object sender, EventArgs e)
        {
            toyslistBox.Items.Remove(toyslistBox.SelectedItem);
        }


        private void speedUpButton_Click(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if(obj is ISpeed)
            {
                ISpeed toy = (ISpeed)obj;
                toy.upSpeed();
                speedTextBox.Text = toy.getSpeed().ToString();
            }
            
        }

        private void speedDownButton_Click(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is ISpeed)
            {
                ISpeed toy = (ISpeed)obj;
                toy.downSpeed();
                speedTextBox.Text = toy.getSpeed().ToString();
            }
        }

        private void speedTextBox_TextChanged(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is ISpeed)
            {
                String text = speedTextBox.Text;
                int mynumber;
                ISpeed toy = (ISpeed)obj;
                if (int.TryParse(text, out mynumber))
                toy.setSpeed(mynumber);
            }
            
        }

        private void riseTextBox_TextChanged(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is IRise)
            {
                String text = riseTextBox.Text;
                int mynumber;
                IRise toy = (IRise)obj;
                if (int.TryParse(text, out mynumber))
                    toy.setRise(mynumber);
            }
        }

        private void riseUpButton_Click(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is IRise)
            {
                IRise plane = (IRise)obj;
                plane.upRise();
                riseTextBox.Text = plane.getRise().ToString();
            }
        }

        private void riseDownButton_Click(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is IRise)
            {
                IRise plane = (IRise)obj;
                plane.downRise();
                riseTextBox.Text = plane.getRise().ToString();
            }
        }

        private void diveUpButton_Click(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is IDive)
            {
                IDive submarine = (IDive)obj;
                submarine.upDive();
                diveTextBox.Text = submarine.getDive().ToString();
            }
        }

        private void diveTextBox_TextChanged(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is IDive)
            {
                String text = diveTextBox.Text;
                int mynumber;
                IDive submarine = (IDive)obj;
                if (int.TryParse(text, out mynumber))
                    submarine.setDive(mynumber);

            }
        }

        private void diveDownButton_Click(object sender, EventArgs e)
        {
            Object obj = toyslistBox.SelectedItem;
            if (obj is IDive)
            {
                IDive submarine = (IDive)obj;
                submarine.downDive();
                diveTextBox.Text = submarine.getDive().ToString();
            }
        }
    }
}
