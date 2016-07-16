 package at.spot.engine.isometric;

import at.spot.engine.isometric.game.Game;
import at.spot.engine.isometric.graphics.GraphicsDefinition;
import at.spot.engine.isometric.mapping.MapDefinition;

public class Main {

	public static void main(String[] args) {
		
		new Game(
			new GraphicsDefinition(),
			new MapDefinition()
		).run();
		
	}
}
