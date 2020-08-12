package com.treidex.gameapi.engine.graphics;

import org.lwjgl.glfw.GLFW;

import com.treidex.gameapi.engine.gameobject.GameObject;
import com.treidex.gameapi.engine.io.Input;
import com.treidex.gameapi.engine.math.Vector3f;

public class Camera
{
	private Vector3f position, rotation, velocity;
	private float    moveSpeed = 0.15f, mouseSensitivity = 0.15f, scrollSensitivity = 1.5f, distance = 2.0f,
			horizontalAngle = 0, verticalAngle = 0, speedDamp = 0.88f;
	private double   pMouseX   = 0, pMouseY = 0, mouseX, mouseY, pScrollX, pScrollY, scrollX, scrollY;

	public Camera(Vector3f position, Vector3f rotation)
	{
		this.position = position;
		this.rotation = rotation;
		velocity      = new Vector3f(0, 0, 0);
	}

	public void addForce(Vector3f force)
	{
		velocity = Vector3f.add(velocity, force);
	}

	public void update()
	{
		mouseX = Input.getMouseX();
		mouseY = Input.getMouseY();

		scrollX = Input.getScrollX();
		scrollY = Input.getScrollY();

		@SuppressWarnings("unused")
		float dsx = (float) -(scrollX - pScrollX);
		float dsy = (float) (scrollY - pScrollY);

		if (moveSpeed > 0)
			moveSpeed += dsy * scrollSensitivity / 4;
		else
			moveSpeed = 0.1f;

		float x = (float) Math.sin(Math.toRadians(rotation.getY())) * moveSpeed;
		float z = (float) Math.cos(Math.toRadians(rotation.getY())) * moveSpeed;

//		addForce(new Vector3f(0, -1, 0));

		if (Input.isKeyDown(GLFW.GLFW_KEY_A))
			addForce(new Vector3f(-z, 0, x));
		if (Input.isKeyDown(GLFW.GLFW_KEY_D))
			addForce(new Vector3f(z, 0, -x));
		if (Input.isKeyDown(GLFW.GLFW_KEY_W))
			addForce(new Vector3f(-x, 0, -z));
		if (Input.isKeyDown(GLFW.GLFW_KEY_S))
			addForce(new Vector3f(x, 0, z));
		if (Input.isKeyDown(GLFW.GLFW_KEY_SPACE))
			addForce(new Vector3f(0, moveSpeed, 0));
		if (Input.isKeyDown(GLFW.GLFW_KEY_LEFT_SHIFT))
			addForce(new Vector3f(0, -moveSpeed, 0));

		position = Vector3f.add(position, velocity);
		velocity = Vector3f.multiply(velocity, speedDamp);

		float dx = (float) (mouseX - pMouseX);
		float dy = (float) (mouseY - pMouseY);

		rotation = Vector3f.add(rotation, new Vector3f(-dy * mouseSensitivity, -dx * mouseSensitivity, 0));

		pMouseX = mouseX;
		pMouseY = mouseY;

		pScrollX = scrollX;
		pScrollY = scrollY;
	}

	public void update(GameObject object)
	{
		mouseX = Input.getMouseX();
		mouseY = Input.getMouseY();

		scrollX = Input.getScrollX();
		scrollY = Input.getScrollY();

		float dx = (float) (mouseX - pMouseX);
		float dy = (float) (mouseY - pMouseY);

		@SuppressWarnings("unused")
		float dsx = (float) -(scrollX - pScrollX);
		float dsy = (float) -(scrollY - pScrollY);

		if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_MIDDLE))
		{
			verticalAngle   -= dy * mouseSensitivity;
			horizontalAngle += dx * mouseSensitivity;
		}

		if (distance > 0)
			distance += dsy * scrollSensitivity / 4;
		else
			distance = 0.1f;

		float horizontalDistance = (float) (distance * Math.cos(Math.toRadians(verticalAngle)));
		float verticalDistance   = (float) (distance * Math.sin(Math.toRadians(verticalAngle)));

		float xOffset = (float) (horizontalDistance * Math.sin(Math.toRadians(-horizontalAngle)));
		float zOffset = (float) (horizontalDistance * Math.cos(Math.toRadians(-horizontalAngle)));

		position.set(object.getPosition().getX() + xOffset, object.getPosition().getY() - verticalDistance,
				object.getPosition().getZ() + zOffset);

		rotation.set(verticalAngle, -horizontalAngle, 0);

		pMouseX = mouseX;
		pMouseY = mouseY;

		pScrollX = scrollX;
		pScrollY = scrollY;
	}

	public Vector3f getPosition()
	{ return position; }

	public Vector3f getRotation()
	{ return rotation; }
}