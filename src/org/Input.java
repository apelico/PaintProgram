package org;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements MouseListener, MouseMotionListener{
	Window window;
	
	public Input(Window w) {
		window = w;
		window.getCanvas().addMouseListener(this);
		window.getCanvas().addMouseMotionListener(this);
		window.SetPixel(75, 75, 0xffffffff);
	}

	//The draw input
	@Override
	public void mouseDragged(MouseEvent e) {
		
		for (int x = -Paint.brushSize/2; x < Paint.brushSize/2 ; x++)
		{
		    int height = (int)Math.sqrt((Paint.brushSize/2) * (Paint.brushSize/2) - x * x);

		    for (int y = -height; y < height; y++)
		    	if(x + e.getX() < 800 && y + e.getY() < 530 && x + e.getX() > 0 && y + e.getY() > 0)
		    		window.SetPixel(x + e.getX(), y +  e.getY(), Paint.colorOne.getRGB());
		        //bmp.SetPixel(x + ox, y + oy, Color.Red);
		}
		
		
		/*for(int x = e.getX() - Paint.brushSize/2; x < e.getX() + Paint.brushSize;x++)  
		{
			for(int y = e.getY() - Paint.brushSize/2; y < e.getY() + Paint.brushSize;y++)
			{
				if(((x- e.getX()) * (x- e.getX())) + ((y- e.getY()) * (y- e.getY())) < Paint.brushSize)
				{
					window.SetPixel(x, y, Paint.colorOne.getRGB());
				}
			}
		}*/
		//window.SetPixel(e.getX(), e.getY(), Paint.colorOne.getRGB());
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		window.SetPixel(e.getX(), e.getY(), 0xffffffff);
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
