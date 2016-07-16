package at.spot.engine.isometric.mapping.tiles;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

import at.spot.engine.isometric.graphics.textures.TextureManager;

public class Tile {

	public int tileWidth, tileHeight;
	public int x, y;
	private TileType type;
	private Texture texture;

	public boolean selected = false;

	public Tile(int x, int y, TileType type) {
		this.tileWidth = 32;
		this.tileHeight = tileWidth / 2;
		this.x = x;
		this.y = y;
		this.type = type;
		this.texture = TextureManager.instance().loadTileTexture(type.textureName);
	}

	public TileType getType() {
		return this.type;
	}

	public int getWorldX() {
		int halfWidth = tileWidth / 2;
		int screenX = (x - y) * halfWidth;

		return screenX;
	}

	public int getWorldY() {
		int halfHeight = tileHeight / 2;
		int screenY = (x + y) * halfHeight;

		return screenY;
	}

	public void draw() {

		int halfWidth = tileWidth / 2;
		int halfHeight = tileHeight / 2;

		int screenX = (x - y) * halfWidth;
		int screenY = (x + y) * halfHeight;

		texture.bind();
		glTranslatef(x, y, 0);

		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(screenX, screenY);
		glTexCoord2f(1, 0);
		glVertex2f(screenX + halfWidth, screenY + halfHeight);
		glTexCoord2f(1, 1);
		glVertex2f(screenX, screenY + tileHeight);
		glTexCoord2f(0, 1);
		glVertex2f(screenX - halfWidth, screenY + halfHeight);
		glEnd();
		glLoadIdentity();
	}

}
