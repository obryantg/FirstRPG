package tileRPG;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tileRPG.display.Display;

public class Game implements Runnable{
 
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics gr;
	
	public Game (String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		display = new Display(title, width, height);
	}
	
	private void init(){
		//initialization of the game, ran once during run.
		display = new Display(title, width, height);
	}
	
	private void update()
	{
		
	}
	
	private void render()
	{
		//bufferStrat tell the computer how to draw things
		//buffers prevent the flicker' on the screen
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		gr = bs.getDrawGraphics();
		//draw yo.
		
		gr.fillRect(0, 0, width, height);
		
		//stop
		bs.show();
		gr.dispose();
	}
	
	public void run()
	{
		init();
		while(running)
		{
			update();
			render();
		}
		stop();
	}
	//synchronized used whenever we are working with threads directly
	public synchronized void start()
	{
		if (running)
			return;
		running =true;
		//prevent trying to repeatedly start the game if already running
		//this = represent the class (Game) we are going to run
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		if (!running)
			return;
		//prevents from stopping code if game is already stopped
		running =false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
