package com.java.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField searchText;

	public static void main(String[] args) {
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
//			System.out.println("Record Entered");
			Home.this.setVisible(true);
		});
	}

	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Home");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(11, 28, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		/////////// card logic///////
		ExpandableCard expandableCard = new ExpandableCard("Website  Username", "actual data goes here");
		expandableCard.setForeground(new Color(11, 28, 53));
		expandableCard.setBackground(new Color(11, 28, 53));
		expandableCard.setLocation(241, 178);
		expandableCard.setSize(723, 99);

		contentPane.add(expandableCard, BorderLayout.CENTER);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton searchButton = new JButton("Search");
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
				Home.this.navigateToAddPassword();
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
	}
}

class ExpandableCard extends JPanel {
	private JButton toggleButton;
	private JPanel contentPanel;

	public ExpandableCard(String buttonText, String contentText) {
		setLayout(new BorderLayout());

		toggleButton = new JButton(buttonText);
		toggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toggleContent();
			}
		});
		toggleButton.setBackground(new Color(35, 50, 73));

		contentPanel = new JPanel();
		contentPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

		JPanel iconsPanel = new JPanel();
		iconsPanel.setBackground(new Color(35, 50, 73));
		GridBagConstraints textGbc = new GridBagConstraints();
		textGbc.gridx = 0;
		textGbc.gridy = 0;
		textGbc.anchor = GridBagConstraints.CENTER;
		textGbc.fill = GridBagConstraints.NONE;

		JButton copyButton = new JButton();
		copyButton.setBackground(new Color(11, 28, 53));
		Image copy_img = new ImageIcon(this.getClass().getResource("/copy.png")).getImage().getScaledInstance(20, 20,
				ABORT);
		copyButton.setIcon(new ImageIcon(copy_img));
		copyButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		copyButton.setUI(new BasicButtonUI());
		copyButton.setBackground(new Color(35, 50, 73));
		iconsPanel.add(copyButton); // copy button

		JButton showButton = new JButton();
		showButton.setBackground(new Color(11, 28, 53));
		Image show_img = new ImageIcon(this.getClass().getResource("/show.png")).getImage().getScaledInstance(20, 20,
				ABORT);
		showButton.setIcon(new ImageIcon(show_img));
		showButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		showButton.setUI(new BasicButtonUI());
		showButton.setBackground(new Color(35, 50, 73));
		iconsPanel.add(showButton); // show button

		JButton deleteButton = new JButton();
		deleteButton.setBackground(new Color(11, 28, 53));
		Image delete_img = new ImageIcon(this.getClass().getResource("/delete.png")).getImage().getScaledInstance(20,
				20, ABORT);
		deleteButton.setIcon(new ImageIcon(delete_img));
		deleteButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		deleteButton.setUI(new BasicButtonUI());
		deleteButton.setBackground(new Color(35, 50, 73));
		iconsPanel.add(deleteButton); // delete button

		JLabel contentLbl = new JLabel(contentText);
		contentLbl.setForeground(Color.WHITE);
		contentPanel.add(contentLbl, textGbc);
		contentPanel.add(iconsPanel, gbc);
		contentPanel.setBackground(new Color(35, 50, 73));
		add(toggleButton, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);

		// color
		toggleButton.setForeground(Color.WHITE);

		System.out.println(contentPanel.getForeground());
		System.out.println(toggleButton.getForeground());

		contentPanel.setVisible(false);
		contentPanel.setForeground(Color.WHITE);
	}

	private void toggleContent() {
		contentPanel.setVisible(!contentPanel.isVisible());
	}
}
