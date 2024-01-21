package com.java.project;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Insets;

public class AddPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPassword frame = new AddPassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddPassword() {
		ImageIcon appIcon = loadImageIcon("/app_icon.png");
		ImageIcon backArrow = loadImageIcon("/back_icon.png");

		this.setIconImage(appIcon.getImage());
		this.setTitle("Password Manager");
		this.setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(11, 28, 53));
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 50, 1166, 0 };
		gbl_contentPane.rowHeights = new int[] { 50, 62, 521, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton sampleButton = new JButton();
		sampleButton.setBackground(new Color(11, 28, 53));
		sampleButton
				.setIcon(new ImageIcon(backArrow.getImage().getScaledInstance(50, 50, BufferedImage.TYPE_INT_ARGB)));
		sampleButton.setBounds(0, 0, 20, 20);
		// hide the default button borders
		sampleButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		// hide click events
		sampleButton.setUI(new BasicButtonUI());

		JPanel topPanel = new JPanel();
		topPanel.setBounds(0, 0, 100, 100);
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.setBackground(new Color(0, 0, 0, 0));
		topPanel.add(sampleButton);

		JLabel backNavigationLabel = new JLabel("Back");
		backNavigationLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
		backNavigationLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		backNavigationLabel.setForeground(Color.WHITE);
		topPanel.add(backNavigationLabel);

		JPanel headingLabelContainer = new JPanel(new FlowLayout());
		headingLabelContainer.setBackground(new Color(0, 0, 0, 0));
		JLabel headingLabel = new JLabel("Add Password");
		headingLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
		headingLabel.setForeground(new Color(255, 255, 255));
		headingLabelContainer.add(headingLabel);

		topPanel.add(headingLabelContainer, BorderLayout.WEST);

		GridBagConstraints gbc_topPanel = new GridBagConstraints();
		gbc_topPanel.anchor = GridBagConstraints.NORTH;
		gbc_topPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_topPanel.insets = new Insets(0, 0, 5, 0);
		gbc_topPanel.gridx = 1;
		gbc_topPanel.gridy = 1;
		contentPane.add(topPanel, gbc_topPanel);

		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 10 };

		JPanel contentPanel = new JPanel(gbl_contentPanel);
		contentPanel.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		contentPanel.setBounds(0, 0, 500, 500);
		contentPanel.setBackground(new Color(0, 0, 0, 0.3f));

		GridBagConstraints contentPanelConstraints = new GridBagConstraints();
		final int contentPanelPadding = 60;

		contentPanelConstraints.fill = GridBagConstraints.BOTH;
		contentPanelConstraints.insets = new Insets(contentPanelPadding, contentPanelPadding, contentPanelPadding,
				contentPanelPadding);
		contentPanelConstraints.gridx = 1;
		contentPanelConstraints.gridy = 2;

		JTextField websiteName = new JTextField("Enter the website Url");
		websiteName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JTextField websiteUserName = new JTextField("Enter the Website Username");
		websiteUserName.setFont(new Font("Tahoma", Font.PLAIN, 25));
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		saveButton.setBackground(new Color(217, 217, 217));

		final int contentTextFieldPaddingBase = 10;
		final int contentTextFieldPaddingHorizontal = 20;
		final int contentTextFieldPaddingTop = 10;
		final int contentTextFieldPaddingBottom = 10;

		GridBagConstraints websiteNameGridBagConstraints = new GridBagConstraints();
		websiteNameGridBagConstraints.gridx = 0;
		websiteNameGridBagConstraints.gridy = 0;
		websiteNameGridBagConstraints.fill = GridBagConstraints.BOTH;
		websiteNameGridBagConstraints.weightx = 1.0;
		websiteNameGridBagConstraints.weighty = 1.0;
		websiteNameGridBagConstraints.insets = new Insets(contentTextFieldPaddingBase + contentTextFieldPaddingTop,
				contentTextFieldPaddingBase + contentTextFieldPaddingHorizontal, contentTextFieldPaddingBase,
				contentTextFieldPaddingBase + contentTextFieldPaddingHorizontal);
		websiteNameGridBagConstraints.anchor = GridBagConstraints.PAGE_START;
		contentPanel.add(websiteName, websiteNameGridBagConstraints);

		GridBagConstraints websiteUserNameGridBagConstraints = new GridBagConstraints();
		websiteUserNameGridBagConstraints.gridx = 0;
		websiteUserNameGridBagConstraints.gridy = 1;
		websiteUserNameGridBagConstraints.fill = GridBagConstraints.BOTH;
		websiteUserNameGridBagConstraints.weightx = 1.0;
		websiteUserNameGridBagConstraints.weighty = 1.0;
		websiteUserNameGridBagConstraints.insets = new Insets(contentTextFieldPaddingBase,
				contentTextFieldPaddingBase + contentTextFieldPaddingHorizontal, contentTextFieldPaddingBase,
				contentTextFieldPaddingBase + contentTextFieldPaddingHorizontal);
		websiteUserNameGridBagConstraints.anchor = GridBagConstraints.PAGE_START;
		contentPanel.add(websiteUserName, websiteUserNameGridBagConstraints);
		

		GridBagLayout gbl_passwordPanel = new GridBagLayout();
		gbl_passwordPanel.columnWidths = new int[]{10, 0};
		gbl_passwordPanel.rowHeights = new int[]{0, 0};
		gbl_passwordPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_passwordPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};

		JPanel passwordPanel = new JPanel(gbl_passwordPanel);

		GridBagConstraints gbc_passwordPanel = new GridBagConstraints();
		gbc_passwordPanel.fill = GridBagConstraints.BOTH;
		gbc_passwordPanel.insets = new Insets(contentTextFieldPaddingBase,
				contentTextFieldPaddingBase + contentTextFieldPaddingHorizontal, contentTextFieldPaddingBase + contentTextFieldPaddingBottom,
				contentTextFieldPaddingBase + contentTextFieldPaddingHorizontal);
		gbc_passwordPanel.gridx = 0;
		gbc_passwordPanel.gridy = 2;
		gbc_passwordPanel.weightx = 1.0;
		gbc_passwordPanel.weighty = 1.0;		

		JTextField websiteUserPassword = new JTextField("Enter the Website Password");				
		websiteUserPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));

		GridBagConstraints gbc_websiteUserPassword = new GridBagConstraints();
		gbc_websiteUserPassword.fill = GridBagConstraints.BOTH;
		gbc_websiteUserPassword.gridx = 0;
		gbc_websiteUserPassword.gridy = 0;
		gbc_websiteUserPassword.weightx = 1.0;
		gbc_websiteUserPassword.weighty = 1.0;				
		passwordPanel.add(websiteUserPassword, gbc_websiteUserPassword);

		contentPanel.add(passwordPanel, gbc_passwordPanel);

		GridBagConstraints saveButtonGridBagConstraints = new GridBagConstraints();
		saveButtonGridBagConstraints.weightx = 1.0;
		saveButtonGridBagConstraints.gridx = 0;
		saveButtonGridBagConstraints.gridy = 3;
		saveButtonGridBagConstraints.fill = GridBagConstraints.BOTH;
		saveButtonGridBagConstraints.weighty = 0.5;
		saveButtonGridBagConstraints.insets = new Insets(10, 200, 10, 200);
		saveButtonGridBagConstraints.anchor = GridBagConstraints.PAGE_START;
		contentPanel.add(saveButton, saveButtonGridBagConstraints);

		contentPane.add(contentPanel, contentPanelConstraints);

		setContentPane(contentPane);
	}

	private static ImageIcon loadImageIcon(String path) {
		URL imageURL = AddPassword.class.getResource(path);

		if (imageURL != null) {
			try {
				BufferedImage image = ImageIO.read(imageURL);
				return new ImageIcon(image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

}
