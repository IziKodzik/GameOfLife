package mainPacket;

import javax.swing.*;
import java.awt.*;

public class GUI {

	public static JFrame createGUI(int height,int weight){

		JFrame result = new JFrame();
		result.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		result.getContentPane().setLayout(new FlowLayout());

		JPanel container = new JPanel(new GridLayout(height,weight));

		for(int op = 0 ; op < height; ++ op){
			for(int po = 0 ; po < weight ; ++ po){

				JButton button = new JButton();
				button.setPreferredSize(new Dimension(10,10));
				button.addActionListener(e -> {

					button.setBackground(Color.RED);

				});
				container.add(button);
			}
		}

		result.getContentPane().add(container);
		result.pack();

		result.setVisible(true);



		return result;

	}

}

