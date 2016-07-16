package at.spot.engine.isometric.mapping;

import at.spot.engine.isometric.mapping.tiles.TileDefinition;
import at.spot.engine.isometric.mapping.tiles.TileType;

public class MapDefinition {
	
	public MapDefinition() {
		
	}
	
	public TileDefinition[][] get() {
		TileDefinition water = new TileDefinition(TileType.water);
		TileDefinition grass = new TileDefinition(TileType.grass);
		
		return new TileDefinition[][] {
				  { grass, grass, grass },
				  { grass, water, grass },
				  { grass, grass, grass }
				};
	}
}
