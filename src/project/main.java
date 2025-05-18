package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class main extends JFrame implements ActionListener {

    public JButton addButton, supplierButton, orderButton, exitButton, loginbutton, sbutton, obutton, pbutton;
    JLabel title, hello,intro,a,b,c,d,e,f,i,j;

    public main() {
        setTitle("INVENTORY MANAGEMENT SYSTEM");
        setSize(1200, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        intro=new JLabel("                                                                                                                                                                                                                                                                   WELCOME CHIEF...                                                                                                                                                                                                                                                                                  ");
        a= new JLabel("                                                -ADMIN PAGE                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        b= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                       ");
        f= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");       
        c= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
                j= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
          
        i= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
  
        d= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
                e= new JLabel("                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ");
        title = new JLabel("                                                                                                                                                                                                                                                                                                                           Inventory Management System                                                                                                                                                                                                                                                                                                                                    ");
        hello = new JLabel("                                                                                                                                                                                                                          SELECT THE OPERATION TO BE PERFORMED                                                                                                                                                                                                                                            ");
        title.setBounds(100, 50, 500, 100);
        sbutton = new JButton("Supplier details");
        obutton = new JButton("Order Details");
        pbutton = new JButton("Product Details");
        addButton = new JButton("Add Product");
        addButton.setBounds(50, 950, 50, 50);
        supplierButton = new JButton("Add Supplier");
        supplierButton.setBounds(150, 650, 50, 50);
        orderButton = new JButton("Add Order");
        orderButton.setBounds(250, 650, 50, 50);
        exitButton = new JButton("Exit");
        exitButton.setBounds(250, 650, 50, 50);
        loginbutton = new JButton("LOGIN PAGE");

        sbutton.addActionListener(this);
                obutton.addActionListener(this);
                pbutton.addActionListener(this);
        addButton.addActionListener(this);
        supplierButton.addActionListener(this);
        orderButton.addActionListener(this);
        exitButton.addActionListener(this);
        loginbutton.addActionListener(this);

        JPanel panel = new JPanel();
        add(panel);
        panel.setSize(1000, 400);
       panel.add(a);
        panel.add(title);
         panel.add(b);
        panel.add(intro);
        panel.add(hello);
         panel.add(i);
        panel.add(addButton);
         panel.add(c);
        panel.add(supplierButton);
         panel.add(d);
        panel.add(orderButton);
         panel.add(e);
        panel.add(exitButton);
         panel.add(f);
        panel.add(loginbutton);
        panel.add(j);
          panel.add(sbutton);
            panel.add(pbutton);
              panel.add(obutton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                new Addproduct();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }

            dispose();

        } else if (e.getSource() == supplierButton) {
            try {
                new AddSupplier();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } else if (e.getSource() == orderButton) {
            try {
                new addOrder();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } else if (e.getSource() == exitButton) {
            dispose();
        }
        else if (e.getSource() == loginbutton) {
            new loginpage().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        //new loginpage();
        //addOrder jj = new addOrder();
        //Addproduct kk=new Addproduct();
        new loginpage().setVisible(true);
    }
}
