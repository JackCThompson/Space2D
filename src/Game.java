import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

	private int width;
	private int height;
	
	private boolean running; 
	private boolean debug;
	
	private Display display;
	
	private Handler handler;
	private Field system1;
	
	// Constructs a Game object for a window of int:width and int:height
	// Debug info will be printed to console if debug = true
	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		
		debug = true;
	}
	
	// Initializes important variables
	private void init() {
		display = new Display(width, height);
		
		handler = new Handler(this);
		system1 = new Field(handler);
	}
	
	// Sets up the game and runs the tick and render loop until the game is over
	public void run() {
		if(debug) {System.out.println("INITIALIZING");}
		init();
		if(debug) {System.out.println("INITIALIZED");}
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int ticks = 0;
		int frames = 0;
		long now;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				ticks ++;
				
				if (delta <= 2) {
					render();
					frames ++;
				}
				
				delta --;
			}
			if (timer >= 1000000000) {
				System.out.println("FPS: " + frames + ", TPS: " + ticks);
				
				timer = 0;
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	// Calls tick() of all necessary objects
	private void tick() {
		system1.tick();
	}
	
	// Clears screen and calls render(Graphics g) of all necessary objects
	private void render() {
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		
		g.clearRect(0, 0, width, height);
		
		system1.render(g);
		
		bs.show();
		g.dispose();
	}
	
	// Starts this object as a thread
	public void start() {
		running = true;
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
