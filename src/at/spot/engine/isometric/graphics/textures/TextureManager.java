package at.spot.engine.isometric.graphics.textures;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import at.spot.engine.isometric.mapping.tiles.TileDefinition;

public class TextureManager {

	private static TextureManager mgr;

	public static TextureManager instance() {
		if (mgr == null)
			mgr = new TextureManager();

		return mgr;
	}

	private HashMap<TileDefinition, List<Texture>> tileTextureCache = new HashMap<>();

	public Texture loadTileTexture(TileDefinition tileDefinition) {

		if (!tileTextureCache.containsKey(tileDefinition)) {
			tileTextureCache.put(tileDefinition, textureLoad("res/terrain/" + tileDefinition.getType().name() + ".png", "PNG"));
		}

		return getRandomTileTexture(tileDefinition);
	}

	private Texture getRandomTileTexture(TileDefinition tileDefinition) {
		List<Texture> texes = tileTextureCache.get(tileDefinition);
		
		Texture tex = null;
		
		if (texes != null) {
			int r = ThreadLocalRandom.current().nextInt(0, texes.size());
			tex = tileTextureCache.get(tileDefinition).get(r);
		}

		return tex;
	}

	private List<Texture> textureLoad(String path, String fileType) {
		List<Texture> tex = new ArrayList<>();

		List<BufferedImage> textureImages = loadTextureFile(path);
		
		try {
			for (BufferedImage i : textureImages) {
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				ImageIO.write(i, "png", os);
				InputStream is = new ByteArrayInputStream(os.toByteArray());
				
				tex.add(TextureLoader.getTexture(fileType, is));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tex;
	}
	
	private List<BufferedImage> loadTextureFile(String path) {
		List<BufferedImage> subTileTextures = new ArrayList<>();
		
		int tileSize = 32;
		
		try {
			BufferedImage image = ImageIO.read(ResourceLoader.getResourceAsStream(path));
			
			int tileStepsH = (image.getWidth() / tileSize);
			int tileStepsV = (image.getHeight() / tileSize);
			
			for (int vStep = 0; vStep < tileStepsV; vStep++) {
				for (int hStep = 0; hStep < tileStepsH; hStep++) {
					BufferedImage subTileTexture = image.getSubimage(hStep * tileSize, vStep * tileSize, tileSize, tileSize);
					subTileTextures.add(subTileTexture);
				}
			}
		} catch (IOException e) {
			System.out.println("Could not load texture: " + path);
		}
		
		return subTileTextures;
	}
}
