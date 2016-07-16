package at.spot.engine.isometric.mapping.tiles;

public enum TileType {
	grass("grass"), water("water");
	
	String textureName;
	
	TileType(String textureName){
		this.textureName = textureName;
	}
}
