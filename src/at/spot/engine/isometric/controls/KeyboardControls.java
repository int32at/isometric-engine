package at.spot.engine.isometric.controls;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import at.spot.engine.isometric.mapping.Map;

public class KeyboardControls {

	public KeyboardControls() {

	}

	public static void tick(Map map) {
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_MINUS) {
				if (Keyboard.getEventKeyState()) {

				} else {
					map.zoomOut();

				}
			} else if (Keyboard.getEventKey() == Keyboard.KEY_EQUALS) {
				if (Keyboard.getEventKeyState()) {

				} else {
					map.zoomIn();
				}
			}
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			map.shiftRight();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			map.shiftLeft();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			map.shiftUp();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {

			map.shiftDown();
		} else if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Display.destroy();
		}
	}
}
