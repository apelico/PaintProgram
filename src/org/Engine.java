package org;

public class Engine implements Runnable{
	
	private Thread thread;
    private Window window;
    private Input input;
    
    private boolean running = false;
    public int fps;

    public void start() {
        window = new Window();
        input = new Input(window);

        running = true;
        thread = new Thread(this);
        thread.run();
    }

    public void stop() {

    }
    // Render loop
	public void run() {
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / 60.0d;
        final double timeF = 1000000000 / 60.0d;
        double deltaU = 0, deltaF = 0;
        int frames = 0; //Frames per seconds display
        //int ticks = 0; // Updates per second display
        long timer = System.currentTimeMillis();

        while (running) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                //input.update();
                //game.update(this);
                //ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                window.Render();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                fps = frames;
                frames = 0;
                //ticks = 0; System.out.println(ticks); Displays the ticks per second when enabled
                timer += 1000;
            }

        }

        dispose();
    }
	
	private void dispose() {

    }
}
