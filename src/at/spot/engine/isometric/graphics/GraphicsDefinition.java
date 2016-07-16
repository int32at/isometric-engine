package at.spot.engine.isometric.graphics;

public class GraphicsDefinition {

	private String title;
	private int width, height;
	
	public GraphicsDefinition() {
		this("Isometric Engine", 1000, 500);
	}

	public GraphicsDefinition(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	public String getTile() {
		return title;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
}
