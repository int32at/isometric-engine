package at.spot.engine.isometric.mapping;

import at.spot.engine.isometric.mapping.tiles.TileDefinition;
import at.spot.engine.isometric.mapping.tiles.TileType;

public class MapDefinition {
	
	public TileDefinition[][] get() {
		TileDefinition water = new TileDefinition(TileType.water);
		TileDefinition grass = new TileDefinition(TileType.grass);
		
		TileDefinition[][] mapData = new TileDefinition[30][30];
		
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				mapData[i][j] = grass;
			}
		}
		
		return mapData;
	}
}
