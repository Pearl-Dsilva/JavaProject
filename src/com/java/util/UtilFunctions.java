package com.java.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.java.project.AddPassword;

public class UtilFunctions {
	public static ImageIcon loadImageIcon(String path) {
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
