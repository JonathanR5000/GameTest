package FullScreen;

import java.awt.*;
import javax.swing.JFrame;

public class SimpleScreenManager {

	private GraphicsDevice device;
	/**
	Creates a new SimpleScreenManager object.
	*/
	public SimpleScreenManager() {
	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
	device = environment.getDefaultScreenDevice();
	}
	/**
	Enters full screen mode and changes the display mode.
	*/
	public void setFullScreen(DisplayMode displayMode, JFrame window)
	{
		window.setUndecorated(true);
		window.setResizable(false);
		device.setFullScreenWindow(window);
	if (displayMode != null &&
	device.isDisplayChangeSupported())
	{
	try {
	device.setDisplayMode(displayMode);
	}
	catch (IllegalArgumentException ex) {
	// ignore - illegal mode for this device
			}
		}
	}
	/**
	Returns the window currently used in full screen mode.
	*/
	public java.awt.Window getFullScreenWindow() {
	return device.getFullScreenWindow();
	}
	/**
	Restores the screen's display mode.
	*/
	public void restoreScreen() {
	java.awt.Window window = device.getFullScreenWindow();
	if (window != null) {
	window.dispose();
	}
	device.setFullScreenWindow(null);
	}
}