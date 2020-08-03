#version 330 core

in vec4 color;
in vec2 uvMap;

out vec4 outColor;

uniform sampler2D tex;

void main()
{
	outColor = texture(tex, uvMap) + color;
}