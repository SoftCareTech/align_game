package gui;

import java.util.Random;

import game_src.AutoPlayer;
import game_src.EventData;
import game_src.EventsResize;
import game_src.MsgRelo;
import game_src.Player;
import game_src.Profile;
import game_src.Switch_player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FxGame extends Application implements MsgRelo {
	public static void main(String[] args) {
		launch(args);
	} 
	Player player1 = new Player("RAPHAEL");
	AutoPlayer player2 = new AutoPlayer(player1); 
	Label center_msg, down_msg;
	EventsResize er = new EventsResize(player1, player2, this);
	
	public void initialise(Scene s) { //// initialization;
		er.init(s.getWidth(), s.getHeight());
		
		// x0,x1,x2,y0,y1,y2,dime=30,gap,len_dim;
		pro_c.setWidth(er.len_dimX);
		pro_c.setHeight(er.dimY);
		pro_gc = pro_c.getGraphicsContext2D();
		
	}// end initi
	
	public void initi() {
		font = er.dimY / 2;
		sty = " " + "-fx-border-color: white;" + "-fx-border-width: 2px;" + "-fx-alignment:center;"
				+ "-fx-border-radius: 40;" + "-fx-font-size:" + font + ";";
		
		c1.setStyle(sty);
		c2.setStyle(sty);
		c3.setStyle(sty);
		c4.setStyle(sty);
		c5.setStyle(sty);
		c6.setStyle(sty);
		c7.setStyle(sty);
		c8.setStyle(sty);
		c9.setStyle(sty);
		c1.setPrefWidth(er.dimX);
		c1.setPrefHeight(er.dimY);
		c1.setTranslateX(er.x0);
		c1.setTranslateY(er.y0);
		
		c2.setPrefWidth(er.dimX);
		c2.setPrefHeight(er.dimY);
		c2.setTranslateX(er.x1);
		c2.setTranslateY(er.y0);
		
		c3.setPrefWidth(er.dimX);
		c3.setPrefHeight(er.dimY);
		c3.setTranslateX(er.x2);
		c3.setTranslateY(er.y0);
		
		c4.setPrefWidth(er.dimX);
		c4.setPrefHeight(er.dimY);
		c4.setTranslateX(er.x0);
		c4.setTranslateY(er.y1);
		
		c5.setPrefWidth(er.dimX);
		c5.setPrefHeight(er.dimY);
		c5.setTranslateX(er.x1);
		c5.setTranslateY(er.y1);
		
		c6.setPrefWidth(er.dimX);
		c6.setPrefHeight(er.dimY);
		c6.setTranslateX(er.x2);
		c6.setTranslateY(er.y1);
		
		c7.setPrefWidth(er.dimX);
		c7.setPrefHeight(er.dimY);
		c7.setTranslateX(er.x0);
		c7.setTranslateY(er.y2);
		
		c8.setPrefWidth(er.dimX);
		c8.setPrefHeight(er.dimY);
		c8.setTranslateX(er.x1);
		c8.setTranslateY(er.y2);
		
		c9.setPrefWidth(er.dimX);
		c9.setPrefHeight(er.dimY);
		c9.setTranslateX(er.x2);
		c9.setTranslateY(er.y2);
		
	}
	
	ProductBanner product;
	Label pro;
	Switch_player player;
	
	Rectangle board, highlightMouse, innerBoard;
	Label c1, c2, c3, c4, c5, c6, c7, c8, c9;
	Button btnStart, btnRestart;
	Scene myScene, open; Stage stage; FlowPane o_node;
	Line line2, liinex0y0x2y2, linex2y0x0y2, linex0y1x2y1, linex1y0x1y2;
	Canvas pro_c; GraphicsContext pro_gc;
	private int font; private String sty; private Button back_to_main;
	private BorderPane mainDisplay; private Pane rootNode; private ColorPicker bgColor;
	
	public void start(Stage myStage) {
		product = new ProductBanner();
		pro = new Label(er.Raph);
		pro_c = new Canvas(er.len_dimX, er.dimY);
		pro_gc = pro_c.getGraphicsContext2D();
		pro_gc.setLineWidth(2);
		pro_gc.setLineWidth(1);
		pro_gc.setStroke(Color.MAGENTA); 
		pro_gc.strokeText(er.Raph, er.x0, (int) er.dimY / 2);
		System.out.println((int) er.dimY / 2);
		player = new Switch_player(player1, player2.player, er.msg2);
		/// start
		btnStart = new Button("start");
		o_node = new FlowPane();
		btnRestart = new Button("Restart");
		btnRestart.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				stage.setScene(myScene);
				// er.init(myScene.getWidth(), myScene.getHeight());
			}
		});
		btnStart.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				stage.setScene(myScene);
				
			}
		});
		stage = myStage;
		///////////////////////////////////////////////////////////////////////////////
		////////////////////////////////// menus////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////
		MenuBar mb = new MenuBar();
		Menu file = new Menu("File");
		Menu setting = new Menu("Setting");
		Menu about = new Menu("About");
		mb.getMenus().addAll(file);
		// file menu items
		MenuItem exit = new MenuItem("Exit");
		// setting
		MenuItem pc = new MenuItem("player color");
		MenuItem bgc = new MenuItem("background color");
		setting.getItems().addAll(pc, bgc);
		
		// about
		MenuItem author = new MenuItem("Author");
		MenuItem help = new MenuItem("How to use ");
		MenuItem fellow = new MenuItem("Rate Us Now");
		about.getItems().addAll(author, help, fellow);
		file.getItems().addAll(setting, about, exit);
		back_to_main = new Button("Back");
		bgColor = new ColorPicker(Color.RED);
		
		class mbHandler implements EventHandler<ActionEvent> {
			public void handle(ActionEvent ae) {
				if (ae.getSource().equals(bgColor)) {
					board.setFill(bgColor.getValue());
					mainDisplay.setCenter(rootNode);
					;
				} else if (ae.getSource().equals(back_to_main)) {
					mainDisplay.setCenter(rootNode);
					;
				} else {
					String cmd = ((MenuItem) ae.getTarget()).getText();
					// If Exit is chosen, the program is terminated.
					if (cmd.equals("Exit")) {
						System.exit(0);
					} else if (cmd.equals("background color")) {
						mainDisplay.setCenter(bgColor);
						///
					}
					if (cmd.equals("Author")) {
						mainDisplay.setCenter(new Profile(back_to_main));
						;
					}
				}
			}
		}
		mbHandler handle = new mbHandler();
		
		exit.setOnAction(handle);
		bgColor.setOnAction(handle);
		back_to_main.setOnAction(handle);
		about.setOnAction(handle);
		bgc.setOnAction(handle);
		myStage.setTitle(" Align");
		mainDisplay = new BorderPane();
		rootNode = new Pane();
		Pane group_card = new Pane();
		
		myScene = new Scene(mainDisplay, 500, 500);
		open = new Scene(o_node, 500, 500);
		o_node.getChildren().add(btnStart);
		initialise(myScene);
		
		player1.card[0].point.setxy(er.x0 - er.dimX * 2 / 3, er.y0);
		player1.card[1].point.setxy(er.x0 - er.dimX * 2 / 3, er.y0 + 2 * er.dimY);
		player1.card[2].point.setxy(er.x0 - er.dimX * 2 / 3, er.y0 + 4 * er.dimY);
		
		player2.player.card[0].point.setxy(er.x2 + er.dimX + er.dimX * 2 / 3, er.y0);
		player2.player.card[1].point.setxy(er.x2 + 5 / 3 * er.dimX + er.dimX * 2 / 3, er.y0 + 2 * er.dimY);
		player2.player.card[2].point.setxy(er.x2 + 5 / 3 * er.dimX + er.dimX * 2 / 3, er.y0 + 4 * er.dimY);
		for (int i = 0; i < 3; i++) {
			player1.card[i].draw();
			player1.card[i].c.setFill(Color.CORAL);
			player2.player.card[i].draw();
		}
		player1.card[0].posi = 0;
		player1.card[1].posi = 0;
		player1.card[2].posi = 0;
		player2.player.card[0].posi = 0;
		player2.player.card[1].posi = 0;
		player2.player.card[2].posi = 0;
		center_msg = new Label("Started");
		down_msg = new Label("point");
		board = new Rectangle(er.x0, er.y0, er.len_dimX, er.len_dimY);
		c1 = new Label("1");
		c2 = new Label("2");
		c3 = new Label("3");
		c4 = new Label("4");
		c5 = new Label("5");
		c6 = new Label("6");
		c7 = new Label("7");
		c8 = new Label("8");
		c9 = new Label("9");
		highlightMouse = new Rectangle();
		
		initi();
		innerBoard = new Rectangle(er.x0 + (er.dimX / 2), er.y0 + (er.dimY / 2), er.len_dimX - er.dimX, er.len_dimY - er.dimY);
		//innerBoard.setCol
		liinex0y0x2y2 = new Line(er.x0 + (er.dimX / 2), er.y0 + (er.dimY / 2), er.x2 + er.dimX / 2,
				er.y2 + er.dimY / 2);
		linex2y0x0y2 = new Line(er.x2 + er.dimX / 2, er.y0 + er.dimY / 2, er.x0 + (er.dimX / 2), er.y2 + er.dimY / 2);
		linex0y1x2y1 = new Line(er.x0 + er.dimX / 2, er.y1 + (er.dimY / 2), er.x2 + er.dimX / 2, er.y1 + (er.dimY / 2));
		linex1y0x1y2 = new Line(er.x1 + (er.dimX / 2), er.y0 + er.dimY / 2, er.x1 + (er.dimX / 2), er.y2 + er.dimY / 2);
		Color col = Color.GREEN;
		int str = 3;
		highlightMouse.setFill(Color.TRANSPARENT);
		highlightMouse.setStrokeWidth(str);
		highlightMouse.setStroke(Color.BLUEVIOLET);
		
		innerBoard.setFill(Color.TRANSPARENT);
		innerBoard.setStrokeWidth(str);
		innerBoard.setStroke(Color.BLUE);
		
		liinex0y0x2y2.setFill(Color.TRANSPARENT);
		liinex0y0x2y2.setStrokeWidth(str);
		liinex0y0x2y2.setStroke(col);
		
		linex2y0x0y2.setFill(Color.TRANSPARENT);
		linex2y0x0y2.setStrokeWidth(str);
		linex2y0x0y2.setStroke(col);
		
		linex0y1x2y1.setFill(Color.TRANSPARENT);
		linex0y1x2y1.setStrokeWidth(str);
		linex0y1x2y1.setStroke(col);
		
		linex1y0x1y2.setFill(Color.TRANSPARENT);
		linex1y0x1y2.setStrokeWidth(str);
		linex1y0x1y2.setStroke(col);
		
		font = er.dimY / 2;
		sty = " " + "-fx-border-color: white;" + "-fx-border-width: 2px;" + "-fx-alignment:center;"
				+ "-fx-text-color:white;" + "-fx-border-radius: 40;" + "-fx-font-size:" + font + ";";
		
		c1.setStyle(sty);
		c2.setStyle(sty);
		c3.setStyle(sty);
		c4.setStyle(sty);
		c5.setStyle(sty);
		c6.setStyle(sty);
		c7.setStyle(sty);
		c8.setStyle(sty);
		c9.setStyle(sty);
		
		board.setFill(Color.MAGENTA);
		board.toBack();
		board.setStrokeWidth(5);
		board.setStroke(Color.YELLOWGREEN);
		line2 = new Line(0, 499, 550, 0);
		line2.setStrokeWidth(1.0);
		
		down_msg.setTranslateY(er.y2 + er.dimY);
		down_msg.setTranslateX(er.x0);
		center_msg.setTranslateY(er.y0 - er.dimY / 2);
		
		mainDisplay.setCenter(rootNode);
		FlowPane top = new FlowPane();
		btnRestart.setAlignment(Pos.TOP_LEFT);
		top.getChildren().addAll(mb, btnRestart);
		mainDisplay.setTop(top);
		mainDisplay.setBottom(pro_c);
		group_card.getChildren().addAll(c1, c2, c3, c4, c5, c6, c7, c8, c9);
		center_msg.setTranslateX((er.x1 - 2 / 3 * er.x1));
		rootNode.getChildren().addAll(board, innerBoard);
		rootNode.getChildren().addAll(liinex0y0x2y2, linex2y0x0y2, linex0y1x2y1, linex1y0x1y2, group_card, highlightMouse,
				player1.card[0].c.c, player1.card[1].c.c, player1.card[2].c.c, player2.player.card[0].c.c,
				player2.player.card[1].c.c, player2.player.card[2].c.c, down_msg, center_msg);
		myStage.setScene(open);
		
		EventHandler<MouseEvent> mouse = new EventHandler<MouseEvent>() {
			double mx, my;
			
			public void handle(MouseEvent e) {
				mx = e.getX();
				my = e.getY();
				//////// mouse Entered
				if (e.getEventType().equals(MouseEvent.MOUSE_ENTERED_TARGET)) {
					initialise(myScene);
					initi();
					repaint();
					
				}
				if (e.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
					// if(comp_play)swap_next_player();
					
					er.press(mx, my);
				} else
				
				////////////////////////////////////////////////////////////////////////////////////////
				// MOUSE DRAGGED event
				
				if (e.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
					er.drag(mx, my);
					e.consume();
				} else
				////////////////////////////////////////////////////////////////////////////////////////
				// MOUSE_MOVED event
				
				if (e.getEventType().equals(MouseEvent.MOUSE_MOVED)) {
					// System.out.println("mouse move ");
					er.MouseMove(mx, my);
					e.consume();
					
				} else if (e.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
					System.out.println("MOUSE_RELEASED");
					er.relesed(mx, my);
					e.consume();
				}
			}
			// end of mousePressed(MouseEvent e)
		};
		
		rootNode.addEventFilter(MouseEvent.MOUSE_DRAGGED, mouse);
		rootNode.addEventFilter(MouseEvent.MOUSE_CLICKED, mouse);
		rootNode.addEventFilter(MouseEvent.MOUSE_PRESSED, mouse);
		rootNode.addEventFilter(MouseEvent.MOUSE_RELEASED, mouse);
		rootNode.addEventFilter(MouseEvent.MOUSE_MOVED, mouse);
		rootNode.addEventFilter(MouseEvent.MOUSE_ENTERED_TARGET, mouse);
		myStage.show();
		btnStart.fire();
	}
	
	public void stop() {
		
		System.out.println("STOPING THE GAME ");
		System.exit(0);
		
	}
	
	void repaint() {
		er.repaint();
		
		center_msg.setTranslateX((er.x1 - 2 / 3 * er.x1));
		
		board.setWidth(er.len_dimX);
		board.setX(er.x0);
		board.setY(er.y0);
		board.setHeight(er.len_dimY);
		innerBoard.setWidth(er.len_dimX - er.dimX);
		innerBoard.setX(er.x0 + (er.dimX / 2));
		innerBoard.setY(er.y0 + (er.dimY / 2));
		innerBoard.setHeight(er.len_dimY - er.dimY);
		
		down_msg.setTranslateY(er.y2 + er.dimY);
		down_msg.setTranslateX(er.x0);
		center_msg.setTranslateY(er.y0 - er.dimY / 2);
		
		// lines settings
		liinex0y0x2y2.setStartX(er.x0 + er.dimX / 2);
		liinex0y0x2y2.setStartY(er.y0 + er.dimY / 2);
		liinex0y0x2y2.setEndX(er.x2 + er.dimX / 2);
		liinex0y0x2y2.setEndY(er.y2 + er.dimY / 2);
		
		linex0y1x2y1.setStartX(er.x0 + er.dimX / 2);
		linex0y1x2y1.setStartY(er.y1 + (er.dimY / 2));
		linex0y1x2y1.setEndX(er.x2 + er.dimX / 2);
		linex0y1x2y1.setEndY(er.y1 + (er.dimY / 2));
		
		linex2y0x0y2.setStartX(er.x2 + er.dimX / 2);
		linex2y0x0y2.setStartY(er.y0 + er.dimY / 2);
		linex2y0x0y2.setEndX(er.x0 + er.dimX / 2);
		linex2y0x0y2.setEndY(er.y2 + er.dimY / 2);
		
		linex1y0x1y2.setStartX(er.x1 + (er.dimX / 2));
		linex1y0x1y2.setStartY(er.y0 + er.dimY / 2);
		linex1y0x1y2.setEndX(er.x1 + (er.dimX / 2));
		linex1y0x1y2.setEndY(er.y2 + er.dimY / 2);
	}
	
	  class ProductBanner implements Runnable {
		Thread play;
		
		ProductBanner() {
			play = new Thread(this, "product banner");
			System.out.println("Child thread: " + play);
			play.start();
		}
		
		public void run() {
			try {
				Thread.sleep(440);
			} catch (InterruptedException e) {
			}
			for (;;) {
				try {
					
					if (er.Raph.compareToIgnoreCase("     RAPHAEL RAYMOND PRODUCT     ") == 0) {
						Thread.sleep(5000);
					}
					er.Raph = er.Raph.substring(1, er.Raph.length()) + er.Raph.charAt(0);
					pro_gc.clearRect(0, 0, 5530, 5500);
					pro_gc.strokeText(er.Raph, (er.x0 + er.x1) / 2, (int) er.dimY / 2);
					
					if (player1.play == false && player2.player.play == false) {
						if (player1.win)
							er.msg2 = player1.name + " have won game over ";
						else if (player2.player.win)
							er.msg2 = player2.player.name + " have won game over ";
                       
					}
						
					Thread.sleep(250);
				} catch (InterruptedException e) {
				}
			}
			
		}
	}
	
	@Override
	public void onRelocate(boolean visibility, double h_pointx, double h_pointy, double h_dimX, double h_dimY) {
		
		highlightMouse.setVisible(visibility);
		highlightMouse.relocate(h_pointx, h_pointy);
		highlightMouse.setWidth(h_dimX);
		highlightMouse.setHeight(h_dimY);
		;
		
	}
	
	@Override
	public void down_msg(String msg) {
		down_msg.setText(msg); 
		;
	}
	
	@Override
	public void onRelocate(double h_pointx, double h_pointy, double h_dimX, double h_dimY) {
		highlightMouse.relocate(h_pointx, h_pointy);
		highlightMouse.setWidth(h_dimX);
		highlightMouse.setHeight(h_dimY);
		;
		
	}
	
	@Override
	public void onRelocate(boolean visibility) {
		highlightMouse.setVisible(visibility);
		
	}
	
	@Override
	public void center_msg(String msg) {
		center_msg.setText(msg);
	}
	
}
