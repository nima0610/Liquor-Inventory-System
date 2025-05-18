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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
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

public class prodam extends JFrame {

	private JPanel LoginPage;
	private JLabel lblNewLabel_1;
	private JButton createButton;
        private JButton priceButton;
	private JLabel lblNewLabel_3;
	private JTextField priceField;
	//private JTextField nameField;
        private JTextField pp;
         private JTextField qleft;
	private JTextField quantityField;
	private JLabel lblName;
        private JLabel quantity;
	private JLabel lblPrice_1; 
	private JLabel lblPrice_2;
	private JLabel lblPrice_3;
	private JLabel lblPrice_4;
	private JLabel lblPrice_5;
        private JLabel lblPrice_15;
	private JLabel idlabel;
	private int passid;

	/**
	
	 */
	public static void main(String[] args) {
           
       
            new ConnectionProvider();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prodam frame = new prodam();
					frame.setVisible(true);
					Image icon = Toolkit.getDefaultToolkit().getImage("image//icon.png");
					frame.setIconImage(icon);
					getClass().getResourceAsStream("icon.png");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prodam() throws ClassNotFoundException {
		setVisible(true);
		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		setTitle("Inventory Management System");
		setBounds(475, 200, 580, 420);
		LoginPage = new JPanel();
		LoginPage.setBackground(new Color(255, 0, 0));
		LoginPage.setBorder(new EmptyBorder(5, 5, 5, 5));

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

		JLabel lblPassword = new JLabel("Cost Price ");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPassword.setBounds(30, 160, 182, 26);
		LoginPage.add(lblPassword);
                
                JLabel quantity = new JLabel("Quantity Left ");
		quantity.setHorizontalAlignment(SwingConstants.LEFT);
		quantity.setForeground(Color.WHITE);
		quantity.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		quantity.setBounds(30, 240, 182, 26);
		LoginPage.add(quantity);

		lblNewLabel_1 = new JLabel("PRODUCT DAMAGED");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, -28, 566, 135);
		LoginPage.add(lblNewLabel_1);
                priceButton = new JButton("TOTAL PRICE : ");
		createButton = new JButton("FINISH");
                 priceButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                
                                int num1 = Integer.parseInt(quantityField.getText());
                                int num2 = Integer.parseInt(priceField.getText());
                                int num3 = Integer.parseInt(qleft.getText());
                                int pq = num1*num2;
                               pp.setText(Integer.toString(pq));
                               
                               
                                    }
                                });
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            int num1 = Integer.parseInt(quantityField.getText());
                            int num3 = Integer.parseInt(qleft.getText());
				String ide = idlabel.getText();
                                int id = Integer.parseInt(ide);
				//String nam = nameField.getText();
                               // int name = Integer.parseInt(nam);
				String pricee = priceField.getText();
                                int price = Integer.parseInt(pricee);
				String category = (String) categoryField.getSelectedItem();
				String quantityy = quantityField.getText();
                                int quantity = Integer.parseInt(quantityy);
                                String gl = pp.getText();
                                int pk = Integer.parseInt(gl);
                             
                               
                                
				

				//if (unit == "Unit..") {
					//JOptionPane.showMessageDialog(null, "Please select a Unit");
				
					if (category == "Select Item..") {
						JOptionPane.showMessageDialog(null, "Please select an Item");
					} 
                                        else if(num1>num3) {
                                   JOptionPane.showMessageDialog(null, "Error Error Error");
                               }
                                        else {

						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection con = DriverManager.getConnection(url, user, pass);
                                                        String Query = "UPDATE products SET quantity = quantity - ? WHERE category = ?";
                                                       
							String sql = "INSERT INTO productdamaged (name,cp,quantity,total,sn) values (?,?,?,?,?)";
							PreparedStatement pstmt = con.prepareStatement(Query);
                                                        PreparedStatement kkk = con.prepareStatement(sql);
                                                        pstmt.setInt(1, quantity);
                                                        pstmt.setString(2, category);
                                                        kkk.setString(1, category);
                                                        kkk.setInt(2, price);
                                                        kkk.setInt(3, quantity);
                                                        kkk.setInt(4, pk);
                                                         kkk.setInt(5, id);
							

							pstmt.execute();
                                                        kkk.execute();
							JOptionPane.showMessageDialog(null, "SELECTED PRODUCT ADDED INTO DAMAGED PRODUCT'S LIST");
                                                        
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
                
                categoryField.addActionListener(new ActionListener(){
                       public void actionPerformed(ActionEvent e) {
                          
                           
                           
                             try {
                                String selectedCategory = (String) categoryField.getSelectedItem();
                           
							Class.forName("com.mysql.cj.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/inventory";
							String user = "root";
							String pass = "";
							Connection con = DriverManager.getConnection(url, user, pass);
							String sql = "SELECT cp FROM category WHERE name=?";
                                                        PreparedStatement statement = con.prepareStatement(sql);
                                                        statement.setString(1, selectedCategory);
                                                        
                                                        ResultSet result = statement.executeQuery();
                                                        if(result.next()){
                                                            int price = result.getInt(String.valueOf("cp"));
                                                            priceField.setText(String.valueOf(price));
                                                        }
                                                        
                                                         String pq = "SELECT quantity FROM products WHERE category=?";
                                                        PreparedStatement statemen = con.prepareStatement(pq);
                                                        statemen.setString(1, selectedCategory);
                                                        
                                                        ResultSet resultss = statemen.executeQuery();
                                                        if(resultss.next()){
                                                            int pri = resultss.getInt(String.valueOf("quantity"));
                                                            qleft.setText(String.valueOf(pri));
                                                        }
                                                        
                                                        
                                                        
                                                        
                          
                       }
                           catch(SQLException f){
                               f.printStackTrace();
                           } catch (ClassNotFoundException ex) {
                               Logger.getLogger(Addproduct.class.getName()).log(Level.SEVERE, null, ex);
                           }
                       }
                  });
                
                
		lblNewLabel_3 = new JLabel("____________________________________");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(215, 308, 310, 26);
		LoginPage.add(lblNewLabel_3);

		priceField = new JTextField();
		priceField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		priceField.setColumns(10);
		priceField.setBorder(null);
		priceField.setBounds(222, 160, 216, 26);
		LoginPage.add(priceField);

		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel_5.setBounds(30, 200, 112, 26);
		LoginPage.add(lblNewLabel_5);

		 qleft = new JTextField();
             qleft.setEditable(false);
		qleft.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		qleft.setColumns(10);
		qleft.setBorder(null);
		qleft.setBounds(222, 240, 216, 26);
		LoginPage.add(qleft);
                
              pp = new JTextField();
              pp.setEditable(false);
		pp.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		pp.setColumns(10);
		pp.setBorder(null);
		pp.setBounds(222, 280, 216, 26);
		LoginPage.add(pp);
                
                

		//JLabel lblPrice = new JLabel("Price Per Unit");
		//lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		//lblPrice.setForeground(Color.WHITE);
		//lblPrice.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		//lblPrice.setBounds(30, 240, 200, 26);
		//LoginPage.add(lblPrice);

		quantityField = new JTextField();
		quantityField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		quantityField.setColumns(10);
		quantityField.setBorder(null);
		quantityField.setBounds(222, 200, 216, 26);
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
                
                lblPrice_15 = new JLabel(":");
		lblPrice_15.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_15.setForeground(Color.WHITE);
		lblPrice_15.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_15.setBounds(199, 240, 88, 26);
		LoginPage.add(lblPrice_15);

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
            categoryField.setBounds(222, 120, 216, 26);
		LoginPage.add(categoryField);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		

		try {

			
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
		String query = "SELECT MAX(SN) + 1 FROM productdamaged";

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