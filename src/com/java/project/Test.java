package com.java.project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.java.database.DataModel;
import com.java.database.JDBCHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Test extends JFrame {

    private JPanel contentPane;
    private JTextField searchText;
    private JPanel cardsPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Home frame = new Home();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Test() {
        SwingUtilities.invokeLater(() -> {
            // Set up JFrame properties
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 1280, 720);
            setResizable(false);
            setTitle("Password Manager");

            // Set up contentPane with BorderLayout
            contentPane = new JPanel(new BorderLayout());
            contentPane.setBackground(new Color(11, 28, 53));
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

            // Create a JScrollPane
            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBorder(null);
            scrollPane.setBackground(new Color(0, 0, 0, 0));
            scrollPane.setOpaque(true);  // Set opaque for the scroll pane

            // Create a JPanel for password entries
            cardsPanel = new JPanel();
            cardsPanel.setBackground(new Color(0, 0, 0, 0));
            cardsPanel.setLayout(new BoxLayout(cardsPanel, BoxLayout.PAGE_AXIS));
            cardsPanel.setOpaque(true);  // Set opaque for the cardsPanel

            // Add the cardsPanel to the JScrollPane
            scrollPane.setViewportView(cardsPanel);

            // Add the JScrollPane to the center of the contentPane
            contentPane.add(scrollPane, BorderLayout.CENTER);

            // Create a panel for buttons
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            buttonPanel.setBackground(new Color(0, 0, 0, 0));
            buttonPanel.setOpaque(true);  // Set opaque for the buttonPanel

            // Create buttons
            JButton searchButton = new JButton("Search");
            JButton addButton = new JButton(new ImageIcon(getClass().getResource("/add.png")));
            JButton settingsButton = new JButton(new ImageIcon(getClass().getResource("/settings.png")));

            // Add ActionListeners to buttons
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle search button click
                }
            });

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	Test.this.setVisible(false);
                    AddPassword.startAddPasswordScreen(() -> Test.this.setVisible(true));
                }
            });

            settingsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle settings button click
                }
            });

            // Add buttons to the buttonPanel
            buttonPanel.add(searchButton);
            buttonPanel.add(addButton);
            buttonPanel.add(settingsButton);

            // Add the buttonPanel to the north of the contentPane
            contentPane.add(buttonPanel, BorderLayout.NORTH);

            // Create a search text field
            searchText = new JTextField();
            contentPane.add(searchText, BorderLayout.SOUTH);

            // Add the contentPane to the JFrame
            setContentPane(contentPane);

            // Initialize with dummy data
            initialLoad(cardsPanel);
        });
    }

    public void addPasswordEntry(JPanel panel) {
        // Add password entry to the panel
        // ... existing code ...
    }

    private void initialLoad(JPanel panel) {
        // Load initial data
        ArrayList<DataModel> data = JDBCHelper.read();
        data.forEach((item) -> {
            addPasswordEntry(cardsPanel);
        });
    }
}
