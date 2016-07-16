package at.spot.engine.isometric.graphics.tiles;

public enum TileType {
	grass("grass"), water("water");
	
	String textureName;
	
	TileType(String textureName){
		this.textureName = textureName;
	}
}
