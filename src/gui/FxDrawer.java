package gui;

import game_src.Drawer;
import game_src.Pointxy;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class FxDrawer extends Drawer {

	public Circle c;
	public FxDrawer(double size,Pointxy point) {
		super(size);
		c= new Circle(point.x,point.y,size);
		c.setStyle("-fx-color:yellow;");
		 
	} 

	@Override
	public void draw(double x, double y, double size) {
		c.setTranslateX(x);	
		c.setTranslateY(y);
		c.setRadius(size);
	}

	@Override
	public void draw(double x, double y) { 
		
		c.setTranslateX(x);	
		c.setTranslateY(y);
		
	}


	@Override
	public void draw(Pointxy point, double size) { 
		c.setTranslateX(point.x);	
		c.setTranslateY(point.y);c.setRadius(size);
	}
	@Override
	public void draw(Pointxy point) { 
		c.setTranslateX(point.x);	
		c.setTranslateY(point.y);
		
	} 

	@Override
	public void setFill(Object azure) {
		c.setFill((Color)azure);
		
	}

 
	
}
