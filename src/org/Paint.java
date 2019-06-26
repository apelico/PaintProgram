package org;

import java.awt.Color;

public class Paint {
	
	//The static functions
	public static Color colorOne= new Color(0,0,0);
	public static int brushSize = 1;
	
	public static Color getColor() {
		return colorOne;
	}
	
	public static void setColor(int red, int blue, int green)
	{
		colorOne = new Color(red,blue,green);
	}
	
	public static void setRed(int red)
	{
		colorOne = new Color(red,colorOne.getGreen(),colorOne.getBlue());
	}
	
	public static void setGreen(int green)
	{
		colorOne = new Color(colorOne.getRed(),green,colorOne.getBlue());
	}
	
	public static void setBlue(int blue)
	{
		colorOne = new Color(colorOne.getRed(),colorOne.getGreen(),blue);
	}
}
