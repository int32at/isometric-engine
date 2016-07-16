package at.spot.engine.isometric.entities;

import org.lwjgl.util.Point;

public abstract class Entity {

	protected int x = 0, y = 0;
	
	public Entity() {
		
	}
	
	public abstract void setUp();
	public abstract void draw();
	public abstract void destroy();
	
	public void setLocation(Point p) {
		setLocation(p.getX(), p.getY());
	}
	
	public void setLocation(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
}
