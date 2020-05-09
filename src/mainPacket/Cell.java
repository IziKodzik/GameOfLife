package mainPacket;

import javax.swing.*;
import java.awt.*;

public class Cell
	extends JButton {

	boolean alive;

	public Cell(){
		super();
		addActionListener( (event) ->{

			alive = !alive;
			if(alive)
				setBackground(Color.GREEN);
			else
				setBackground(Color.WHITE);

		});

	}

}
