package fr.usagani.billiard;

import java.awt.Graphics;

public class Trou {
	Vecteur position;
	public int radius;
	
	public Trou(Vecteur position, int radius) {
		this.position=position;
		this.radius=radius;
	}
	
	public void dessine(Graphics g) {
		g.fillOval((int)this.position.x-this.radius, (int)this.position.y-this.radius, 2*this.radius, 2*this.radius);
	}
	
	public Trou ConversionGraphique(int xMilieuGraphique, int yMilieuGraphique,double proportion) {
		return new Trou(this.position.Multiply(proportion).Sum(new Vecteur(xMilieuGraphique,yMilieuGraphique)),this.radius*(int)proportion);
	}
}
