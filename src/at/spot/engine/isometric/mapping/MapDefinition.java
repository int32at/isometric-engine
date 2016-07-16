package at.spot.engine.isometric.mapping;

import at.spot.engine.isometric.mapping.tiles.TileDefinition;
import at.spot.engine.isometric.mapping.tiles.TileType;

public class MapDefinition {
	
	public TileDefinition[][] get() {
		TileDefinition water = new TileDefinition(TileType.water);
		TileDefinition grass = new TileDefinition(TileType.grass);
		
		int mapSize = 100;
		TileDefinition[][] mapData = new TileDefinition[mapSize][mapSize];
		
		for (int i = 0; i < mapData[0].length; i++) {
			for (int j = 0; j < mapData[1].length; j++) {
				mapData[i][j] = grass;
			}
		}
		
		return mapData;
	}
}
