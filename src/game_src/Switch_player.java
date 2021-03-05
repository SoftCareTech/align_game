package game_src;

import javafx.scene.control.Label;

public class  Switch_player implements Runnable{
	Thread play;
	 
	Player player1,player2;
	 String msg2;
public	Switch_player(Player p1,Player p2,String msg){
		player1=p1;player2=p2;	
		msg2=msg;
		// Create a new, second thread
		play = new Thread(this, " switch_player");
		System.out.println("Child thread: " + play);
		play.start(); // Start the thread
	}
	public synchronized void st(){
	
		player1.play = true;
		if(player1.played){
			player1.played=false;
			
			player1.play =false;
			player2.play=true;
			
			//try {Thread.sleep(50);} catch(InterruptedException e) {}
				msg2="NEXT is "+player2.name;	
			}
		else
			if(player2.played){
				player2.played=false;
				player2.play =false;
				player1.play=true;
			//	try {Thread.sleep(50);} catch(InterruptedException e) {}
					msg2="NEXT is "+player1.name;	
				}
		while(player1.win==false && player2.win==false){
			
			if(player1.played){
				player1.played=false;
				System.out.println("here againt 11");
				player1.play =false;
				player2.play=true;
				
				//try {Thread.sleep(50);} catch(InterruptedException e) {}
					msg2="NEXT is "+player2.name;	
				}
			else
				if(player2.played){
					player2.played=false;
					player2.play =false;
					player1.play=true;
				//	try {Thread.sleep(50);} catch(InterruptedException e) {}
						msg2="NEXT is "+player1.name;	
					}
			//winer();
			try {Thread.sleep(100);} catch(InterruptedException e) {}
				
			}
		if (player1.win==true)msg2=player1.name+" have won ";
		if (player2.win==true)msg2=player2.name+" have won ";
		player2.play =false;
		player1.play =false;
		try {Thread.sleep(100);} catch(InterruptedException e) {}
		msg2=msg2+"  game over ";
		return;
		}
	

		
	public void run() {
		try {
			
		Thread.sleep(500);
		
		} catch(InterruptedException e) {}
		
			try {
				st();
			Thread.sleep(50);
			System.out.println("the end of of swap ");
			} catch(InterruptedException e) {}
			
			try {
				this.play.join();
			 } catch (InterruptedException e) {
				e.printStackTrace();
			 }
			
			System.out.println("the end of player swap thread ");	
	}
	

void winer(){
	int posi =5,cc ,s1=0,s2=0;
	
	for(int i= 0; i<3;i++){
		if (player1.card[i].posi== posi){
			cc=i;
			if(cc==0){ s1=1;s2=2;}
			if(cc==1){s1=0;s2=2;}
			if(cc==2){s1=0;s2=1;}
			if ( player1.side_correct(player1.card[s1].posi,player1.card[s2].posi)) {player1.win=true;}
		}else
		if (player2.card[i].posi== posi){
			cc=i;
			if(cc==0){ s1=1;s2=2;}
			if(cc==1){s1=0;s2=2;}
			if(cc==2){s1=0;s2=1;}
			if ( player2.side_correct(player2.card[s1].posi,player2.card[s2].posi)) {player2.win=true;}
		}
		}
}

	}
