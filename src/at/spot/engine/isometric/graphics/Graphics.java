package at.spot.engine.isometric.graphics;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Point;

import at.spot.engine.isometric.mapping.Map;
import at.spot.engine.isometric.player.Player;

public class Graphics {

	private static Graphics instance;

	public static Graphics instance() {
		if (instance == null)
			instance = new Graphics();
		return instance;
	}

	private String title;
	private int width;
	private int height;

	public void init(GraphicsDefinition gfx) {

		title = gfx.getTile();
		width = gfx.getWidth();
		height = gfx.getHeight();

		setupDisplay();
		setupOpenGL();
	}
	
	public Point getSize() {
		return new Point(width, height);
	}

	public void render(Map map, Player player) {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		if (Display.getWidth() != this.width | Display.getHeight() != height) {
			this.width = Display.getWidth();
			this.height = Display.getHeight();
			
			setupOpenGL();
		}
		
		map.draw();
		player.draw();
		
		Display.update();
		
		Display.sync(60);
	}

	private void setupDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			Display.create();
			Display.setVSyncEnabled(true);
			Display.setResizable(true);

		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	private void setupOpenGL() {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

		GL11.glViewport(0, 0, width, height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();

		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
}
