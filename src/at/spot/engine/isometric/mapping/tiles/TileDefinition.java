package at.spot.engine.isometric.mapping.tiles;

public class TileDefinition {

	private TileType type;
	private int size;

	public TileDefinition(TileType type, int size) {
		this.type = type;
		this.size = size;
	}

	public TileType getType() {
		return this.type;
	}

	public int getSize() {
		return size;
	}
}
