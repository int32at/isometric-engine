package at.spot.engine.isometric.player;

import org.lwjgl.opengl.GL11;

import at.spot.engine.isometric.entities.DynamicEntity;
import at.spot.engine.isometric.graphics.Graphics;

public class Player extends DynamicEntity {

	private int size = 20;

	public Player() {
		setLocation(Graphics.instance().getSize().getX() / 2,
				Graphics.instance().getSize().getY() / 2);
	}

	@Override
	public void draw() {

		int halfX = x - size / 2;
		int halfY = y - size / 2;

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(halfX, halfY);
		GL11.glVertex2f(halfX + size, halfY);
		GL11.glVertex2f(halfX + size, halfY + size);
		GL11.glVertex2f(halfX, halfY + size);

		GL11.glEnd();
	}

	@Override
	public void setUp() {
	}

	@Override
	public void destroy() {
	}
}
