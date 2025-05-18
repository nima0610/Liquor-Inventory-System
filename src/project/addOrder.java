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

public class addOrder extends JFrame {

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
             private JTextField ppli;
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
					addOrder frame = new addOrder();
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
        
        
        
	public addOrder() throws ClassNotFoundException {
		setVisible(true);
		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		setTitle("Inventory Management System");
		setBounds(475, 200, 580, 420);
		LoginPage = new JPanel();
		LoginPage.setBackground(new Color(0, 204, 153));
		LoginPage.setBorder(new EmptyBorder(5, 5, 5, 5));

                priceButton = new JButton("TOTAL PRICE : ");
		setContentPane(LoginPage);
		LoginPage.setLayout(null);
                final JComboBox<String> categoryField = new JComboBox<>();
		final JComboBox<String> unitField = new JComboBox<>();

                
               
                
                
                
		JLabel lblNewLabel = new JLabel("SN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 80, 140, 26);
		LoginPage.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Product Name");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPassword.setBounds(30, 120, 182, 26);
		LoginPage.add(lblPassword);
                
                
                JLabel lblPassword11 = new JLabel("Quantity Left");
		lblPassword11.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword11.setForeground(Color.WHITE);
		lblPassword11.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPassword11.setBounds(30, 240, 182, 26);
		LoginPage.add(lblPassword11);

		lblNewLabel_1 = new JLabel("Add Customer Order");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, -28, 566, 135);
		LoginPage.add(lblNewLabel_1);

		
                priceButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                
                                int num1 = Integer.parseInt(quantityField.getText());
                                int num2 = Integer.parseInt(priceField.getText());
                                int num3 = Integer.parseInt(cp.getText());
                                //int num4 = Integer.parseInt(ppli.getText());
                                int pq = num1*num2;
                                int lq = num3*num1;
                                //int dis = (num4*num1*num2)/100;
                                //int pq = mq-dis; 
                                
                               pp.setText(Integer.toString(pq));
                               totalcp.setText(Integer.toString(lq));
                                    }
                                });
                createButton = new JButton("Create New Order");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idlabel.getText();
				String name = (String) categoryField.getSelectedItem();
				String priceee = priceField.getText();
                                int price = Integer.parseInt(priceee);
				String quantity = quantityField.getText();
                                int llk = Integer.parseInt(quantity);
				String unit = (String) unitField.getSelectedItem();
                                String gl = pp.getText();
                                 int pk = Integer.parseInt(gl);
                                 
                                 String kk = cp.getText();
                                 int ok = Integer.parseInt(kk);
                                 
                                 String jj = totalcp.getText();
                                 int ko = Integer.parseInt(jj);
                                 
                                 String jsn = qField.getText();
                                 int quant = Integer.parseInt(jsn);

				
                              if (llk > quant){
                                    
                                JOptionPane.showMessageDialog(null, "SORRY SIR/MAM, WE DON'T HAVE ENOUGH PRODUCTS. ");
                                }
                                else {

						try {
                                                     Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection con = DriverManager.getConnection(url, user, pass);
					
                                                        String Query = "INSERT INTO salesorder (SN,pname,quantity,unit,ppu,DOrder,totalprice,cp,total) values (?,?,?,?,?,?,?,?,?)";
							String sql = "UPDATE products SET quantity = quantity - ? WHERE category = ?";
                                                        String ppl = "UPDATE orders SET quantity = quantity + ? WHERE name = ?";
                                                        PreparedStatement pstmt = con.prepareStatement(Query);
                                                        PreparedStatement tt = con.prepareStatement(ppl);
                                                        PreparedStatement jjj = con.prepareStatement(sql);
                                                        jjj.setString(1, quantity);
                                                        jjj.setString(2, name);
                                                         tt.setString(1, quantity);
                                                        tt.setString(2, name);
                                                        
							pstmt.setString(1, id);
							pstmt.setString(2, name);
							pstmt.setString(3, quantity);
							pstmt.setString(4, unit);
							pstmt.setInt(5, price);
							pstmt.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                                                        pstmt.setInt(7, pk);
                                                        pstmt.setInt(8, ok);
                                                        pstmt.setInt(9, ko);

							pstmt.execute();
                                                        jjj.execute();
                                                        tt.execute();
							JOptionPane.showMessageDialog(null, "New product added");
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
                
                
                 categoryField.addActionListener(new ActionListener(){
                       public void actionPerformed(ActionEvent e) {
                           try {
                                String selectedCategory = (String) categoryField.getSelectedItem();
                           
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection con = DriverManager.getConnection(url, user, pass);
							String sql = "SELECT price FROM category WHERE name=?";
                                                        PreparedStatement statement = con.prepareStatement(sql);
                                                        statement.setString(1, selectedCategory);
                                                        
                                                        ResultSet result = statement.executeQuery();
                                                        if(result.next()){
                                                            int price = result.getInt(String.valueOf("price"));
                                                            priceField.setText(String.valueOf(price));
                                                        }
                                                        
                                                     
							
							String pql = "SELECT cp FROM category WHERE name=?";
                                                        PreparedStatement statements = con.prepareStatement(pql);
                                                        statements.setString(1, selectedCategory);
                                                        
                                                        ResultSet results = statements.executeQuery();
                                                        if(results.next()){
                                                            int pri = results.getInt(String.valueOf("cp"));
                                                            cp.setText(String.valueOf(pri));
                                                        }
                                                        
                                                        String pq = "SELECT quantity FROM products WHERE category=?";
                                                        PreparedStatement statemen = con.prepareStatement(pq);
                                                        statemen.setString(1, selectedCategory);
                                                        
                                                        ResultSet resultss = statemen.executeQuery();
                                                        if(resultss.next()){
                                                            int pri = resultss.getInt(String.valueOf("quantity"));
                                                            qField.setText(String.valueOf(pri));
                                                        }
                                                        }
                           
                           
                           catch(SQLException f){
                               f.printStackTrace();
                           } catch (ClassNotFoundException ex) {
                               Logger.getLogger(Addproduct.class.getName()).log(Level.SEVERE, null, ex);
                           }
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
                priceButton.setFocusPainted(false);
		priceButton.setForeground(Color.WHITE);
		priceButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		priceButton.setBackground(new Color(51, 51, 153));
                priceButton.setBounds(30, 280, 180, 26);
                LoginPage.add(priceButton);

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
                 priceField.setEditable(false);
		priceField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		priceField.setColumns(10);
		priceField.setBorder(null);
		priceField.setBounds(222, 200, 216, 26);
		LoginPage.add(priceField);
                
                qField = new JTextField();
                 qField.setEditable(false);
		qField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		qField.setColumns(10);
		qField.setBorder(null);
		qField.setBounds(222, 240, 216, 26);
		LoginPage.add(qField);
                
               cp = new JTextField();
              // cp.setVisible(false);
                 cp.setEditable(false);
		cp.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		cp.setColumns(10);
		cp.setBorder(null);
		cp.setBounds(522, 240, 20, 26);
                cp.setVisible(false);
		LoginPage.add(cp);
                cp.setVisible(false);
                
                totalcp = new JTextField();
              // cp.setVisible(false);
                 totalcp.setEditable(false);
		totalcp.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		totalcp.setColumns(10);
		totalcp.setBorder(null);
		totalcp.setBounds(522, 200, 20, 26);
                totalcp.setVisible(false);
		LoginPage.add(totalcp);

		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel_5.setBounds(30, 160, 112, 26);
		LoginPage.add(lblNewLabel_5);
                
              //  JLabel lblNewLabel_61 = new JLabel("Discount");
		//lblNewLabel_61.setHorizontalAlignment(SwingConstants.LEFT);
		//lblNewLabel_61.setForeground(Color.WHITE);
		//lblNewLabel_61.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		///lblNewLabel_61.setBounds(320, 160, 112, 26);
		//LoginPage.add(lblNewLabel_61);

		
               JLabel  lblPrice_19 = new JLabel(":");
		lblPrice_19.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_19.setForeground(Color.WHITE);
		lblPrice_19.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_19.setBounds(430, 160, 88, 26);
		LoginPage.add(lblPrice_19);
                
                
              //  JTextField ppli = new JTextField();
             
		//ppli.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		//ppli.setColumns(10);
		///ppli.setBorder(null);
		//ppli.setBounds(222, 120, 80, 26);
            
		//LoginPage.add(ppli);
                
                 pp = new JTextField();
              pp.setEditable(false);
		pp.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		pp.setColumns(10);
		pp.setBorder(null);
		pp.setBounds(222, 280, 216, 26);
		LoginPage.add(pp);
                
		JLabel lblPrice = new JLabel("Price per Unit");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice.setBounds(30, 200, 159, 26);
		LoginPage.add(lblPrice);

		quantityField = new JTextField();
		quantityField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		quantityField.setColumns(10);
		quantityField.setBorder(null);
		quantityField.setBounds(222, 160, 80, 26);
		LoginPage.add(quantityField);

		lblPrice_1 = new JLabel(":");
		lblPrice_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_1.setForeground(Color.WHITE);
		lblPrice_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_1.setBounds(199, 80, 88, 26);
		LoginPage.add(lblPrice_1);

		lblPrice_2 = new JLabel(":");
		lblPrice_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_2.setForeground(Color.WHITE);
		lblPrice_2.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_2.setBounds(199, 120, 88, 26);
		LoginPage.add(lblPrice_2);

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

		try {
                                                        Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection con = DriverManager.getConnection(url, user, pass);
			int nextAvailableSN = findNextAvailableSN(con);
			passid = nextAvailableSN;
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		idlabel = new JLabel(String.valueOf(passid));
		idlabel.setHorizontalAlignment(SwingConstants.LEFT);
		idlabel.setForeground(Color.WHITE);
		idlabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		idlabel.setBounds(222, 80, 140, 26);
		LoginPage.add(idlabel);

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
            categoryField.setBounds(220, 120, 216, 26);
		LoginPage.add(categoryField);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                                                        
                                                        
                
		
        
       
        

	private static int findNextAvailableSN(Connection connection) throws SQLException {
		String query = "SELECT MAX(SN) + 1 FROM salesorder";

		try (PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			if (resultSet.next()) {
				int nextAvailableSN = resultSet.getInt(1);
				if (resultSet.wasNull()) {
					// If the result is NULL (no existing rows), start with SN = 1
					return 1;
				} else {
					return nextAvailableSN;
				}
			} else {
				// If there are no rows in the table, start with SN = 1
				return 1;
			}
		}
	}
}