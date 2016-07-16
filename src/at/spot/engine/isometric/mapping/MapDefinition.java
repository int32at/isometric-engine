package at.spot.engine.isometric.mapping;

import at.spot.engine.isometric.config.Config;
import at.spot.engine.isometric.mapping.tiles.TileDefinition;
import at.spot.engine.isometric.mapping.tiles.TileType;

public class MapDefinition {
	
	public int getTileSize() {
		return 60;
	};
	
	public int getMapWidth() {
		return 100;
	}
	
	public int getMapHeight() {
		return 100;
	}
	
	public TileDefinition[][] getTileDefinitions() {
		TileDefinition water = new TileDefinition(TileType.water, getTileSize());
		TileDefinition grass = new TileDefinition(TileType.grass, getTileSize());
		
		TileDefinition[][] mapData = new TileDefinition[getMapWidth()][getMapHeight()];
		
		for (int i = 0; i < mapData[0].length; i++) {
			for (int j = 0; j < mapData[1].length; j++) {
				mapData[i][j] = grass;
			}
		}
		
		return mapData;
	}
}
