package at.spot.engine.isometric.graphics.textures;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TextureManager {

	private static TextureManager mgr;
	
	public static TextureManager instance() {
		if(mgr == null)
			mgr = new TextureManager();
		
		return mgr;
	}
	
	private HashMap<String, Texture> tileTextureCache = new HashMap<String, Texture>();
	private HashMap<String, Texture> playerTextureCache = new HashMap<String, Texture>();
	
	public Texture loadTileTexture(String name) {
		
		if(!tileTextureCache.containsKey(name)) {
			tileTextureCache.put(name, textureLoad("res/tiles/" + name + ".png", "PNG"));
		}
		
		return tileTextureCache.get(name);
	}
	
	public Texture loadPlayerTexture(String name) {
		if(!playerTextureCache.containsKey(name)) {
			playerTextureCache.put(name, textureLoad("res/player/" + name + ".png", "PNG"));
		}
		
		return playerTextureCache.get(name);
	}
	
	private Texture textureLoad(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		try{
			tex = TextureLoader.getTexture(fileType, in);
		}catch(IOException e){
			e.printStackTrace();
		}
		return tex;
	}
}
