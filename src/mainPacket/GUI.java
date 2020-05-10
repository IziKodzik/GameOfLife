package mainPacket;

import javax.swing.*;
import java.awt.*;

public class GUI {

	public static JFrame createGUI(int height,int width){

		JFrame result = new JFrame();
		Engine engine = new Engine(height,width);
		result.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		result.getContentPane().setLayout(new FlowLayout());
		result.getContentPane().setBackground(new Color(75,75,75));
		JPanel root = new JPanel();
		root.setBackground(new Color(75,75,75));
		root.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.insets = new Insets(5,0,5,0);

		result.getContentPane().add(root);

		Cell[][] cells = new Cell[height][width];
		JPanel mapContainer = new JPanel(new GridLayout(height,width));

		for(int op = 0 ; op < height; ++ op){
			for(int po = 0 ; po < width ; ++ po){

				Cell button = new Cell(op,po);
				button.setPreferredSize(new Dimension(30,30));
				button.addActionListener( (event) ->{

					button.alive = !button.alive;
					if(button.alive)
						button.setBackground(new Color(100, 0, 255));
					else
						button.setBackground(new JButton().getBackground());
					engine.remote(button.x,button.y);

				});
				cells[op][po] = button;
				mapContainer.add(button);


			}
		}


		constraints.anchor = GridBagConstraints.PAGE_START;
		root.add(mapContainer,constraints);

		constraints.gridy =1;
		constraints.anchor = GridBagConstraints.PAGE_END;
		JButton stepButton = new JButton("STEP");
		stepButton.addActionListener(event -> {

			engine.step(cells);

		});
		root.add(stepButton,constraints);

		result.setMinimumSize(new Dimension(320,240));
		result.pack();

		result.setVisible(true);

		return result;

	}

}

