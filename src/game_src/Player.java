package game_src;

import java.util.Random;

public class Player {
	
	 public boolean win = false;
	 public String name;
	 public  boolean play=false;
	 public  boolean played=false;
	 public Card card[] = new Card[3];
	 public Card op_card[] = new Card[3];
	public Player(String s){
		name=s;
	card[0] = new Card(this,20);
	card[1] = new Card(this,20);
	card[2] = new Card(this,20);
	
	 }

public boolean side_correct(int s1,int s2){
	if(s1==1&&s2==9)return true;
	if(s1==2&&s2==8)return true;
	if(s1==3&&s2==7)return true;
	if(s1==4&&s2==6)return true;
	//if(s1==5&&s2==9)return true;
	if(s1==6&&s2==4)return true;
	if(s1==7&&s2==3)return true;
	if(s1==8&&s2==2)return true;
	if(s1==9&&s2==1)return true;
return false;	
}	
}


