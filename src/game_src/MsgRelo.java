package game_src;

public interface MsgRelo {
	public void onRelocate(boolean visibility, double h_pointx, double h_pointy, double h_dimX, double h_dimY);
	
	void onRelocate(double h_pointx, double h_pointy, double h_dimX, double h_dimY);
	
	void onRelocate(boolean visibility);
	
	public void center_msg(String msg);
	
	public void down_msg(String msg);
	
}
