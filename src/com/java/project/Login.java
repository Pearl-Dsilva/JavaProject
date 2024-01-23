package com.java.project;

import java.awt.Color;
import java.awt.Dimension;
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

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JButton Signinbutton;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JPanel left;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		jPanel1 = new JPanel();
		jPanel2 = new JPanel();
		jLabel3 = new JLabel();
		left = new JPanel();
		jLabel1 = new JLabel();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		Signinbutton = new JButton();
		jLabel2 = new JLabel();
		jButton2 = new JButton();

		setTitle("Password Manager");
		setPreferredSize(new Dimension(800, 500));

		jPanel1.setBackground(new Color(11, 28, 53));
		jPanel1.setPreferredSize(new Dimension(800, 500));
		jPanel1.setLayout(null);

		jPanel2.setBackground(new Color(15, 28, 70));
		jPanel2.setForeground(new Color(255, 255, 255));
		jPanel2.setPreferredSize(new Dimension(400, 500));

		jLabel3.setFont(new Font("Tahoma", 1, 24));
//		jLabel3.setForeground(new Color(153, 153, 153));
		jLabel3.setBackground(new Color(0, 255, 0));
		jLabel3.setIcon(new ImageIcon("/add.png"));

		GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(218, Short.MAX_VALUE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGap(77)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(144)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(187, Short.MAX_VALUE)));
		jPanel2.setLayout(jPanel2Layout);

		jPanel1.add(jPanel2);
		jPanel2.setBounds(0, 0, 400, 500);

		left.setBackground(new Color(11, 28, 53));
		left.setForeground(new Color(255, 255, 255));
		left.setPreferredSize(new Dimension(400, 500));

		jLabel1.setFont(new Font("Tahoma", 1, 36));
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel1.setText("    Sign  in");

		jTextField2.setFont(new Font("Tahoma", 0, 12));
		jTextField2.setText("Name");
		jTextField2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField2ActionPerformed(e);
			}
		});

		jTextField3.setFont(new Font("Tahoma", 0, 12));
		jTextField3.setText("Password");
		jTextField3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextField3ActionPerformed(e);
			}
		});

		Signinbutton.setFont(new Font("Tahoma", 0, 12)); // NOI18N
		Signinbutton.setText("Sign in");
		Signinbutton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				SigninbuttonMouseClicked(evt);
			}
		});
		Signinbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SigninbuttonActionPerformed(e);
			}
		});

		jLabel2.setForeground(new Color(0, 153, 51));
		jLabel2.setText("Don't have an account?");

		jButton2.setBackground(new Color(11, 28, 53));
		jButton2.setFont(new Font("Tahoma", 0, 12));
		jButton2.setForeground(new Color(0, 153, 51));
		jButton2.setText("Sign up");

		GroupLayout leftLayout = new GroupLayout(left);
		left.setLayout(leftLayout);
		leftLayout.setHorizontalGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(leftLayout.createSequentialGroup().addContainerGap(74, Short.MAX_VALUE)
						.addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										leftLayout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jButton2).addGap(100, 100, 100))
								.addGroup(GroupLayout.Alignment.TRAILING,
										leftLayout.createSequentialGroup()
												.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 192,
														GroupLayout.PREFERRED_SIZE)
												.addGap(92, 92, 92))
								.addGroup(GroupLayout.Alignment.TRAILING,
										leftLayout.createSequentialGroup()
												.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 255,
														GroupLayout.PREFERRED_SIZE)
												.addGap(71, 71, 71))
								.addGroup(GroupLayout.Alignment.TRAILING,
										leftLayout.createSequentialGroup()
												.addComponent(Signinbutton, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addGap(151, 151, 151))))
				.addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
						GroupLayout.Alignment.TRAILING,
						leftLayout.createSequentialGroup().addContainerGap(117, Short.MAX_VALUE)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
								.addGap(94, 94, 94))));
		leftLayout.setVerticalGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(leftLayout
				.createSequentialGroup().addGap(45, 45, 45)
				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE).addGap(34, 34, 34)
				.addComponent(
						jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(89, 89, 89)
				.addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(jLabel2)
						.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18).addComponent(Signinbutton).addContainerGap(178, Short.MAX_VALUE))
				.addGroup(leftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(leftLayout.createSequentialGroup().addGap(201, 201, 201).addComponent(jTextField3,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(275, Short.MAX_VALUE))));

		jPanel1.add(left);
		left.setBounds(400, 0, 400, 500);

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

		getAccessibleContext().setAccessibleName("login");

		pack();
	}

	private void jTextField2ActionPerformed(ActionEvent e) {
	}

	private void jTextField3ActionPerformed(ActionEvent e) {
	}

	private void SigninbuttonMouseClicked(MouseEvent e) {
	}

	private void SigninbuttonActionPerformed(ActionEvent evt) {
		String username = jTextField2.getText();
		String password = jTextField3.getText();

		if (authenticateUser(username, password)) {
			Home.startAddPasswordScreen(() -> {
				Login.this.setVisible(true);
			});
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private boolean authenticateUser(String username, String password) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "64152737");
			String query = "SELECT * FROM users_details WHERE username = ? AND password = ?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();

			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
