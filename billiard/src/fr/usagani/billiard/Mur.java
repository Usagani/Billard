package fr.usagani.billiard;
import java.awt.Graphics;
public class Mur{
    public int xD;
    public int yD;
    public int xF;
    public int yF;
    
    public Mur(int a, int b, int c, int d){
        this.xD=a;
        this.yD=b;
        this.xF=c;
        this.yF=d;
    }
    
    public void dessine(Graphics g){
        g.drawLine(this.xD,this.yD,this.xF,this.yF);
    }
    
    public Mur Proportion(double p){
    	return new Mur((int)(p*this.xD),(int)(p*this.yD),(int)(p*this.xF),(int)(p*this.yF));
    	
    }
    
    public Mur Add(int a, int b) {
    	return new Mur(this.xD+a,this.yD+b,this.xF+a,this.yF+b);
    }
}