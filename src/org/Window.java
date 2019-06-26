package org;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.Font;

public class Window {
	int[] pixels;
	private BufferStrategy bufferStrategy;
	private BufferedImage bufferedImage;
	private Graphics g;
	private Canvas canvas;
	private JFrame frame;

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	JPanel colorTab;
	public Window() {

		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		canvas = new Canvas();
		canvas.setSize(WIDTH, HEIGHT);
		
		JPanel colorTab = new JPanel();
		colorTab.setBackground(Paint.getColor());
		colorTab.setBounds(200, 540, 60, 60);
		frame.getContentPane().add(colorTab);
		
		JSlider redSlider = new JSlider();
		redSlider.setBackground(new Color(0xff0f0f0f));
		redSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Paint.setRed(redSlider.getValue());
				colorTab.setBackground(Paint.getColor());
			}
		});
		redSlider.setValue(50);
		redSlider.setMaximum(255);
		redSlider.setBounds(0, 540, 200, 20);
		frame.getContentPane().add(redSlider);
		
		JSlider greenSlider = new JSlider();
		greenSlider.setBackground(new Color(0xff0f0f0f));
		greenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Paint.setGreen(greenSlider.getValue());
				colorTab.setBackground(Paint.getColor());
			}
		});
		greenSlider.setValue(50);
		greenSlider.setMaximum(255);
		greenSlider.setBounds(0, 560, 200, 20);
		frame.getContentPane().add(greenSlider);
		//Stuff
		JSlider blueSlider = new JSlider();
		blueSlider.setBackground(new Color(0xff0f0f0f));
		blueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Paint.setBlue(blueSlider.getValue());
				colorTab.setBackground(Paint.getColor());
			}
		});
		blueSlider.setValue(50);
		blueSlider.setMaximum(255);
		blueSlider.setBounds(0, 580, 200, 20);
		frame.getContentPane().add(blueSlider);
		
		JLabel pixelSize = new JLabel(Paint.brushSize + "px");
		pixelSize.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pixelSize.setBounds(460, 555, 50, 32);
		frame.getContentPane().add(pixelSize);
		
		JSlider brushSize = new JSlider();
		brushSize.setBackground(new Color(0xff0f0f0f));
		brushSize.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				Paint.brushSize = brushSize.getValue();
				pixelSize.setText(Paint.brushSize + "px");
			}
		});
		brushSize.setValue(10);
		brushSize.setMinimum(2);
		brushSize.setMaximum(50);
		brushSize.setBounds(260, 560, 200, 20);
		frame.getContentPane().add(brushSize);

		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
		
		

		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();
		setGUI();
		Render();
	}

	public void SetPixel(int x, int y, int color) {
		bufferedImage.setRGB(x, y, color);
	}
	
	void setGUI() {
		
		for(int x = 0; x < WIDTH;x++)
		{
			for(int y = 0; y < HEIGHT;y++)
			{
				if(y < 530) {
					SetPixel(x, y, 0xffffffff);
				}else
					SetPixel(x, y, 0xff0f0f0f);
			}
		}
	}

	public void Render() {
		g = bufferStrategy.getDrawGraphics();
		g.drawImage(bufferedImage, 0, 0, WIDTH, HEIGHT, null);
		g.dispose();
		bufferStrategy.show();
	}
	
	public Canvas getCanvas() {
        return canvas;
    }
    
    public JFrame getFrame() {
		return frame;
	}

	/*
	 * public void Render() { //AffineTransform at = new AffineTransform(); //set
	 * screen position to center after zoom anchorX = (WIDTH - (WIDTH * (zoom))) /
	 * 2; anchorY = (HEIGHT - (HEIGHT * (zoom))) / 2;
	 * 
	 * //zooms the screen in and positions to center at.translate(anchorX, anchorY);
	 * at.scale(zoom, zoom);
	 * 
	 * //g.setTransform(at);
	 * 
	 * //Draws all objects g.drawImage(bufferedImage, 0,0,WIDTH,HEIGHT,null);
	 * //bufferStrategy.show();
	 * 
	 * //Clears screen g.clearRect(-10000, -10000, 20000, 20000); }
	 */
}
