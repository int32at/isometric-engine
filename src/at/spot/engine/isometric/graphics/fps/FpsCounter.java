package at.spot.engine.isometric.graphics.fps;

import org.lwjgl.Sys;

public class FpsCounter {
	
	private int fps;
	private long lastFrame;
	private long lastFps;
	
	public FpsCounter() {
		getDelta();
		lastFps = getTime();
	}
	
	public void update() {
		if (getTime() - lastFps > 1000) {
			fps = 0;
			lastFps += 1000;
		}
		fps++;
	}
	
	private int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}

	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
}
