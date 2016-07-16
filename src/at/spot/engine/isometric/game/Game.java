package at.spot.engine.isometric.game;

import org.lwjgl.opengl.Display;

import at.spot.engine.isometric.controls.KeyboardControls;
import at.spot.engine.isometric.graphics.Graphics;
import at.spot.engine.isometric.graphics.GraphicsDefinition;
import at.spot.engine.isometric.mapping.Map;
import at.spot.engine.isometric.mapping.MapDefinition;
import at.spot.engine.isometric.player.Player;

public class Game {
	private Map map;
	private Player player;

	private KeyboardControls controls;

	public Game(GraphicsDefinition gfx, MapDefinition mapDef) {
		Graphics.instance().init(gfx);
		controls = new KeyboardControls();
		
		map = new Map(mapDef);
		player = new Player();
	}

	private void update() {
		controls.update(map);
		Graphics.instance().render(map, player);
	}


	public void run() {
		while (!Display.isCloseRequested()) {
			update();
		}
	}

}
