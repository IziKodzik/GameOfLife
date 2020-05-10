package mainPacket;

import javax.swing.*;
import java.awt.*;

public class GUI {

	public static JFrame createGUI(int height,int width){

		JFrame result = new JFrame();
		Engine engine = new Engine(height,width);
		result.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		result.getContentPane().setLayout(new FlowLayout());
		Cell[][] cells = new Cell[height][width];
		JPanel container = new JPanel(new GridLayout(height,width));

		for(int op = 0 ; op < height; ++ op){
			for(int po = 0 ; po < width ; ++ po){

				Cell button = new Cell(op,po);
				button.setPreferredSize(new Dimension(10,10));
				button.addActionListener( (event) ->{

					button.alive = !button.alive;
					if(button.alive)
						button.setBackground(Color.GREEN);
					else
						button.setBackground(Color.WHITE);
					engine.remote(button.x,button.y);

				});
				cells[op][po] = button;
				container.add(button);


			}
		}

		result.getContentPane().add(container);
		result.getContentPane().add(new JButton("JD"));
		result.pack();

		result.setVisible(true);

		return result;

	}

}

