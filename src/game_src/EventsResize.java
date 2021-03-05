package game_src;

import javafx.scene.input.MouseEvent;

public class EventsResize {
	
	public int x0,x1,x2,y0,y1,y2,
	 dime=30,gapX,gapY,
	 gap,len_dimY,len_dimX;

public String card_owner="",card_owner_click=""; 

public String Raph="     RAPHAEL RAYMOND PRODUCT     ";
//var
public  boolean comp_play =true;
public boolean start=false;
public int ix,iy;//intial value to return to after dragged
public int x,y;
public int card_num ;
public String point=" ",msg2=" STARTED ",winer="non";

int 
h_pointx=0,h_pointy=0;

public int dimX=0;

public int dimY=0;

int dim_h=0;

int h_dimX=0;

int h_dimY=0; 
Player player1 ;
MsgRelo msgRelo;

AutoPlayer player2; 
public EventsResize(Player player1, AutoPlayer player2, MsgRelo msgRelo) {
	super();
	this.player1 = player1;
	this.player2 = player2;
	this.msgRelo = msgRelo;
}


public void init(double width, double height) {
	len_dimX= (int) ((0.8)*width);
	len_dimY= (int) ((0.8)*height  );
	gapX=(int)width -len_dimX;
	gapY=(int)height -len_dimY;
	x0=(int)gapX/2;
	y0=(int)gapY/2;
	//dim=(int)(0.09*len_dimX);
	dimX=(int)(0.09*len_dimX);
	dimY=(int)(0.09*len_dimY);
	len_dimY=len_dimY-dimY;
	dimY=(int)(0.09*len_dimY);
	x2=x0+len_dimX-dimX;
	y2= y0+len_dimY-dimY;
	x1=(int)(x0+x2)/2 ;
	y1=(int)(y0+y2)/2;
	
	
} 


public void repaint(){
	 if(player1.card[0].posi==0)
		 player1.card[0].point.setxy(x0-dimX*2/3, y0);
	 if(player1.card[1].posi==0)
		 player1.card[1].point.setxy(x0-dimX*2/3, y0+2*dimY);
	 if(player1.card[2].posi==0)
		 player1.card[2].point.setxy(x0-dimX*2/3, y0+4*dimY);
	 if(player2.player. card[0].posi==0)
		 player2.player.  card[0].point.setxy(x2+dimX+dimX*2/3, y0);
	 if(player2.player. card[1].posi==0)
		 player2.player .card[1].point.setxy(x2+5/3*dimX+dimX*2/3, y0+2*dimY);
	 if(player2.player.card[2].posi==0)
		 player2.player.card[2].point.setxy(x2+5/3*dimX+dimX*2/3, y0+4*dimY);
	
	for(int i=0;i<3;i++){
		player1.card[i].move( i, player1.card[i].posi, x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2),true);
		player2.player.card[i].move(i, player2.player.card[i].posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2),true);
		player1.card[i].draw();
		player2.player.card[i].draw();
		}
	 
}
 
public void press(double mx,double my){ 
	/// point 1
		{if((mx >= x0 && mx <= x0 + dimX)&&( my>=y0&& my <=y0+dimY))
		    {   
				point = "  on point 1  ";
				if( !card_exist(1)){
					card_num =which_card(1);
					point =	card_owner_click + point;
				}
				
				}
			
			else /// point 2
				if((mx >= x1&& mx <= x1+dimX)&&( my>=y0&& my <=y0+dimY))
		    {   
				point = "  on point 2 ";
				if(! card_exist(2)){
					card_num=which_card(2);
					point =	card_owner_click +point;
				}
				
				
				}
			 else /// point 3
				if((mx >= x2&& mx <= x2+dimX)&&( my>=y0&& my <=y0+dimY))
		    {   
				point = "  on point 3 ";
				if( !card_exist(3)){
					card_num=which_card(3);
					point =	card_owner_click +point;
					
				}
				}
			
			
			else
			/// point 4
			if((mx >= x0 && mx <= x0+dimX)&&( my>=y1&& my <=y1+dimY))
		    {   
				
				point = "  on point 4 ";
				if( !card_exist(4)){
					card_num=which_card(4);
					point =	card_owner_click +point;		
				;}}
			
			else /// point 5
				if((mx >= x1&& mx <= x1+dimX)&&( my>=y1&& my <=y1+dimY))
		    {   
				point = "  on point 5 ";
				if( card_exist(5)){
					card_num=which_card(5);
					point =	card_owner_click +point;
				}
				}
			 else /// point 6
				if((mx >= x2&& mx <= x2+dimX)&&(my>=y1&& my <=y1+dimY))
		    {   
				point = "  on point 6 ";
				if( card_exist(6)){
					card_num=which_card(6);
					point =	card_owner_click +point;
				}
				}
			
				else	/// point 7
					if((mx >= x0 && mx <= x0+dimX)&&( my>=y2&& my <=y2+dimY))
				    {   
						point = "  on point 7 ";
						
						if( card_exist(7)){
							card_num=which_card(7);
							point =	card_owner_click +point;
						}
						}
					
					else /// point 8
						if((mx >= x1&& mx <= x1+dimX)&&( my>=y2&& my <=y2+dimY))
				    {   
						point = "  on point 8 ";
						if( card_exist(8)){
							card_num=which_card(8);
							point =	card_owner_click +point;
						}
						}
					 else /// point 9
						if((mx >= x2&& mx <= x2+dimX)&&( my>=y2&& my <=y2+dimY))
				    {   
						point = "  on point 9 ";
						if( card_exist(9)){
							card_num=which_card(9);
							point =	card_owner_click +point;
						}
			}
					
			else if(card_exist(mx,my)){
				card_num= which_card(mx,my);
				point ="   not on point ";
				point =	card_owner_click +point;
				
	} else 
		
		{ 		
			
				point ="";
				card_owner_click= " ";
				card_num=-1;
				
				}
		msgRelo.down_msg(point);
		
		///set initial 
		if(card_owner_click == player1.name){
			
			if(card_num>-1&&card_num<3){
				ix=player1.card[card_num].point.x;
				iy=player1.card[card_num].point.y;
			System.out.println("mouseReleased=for1_re "+card_num+" card pos1 "+player1.card[card_num].posi);
			}							
			}
			else {
		if(card_owner_click ==player2.player.name){
			if(card_num>-1&&card_num<3){
				ix=player2.player.card[card_num].point.x;
				iy=player2.player.card[card_num].point.y;
			}}
		}
		}
			System.out.println("mouseClicked= "+card_num);
}
public void MouseMove(double mx,double my){ 
	
	  {	  
		/// point 1
		if((mx >= x0 && mx <= x0 + dimX)&&( my>=y0&& my<=y0+dimY))
	    {   
			point = "  on point 1  ";
			if( card_exist(1)){
				point =	card_owner +point;
			}
			
			
			h_dimX=dimX;h_dimY=dimY;
			h_pointx =x0;
			h_pointy=y0;
			msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY); 
			
			}
		
		else /// point 2
			if((mx >= x1&& mx <= x1+dimX)&&( my>=y0&& my <=y0+dimY))
	    {   
			point = "  on point 2 ";
			if( card_exist(2)){
				point =	card_owner +point;
			}
			
			
			h_dimX=dimX;h_dimY=dimY;
			 h_pointx = x1;
			h_pointy=y0;
			
			msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
			}
		 else /// point 3
			if((mx >= x2&& mx <= x2+dimX)&&( my>=y0&& my <=y0+dimY))
	    {   
			point = "  on point 3 ";
			if( card_exist(3)){
				point =	card_owner +point;
			}
			
			
			h_dimX=dimX;h_dimY=dimY;
			h_pointx = x2;
			h_pointy=y0;
			
			msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
				
	    }
		
		
		else
		/// point 4
		if((mx >= x0 && mx <= x0+dimX)&&( my>=y1&& my <=y1+dimY))
	    {   
			point = "  on point 4 ";
			if( card_exist(4)){
				point =	card_owner +point;
			}
			
			h_dimX=dimX;h_dimY=dimY;
			h_pointx =x0;
			h_pointy=y1;
			
			msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
				
	    }
		
		else /// point 5
			if((mx >= x1&& mx <= x1+dimX)&&( my>=y1&& my <=y1+dimY))
	    {   
			point = "  on point 5 ";
			if( card_exist(5)){
				point =	card_owner +point;
			}
				
			
			h_dimX=dimX;h_dimY=dimY;
			 h_pointx = x1;
			h_pointy=y1;
			
			msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
			}
		 else /// point 6
			if((mx >= x2&& mx <= x2+dimX)&&(my>=y1&& my <=y1+dimY))
	    {   
			point = "  on point 6 ";
			if( card_exist(6)){
				point =	card_owner +point;
			}
			
			
			h_dimX=dimX;h_dimY=dimY;
			h_pointx = x2;
			h_pointy=y1;
			
			msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
				}
		
			else	/// point 7
				if((mx >= x0 && mx <= x0+dimX)&&( my>=y2&& my <=y2+dimY))
			    {  
					point = "  on point 7 ";
					
					if( card_exist(7)){
						point =	card_owner +point;
					}
					h_dimX=dimX;h_dimY=dimY;
					h_pointx =x0;
					h_pointy=y2;
					
					msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
						
			    }
				
				else /// point 8
					if((mx >= x1&& mx <= x1+dimX)&&( my>=y2&& my <=y2+dimY))
			    {   
					point = "  on point 8 ";
					if( card_exist(8)){
						point =	card_owner +point;
					}
					
					
					h_dimX=dimX;h_dimY=dimY;
					 h_pointx = x1;
					h_pointy=y2;
					
					msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
					}
				 else /// point 9
					if((mx >= x2&& mx <= x2+dimX)&&( my>=y2&& my <=y2+dimY))
			    {   
					point = "  on point 6 ";
					if( card_exist(9)){
						point =	card_owner +point;
					}
			
					h_dimX=dimX;h_dimY=dimY;
					h_pointx = x2;
					h_pointy=y2;
					
					msgRelo.onRelocate(true,  h_pointx,  h_pointy,   h_dimX, h_dimY);
						
			    }
				
		else if(card_exist(mx,my)){
			card_num= which_card(mx,my);
			point ="   not on point ";
			point =	card_owner_click +point;
			
                        }
		else{
		
			msgRelo.onRelocate(  h_pointx,  h_pointy,   h_dimX, h_dimY);
			h_dimX=0;h_dimY=0;
		h_pointx =(int) mx;
		h_pointy=(int) my;
			point ="";
			msgRelo.onRelocate(true);
		///	System.out.println("X= "+mx +" ....Not on  point....    Y= " + my);
			}
		msgRelo.down_msg(point);
			
			//end of mouseMoved(MouseEvent e)
		
	}
}
double mx;double my;

public void drag(double mx,double my){
	  
	
	if(card_owner_click == player1.name){
		if(card_num >-1&&card_num<3) {
			player1.card[card_num].moving(card_num, (int)mx,(int)my);
		player1.card[card_num].draw();	}				
		}
		else 
	if(card_owner_click ==player2.player.name){
		
		
		if(card_num>-1&&card_num<3) {
		player2.player.card[card_num].moving(card_num,(int)mx,(int)my);
		player2.player.card[card_num].draw();
		}}
	//mx = e.getX();
	//my = e.getY();
	String nameP=null;
	/// point 1
		if((mx >= x0 && mx <= x0 + dimX)&&( my>=y0&& my <=y0+dimY))
	    {   
			point = "  on point 1  ";
			nameP=card_existDrag(1);
			if( nameP!=null){
				point =	nameP +point;
			}
			
		 
			h_dimX=dimX;h_dimY=dimY;
			h_pointx =x0;
			h_pointy=y0;
			 
			msgRelo.onRelocate(h_pointx,  h_pointy,   h_dimX, h_dimY);
			}
		
		else /// point 2
			if((mx >= x1&& mx <= x1+dimX)&&( my>=y0&& my <=y0+dimY))
	    {   
			point = "  on point 2 ";
			nameP=card_existDrag(2);
			if( nameP!=null){
				point =	nameP +point;
			}
			
			
		 
			h_dimX=dimX;h_dimY=dimY;
			 h_pointx = x1;
			h_pointy=y0;
			 
			 
			msgRelo.onRelocate(h_pointx,  h_pointy,   h_dimX, h_dimY);
			}
		 else /// point 3
			if((mx >= x2&& mx <= x2+dimX)&&( my>=y0&& my <=y0+dimY))
	    {   
			point = "  on point 3 ";
			nameP=card_existDrag(3);
			if( nameP!=null){
				point =	nameP +point;
			}
			
			 
			h_dimX=dimX;h_dimY=dimY;
			h_pointx = x2;
			h_pointy=y0;
			 
			msgRelo.onRelocate( h_pointx,  h_pointy,   h_dimX, h_dimY);

}
		
		
		else
		/// point 4
		if((mx >= x0 && mx <= x0+dimX)&&( my>=y1&& my <=y1+dimY))
	    {   
			point = "  on point 4 ";
			nameP=card_existDrag(4);
			if( nameP!=null){
				point =	nameP +point;
			}
			
			
			h_dimX=dimX;h_dimY=dimY;
			h_pointx =x0;
			h_pointy=y1;

			msgRelo.onRelocate(  h_pointx,  h_pointy,   h_dimX, h_dimY);}
		
		else /// point 5
			if((mx >= x1&& mx <= x1+dimX)&&( my>=y1&& my <=y1+dimY))
	    {   
			point = "  on point 5 ";

			nameP=card_existDrag(5);
			if( nameP!=null){
				point =	nameP +point;
			}	
			
		
			h_dimX=dimX;h_dimY=dimY;
			 h_pointx = x1;
			h_pointy=y1;
			 
			msgRelo.onRelocate( h_pointx,  h_pointy,   h_dimX, h_dimY); 
			}
		 else /// point 6
			if((mx >= x2&& mx <= x2+dimX)&&(my>=y1&& my <=y1+dimY))
	    {   
			point = "  on point 6 ";
			nameP=card_existDrag(6);
			if( nameP!=null){
				point =	nameP +point;
			}
			
		
			h_dimX=dimX;h_dimY=dimY;
			h_pointx = x2;
			h_pointy=y1;
			msgRelo.onRelocate( h_pointx,  h_pointy,   h_dimX, h_dimY);
}
		
			else	/// point 7
				if((mx >= x0 && mx <= x0+dimX)&&( my>=y2&& my <=y2+dimY))
			    {   
					point = "  on point 7 ";
					
					nameP=card_existDrag(7);
					if( nameP!=null){
						point =	nameP +point;
					}
					h_dimX=dimX;h_dimY=dimY;
					h_pointx =x0;
					h_pointy=y2;
					msgRelo.onRelocate( h_pointx,  h_pointy,   h_dimX, h_dimY);
						
			    }
				
				else /// point 8
					if((mx >= x1&& mx <= x1+dimX)&&( my>=y2&& my <=y2+dimY))
			    {   
					point = "  on point 8 ";
					nameP=card_existDrag(8);
					if( nameP!=null){
						point =	nameP +point;
					}
				
					h_dimX=dimX;h_dimY=dimY;
					 h_pointx = x1;
					h_pointy=y2;
					 
					msgRelo.onRelocate( h_pointx,  h_pointy,   h_dimX, h_dimY); 
					}
				 else /// point 9
					if((mx >= x2&& mx <= x2+dimX)&&( my>=y2&& my <=y2+dimY))
			    {   
					point = "  on point 9 ";
					nameP=card_existDrag(9);
					if( nameP!=null){
						point =	nameP +point;
					}
			
					h_dimX=dimX;h_dimY=dimY;
					h_pointx = x2;
					h_pointy=y2;
					 
					msgRelo.onRelocate(  h_pointx,  h_pointy,   h_dimX, h_dimY); 
						;}
				
		else{
			msgRelo.onRelocate(  h_pointx,  h_pointy,   h_dimX, h_dimY); 
			 
			h_dimX=0;h_dimY=0;
		h_pointx =0;
		h_pointy=0;
			point ="";
			
				}
		msgRelo.down_msg(point);
	
	//end of  mouse Dragged(MouseEvent e) 
}
public  void relesed(double mx,double my){
	 
	 
//move back changes done by drag
if(card_owner_click == player1.name){
	
	if(card_num>-1&&card_num<3){
		player1.card[card_num].point.x=ix;
		player1.card[card_num].point.y=iy;
		player1.card[card_num].draw();}							
	}
	else 
if(card_owner_click ==player2.player.name){ 
	if(card_num>-1&&card_num<3){
		player2.player.card[card_num].point.x=ix;
		player2.player.card[card_num].point.y=iy;}	
	player2.player.card[card_num].draw();}
///end of move back



/// point 1
if((mx >= x0 && mx <= x0 +dimX)&&( my>=y0&& my <=y0+dimY)){

			if( !card_exist(1)){
				System.out.println("mouseReleased= !card_exist(1)");
				if(card_owner_click == player1.name){
				int posi=	point(mx,my );
				if(card_num>-1&&card_num<3){
				msg2=	player1.card[card_num].move(card_num, posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
				player2.player.op_card=player1.card;
				player1.card[card_num].draw();
				}
											
				}
				else 
			if(card_owner_click ==player2.player.name){
			
				int posi=	point(mx,my );System.out.println("aaaaa"+posi);
				if(card_num>-1&&card_num<3)
			msg2=player2.player.card[card_num].move(card_num, posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
				player2.player.card[card_num].draw();
				}}
			}
 
						else /// point 2
							if((mx >= x1&& mx <= x1+dimX)&&( my>=y0&& my <=y0+dimY))
					    {   
							point = "  on point 2 ";
							System.out.println("mouseReleased= !card_exist(2)"+which_card(2)+card_exist(2));
							if( !card_exist(2)){
								System.out.println("mouseReleased= !card_exist(2)");
								if(card_owner_click == player1.name){
								int posi=	point(mx,my );
								if(card_num>-1&&card_num<3){
								msg2=	player1.card[card_num].move(card_num, posi
										,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));player1.card[card_num].draw();
								player2.player.op_card=player1.card;}
															
								}
								else 
							if(card_owner_click ==player2.player.name){
								
								int posi=	point(mx,my );System.out.println("aaaaa"+posi);
								if(card_num>-1&&card_num<3)
									msg2=player2.player.card[card_num].move(card_num,
											posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
								player2.player.card[card_num].draw();
								}}
							}
						 else /// point 3
							if((mx >= x2&& mx <= x2+dimX)&&( my>=y0&& my <=y0+dimY))
					    {   
							point = "  on point 3 ";
							if( !card_exist(3)){
								System.out.println("mouseReleased= !card_exist(1)");
								if(card_owner_click == player1.name){
								int posi=	point(mx,my );
								if(card_num>-1&&card_num<3){
								msg2=	player1.card[card_num].move(card_num, posi
										,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
								player1.card[card_num].draw();
								player2.player.op_card=player1.card;}
															
								}
								else 
							if(card_owner_click ==player2.player.name){
								
								int posi=	point(mx,my );System.out.println("aaaaa"+posi);
								if(card_num>-1&&card_num<3)
									msg2=player2.player.card[card_num].move(card_num,
											posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
								player2.player.card[card_num].draw();
								}};}
						
						
						else
						/// point 4
						if((mx >= x0 && mx <= x0+dimX)&&( my>=y1&& my <=y1+dimY))
					    {   
							point = "  on point 4 ";
							if(! card_exist(4)){
								System.out.println("mouseReleased= !card_exist(1)");
								if(card_owner_click == player1.name){
								int posi=	point(mx,my );
								if(card_num>-1&&card_num<3){
								msg2=	player1.card[card_num].move(card_num, posi
										,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));player1.card[card_num].draw();
								player2.player.op_card=player1.card;}
															
								}
								else 
							if(card_owner_click ==player2.player.name){
								
								int posi=	point(mx,my );System.out.println("aaaaa"+posi);
								if(card_num>-1&&card_num<3)
									msg2=player2.player.card[card_num].move(card_num,
											posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
								player2.player.card[card_num].draw();
								}};}
						else /// point 5
							if((mx >= x1&& mx <= x1+dimX)&&( my>=y1&& my <=y1+dimY))
					    {   
							point = "  on point 5 ";
							if(! card_exist(5)){
								System.out.println("mouseReleased= !card_exist(1)");
								if(card_owner_click == player1.name){
								int posi=	point(mx,my );
								if(card_num>-1&&card_num<3){
								msg2=	player1.card[card_num].move(card_num, posi
										,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));player1.card[card_num].draw();
								player2.player.op_card=player1.card;}
															
								}
								else 
							if(card_owner_click ==player2.player.name){
								
								int posi=	point(mx,my );System.out.println("aaaaa"+posi);
								if(card_num>-1&&card_num<3)
									msg2=player2.player.card[card_num].move(card_num,
											posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
								player2.player.card[card_num].draw();
								}};}
						 else /// point 6
							if((mx >= x2&& mx <= x2+dimX)&&(my>=y1&& my <=y1+dimY))
					    {   
							point = "  on point 6 ";
							if(! card_exist(6)){
								System.out.println("mouseReleased= !card_exist(1)");
								if(card_owner_click == player1.name){
								int posi=	point(mx,my );
								if(card_num>-1&&card_num<3){
								msg2=	player1.card[card_num].move(card_num, posi
										,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
								player1.card[card_num].draw();
								player2.player.op_card=player1.card;}
															
								}
								else 
							if(card_owner_click ==player2.player.name){
								
								int posi=	point(mx,my );System.out.println("aaaaa"+posi);
								if(card_num>-1&&card_num<3)
									msg2=player2.player.card[card_num].move(card_num,
											posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));player2.player.card[card_num].draw();
				
								}};}
							else	/// point 7
								if((mx >= x0 && mx <= x0+dimX)&&( my>=y2&& my <=y2+dimY))
							    {   
									point = "  on point 7 ";
									
									if( !card_exist(7)){
										System.out.println("mouseReleased= !card_exist(1)");
										if(card_owner_click == player1.name){
										int posi=	point(mx,my );
										if(card_num>-1&&card_num<3){
										msg2=	player1.card[card_num].move(card_num, posi
												,x0+(dimX/2),y0+(dimY/2),x2+(dimY/2),y2+(dimX/2));player1.card[card_num].draw();
										player2.player.op_card=player1.card;}
																	
										}
										else 
									if(card_owner_click ==player2.player.name){
										
										int posi=	point(mx,my );System.out.println("aaaaa"+posi);
										if(card_num>-1&&card_num<3)
											msg2=player2.player.card[card_num].move(card_num,
													posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
										player2.player.card[card_num].draw();
										}};}
								else /// point 8
									if((mx >= x1&& mx <= x1+dimX)&&( my>=y2&& my <=y2+dimY))
							    {   
									point = "  on point 8 ";
									if(! card_exist(8)){
										System.out.println("mouseReleased= !card_exist(1)");
										if(card_owner_click == player1.name){
										int posi=	point(mx,my );
										if(card_num>-1&&card_num<3){
										msg2=	player1.card[card_num].move(card_num, posi
												,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));player1.card[card_num].draw();
										player2.player.op_card=player1.card;}
																	
										}
										else 
									if(card_owner_click ==player2.player.name){
										
										int posi=	point(mx,my );System.out.println("aaaaa"+posi);
										if(card_num>-1&&card_num<3)
											msg2=player2.player.card[card_num].move(card_num,
													posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
										player2.player.card[card_num].draw();
										}};}
								 else /// point 9
									if((mx >= x2&& mx <= x2+dimX)&&( my>=y2&& my <=y2+dimY))
							    {   
									point = "  on point 9 ";
									if(! card_exist(9)){
										System.out.println("mouseReleased= !card_exist(1)");
										if(card_owner_click == player1.name){
										int posi=	point(mx,my );
										if(card_num>-1&&card_num<3){
										msg2=	player1.card[card_num].move(card_num, posi
												,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));player1.card[card_num].draw();
										player2.player.op_card=player1.card;}
																	
										}
										else 
									if(card_owner_click ==player2.player.name){
										
										int posi=	point(mx,my );System.out.println("aaaaa"+posi);
										if(card_num>-1&&card_num<3)
											msg2=player2.player.card[card_num].move(card_num,
													posi,x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
										player2.player.card[card_num].draw();
										}};
									}
						
msgRelo.center_msg(msg2);
		

	card_owner="";
	
}

public void swap_next_player(){
/// computer playing here 
	if (player2.player.play){
		 player2.com_move(x0+(dimX/2),y0+(dimY/2),x2+(dimX/2),y2+(dimY/2));
	
	
   }
}





public boolean card_exist(int posi){
	for(int i= 0; i<3;i++){
		if (player1.card[i].posi== posi){
			card_owner = player1.name;
			card_owner_click= player1.name;
			return true;}
		if (player2.player.card[i].posi== posi){
			card_owner=player2.player.name;
			card_owner_click= player2.player.name;
			return true;}
		
	}
	//card_owner_click= " ";
	card_owner="";
	return false;
}

public  String card_existDrag(int posi){
	for(int i= 0; i<3;i++){
		if (player1.card[i].posi== posi){ 
			return player1.name;}
		
		if (player2.player.card[i].posi== posi){ 
			return player2.player.name;}
		
	}
	 
	return null;
}

public  boolean card_exist(double x,double y){
	for(int i= 0; i<3;i++){
		if ((player1.card[i].point.x +20>=x &&player1.card[i].point.x-20<=x)
				&&(player1.card[i].point.y+20 >=y &&player1.card[i].point.y-30<=y)
				){
			card_owner = player1.name;
	
			//cy=player1.card[i].point.y;
				//	cx=player1.card[i].point.x;
			card_owner_click= player1.name;
			return true;}
		if ((player2.player.card[i].point.x +20>=x &&player2.player.card[i].point.x-20<=x)
				&&(player2.player.card[i].point.y+20 >=y &&player2.player.card[i].point.y-30<=y)
				){
			card_owner=player2.player.name;
			card_owner_click= player2.player.name;
		//	cy=player2.player.card[i].point.y;
			//cx=player2.player.card[i].point.x;
			return true;}
		
	}
	//
	//card_owner_click= " ";
	card_owner="";
	return false;
}


public int  which_card(double x,double y){
	for(int i= 0; i<3;i++){
		if ((player1.card[i].point.x <=x+30 &&player1.card[i].point.x>=x-30)&&
				(player1.card[i].point.y <=y+30 &&player1.card[i].point.y>=y-30)){
			card_owner = player1.name;
			card_owner_click= player1.name;
			//cy=player1.card[i].point.y;
			//cx=player1.card[i].point.x;
			return i;}
		if ((player2.player.card[i].point.x <=x +30&&player2.player.card[i].point.x>=x-30)&&
				(player2.player.card[i].point.y <=y+30 &&player2.player.card[i].point.y>=y-30)){
			card_owner=player2.player.name;
			card_owner_click= player2.player.name;
			//cy=player2.player.card[i].point.y;
			//cx=player2.player.card[i].point.x;
			return i;}
		
	}
	//card_owner_click= " ";
	card_owner="";
	return -1;
}

public int point(double mx,double my){
	/// point 1
	if((mx >= x0 && mx <= x0 + dimX)&&( my>=y0&& my <=y0+dimY))
    {  System.out.println("point 1"); return 1;}	
	else /// point 2
		if((mx >= x1&& mx <= x1+dimX)&&( my>=y0&& my <=y0+dimY))
    {   			return 2;		}
	 else /// point 3
		if((mx >= x2&& mx <= x2+dimX)&&( my>=y0&& my <=y0+dimY))
    {   			return 3;}
		else
	/// point 4
	if((mx >= x0 && mx <= x0+dimX)&&( my>=y1&& my <=y1+dimY))
    {  		return 4;}
		else /// point 5
		if((mx >= x1&& mx <= x1+dimX)&&( my>=y1&& my <=y1+dimY))
    {   			return 5;		}
	 else /// point 6
		if((mx >= x2&& mx <= x2+dimX)&&(my>=y1&& my <=y1+dimY))
    {   			return 6;}
			else	/// point 7
			if((mx >= x0 && mx <= x0+dimX)&&( my>=y2&& my <=y2+dimY))
		    { 				return 7;}
						else /// point 8
				if((mx >= x1&& mx <= x1+dimX)&&( my>=y2&& my <=y2+dimY))
		    { 					return 8;				}
			 else /// point 9
				if((mx >= x2&& mx <= x2+dimX)&&( my>=y2&& my <=y2+dimY))
		    {   					return 9;}
				else{		return 0;	}
	
}

public int which_card(int posi){
	for(int i= 0; i<3;i++){
		if (point(player1.card[i].point.x,player1.card[i].point.y)== posi){
			card_owner=player1.name;card_owner_click=player1.name;
			return i
			;} else
		if (point(player2.player.card[i].point.x,player2.player.card[i].point.y)== posi){
			card_owner=player2.player.name;
			card_owner_click= player2.player.name;
			return i;}
	}	 
	//card_owner_click= " ";
	card_owner="";
	return -1;
	 
}
}
