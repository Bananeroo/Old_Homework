using System;

namespace Zabawki
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.categoriesBox = new System.Windows.Forms.ListBox();
            this.toyslistBox = new System.Windows.Forms.ListBox();
            this.addButton = new System.Windows.Forms.Button();
            this.removeButton = new System.Windows.Forms.Button();
            this.speedUpButton = new System.Windows.Forms.Button();
            this.speedDownButton = new System.Windows.Forms.Button();
            this.speedTextBox = new System.Windows.Forms.TextBox();
            this.speedGroupBox = new System.Windows.Forms.GroupBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.riseTextBox = new System.Windows.Forms.TextBox();
            this.riseUpButton = new System.Windows.Forms.Button();
            this.riseDownButton = new System.Windows.Forms.Button();
            this.riseGroupBox = new System.Windows.Forms.GroupBox();
            this.diveTextBox = new System.Windows.Forms.TextBox();
            this.diveUpButton = new System.Windows.Forms.Button();
            this.diveDownButton = new System.Windows.Forms.Button();
            this.diveGroupBox = new System.Windows.Forms.GroupBox();
            this.speedGroupBox.SuspendLayout();
            this.riseGroupBox.SuspendLayout();
            this.diveGroupBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // categoriesBox
            // 
            this.categoriesBox.FormattingEnabled = true;
            this.categoriesBox.ItemHeight = 15;
            this.categoriesBox.Items.AddRange(new object[] {
            "Car",
            "Plane",
            "Submarine",
            "Computer"});
            this.categoriesBox.Location = new System.Drawing.Point(127, 95);
            this.categoriesBox.Name = "categoriesBox";
            this.categoriesBox.Size = new System.Drawing.Size(120, 94);
            this.categoriesBox.TabIndex = 0;
            // 
            // toyslistBox
            // 
            this.toyslistBox.FormattingEnabled = true;
            this.toyslistBox.ItemHeight = 15;
            this.toyslistBox.Location = new System.Drawing.Point(529, 95);
            this.toyslistBox.Name = "toyslistBox";
            this.toyslistBox.Size = new System.Drawing.Size(120, 94);
            this.toyslistBox.TabIndex = 1;
            this.toyslistBox.SelectedIndexChanged += new System.EventHandler(this.toyslistBox_SelectedIndexChanged);
            // 
            // addButton
            // 
            this.addButton.Location = new System.Drawing.Point(355, 95);
            this.addButton.Name = "addButton";
            this.addButton.Size = new System.Drawing.Size(75, 23);
            this.addButton.TabIndex = 2;
            this.addButton.Text = "Add";
            this.addButton.UseVisualStyleBackColor = true;
            this.addButton.Click += new System.EventHandler(this.addButton_Click);
            // 
            // removeButton
            // 
            this.removeButton.Location = new System.Drawing.Point(355, 166);
            this.removeButton.Name = "removeButton";
            this.removeButton.Size = new System.Drawing.Size(75, 23);
            this.removeButton.TabIndex = 3;
            this.removeButton.Text = "Remove";
            this.removeButton.UseVisualStyleBackColor = true;
            this.removeButton.Click += new System.EventHandler(this.removeButton_Click);
            // 
            // speedUpButton
            // 
            this.speedUpButton.Location = new System.Drawing.Point(10, 31);
            this.speedUpButton.Name = "speedUpButton";
            this.speedUpButton.Size = new System.Drawing.Size(75, 23);
            this.speedUpButton.TabIndex = 2;
            this.speedUpButton.Text = "+";
            this.speedUpButton.UseVisualStyleBackColor = true;
            this.speedUpButton.Click += new System.EventHandler(this.speedUpButton_Click);
            // 
            // speedDownButton
            // 
            this.speedDownButton.Location = new System.Drawing.Point(197, 32);
            this.speedDownButton.Name = "speedDownButton";
            this.speedDownButton.Size = new System.Drawing.Size(75, 23);
            this.speedDownButton.TabIndex = 2;
            this.speedDownButton.Text = "-";
            this.speedDownButton.UseVisualStyleBackColor = true;
            this.speedDownButton.Click += new System.EventHandler(this.speedDownButton_Click);
            // 
            // speedTextBox
            // 
            this.speedTextBox.Location = new System.Drawing.Point(91, 32);
            this.speedTextBox.Name = "speedTextBox";
            this.speedTextBox.Size = new System.Drawing.Size(100, 23);
            this.speedTextBox.TabIndex = 4;
            this.speedTextBox.TextChanged += new System.EventHandler(this.speedTextBox_TextChanged);
            // 
            // speedGroupBox
            // 
            this.speedGroupBox.Controls.Add(this.speedTextBox);
            this.speedGroupBox.Controls.Add(this.speedUpButton);
            this.speedGroupBox.Controls.Add(this.speedDownButton);
            this.speedGroupBox.Location = new System.Drawing.Point(127, 216);
            this.speedGroupBox.Name = "speedGroupBox";
            this.speedGroupBox.Size = new System.Drawing.Size(288, 74);
            this.speedGroupBox.TabIndex = 5;
            this.speedGroupBox.TabStop = false;
            this.speedGroupBox.Text = "Speed";
            this.speedGroupBox.Visible = false;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(0, 0);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(100, 23);
            this.textBox2.TabIndex = 0;
            // 
            // riseTextBox
            // 
            this.riseTextBox.Location = new System.Drawing.Point(91, 32);
            this.riseTextBox.Name = "riseTextBox";
            this.riseTextBox.Size = new System.Drawing.Size(100, 23);
            this.riseTextBox.TabIndex = 4;
            this.riseTextBox.TextChanged += new System.EventHandler(this.riseTextBox_TextChanged);
            // 
            // riseUpButton
            // 
            this.riseUpButton.Location = new System.Drawing.Point(10, 31);
            this.riseUpButton.Name = "riseUpButton";
            this.riseUpButton.Size = new System.Drawing.Size(75, 23);
            this.riseUpButton.TabIndex = 2;
            this.riseUpButton.Text = "+";
            this.riseUpButton.UseVisualStyleBackColor = true;
            this.riseUpButton.Click += new System.EventHandler(this.riseUpButton_Click);
            // 
            // riseDownButton
            // 
            this.riseDownButton.Location = new System.Drawing.Point(197, 32);
            this.riseDownButton.Name = "riseDownButton";
            this.riseDownButton.Size = new System.Drawing.Size(75, 23);
            this.riseDownButton.TabIndex = 2;
            this.riseDownButton.Text = "-";
            this.riseDownButton.UseVisualStyleBackColor = true;
            this.riseDownButton.Click += new System.EventHandler(this.riseDownButton_Click);
            // 
            // riseGroupBox
            // 
            this.riseGroupBox.Controls.Add(this.riseTextBox);
            this.riseGroupBox.Controls.Add(this.riseUpButton);
            this.riseGroupBox.Controls.Add(this.riseDownButton);
            this.riseGroupBox.Location = new System.Drawing.Point(127, 296);
            this.riseGroupBox.Name = "riseGroupBox";
            this.riseGroupBox.Size = new System.Drawing.Size(288, 74);
            this.riseGroupBox.TabIndex = 5;
            this.riseGroupBox.TabStop = false;
            this.riseGroupBox.Text = "Rise";
            this.riseGroupBox.Visible = false;
            // 
            // diveTextBox
            // 
            this.diveTextBox.Location = new System.Drawing.Point(91, 32);
            this.diveTextBox.Name = "diveTextBox";
            this.diveTextBox.Size = new System.Drawing.Size(100, 23);
            this.diveTextBox.TabIndex = 4;
            this.diveTextBox.TextChanged += new System.EventHandler(this.diveTextBox_TextChanged);
            // 
            // diveUpButton
            // 
            this.diveUpButton.Location = new System.Drawing.Point(10, 31);
            this.diveUpButton.Name = "diveUpButton";
            this.diveUpButton.Size = new System.Drawing.Size(75, 23);
            this.diveUpButton.TabIndex = 2;
            this.diveUpButton.Text = "+";
            this.diveUpButton.UseVisualStyleBackColor = true;
            this.diveUpButton.Click += new System.EventHandler(this.diveUpButton_Click);
            // 
            // diveDownButton
            // 
            this.diveDownButton.Location = new System.Drawing.Point(197, 32);
            this.diveDownButton.Name = "diveDownButton";
            this.diveDownButton.Size = new System.Drawing.Size(75, 23);
            this.diveDownButton.TabIndex = 2;
            this.diveDownButton.Text = "-";
            this.diveDownButton.UseVisualStyleBackColor = true;
            this.diveDownButton.Click += new System.EventHandler(this.diveDownButton_Click);
            // 
            // diveGroupBox
            // 
            this.diveGroupBox.Controls.Add(this.diveTextBox);
            this.diveGroupBox.Controls.Add(this.diveUpButton);
            this.diveGroupBox.Controls.Add(this.diveDownButton);
            this.diveGroupBox.Location = new System.Drawing.Point(127, 376);
            this.diveGroupBox.Name = "diveGroupBox";
            this.diveGroupBox.Size = new System.Drawing.Size(288, 74);
            this.diveGroupBox.TabIndex = 5;
            this.diveGroupBox.TabStop = false;
            this.diveGroupBox.Text = "Dive";
            this.diveGroupBox.Visible = false;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(836, 478);
            this.Controls.Add(this.diveGroupBox);
            this.Controls.Add(this.riseGroupBox);
            this.Controls.Add(this.speedGroupBox);
            this.Controls.Add(this.removeButton);
            this.Controls.Add(this.addButton);
            this.Controls.Add(this.toyslistBox);
            this.Controls.Add(this.categoriesBox);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.speedGroupBox.ResumeLayout(false);
            this.speedGroupBox.PerformLayout();
            this.riseGroupBox.ResumeLayout(false);
            this.riseGroupBox.PerformLayout();
            this.diveGroupBox.ResumeLayout(false);
            this.diveGroupBox.PerformLayout();
            this.ResumeLayout(false);

        }

       

        #endregion

        private System.Windows.Forms.ListBox categoriesBox;
        private System.Windows.Forms.ListBox toyslistBox;
        private System.Windows.Forms.Button addButton;
        private System.Windows.Forms.Button removeButton;
        private System.Windows.Forms.Button speedUpButton;
        private System.Windows.Forms.Button speedDownButton;
        private System.Windows.Forms.TextBox speedTextBox;
        private System.Windows.Forms.GroupBox speedGroupBox;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox riseTextBox;
        private System.Windows.Forms.Button riseUpButton;
        private System.Windows.Forms.Button riseDownButton;
        private System.Windows.Forms.GroupBox riseGroupBox;
        private System.Windows.Forms.TextBox diveTextBox;
        private System.Windows.Forms.Button diveUpButton;
        private System.Windows.Forms.Button diveDownButton;
        private System.Windows.Forms.GroupBox diveGroupBox;
    }
}

