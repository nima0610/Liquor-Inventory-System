package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class changeprice extends JFrame {

	private JPanel LoginPage;
	private JLabel lblNewLabel_1;
	private JButton createButton;
        private JButton priceButton;
	private JLabel lblNewLabel_3;
	private JTextField priceField;
        private JTextField qField;
	private JTextField nameField;
        private JTextField cp;
        private JTextField totalcp;
	private JTextField quantityField;
         private JTextField pp;
         private JLabel lblPrice_11;
	private JLabel lblPrice_1;
	private JLabel lblPrice_2;
	private JLabel lblPrice_3;
	private JLabel lblPrice_4;
	private JLabel idlabel;
	private int passid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
         
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeprice frame = new changeprice();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
               
               
	}

	/**
	 * Create the frame.
	 */
        
        
        
	public changeprice() throws ClassNotFoundException {
		setVisible(true);
		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		setTitle("Inventory Management System");
		setBounds(475, 200, 580, 420);
		LoginPage = new JPanel();
		LoginPage.setBackground(new Color(102, 153, 102));
		LoginPage.setBorder(new EmptyBorder(5, 5, 5, 5));

                priceButton = new JButton("TOTAL PRICE : ");
		setContentPane(LoginPage);
		LoginPage.setLayout(null);
                final JComboBox<String> categoryField = new JComboBox<>();
		final JComboBox<String> unitField = new JComboBox<>();

                
               
                
                
                
		

		JLabel lblPassword = new JLabel("Product Name");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPassword.setBounds(30, 80, 182, 26);
		LoginPage.add(lblPassword);
                
                JLabel lblPassword11 = new JLabel("Set Cost Price");
		lblPassword11.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword11.setForeground(Color.WHITE);
		lblPassword11.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPassword11.setBounds(30, 160, 182, 26);
		LoginPage.add(lblPassword11);
                

		lblNewLabel_1 = new JLabel("SET PRODUCT PRICE");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, -28, 566, 135);
		LoginPage.add(lblNewLabel_1);

		
                
                createButton = new JButton("SET PRICE");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String priceee = priceField.getText();
                                int price = Integer.parseInt(priceee);
				
				String name = (String) categoryField.getSelectedItem();
                                 
                                 String jsn = qField.getText();
                                 int quant = Integer.parseInt(jsn);

				
                                if (price < quant){
                                    
                                JOptionPane.showMessageDialog(null, "Selling Price should be set higher than cost price ");
                                }
                                else {

						try {
                                                     Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection con = DriverManager.getConnection(url, user, pass);
					
                                                        String Query = "UPDATE category SET cp = ? WHERE name = ?";
							String sql = "UPDATE category SET price = ? WHERE name = ?";
                                                        String ppl = "UPDATE products SET sp = ? WHERE category = ?";
                                                        String kkl = "UPDATE products SET cp = ? WHERE category = ?";
                                                        PreparedStatement pstmt = con.prepareStatement(Query);
                                                        PreparedStatement kk = con.prepareStatement(ppl);
                                                        PreparedStatement ii = con.prepareStatement(kkl);
                                                        PreparedStatement jjj = con.prepareStatement(sql);
                                                        jjj.setInt(1, price);
                                                        jjj.setString(2, name);
                                                        
                                                      kk.setInt(1, price);
						kk.setString(2, name);
                                                        
                                                        ii.setInt(1, quant);
							ii.setString(2, name);
                                                        
							pstmt.setInt(1, quant);
							pstmt.setString(2, name);

							pstmt.execute();
                                                        jjj.execute();
                                                        ii.execute();
                                                        kk.execute();
                                                     
							JOptionPane.showMessageDialog(null, "Price Successfully Updated");
							dispose();
                                                        new loginnn();
						} catch (Exception e1) {
							System.out.println(e1);
						}
					}
				}
		});
		createButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				createButton.setBackground(new Color(0, 153, 204));

			}

			public void mouseExited(MouseEvent e) {
				createButton.setBackground(new Color(51, 51, 153));
			}
		});
                
                
                
                 
                 
                 
                  
                  
                  
                  
                  
                  
                 priceButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				priceButton.setBackground(new Color(0, 153, 204));

			}

			public void mouseExited(MouseEvent e) {
				priceButton.setBackground(new Color(51, 51, 153));
			}
		});
                

		createButton.setFocusPainted(false);
		createButton.setForeground(Color.WHITE);
		createButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		createButton.setBackground(new Color(51, 51, 153));
		createButton.setBounds(222, 340, 216, 33);
		createButton.setBorder(null);
		LoginPage.add(createButton);

		lblNewLabel_3 = new JLabel("____________________________________");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(215, 308, 310, 26);
		LoginPage.add(lblNewLabel_3);

		priceField = new JTextField();
                // priceField.setEditable(false);
		priceField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		priceField.setColumns(10);
		priceField.setBorder(null);
		priceField.setBounds(222, 200, 216, 26);
		LoginPage.add(priceField);
          
                
		JLabel lblPrice = new JLabel("Selling Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice.setBounds(30, 200, 159, 26);
		LoginPage.add(lblPrice);

		

		lblPrice_1 = new JLabel(":");
		lblPrice_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_1.setForeground(Color.WHITE);
		lblPrice_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_1.setBounds(199, 80, 88, 26);
		LoginPage.add(lblPrice_1);

		

		lblPrice_3 = new JLabel(":");
		lblPrice_3.setBorder(null);
		lblPrice_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_3.setForeground(Color.WHITE);
		lblPrice_3.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_3.setBounds(199, 160, 33, 26);
		LoginPage.add(lblPrice_3);

		lblPrice_4 = new JLabel(":");
		lblPrice_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_4.setForeground(Color.WHITE);
		lblPrice_4.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_4.setBounds(199, 200, 88, 26);
		LoginPage.add(lblPrice_4);

		
		 qField = new JTextField();
                
		qField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		qField.setColumns(10);
		qField.setBorder(null);
		qField.setBounds(222, 160, 216, 26);
		LoginPage.add(qField);

                categoryField.setMaximumRowCount(5);
		categoryField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		categoryField.setBorder(null);
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection connection = DriverManager.getConnection(url, user, pass);
                                                         Statement statement = connection.createStatement();
                                                         ResultSet resultSet = statement.executeQuery("SELECT name FROM category");
                                                        Vector<String> categories = new Vector<>();
                                                         while (resultSet.next()) {
                                                          categories.add(resultSet.getString("name"));
                                                           }
                                                         categoryField.setModel(new DefaultComboBoxModel<>(categories));
                                                         resultSet.close();
            statement.close();
            connection.close();
            categoryField.setBounds(222, 80, 216, 26);
		LoginPage.add(categoryField);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                                                        
                                                        
                
		
        
       
        

	
}