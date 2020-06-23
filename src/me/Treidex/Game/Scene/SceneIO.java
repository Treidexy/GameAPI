package me.Treidex.Game.Scene;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.simple.JSONObject;

import me.Treidex.Game.GameObject.GameObject;
import me.Treidex.Game.Math.JSON;

public class SceneIO {
	public String name;
	
	public GameObject[] noTranslateObjects;
	
	public GameObject[] staticObjects;
	
	/**
	 * The List of Game Objects.
	 */
	public GameObject[] gameObjects;
	
	JSONObject scene;
	
	@SuppressWarnings("unchecked")
	public JSONObject getScene() {
		scene = new JSONObject();
		scene.put("no-translate-objects", JSON.arrayToJSONArray(noTranslateObjects));
		scene.put("static-objects", JSON.arrayToJSONArray(staticObjects));
		scene.put("game-objects", JSON.arrayToJSONArray(gameObjects));
		
		return scene;
	}
	
	public void save(String filename) {
		getScene();
		File file = new File(filename);
		try {
			Writer fw = new FileWriter(file);
			fw.append(scene.toString());
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene load(String filename) {
		return null;
	}
}
