package me.Treidex.GameAPI.Scene;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import me.Treidex.GameAPI.GameObject.GameObject;
import me.Treidex.GameAPI.Util.JSON;

public class SceneIO {
	
	private JSONObject scene;
	
	@SuppressWarnings("unchecked")
	public JSONObject getScene() {
		scene = new JSONObject();
		scene.put("name", name);
		
		JSONArray noTranslateObjectsA = new JSONArray();
		for (GameObject object: noTranslateObjects) {
			noTranslateObjectsA.add(object.getMap());
		}
		scene.put("no-translate-objects", noTranslateObjectsA);
		
		JSONArray staticObjectsA = new JSONArray();
		for (GameObject object: staticObjects) {
			staticObjectsA.add(object.getMap());
		}
		scene.put("static-objects", staticObjectsA);
		
		JSONArray gameObjectsA = new JSONArray();
		for (GameObject object: gameObjects) {
			gameObjectsA.add(object.getMap());
		}
		scene.put("game-objects", gameObjectsA);
		
		return scene;
	}
	
	public void save(String filename) {
		try {
			getScene();
			File file = new File(filename);
			Writer w = new FileWriter(file);
			w.append(scene.toString());
			w.flush();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene load(String filename) {
		return load(JSON.load(filename));
	}
	
	public static Scene load(JSONObject obj) {
		String name = (String) obj.get("name");
		JSONArray noTranslateObjectsA = (JSONArray) obj.get("no-translate-objects");
		JSONArray staticObjectsA = (JSONArray) obj.get("static-objects");
		JSONArray gameObjectsA = (JSONArray) obj.get("game-objects");
		
		GameObject[] noTranslateObjects = new GameObject[noTranslateObjectsA.size()];
		for (int i = 0; i < noTranslateObjectsA.size(); i++) {
			noTranslateObjects[i] = (GameObject) noTranslateObjectsA.get(i);
		}
		
		GameObject[] staticObjects = new GameObject[staticObjectsA.size()];
		for (int i = 0; i < noTranslateObjectsA.size(); i++) {
			staticObjects[i] = GameObject.loadMap((JSONObject) staticObjectsA.get(i));
		}
		
		GameObject[] gameObjects = new GameObject[gameObjectsA.size()];
		for (int i = 0; i < noTranslateObjectsA.size(); i++) {
			gameObjects[i] = (GameObject) gameObjectsA.get(i);
		}
		
		return new Scene(name, noTranslateObjects, staticObjects, gameObjects);
	}
}
