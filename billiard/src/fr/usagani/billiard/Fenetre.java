package fr.usagani.billiard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
public class Fenetre extends JFrame {
	Plateau plateau;
	private static final long serialVersionUID = 1L;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Fenetre() {
		this.plateau=new Plateau();
		this.setTitle("Billard");
		this.setSize((int)(screenSize.getWidth()*plateau.proportionEcran), (int)(screenSize.getHeight()*plateau.proportionEcran));
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel pan = new JPanel();
	    pan.setLayout(null);
	    pan.setBackground(Color.ORANGE);
	    JPanel rectangleVert=new JPanel();
	    rectangleVert.setLayout(null);
	    rectangleVert.setBounds(400,400,1000,1000);
	    rectangleVert.setBackground(Color.green);
	    pan.add(rectangleVert);
	    this.add(pan);
	    this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.blue);
		for (int i=0;i<6;i++) {
			plateau.mursGraphiques[i].dessine(g);
		}
		g.setColor(Color.black);
		for (int i=0;i<6;i++) {
			plateau.trousGraphiques[i].dessine(g);
		}
		g.setColor(Color.YELLOW);
		g.fillPolygon(new int[] {50,50,100,100},new int[] {50,100,100,50},4);
	}
}

