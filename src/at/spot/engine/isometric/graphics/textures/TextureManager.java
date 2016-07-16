package at.spot.engine.isometric.graphics.textures;

import java.io.IOException;
import java.io.InputStream;

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
	
	public Texture loadTexture(String name) {
		Texture tex = textureLoad("res/" + name + ".png", "PNG");
		return tex;	
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
