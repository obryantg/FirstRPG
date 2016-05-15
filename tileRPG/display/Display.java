package tileRPG.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	//JFrame for window display with title and size
	//these are private; no other classes should have access to this
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		//this will make sure our frame/window will close down properly
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//user can't resize window if they so desired; set to width and height
		//assigned
		frame.setResizable(false);
		//when window pops up it is centered with 'null' argument
		frame.setLocationRelativeTo(null);
		//by default, jframes aren't visible? ok...
		frame.setVisible(true);
		
		canvas = new Canvas();
		//below is standard for setting size of canvas for layout/images
		canvas.setPreferredSize(new Dimension(width, height));
		//adding max and min to same parameters as preferred size
		//will maintain the shape of canvas (won't change)
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
		//pack formats the canvas relative to the window
		frame.pack();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
}
