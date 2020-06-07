package me.Treidex.Game.GameObject.Components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import me.Treidex.Game.GameObject.GameObject;

public class Sprite extends Component {
	public String filepath;
	
	private Image spriteRaw;
	private Image sprite;
	
	public Sprite(String filepath) {
		this.filepath = filepath;
		
		spriteRaw = Toolkit.getDefaultToolkit().getImage(getClass().getResource(filepath));
		sprite = spriteRaw;
	}
	
	public void setParent(GameObject parent) {
		super.setParent(parent);
		
		sprite = spriteRaw.getScaledInstance((int) transform.size.x, (int) transform.size.y, Image.SCALE_DEFAULT);
	}
	
	public void draw(Graphics g) {
		g.drawImage(sprite, (int) transform.position.x, (int) transform.position.y, null);
	}
}
