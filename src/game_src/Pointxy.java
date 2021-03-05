package game_src;
public class Pointxy{
	public int x,y ;
	public Pointxy(){ }
	
public	void setxy(int a,int b){
	
		x=a;
		y=b;
	} 
	void  point(int posi,int sx,int sy,int ex, int ey){
	switch(posi){
		case 1:this.x=sx;this.y=sy;
		break;	
		case 2:this.x= (sx+ex)/2;this.y =sy  ;
		break;
		case 3: this.x= ex ;this.y = sy ;
		break;
		case 4:this.x= sx ;this.y =(sy+ey)/2  ;
		break;
		case 5:this.x= (sx+ex)/2 ;this.y =(sy+ey)/2   ;
		break;
		case 6:this.x=ex; this.y =(sy+ey)/2   ;
		break;
		case 7:this.x= sx; this.y = ey  ;
		break;
		case 8:this.x= (sx+ex)/2; this.y = ey ;
		break;
		case 9:this.x=ex; this.y =ey ;
		break;
		
		
		}
	
	}
	
	
}