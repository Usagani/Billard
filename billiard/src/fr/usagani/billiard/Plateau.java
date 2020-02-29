package fr.usagani.billiard;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Plateau {
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double p;
	private int xMilieuGraphique;
	private int yMilieuGraphique;
	public Bille[] billes=new Bille[16];
	public Trou[] trous=new Trou[6];
	public Trou[] trousGraphiques=new Trou[6];
	public Mur[] murs=new Mur[6];
	public Mur[] mursGraphiques = new Mur[6];
	public double proportionEcran;
	int tailleGraphique;
	int mursBlocs[][]=new int[6][8];
	
	
	public Plateau(/*double proportionEcran*/) {
		tailleGraphique=12;
		this.proportionEcran=2.0/3;
		this.xMilieuGraphique=(int)(screenSize.getWidth()*this.proportionEcran/2);
		this.yMilieuGraphique=(int)(screenSize.getHeight()*this.proportionEcran/2);
		int longBarreau=85;
		int espaceTrouMilieu=16;
		int espaceTrouAngle=10;
		p=proportionEcran*tailleGraphique;
		
		//Creation des trous (pour les calculs)
		trous[0]=new Trou(new Vecteur(-espaceTrouAngle-longBarreau-espaceTrouMilieu/2,-longBarreau/2-espaceTrouAngle),5);
		trous[1]=new Trou(new Vecteur(0,-longBarreau/2-espaceTrouAngle),5);
		trous[2]=new Trou(new Vecteur(+espaceTrouAngle+longBarreau+espaceTrouMilieu/2,-longBarreau/2-espaceTrouAngle),5);
		trous[3]=new Trou(new Vecteur(-espaceTrouAngle-longBarreau-espaceTrouMilieu/2,+longBarreau/2+espaceTrouAngle),5);
		trous[4]=new Trou(new Vecteur(0,+longBarreau/2+espaceTrouAngle),5);
		trous[5]=new Trou(new Vecteur(+espaceTrouAngle+longBarreau+espaceTrouMilieu/2,+longBarreau/2+espaceTrouAngle),5);
		//trous affichage  (change les coordonnees et la taille)
		for (int i=0;i<trous.length;i++) {
			trousGraphiques[i]=trous[i].ConversionGraphique(xMilieuGraphique, yMilieuGraphique, p);
		}
		
		//Creation des murs (pour les calculs)
		murs[0]=new Mur(-longBarreau-espaceTrouMilieu/2,-longBarreau/2-espaceTrouAngle,-espaceTrouMilieu/2,-longBarreau/2-espaceTrouAngle);//.Proportion(p).Add(xMilieuGraphique,yMilieuGraphique);
		murs[1]=new Mur(+espaceTrouMilieu/2,-longBarreau/2-espaceTrouAngle,+longBarreau+espaceTrouMilieu/2,-longBarreau/2-espaceTrouAngle);//.Proportion(p).Add(xMilieuGraphique, yMilieuGraphique);
		murs[2]=new Mur(-longBarreau-espaceTrouMilieu/2,+longBarreau/2+espaceTrouAngle,-espaceTrouMilieu/2,+longBarreau/2+espaceTrouAngle);//.Proportion(p).Add(xMilieuGraphique,yMilieuGraphique);
		murs[3]=new Mur(+espaceTrouMilieu/2,+longBarreau/2+espaceTrouAngle,+longBarreau+espaceTrouMilieu/2,+longBarreau/2+espaceTrouAngle);//.Proportion(p).Add(xMilieuGraphique,yMilieuGraphique);
		murs[4]=new Mur(-longBarreau-espaceTrouMilieu/2-espaceTrouAngle,-longBarreau/2,-longBarreau-espaceTrouMilieu/2-espaceTrouAngle,+longBarreau/2);//.Proportion(p).Add(xMilieuGraphique,yMilieuGraphique);
		murs[5]=new Mur(+longBarreau+espaceTrouMilieu/2+espaceTrouAngle,-longBarreau/2,+longBarreau+espaceTrouMilieu/2+espaceTrouAngle,+longBarreau/2);//.Proportion(p).Add(xMilieuGraphique,yMilieuGraphique);
		//murs affichage (change les coordonnees et la taille)
		for (int i=0;i<mursGraphiques.length;i++) {
			mursGraphiques[i]=murs[i].Proportion(p).Add(xMilieuGraphique, yMilieuGraphique);
		}
	}
	public void setX(int xMilieuGraphique) {
		this.xMilieuGraphique=xMilieuGraphique;
	}
	public void setY(int yMilieuGraphique) {
		this.yMilieuGraphique=yMilieuGraphique;
	}
	
}
