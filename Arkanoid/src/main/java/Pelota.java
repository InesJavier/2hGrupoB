import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JOptionPane;

public class Pelota extends Block {
	int velX, velY;
	Boolean win, lose;
	public Pelota() {
		super(150, 200, 10, 10, Color.red);
		velX = (int) ((Math.random() * 11) - 5);
		velY = -1;
		win = false;
		lose = false;
	}

	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar(List<Block> panel, Raqueta raqueta) {
		x += velX;
		y += velY;
		for (int i = 0; i < panel.size(); i++)
			if (this.intersects(panel.get(i))) {
				panel.remove(i);
				velY = -velY;
			}

		if (this.intersects(raqueta))
			velY = -velY;

		if ((x >= 300) || (x <= 0))
			velX = -velX;

		if (y <= 0)
			velY = -velY;

		if (panel.size() == 0) {
			win = true;
			JOptionPane.showMessageDialog(null, "YOU WIN, PLAY AGAIN.", "WIN", JOptionPane.INFORMATION_MESSAGE);
			y = -10;
			x = -10;
			velY = 0;
			velX = 0;
			panel.add(raqueta);
		}

		if ((y >= 300)) {
			lose = true;
			JOptionPane.showMessageDialog(null, "GAME OVER, YOU LOST, TRY AGAIN.", "LOST", JOptionPane.INFORMATION_MESSAGE);
			y = -10;
			x = -10;
			velY = 0;
			velX = 0;
		}
	}
}