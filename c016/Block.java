package c016;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {
	Color color;

	public Block(int posX, int posY, int ancho, int alto, Color color) {
		x = posX;
		y = posY;
		width = ancho;
		height = alto;
		this.color = color;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}