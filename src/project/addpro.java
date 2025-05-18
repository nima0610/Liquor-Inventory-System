package project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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

public class addpro extends JFrame {

	private JPanel LoginPage;
	private JLabel lblNewLabel_1;
	private JButton createButton;
        private JButton priceButton;
	private JLabel lblNewLabel_3;
	private JTextField priceField;
	private JTextField nameField;
        private JTextField categoryField;
        private JTextField pp;
	private JTextField quantityField;
	private JLabel lblName;
	private JLabel lblPrice_1; 
	private JLabel lblPrice_2;
	private JLabel lblPrice_3;
	private JLabel lblPrice_4;
	private JLabel lblPrice_5;
	private JLabel idlabel;
	private int passid;

	/**
	
	 */
	public static void main(String[] args) {
           
       
            new ConnectionProvider();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addpro frame = new addpro();
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
	public addpro() {
		setVisible(true);
		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		setTitle("Inventory Management System");
		setBounds(475, 200, 580, 420);
		LoginPage = new JPanel();
		LoginPage.setBackground(new Color(51, 153, 255));
		LoginPage.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(LoginPage);
		LoginPage.setLayout(null);

		//final JComboBox<String> categoryField = new JComboBox<>();
		
                final JComboBox<String> unitField = new JComboBox<>();

		JLabel lblNewLabel = new JLabel("SN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 80, 140, 26);
		LoginPage.add(lblNewLabel);

		JLabel lblPassword = new JLabel(" OUR S.P");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPassword.setBounds(30, 160, 182, 26);
		LoginPage.add(lblPassword);

		lblNewLabel_1 = new JLabel("Add Product");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, -28, 566, 135);
		LoginPage.add(lblNewLabel_1);
                priceButton = new JButton("TOTAL PRICE : ");
		createButton = new JButton("Create New Product");
                 priceButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                
                                int num1 = Integer.parseInt(quantityField.getText());
                                int num2 = Integer.parseInt(priceField.getText());
                                int pq = num1*num2;
                               pp.setText(Integer.toString(pq));
                                    }
                                });
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String kj = idlabel.getText();
                                int id = Integer.parseInt(kj);
				String nam = nameField.getText();
                                int name = Integer.parseInt(nam);
				String pricee = priceField.getText();
                                int price = Integer.parseInt(pricee);
				String category =  categoryField.getText();
				String quantityy = quantityField.getText();
                                int quantity = Integer.parseInt(quantityy);
                                String gl = pp.getText();
                                int pk = Integer.parseInt(gl);
                             
                               
                                
				

				//if (unit == "Unit..") {
					//JOptionPane.showMessageDialog(null, "Please select a Unit");
				
                                        if ( name<price)
                                        {
                                            JOptionPane.showMessageDialog(null, "SELLING PRICE MUST BE HIGHER THAN COST PRICE TO AVOID LOSS");
                                        }
                                        
                                        
                                        else if (category == "Select Item..") {
						JOptionPane.showMessageDialog(null, "Please select an Item");
					} 
                                        else {

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection con = DriverManager.getConnection(url, user, pass);
							String Query = "INSERT INTO products (SN,sp,cp,category,quantity,dateAdded,totalprice) values (?,?,?,?,?,?,?)";
                                                        String sql = "INSERT INTO category(name,price,cp) values (?,?,?)";
                                                        String po = "INSERT INTO orders(name,quantity) values (?,?)";
                                                        PreparedStatement jjj = con.prepareStatement(sql);
							PreparedStatement pstmt = con.prepareStatement(Query);
                                                        PreparedStatement kkk = con.prepareStatement(po);
                                                        jjj.setString(1, category);
                                                        jjj.setInt(2, name);
                                                         jjj.setInt(3, price);
							pstmt.setInt(1, id);
							pstmt.setInt(2, name);
							pstmt.setInt(3, price);
							pstmt.setString(4, category);
							pstmt.setInt(5, quantity);
							pstmt.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                                                        pstmt.setInt(7, pk);
                                                        kkk.setString(1, category);
                                                        kkk.setInt(2,0);
                                                        kkk.execute();

							pstmt.execute();
                                                        jjj.execute();
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

		createButton.setFocusPainted(false);
		createButton.setForeground(Color.WHITE);
		createButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		createButton.setBackground(new Color(51, 51, 153));
		createButton.setBounds(222, 340, 216, 33);
		createButton.setBorder(null);
		LoginPage.add(createButton);

                  
                           
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
                
                
                
                
		lblNewLabel_3 = new JLabel("____________________________________");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(215, 308, 310, 26);
		LoginPage.add(lblNewLabel_3);

		priceField = new JTextField();
		priceField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		priceField.setColumns(10);
		priceField.setBorder(null);
		priceField.setBounds(222, 240, 216, 26);
		LoginPage.add(priceField);

		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel_5.setBounds(30, 200, 112, 26);
		LoginPage.add(lblNewLabel_5);

		nameField = new JTextField();
		nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		nameField.setColumns(10);
		nameField.setBorder(null);
		nameField.setBounds(222, 160, 216, 26);
		LoginPage.add(nameField);
                
                
                categoryField = new JTextField();
		categoryField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		categoryField.setColumns(10);
		categoryField.setBorder(null);
		categoryField.setBounds(222, 120, 216, 26);
		LoginPage.add(categoryField);
                
              pp = new JTextField();
              pp.setEditable(false);
		pp.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		pp.setColumns(10);
		pp.setBorder(null);
		pp.setBounds(222, 280, 216, 26);
		LoginPage.add(pp);
                
                

		JLabel lblPrice = new JLabel("Price Per Unit");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice.setBounds(30, 240, 200, 26);
		LoginPage.add(lblPrice);

		quantityField = new JTextField();
		quantityField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		quantityField.setColumns(10);
		quantityField.setBorder(null);
		quantityField.setBounds(222, 200, 125, 26);
		LoginPage.add(quantityField);

		lblName = new JLabel("Product");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblName.setBounds(30, 120, 112, 26);
		LoginPage.add(lblName);

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

		lblPrice_5 = new JLabel(":");
		lblPrice_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_5.setForeground(Color.WHITE);
		lblPrice_5.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_5.setBounds(199, 240, 88, 26);
		LoginPage.add(lblPrice_5);

		

		try {

			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root",
					//"#sql12345");
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

		
	}

	private static int findNextAvailableSN(Connection connection) throws SQLException {
		String query = "SELECT MAX(SN) + 1 FROM products";

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