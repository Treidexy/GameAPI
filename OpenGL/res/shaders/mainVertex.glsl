#version 330 core

layout(location = 0) in vec2 pos;
layout(location = 1) in vec4 col;
layout(location = 2) in vec2 uv;

out vec4 color;
out vec2 uvMap;

void main()
{
	gl_Position = vec4(pos, 1.0, 1.0);
	color = col;
	uvMap = uv;
}