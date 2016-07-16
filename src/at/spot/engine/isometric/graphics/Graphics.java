package at.spot.engine.isometric.graphics;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexParameterf;
import static org.lwjgl.opengl.GL11.glViewport;

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
		glEnable(GL_TEXTURE_2D);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

		glViewport(0, 0, width, height);
		glMatrixMode(GL_MODELVIEW);

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
}
