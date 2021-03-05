package game_src;

import javafx.scene.paint.Color;

public  abstract class Drawer { 
	 double size;
	public Drawer  ( double size) {
		super(); 
		this.size=size;
	}

	public abstract void draw (double x,  double y, double size);
	public abstract void draw (double x,  double y);

	public abstract void draw(Pointxy point);

	public abstract void draw(Pointxy point, double size); 

	public  abstract void  setFill(Object azure);
}
