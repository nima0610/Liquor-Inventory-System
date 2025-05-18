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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class supplierstaff extends JFrame {

	private JPanel LoginPage;
	private JLabel lblNewLabel_1;
	private JButton createButton;
        
	private JLabel lblNewLabel_3;
	
	private JTextField nameField;
	private JTextField contactField;
	
	private JLabel lblPrice_2;
	private JLabel lblPrice_3;
	private JLabel lblPrice_4;
	private JLabel lblPrice_5;
	private int suppid;
	private JLabel idlabel;
	private JLabel lblNewLabel_2;
	private JLabel lblPrice_6;
	private JTextField emailField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplierstaff frame = new supplierstaff();
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
	public supplierstaff() throws ClassNotFoundException {
		setVisible(true);
		setResizable(false);
		setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		setTitle("Inventory Management System");
		setBounds(475, 200, 580, 420);
		LoginPage = new JPanel();
		LoginPage.setBackground(new Color(0, 204, 153));
		LoginPage.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(LoginPage);
		LoginPage.setLayout(null);
                
                final JComboBox<String> categoryField = new JComboBox<>();

		JLabel lblNewLabel = new JLabel("SN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(30, 80, 202, 26);
		LoginPage.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Supplier Name");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPassword.setBounds(30, 120, 202, 26);
		LoginPage.add(lblPassword);

		lblNewLabel_1 = new JLabel("Add Supplier");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, -28, 566, 135);
		LoginPage.add(lblNewLabel_1);

		createButton = new JButton("Add Supplier");
               
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idd = idlabel.getText();
                                int id =  Integer.parseInt(idd);
				String name = nameField.getText();
				String contact = contactField.getText();
				//String product = productField.getText();
				//String price = priceField.getText();
                                String category = (String) categoryField.getSelectedItem();
				String mail = emailField.getText();
                                if (category == "Select Item..") {
						JOptionPane.showMessageDialog(null, "Please select an Item");
					} 
                                else{

				try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/inventory";
					String user = "root";
					String pass = "";
					Connection con = DriverManager.getConnection(url, user, pass);
					String Query = "INSERT INTO suppliers (SN,Name,Contact,mailAddress,item) values (?,?,?,?,?)";
					PreparedStatement pstmt = con.prepareStatement(Query);
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setString(3, contact);
					//pstmt.setString(4, product);
					//pstmt.setString(5, price);
					pstmt.setString(4, mail);
                                        pstmt.setString(5, category);

					pstmt.execute();
					JOptionPane.showMessageDialog(null, "New Supplier added");
					dispose();
                                      //  new startingpage().setVisible(true);
                                        //new loginnn();
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
		createButton.setBounds(400, 340, 150, 33);
		createButton.setBorder(null);
		LoginPage.add(createButton);
                
                

		lblNewLabel_3 = new JLabel("____________________________________");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(215, 308, 310, 26);
		LoginPage.add(lblNewLabel_3);

		

		//JLabel lblNewLabel_5 = new JLabel("Product Name");
		//lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		//lblNewLabel_5.setForeground(Color.WHITE);
		//lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		///lblNewLabel_5.setBounds(30, 200, 192, 26);
		//LoginPage.add(lblNewLabel_5);

		nameField = new JTextField();
		nameField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		nameField.setColumns(10);
		nameField.setBorder(null);
		nameField.setBounds(222, 120, 216, 26);
		LoginPage.add(nameField);

		contactField = new JTextField();
		contactField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		contactField.setColumns(10);
		contactField.setBorder(null);
		contactField.setBounds(222, 160, 216, 26);
		LoginPage.add(contactField);

		///JLabel lblPrice = new JLabel("Price");
		////lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		///lblPrice.setForeground(Color.WHITE);
		//lblPrice.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		///lblPrice.setBounds(30, 240, 71, 26);
		///LoginPage.add(lblPrice);

		//productField = new JTextField();
		//productField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		//productField.setColumns(10);
		//productField.setBorder(null);
		//productField.setBounds(222, 200, 216, 26);
		//LoginPage.add(productField);

		JLabel lblNewLabel_5_1 = new JLabel("Contact");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel_5_1.setBounds(30, 160, 192, 26);
		LoginPage.add(lblNewLabel_5_1);

		JLabel lblPrice_1 = new JLabel(":");
		lblPrice_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_1.setForeground(Color.WHITE);
		lblPrice_1.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_1.setBounds(199, 80, 28, 26);
		LoginPage.add(lblPrice_1);

		lblPrice_2 = new JLabel(":");
		lblPrice_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_2.setForeground(Color.WHITE);
		lblPrice_2.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_2.setBounds(199, 120, 28, 26);
		LoginPage.add(lblPrice_2);

		lblPrice_3 = new JLabel(":");
		lblPrice_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_3.setForeground(Color.WHITE);
		lblPrice_3.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_3.setBounds(199, 160, 28, 26);
		LoginPage.add(lblPrice_3);

		//lblPrice_4 = new JLabel(":");
		///lblPrice_4.setHorizontalAlignment(SwingConstants.LEFT);
		///lblPrice_4.setForeground(Color.WHITE);
		//lblPrice_4.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		/////lblPrice_4.setBounds(199, 200, 28, 26);
		///LoginPage.add(lblPrice_4);

		///lblPrice_5 = new JLabel(":");
		///lblPrice_5.setHorizontalAlignment(SwingConstants.LEFT);
		//lblPrice_5.setForeground(Color.WHITE);
		///lblPrice_5.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		//lblPrice_5.setBounds(199, 240, 28, 26);
		///LoginPage.add(lblPrice_5);
                
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
            categoryField.setBounds(350, 200, 192, 26);
		LoginPage.add(categoryField);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
                
		
		try {

			 Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/inventory";
					String user = "root";
					String pass = "";
					Connection con = DriverManager.getConnection(url, user, pass);
			int nextAvailableSN = findNextAvailableSN(con);
			suppid = nextAvailableSN;
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		idlabel = new JLabel(String.valueOf(suppid));
		idlabel.setHorizontalAlignment(SwingConstants.LEFT);
		idlabel.setForeground(Color.WHITE);
		idlabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		idlabel.setBounds(221, 80, 202, 26);
		LoginPage.add(idlabel);
		
		lblNewLabel_2 = new JLabel("Email Address");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel_2.setBounds(30, 230, 192, 26);
		LoginPage.add(lblNewLabel_2);
		
		lblPrice_6 = new JLabel(":");
		lblPrice_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice_6.setForeground(Color.WHITE);
		lblPrice_6.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblPrice_6.setBounds(199, 230, 28, 26);
		LoginPage.add(lblPrice_6);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		emailField.setColumns(10);
		emailField.setBorder(null);
		emailField.setBounds(222, 230, 216, 26);
		LoginPage.add(emailField);
	}
	private static int findNextAvailableSN(Connection connection) throws SQLException {
		String query = "SELECT MAX(SN) + 1 FROM suppliers";

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