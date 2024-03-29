package com.java.project;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

public class Settings extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setTitle("Home");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(11, 28, 53));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JButton settingsButton = new JButton("");
		settingsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				settingsButtonClicked(e);
			}
		});
		settingsButton.setVerticalAlignment(SwingConstants.TOP);
		settingsButton.setHorizontalAlignment(SwingConstants.LEFT);
		settingsButton.setBounds(55, 46, 100, 100);
		settingsButton.setForeground(new Color(0, 0, 0));
		settingsButton.setBackground(new Color(11, 28, 53));
		Image settings_img = new ImageIcon(this.getClass().getResource("/back_icon.png")).getImage()
				.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		Image settings_img_dark = new ImageIcon(this.getClass().getResource("/back_dark.png")).getImage()
				.getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
		settingsButton.setIcon(new ImageIcon(settings_img));
		settingsButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		settingsButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		settingsButton.setUI(new BasicButtonUI());
		contentPane.add(settingsButton);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(settingsButton);

		JLabel backLabel = new JLabel("Back");
		backLabel.setForeground(new Color(255, 255, 255));

		backLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		backLabel.setBounds(165, 46, 150, 100);
		contentPane.add(backLabel);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(125, 300, 1000, 3);
		contentPane.add(separator);

		JLabel darkModeLabel = new JLabel("Dark Mode");
		darkModeLabel.setForeground(new Color(255, 255, 255));
		darkModeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		darkModeLabel.setBounds(125, 216, 215, 34);
		contentPane.add(darkModeLabel);

		JToggleButton toggleButton = new JToggleButton();
		toggleButton.setBounds(1005, 204, 70, 50);
		toggleButton.setForeground(new Color(0, 0, 0));
		toggleButton.setBackground(new Color(11, 28, 53));
		Image toggle_on_img = new ImageIcon(this.getClass().getResource("/toggle-on.png")).getImage()
				.getScaledInstance(70, 70, DO_NOTHING_ON_CLOSE);
		Image toggle_off_img = new ImageIcon(this.getClass().getResource("/toggle-off.png")).getImage()
				.getScaledInstance(70, 70, DO_NOTHING_ON_CLOSE);
		toggleButton.setIcon(new ImageIcon(toggle_on_img));
		toggleButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		toggleButton.setUI(new BasicButtonUI());
		toggleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (toggleButton.isSelected()) {
					contentPane.setBackground(Color.WHITE);
					settingsButton.setBackground(Color.WHITE);
					backLabel.setForeground(new Color(11, 28, 53));
					toggleButton.setBackground(Color.WHITE);
					darkModeLabel.setForeground(new Color(11, 28, 53));
					separator.setForeground(new Color(11, 28, 53));
					toggleButton.setIcon(new ImageIcon(toggle_off_img));
					settingsButton.setIcon(new ImageIcon(settings_img_dark));
				} else {
					contentPane.setBackground(null);
					toggleButton.setIcon(new ImageIcon(toggle_on_img));
					settingsButton.setIcon(new ImageIcon(settings_img));
					backLabel.setForeground(new Color(255, 255, 255));
					contentPane.setBackground(new Color(11, 28, 53));
					settingsButton.setBackground(new Color(11, 28, 53));
					toggleButton.setBackground(new Color(11, 28, 53));
					darkModeLabel.setForeground(Color.WHITE);
					separator.setForeground(Color.WHITE);
					separator.setBackground(Color.WHITE);
				}
			}
		});
		contentPane.add(toggleButton);
	}

	private void settingsButtonClicked(ActionEvent e) {
		Home.main(null);
		this.dispose();
	}
}