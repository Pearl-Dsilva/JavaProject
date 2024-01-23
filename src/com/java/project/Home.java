package com.java.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import com.java.database.DataModel;
import com.java.database.JDBCHelper;
import com.java.util.UtilFunctions;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchText;
	private JPanel cardsPanel;
	private static DisposeHandler dispose_after;
	
	public static void startAddPasswordScreen(DisposeHandler dispose_after) {
		Home.dispose_after = dispose_after;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void navigateToAddPassword() {
		AddPassword.startAddPasswordScreen(() -> {
			Home.this.setVisible(true);
		});
	}

	public Home() {
		ImageIcon appIcon = UtilFunctions.loadImageIcon("/app_icon.png");
		Color themeColor = new Color(11, 28, 53);

		this.setIconImage(appIcon.getImage());
		this.setTitle("Password Manager");
		this.setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setBackground(themeColor);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(themeColor);
		scrollPane.setBounds(241, 178, 723, 450);

		cardsPanel = new JPanel();
		cardsPanel.setBorder(null);
		cardsPanel.setBackground(themeColor);
		cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.PAGE_AXIS));

		scrollPane.setViewportView(cardsPanel);
		contentPane.add(scrollPane);

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JButton searchButton = new JButton("Search");
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (searchText.getText() != "")
					filter(searchText.getText(), cardsPanel);
			}
		});
		searchButton.setBounds(880, 105, 80, 35);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		searchButton.setForeground(Color.WHITE);
		searchButton.setBackground(new Color(35, 50, 73));
		contentPane.add(searchButton);

		JButton addButton = new JButton();
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home.this.setVisible(false);
				AddPassword.startAddPasswordScreen(() -> {
					Home.this.setVisible(true);
					cardsPanel.removeAll();
					initialLoad(cardsPanel);
				});
			}
		});
		addButton.setBackground(new Color(11, 28, 53));
		addButton.setBounds(1107, 556, 50, 50);
		Image add_img = new ImageIcon(this.getClass().getResource("/add.png")).getImage().getScaledInstance(50, 50,
				DO_NOTHING_ON_CLOSE);
		addButton.setIcon(new ImageIcon(add_img));
		addButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		addButton.setUI(new BasicButtonUI());
		contentPane.add(addButton);

		JButton settingsButton = new JButton("");
		settingsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// goes to settings page
			}
		});
		settingsButton.setBounds(55, 46, 50, 50);
		settingsButton.setForeground(new Color(0, 0, 0));
		settingsButton.setBackground(new Color(11, 28, 53));
		Image settings_img = new ImageIcon(this.getClass().getResource("/settings.png")).getImage()
				.getScaledInstance(50, 50, DO_NOTHING_ON_CLOSE);
		settingsButton.setIcon(new ImageIcon(settings_img));
		settingsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		settingsButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		settingsButton.setUI(new BasicButtonUI());

		contentPane.add(settingsButton);

		searchText = new JTextField();
		searchText.setBounds(241, 106, 600, 35);
		contentPane.add(searchText);
		searchText.setColumns(10);
		initialLoad(cardsPanel);
		scrollPane.revalidate();
		scrollPane.repaint();
	}

	public void addPasswordEntry(JPanel panel, DataModel data) {
		JPanel panelContent = new JPanel();
		panelContent.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelContent.setBackground(new Color(11, 28, 53));

		panelContent.setMaximumSize(new Dimension(9900, 100));
		panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.X_AXIS));

		JPanel item = new JPanel();
		item.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		item.setBackground(new Color(0, 0, 0));
		item.setSize(new Dimension(50, 50));
		item.setLayout(new BoxLayout(item, BoxLayout.Y_AXIS));

		JPanel websiteNamePanel = new JPanel();
		websiteNamePanel.setBorder(new EmptyBorder(0, 5, 0, 0));
		websiteNamePanel.setBackground(new Color(11, 28, 53));
		item.add(websiteNamePanel);
		websiteNamePanel.setLayout(new BorderLayout(0, 0));

		JLabel websiteName = new JLabel(data.getUrl());
		websiteNamePanel.add(websiteName, BorderLayout.WEST);
		websiteName.setFont(new Font("Tahoma", Font.BOLD, 15));
		websiteName.setAlignmentX(Component.LEFT_ALIGNMENT);
		websiteName.setForeground(new Color(255, 255, 255));
		websiteName.setBackground(new Color(11, 28, 53));
		panelContent.add(item);

		JPanel websiteControlsPanel = new JPanel();
		websiteControlsPanel.setBackground(new Color(11, 28, 53));

		JPanel userNamePanel = new JPanel();
		userNamePanel.setBackground(new Color(11, 28, 53));

		JLabel userName = new JLabel(data.getUsername());
		userName.setForeground(new Color(255, 255, 255));
		userName.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton userNameCopyButton = new JButton();
		userNameCopyButton.setBorder(null);
		userNameCopyButton.setBackground(new Color(11, 28, 53));
		userNameCopyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		userNameCopyButton.setIcon(new ImageIcon(
				UtilFunctions.loadImageIcon("/copy.png").getImage().getScaledInstance(25, 25, DO_NOTHING_ON_CLOSE)));

		userNamePanel.add(userName);
		userNamePanel.add(userNameCopyButton);

		JPanel passwordPanel = new JPanel();
		passwordPanel.setBackground(new Color(11, 28, 53));

		JLabel userPassword = new JLabel(data.getPassword());
		userPassword.setForeground(new Color(255, 255, 255));
		userPassword.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton passwordCopyButton = new JButton();
		passwordCopyButton.setBorder(null);
		passwordCopyButton.setBackground(new Color(11, 28, 53));
		passwordCopyButton.setIcon(new ImageIcon(
				UtilFunctions.loadImageIcon("/copy.png").getImage().getScaledInstance(25, 25, DO_NOTHING_ON_CLOSE)));
		passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		passwordPanel.add(userPassword);
		passwordPanel.add(passwordCopyButton);
		websiteControlsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		websiteControlsPanel.add(userNamePanel);
		websiteControlsPanel.add(passwordPanel);
		websiteControlsPanel.add(Box.createHorizontalGlue());

		item.add(websiteControlsPanel);
		panel.add(panelContent);
		panel.repaint();
		panel.revalidate();
	}

	private void initialLoad(JPanel panel) {
		ArrayList<DataModel> data = JDBCHelper.read();
		data.forEach((item) -> {
			addPasswordEntry(panel, item);
		});
	}

	private void filter(String websiteName, JPanel panel) {
		ArrayList<DataModel> data = JDBCHelper.read(websiteName);
		cardsPanel.removeAll();
		data.forEach((item) -> {
			addPasswordEntry(panel, item);
		});
	}
}
