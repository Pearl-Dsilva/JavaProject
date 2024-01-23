package com.java.project;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;

	public SignUp() {
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jLabel3 = new JLabel();
		jPanel3 = new JPanel();
		jLabel1 = new JLabel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		jLabel2 = new JLabel();
		jButton1 = new JButton();
		jButton2 = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("SignUp");
		setPreferredSize(new java.awt.Dimension(800, 500));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));
		jPanel1.setForeground(new java.awt.Color(255, 255, 255));
		jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
		jPanel1.setLayout(null);

		jPanel2.setBackground(new java.awt.Color(11, 28, 53));
		jPanel2.setPreferredSize(new java.awt.Dimension(400, 500));

		jLabel3.setIcon(new ImageIcon("/add.png"));
		jLabel3.setText("jLabel3");

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(81, 81, 81)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(85, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(120, 120, 120).addComponent(jLabel3)
						.addContainerGap(155, Short.MAX_VALUE)));

		jPanel1.add(jPanel2);
		jPanel2.setBounds(0, 0, 400, 500);

		jPanel3.setBackground(new java.awt.Color(16, 28, 70));
		jPanel3.setPreferredSize(new java.awt.Dimension(400, 500));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Sign Up");

		jTextField1.setFont(new java.awt.Font("Tahoma", 0, 12));
		jTextField1.setText("Name");
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				jTextField1ActionPerformed(e);
			}
		});

		jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12));
		jTextField2.setText("Confirm  Password");
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				jTextField2ActionPerformed(e);
			}
		});

		jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12));
		jTextField3.setText("Password");
		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				jTextField3ActionPerformed(e);
			}
		});

		jLabel2.setForeground(new java.awt.Color(0, 153, 51));
		jLabel2.setText("Already have an account?");

		jButton1.setBackground(new java.awt.Color(16, 28, 70));
		jButton1.setFont(new java.awt.Font("Tahoma", 0, 10));
		jButton1.setForeground(new java.awt.Color(0, 153, 51));
		jButton1.setText("Sign in");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				jButton1ActionPerformed(e);
			}
		});

		jButton2.setFont(new java.awt.Font("Tahoma", 0, 12));
		jButton2.setText("Sign Up");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup().addGap(133, 133, 133)
												.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 119,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel3Layout.createSequentialGroup().addGap(108, 108, 108)
												.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 168,
														GroupLayout.PREFERRED_SIZE))))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(124, 124, 124).addComponent(jLabel2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(jButton1)))
						.addContainerGap(63, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE).addComponent(jButton2).addGap(159, 159, 159)));
		jPanel3Layout
				.setVerticalGroup(
						jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(
										jPanel3Layout.createSequentialGroup().addGap(54, 54, 54).addComponent(jLabel1)
												.addGap(43, 43, 43)
												.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(35, 35, 35)
												.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(39, 39, 39)
												.addGroup(jPanel3Layout
														.createParallelGroup(GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2).addComponent(jButton1,
																GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jButton2).addContainerGap(152, Short.MAX_VALUE)));

		jPanel1.add(jPanel3);
		jPanel3.setBounds(400, 0, 400, 500);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout
								.createSequentialGroup().addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout
								.createSequentialGroup().addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		Login LoginFrame = new Login();
		LoginFrame.setVisible(true);
		LoginFrame.pack();
		LoginFrame.setLocationRelativeTo(null);
		this.dispose();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		String username = jTextField1.getText();
		String password = jTextField3.getText();
		String confirmPassword = jTextField2.getText();

		if (password.equals(confirmPassword)) {
			if (createUser(username, password)) {
				JOptionPane.showMessageDialog(this, "Account created successfully", "Signup Success",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Failed to create account", "Signup Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Passwords do not match", "Signup Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean createUser(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Vault", "root", "Zombie@2347245");
			String query = "INSERT INTO users_details (username, password) VALUES (?, ?)";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			int result = pst.executeUpdate();

			return result > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
