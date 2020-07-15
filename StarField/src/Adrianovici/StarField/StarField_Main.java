package Adrianovici.StarField;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class StarField_Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public StarField_Main(int starCount, int speed, int starSize) {
		StarField_Animation animation = new StarField_Animation(starCount, speed, starSize);
		add(animation);
		
		setTitle("StarField");
		setLocationRelativeTo(null);
		
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		getContentPane().setCursor(blankCursor);
		
		setUndecorated(true);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		int speed = 10;
		int starSize = 6;
		int starCount = 750;
		
		@SuppressWarnings("unused")
		StarField_Main frame = new StarField_Main(starCount, speed, starSize);
	}

}
