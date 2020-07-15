package Adrianovici.StarField;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StarField_Animation extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Timer timer = new Timer(1, this);
	private Star[] stars;
	private int starCount;

	public StarField_Animation(int starCount, int speed, int starSize) {
		setBackground(Color.BLACK);
		
		this.starCount = starCount;
		stars = new Star[starCount];
		
		for (int i = 0; i < starCount; i ++)
			stars[i] = new Star(speed, starSize);
		
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for (int i = 0; i < starCount; i ++) {
			stars[i].move();
			stars[i].show(g2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
