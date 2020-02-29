package fr.usagani.billiard;
import java.awt.*;

public class Bille {
	private double radius;
	private double mass;
	private Color color;
	private Vecteur position;
	private Vecteur speed;
	public Bille(double radius, double mass, Color color, Vecteur position) {
		this.radius=radius;
		this.mass=mass;
		this.color=color;
		this.setPosition(position);
	}
	//getters and setters
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	public Vecteur getPosition() {
		return position;
	}
	public void setPosition(Vecteur position) {
		this.position = position;
	}
	public Vecteur getSpeed() {
		return speed;
	}
	public void setSpeed(Vecteur speed) {
		this.speed = speed;
	}
	
	public void collision(Bille b) {
		double pv1=Math.pow(Math.sin(Math.atan((b.getPosition().y-this.position.y)/(b.getPosition().x-this.position.x))-Math.atan((this.speed.y-b.getSpeed().y)/(this.speed.x-b.getSpeed().x))), 2); 
		Vecteur ini1 = this.speed;
		Vecteur radial=new Vecteur(b.getPosition().x-this.position.x,b.getPosition().y-this.position.y);// direction dans laquelle part la boule 2 (direction relative)
		Vecteur radialUnitaire= radial.Multiply(1/radial.Module());
		Vecteur orthoradial=radial.Normale(this.speed.Subtract(b.getSpeed()));
		Vecteur orthoradialUnitaire=orthoradial.Multiply(1/orthoradial.Module());
		this.speed=orthoradialUnitaire.Multiply((ini1.Subtract(b.getSpeed())).Multiply(pv1).Scalaire(orthoradialUnitaire)).Sum(b.getSpeed());//on attribut une nouvelle vitesse à la boule 1 (en prenant en compté les vitesses relatives et les vitesses initiales)
		b.setSpeed(radialUnitaire.Multiply((ini1.Subtract(b.getSpeed())).Multiply((1-pv1)*this.mass/b.getMass()).Scalaire(radialUnitaire)).Sum(b.getSpeed()));// on attribut aussi une nouvelle vitesse pour la boule 2
	}
	public boolean tombeTrou(Trou trou) {
		if (new Vecteur(this.position.x-trou.position.x,this.position.y-trou.position.y).Module()<trou.radius){
			return true;
		}else {
			return false;
		}
	}
	public void ralentir() {
		if(this.speed.Module()>2) {
			this.speed=this.speed.Multiply(0.99);
		}else {
			this.speed=new Vecteur(0,0);
		}
	}
	public boolean toucheMur(Mur mur) {
		if(mur.xD==mur.xF) {
			if(Math.abs(this.position.x-mur.xD)<=this.radius) {
				return true;
			}else {
				return false;
			}
		}else{ 
			double a=(mur.yF-mur.yD)/(mur.xF-mur.xD);
			double b=mur.yD/(a*mur.xD);
					//a*xD+b=yD ==> b=yD/(a*xD)
			if(Math.abs((this.position.y-a*this.position.x-b)/Math.pow(1+Math.pow(a, 2), 1/2))<=this.radius) {
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean toucheBille(Bille bille) {
		if((this.position.Subtract(bille.getPosition())).Module()<(this.radius+bille.getRadius())/2) {
			return true;
		}else {
			return false;
		}
	}
	public void dessine(final Graphics c){
		//super.paintComponent(c);
        c.setColor(this.color);
        c.drawOval(30,30,2*(int)(this.radius),2*(int)this.radius);
    
    }
}
