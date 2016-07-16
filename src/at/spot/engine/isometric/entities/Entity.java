package at.spot.engine.isometric.entities;

public abstract class Entity {

	private int x, y;
	
	public Entity() {
		
	}
	
	public abstract void update();
	
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
