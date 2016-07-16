package at.spot.engine.isometric.mapping;

import java.util.ArrayList;

import at.spot.engine.isometric.graphics.Graphics;
import at.spot.engine.isometric.mapping.tiles.Tile;
import at.spot.engine.isometric.mapping.tiles.TileDefinition;

public class Map {

	private int zoomLevel = 1;
	private ArrayList<Tile> gameMap = new ArrayList<Tile>();

	public Map(MapDefinition mapDefinition) {
		load(mapDefinition);
	}

	private void load(MapDefinition mapDef) {
		TileDefinition[][] inMap = mapDef.get();

		for (int y = 0; y < inMap.length; y++) {
			for (int x = 0; x < inMap[y].length; x++) {
				gameMap.add(new Tile(x, y, inMap[x][y].getType()));
			}
		}
	}

	public void draw() {
		for (Tile t : gameMap) {
			t.draw();
		}
	}
	
	public void update() {
		Graphics.instance().render(this);
	}

	public void zoomIn() {
		if (zoomLevel < 2) {
			for (Tile t : gameMap) {
				t.tileWidth = t.tileWidth * 2;
				t.tileHeight = t.tileHeight * 2;
			}

			for (int i = 0; i < 30; i++) {
				this.shiftRight();
			}
			zoomLevel++;

		}

	}

	public void zoomOut() {
		if (zoomLevel > -3) {
			for (Tile t : gameMap) {
				t.tileWidth = t.tileWidth / 2;
				t.tileHeight = t.tileHeight / 2;
			}

			for (int i = 0; i < 30; i++) {
				this.shiftLeft();
			}
			zoomLevel--;
		}

	}

	public void shiftRight() {
		for (Tile t : gameMap) {
			t.x--;
		}
	}

	public void shiftLeft() {
		for (Tile t : gameMap) {
			t.x++;
		}
	}

	public void shiftUp() {
		for (Tile t : gameMap) {
			t.y++;
		}
	}

	public void shiftDown() {
		for (Tile t : gameMap) {
			t.y--;
		}
	}

}
