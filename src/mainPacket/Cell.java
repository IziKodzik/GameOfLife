package mainPacket;

import javax.swing.*;
import java.awt.*;

public class Cell
	extends JButton {

	boolean alive;
	int x,y;

	public Cell(int x, int y){
		super();
		this.x = x;
		this.y = y;

	}

	public void remote(){

		alive = !alive;
		if(alive)
			setBackground(new Color(100, 0, 255));
		else
			setBackground(new JButton().getBackground());
	}
	public void kill(){

		alive = false;
		setBackground(new JButton().getBackground());
	}
	public void rescue(){
		alive = true;
		setBackground(new Color(100, 0, 255));
	}


}
