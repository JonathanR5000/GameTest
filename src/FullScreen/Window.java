package FullScreen;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window extends JFrame{

	public static void main(String[] args) {
		JFrame window = new JFrame();
		DisplayMode displayMode = new DisplayMode(800, 600, 16, 75); 
		
		//get the Graphics Device
		
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		
		// use the JFrame as the full screen window
		device.setFullScreenWindow(window);
		
		// change the display mode
		device.setDisplayMode(displayMode);
		
		device.setFullScreenWindow(null);
	}
}