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
	
	private HashMap<String, Texture> textureCache = new HashMap<String, Texture>();
	
	public Texture loadTexture(String name) {
		
		if(!textureCache.containsKey(name)) {
			textureCache.put(name, textureLoad("res/" + name + ".png", "PNG"));
		}
		
		return textureCache.get(name);
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
