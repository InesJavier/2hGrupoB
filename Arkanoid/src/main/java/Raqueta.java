import java.awt.Color;
import java.util.List;

public class Raqueta extends Block {
	public static final int VELX = 5;

	public Raqueta() {
		super(100, 275, 50, 10, Color.lightGray);
	}

	public void actualizar(int direccion, List<Block> panel) {
		if (direccion == Jugando.DER)
			x += VELX;
		else
			x -= VELX;

		if (x <= 0)
			x = 0;
		if (x > 250)
			x = 250;
	}
}