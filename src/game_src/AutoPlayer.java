package game_src;

import java.util.Random;

public class AutoPlayer {
	Random r=new Random();
	 boolean cade_a[]= new boolean[3];
	 boolean cade_free[]= new boolean[9];
	 public Player player;
	 Player playMate;
	 
public AutoPlayer(Player playMate){//contructor  
		 player= new Player("Computer");
		 this.playMate=playMate;
		 cade_a[0]= true; cade_a[1]= true; cade_a[2]= true;
		 cade_free[0]= true; cade_free[1]= true; cade_free[2]= 
	true;cade_free[3]= true; cade_free[4]= true; cade_free[5]= true;
	cade_free[6]= true; cade_free[7]= true; cade_free[8]= true;
		 }
	 
	//boolean player.card exist on  give position ?
	 boolean card_exi(int posi){
		for(int i= 0; i<3;i++){
		if (player.card[i].posi== posi){
			return true;}//yes my player.card
		if (playMate.card[i].posi== posi){
			return true;}// yes opposite player player.card 				
			}		
			return false;//no body player.card
		}
	 
	 
	// boolean  parrallel wining side
	 boolean side_correct(int s1,int s2){
			if(s1==1&&s2==9)return true;
			if(s1==2&&s2==8)return true;
			if(s1==3&&s2==7)return true;
			if(s1==4&&s2==6)return true;
			//if(s1==5||s2==5)return true;//   center  not needed
			if(s1==6&&s2==4)return true;
			if(s1==7&&s2==3)return true;
			if(s1==8&&s2==2)return true;
			if(s1==9&&s2==1)return true;
		return false;	
		}
	 
	 
	
	 // player.card cannot move except center
	 boolean card_block(int posi){ 
		 boolean result=false;
		if(posi==1) {
			if (card_exi(4 )&& card_exi(2 )){
				result= true;}}
		if(posi==2){
			if (card_exi( 1)&& card_exi( 3)){
				result= true;}}
		if(posi==3){
			if (card_exi( 2)&& card_exi( 6)){			
			result= true;}}
		if(posi==4){if (card_exi( 1)&& card_exi(7 )){			
			result= true;}
		}
		if(posi==5){
		result= false;}
		if(posi==6){if (card_exi(3 )&& card_exi( 9)){			
		result = true;}
		}
		if(posi==7){ if (card_exi(4 )&& card_exi(8 )){
		result= true;}
		}
		if(posi==8){if (card_exi( 7)&& card_exi( 9)){
		result= true;}
		}
		if(posi==9){if (card_exi(6 )&& card_exi(8 )){
		result= true;}
		}
		if(posi==0){
		result=false;}
		
		if(result==false)
		System.out.println(" side_block return false ");
		return result; 	
	}
	 
	 //computer player.card that cannot move except center 
	int get_blocked_card(){
		if(r.nextBoolean()){////random to start both side of the loop
		for(int h =0;h<3;h++){
			if (card_block(player.card[h].posi))
				return h;
			
		}
	}else {for(int h =2;h>=0;h--){
		if (card_block(player.card[h].posi))
			return h;
		
	}}
		return -1;///return -1 when player.card is not block
	}
	 



//when the side player is at center  or side_correct
	 boolean block_time(){	
			for(int i= 0; i<3;i++){
				if (playMate.card[i].posi== 5)return true;
				}
					if (side_correct(playMate.card[0].posi,playMate.card[1].posi))return true;
					if (side_correct(playMate.card[0].posi,playMate.card[2].posi))return true;
					if (side_correct(playMate.card[1].posi,playMate.card[2].posi))return true;
		 return false;
	 }
	////side correct for a player  
	 boolean block_time_goCenter(){	
					if (side_correct(playMate.card[0].posi,playMate.card[1].posi))return true;
					if (side_correct(playMate.card[0].posi,playMate.card[2].posi))return true;
					if (side_correct(playMate.card[1].posi,playMate.card[2].posi))return true;
		 return false;
	 }
	 
	 int win_time(){	
			for(int i= 0; i<3;i++){
				if (player.card[i].posi== 5)return 5;
				}
				if (side_correct(player.card[0].posi,player.card[1].posi))return 2;
				if (side_correct(player.card[0].posi,player.card[2].posi))return 1;
				if (side_correct(player.card[1].posi,player.card[2].posi))return 0;
		 return -1;
	 }
	void wining(){
int s1=0,s2=0;
		if (win_time()==2&&!card_exi(5)){  
			player.card[2].piority=9;
			player.card[2].tar=5;
		}else
		if (win_time()==1&&!card_exi(5)){
			player.card[1].piority=9;
			player.card[1].tar=5;
		}else
		if (win_time()==0&&!card_exi(5)){
			player.card[0].piority=9;
			player.card[0].tar=5;
		}else
			if(win_time()==5){///searching in center
				int cc1=-1;
				for (int i=0;i<3;i++){
				if (player.card[i].posi==5){////finding the player.card in the center
					cc1=i; break;
				}
				}
				if(cc1==0){ s1=1;s2=2;}
				if(cc1==1){s1=0;s2=2;}
				if(cc1==2){s1=0;s2=1;}	
				if (cc1>-1)
				{for (int p=1;p<10; p++){
					if(side_correct(player.card[s1].posi,p)){
						if(!card_exi(p)){
							for (int v=0;v<3;v++){
								if (player.card[v].correct_target(player.card[v].posi,p)&&player.card[v].posi!=5){
									player.card[v].piority=9;
										player.card[v].tar=p;
										System.out.println(" player.card "+v);
										}
							}
							}}
					if(side_correct(player.card[s2].posi,p)){
						if(!card_exi(p)){
							for (int v=0;v<3;v++){
								if (player.card[v].correct_target(player.card[v].posi,p)&&player.card[v].posi!=5){
									player.card[v].piority=9;
										player.card[v].tar=p;
										System.out.println(" RAPH-RAY 2");
										}}
							}}
					}}}
		}
	void blocking(){
	///block_time() polarity ==7
		int s1=0,s2=0;
		if(block_time()){
			if(!card_exi(5)){
			  int c=	get_blocked_card();
		     	if (c>-1){
				player.card[c].piority=7;
				player.card[c].tar=5;
				}	else {  System.out.println("noting here yet ");   }
			}else{
			  int cc=-1;
			 for (int i=0;i<3;i++){
			   if (playMate.card[i].posi==5)cc=i;}
			 
			if (cc>-1){for (int p=1;p<10; p++){
				if(cc==0){ s1=1;s2=2;}
				if(cc==1){s1=0;s2=2;}
				if(cc==2){s1=0;s2=1;}
				if(side_correct(playMate.card[s1].posi,p)){
					if(!card_exi(p)){
						for (int v=0;v<3;v++){
							if (player.card[v].correct_target(player.card[v].posi,p)){
								player.card[v].piority=7;
									player.card[v].tar=p;
									break;
									}
						}}  
					}
				if(side_correct(playMate.card[s2].posi,p)){
					if(!card_exi(p)){
						for (int v=0;v<3;v++){
							if (player.card[v].correct_target(player.card[v].posi,p)){
								player.card[v].piority=7;
									player.card[v].tar=p;
									break;
									}
						}}
					}
				}}}}//end  of blocked_time
		
		
	}
	 
	boolean opponate_opposite(int c){
		for (int i=0;i<3;i++){
		if (player.side_correct(player.card[c].posi,playMate.card[i].posi))return true;
		}
		return false;
	}
	
	void wise_play1(){
		if (block_time_goCenter())
		////set th random here too
			if(!card_exi(5)){
				int c=get_blocked_card();
				if(c>=0&&c<=2){
					player.card[c].posi=5;
					player.card[c].piority=7;	
				}else{
			for(int i=0;i<3;i++){
				
				if (player.card[i].posi!=5){
					player.card[i].posi=5;
				player.card[i].piority=7;
				}
			}}}
	}
	void wise_play2(){
	if(card_block(player.card[0].posi)&& card_block(player.card[1].posi)){
		set_target(2);
	player.card[2].piority=6;
	}else
	if( card_block(player.card[1].posi)&& card_block(player.card[2].posi)){
		set_target(0);
		player.card[0].piority=6;
		
	}else
	if(card_block(player.card[0].posi)&&card_block(player.card[2].posi)){
		set_target(1);
		player.card[1].piority=6;
	}
	}
	
	void wise_play3(){
	/* if player.card is block and two player.card are opposit of 
	 * an openate then remove center to opposite of 
	 * opponate
	 */
		
		int cc1=-1;
		for (int i=0;i<3;i++){
		if (player.card[i].posi==5)cc1=i;
		}
		if(cc1>-1){
			int s1,s2;
			if(cc1==0){ 
				s1=1;s2=2;
			if(opponate_opposite(s1)&&opponate_opposite(s2)){
				set_target(0);
				player.card[0].piority=8;	
			}
			}
			if(cc1==1){
				s1=0;s2=2;
if(opponate_opposite(s1)&&opponate_opposite(s2)){
	set_target(1);
	player.card[1].piority=8;	
			}}
			if(cc1==2){
				s1=0;s2=1;
if(opponate_opposite(s1)&&opponate_opposite(s2)){
	set_target(2);
	player.card[2].piority=8;
			}}	
			
		}
		}
		
	
	 private void moveOnBoorad() {
		 int jik = -1;
			for(int b=0;b<3;b++){
				if(player.card[b].posi==0)jik=b;
					}
			if(jik>-1){
			if(!card_exi(5)){
				player.card[jik].tar=5;
				player.card[jik].piority=8;
			}else
				
			for(int p=1;p<10;p++){
				if(!card_exi(p)){
					player.card[jik].tar=p;
					player.card[jik].piority=8;}}
			
			}
	
}
	
void	 set_piority(){
	//reset piority
	for(int i =0;i<3;i++){
		player.card[i].piority=0;
	}
	//just set move positon as posible 
		for(int i=0;i<3;i++){
			set_target(i);
		}
		
	///card_block then remove center
		 wise_play2();
		 
		 ///enter center if  the person allign striaght
		 wise_play1();
	//remove center when possible freezing is detected
		 //wise_play3();
	///if not finish initialis or move cards on board before playing the onces on board 
			moveOnBoorad();
			blocking();
			wining();
	}
	

	void  set_target(int c){
		if(r.nextBoolean()){
		for(int t=1;t<10;t++){//random
			if (!card_exi(t))
		         if(player.card[c].correct_target(player.card[c].posi, t)){
		        	 player.card[c].piority=1;
		        	 player.card[c].tar=t;
		        	 return;
		         }
		}
		
		}else{
			for(int t=9;t>0;t--){//random
				if (!card_exi(t))
			         if(player.card[c].correct_target(player.card[c].posi, t)){
			        	 player.card[c].piority=1;
			        	 player.card[c].tar=t;
			        	 return;
			         }
			}
		}
		
		 
	 }

	void update_free(){ //set target for all player.card that are free 
		 for (int c=0;c<3;c++){
			 set_target(c) ;
		 }
	 }
	 
	 int h_p(){
		 for(int h=9;h>-1;h--)
		 for(int i =0;i<3;i++){
			if( player.card[i].piority==h){
				return i;
			}
		 }
		 return -1;
	 }
	
private int	com_which_card_move(){
	update_free();
	set_piority();
	int h=h_p();
	return h;
}
	
public	void  com_move(int x0,int y0,int x2,int y2 ){
	int c= com_which_card_move( );
	int des =0;
	if(c>-1 ){
		des= player.card[c].tar;
		player .card[c].move(c, des ,x0,y0,x2,y2);
	 player.card[c].draw();}
	else 
		System.out.println("error in  void	moved()");
		}

}