package game_src;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Profile extends VBox{
	
	public Profile(Button b){
		super.setHover(isMouseTransparent());
		super.setHover(isCenterShape());
		super.setStyle("-fx-padding:23;"
				+"-fx-font-size:20;");
		super.getChildren().add(b);
		
		details();
	}
	
	void details(){
		super.getChildren().add((new Label("NAME : Gbenge Aondoakula Raphael Raymond")));
	}
}
