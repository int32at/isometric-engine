package at.spot.engine.isometric.mapping.tiles;

public class TileDefinition {

	private TileType type;

	public TileDefinition(TileType type) {
		this.type = type;
	}

	public TileType getType() {
		return this.type;
	}
}
