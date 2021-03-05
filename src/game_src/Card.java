package game_src;

import gui.FxDrawer;
import javafx.scene.shape.Circle;

public class	Card  {
	public Pointxy point	;
	int piority=0;
	int tar=0;
	public  FxDrawer c;
	public int posi=0;
	Player player;
	
	
	Card(Player player, double size ){ point = new Pointxy();
	c= new FxDrawer(size, point);
	this.player=player;

}
	




public void draw(){	
	c.draw(point); 
	
}
	boolean correct_target(int posi ,int target){
			boolean result=false;
		if(posi==1) {
			if (target==2 ||target==5 ||target==4){
				result= true;}}
		if(posi==2){
			if (target==1 ||target==5||target==3){
				result= true;}}
		if(posi==3){
			if (target== 2||target==5||target==6){			
			result= true;}}
		if(posi==4){if (target== 1||target==5||target==7){			
			result= true;}
		}
		if(posi==5){
		result= true;
		System.out.println(result+"  correct target");}
		if(posi==6){if (target== 3||target==5||target==9){			
		result = true;}
		}
		if(posi==7){ if (target== 4||target==5||target==8){
		result= true;}
		}
		if(posi==8){if (target== 7||target==5||target==9){
		result= true;}
		}
		if(posi==9){if (target== 6||target==5||target==8){
		result= true;}
		}
		if(posi==0){
		result=true;}
		System.out.println(result+"  correct target");
		if(result==false)
		System.out.println(" not correct target");
		return result; }
	
	public String move(int n,int target,int sx,int sy,int ex, int ey){
		if(player.play){
		if(correct_target(player.card[n].posi,target)){
		
			
		if(target>0&&n>-1){	
			Pointxy target_p = new Pointxy();
		    target_p.point( target,sx,sy,ex,ey);
		    player.card[n].point.x =target_p.x;
		    player.card[n].point.y=target_p.y;
		    player.card[n].posi= target;
		   player.played=true;
		    return "YOU HAVE PLAYED "+player.name;
		    }
		
		}
		else
			return "WRONG TARGET "+player.name+" ...TRY AGAIN...";}
		else
			return "NOT  YOUR TURN "+player.name;
		return " Replay  ";
			
		}
	
	
	public String move(int n,int target,int sx,int sy,int ex, int ey, boolean no_conditon){
			Pointxy target_p = new Pointxy();
		    target_p.point( target,sx,sy,ex,ey);
		    if(target>0){
		    player.card[n].point.x =target_p.x;
		    player.card[n].point.y=target_p.y;
		    player.card[n].posi= target;}
		return " Resize done  ";
			
		}
	
	
	public void moving( int n, int  x,int y){
		player.card[n].point.x =x;
		player.card[n].point.y=y;
		}
	 	 
	}	 	 

