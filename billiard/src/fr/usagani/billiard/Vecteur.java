package fr.usagani.billiard;

public class Vecteur {
	public double x;
	public double y;
	
	public Vecteur(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	
	public Vecteur Sum(Vecteur b) {
		return new Vecteur(this.x+b.x,this.y+b.y);
	}
	
	public Vecteur Subtract(Vecteur b) {
		return new Vecteur(this.x-b.x,this.y-b.y);
	}
	
	public Vecteur Multiply(double a) {
		return new Vecteur(this.x*a,this.y*a);
	}
	
	public double Scalaire(Vecteur b) {
		return this.x*b.x+this.y*b.y;
	}
	
	public double Module() {
		return Math.pow(Math.pow(this.x, 2)+Math.pow(this.y, 2), 0.5);
	}
	
	public Vecteur Normale(Vecteur aideSens) {
		if(aideSens.Scalaire(new Vecteur(this.y, -this.x))>=0){
			return new Vecteur(this.y, -this.x);
		}else {
			return new Vecteur(-this.y,this.x);
		}
	}
}
