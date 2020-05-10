package mainPacket;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {

	static volatile boolean running;

	public static JFrame createGUI(int height,int width,int cellSize){

		GraphicsDevice screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int sWidth = screen.getDisplayMode().getWidth();
		int sHeight = screen.getDisplayMode().getHeight() - 100;

		if(height*cellSize > sHeight)
			height = sHeight/cellSize;

		if(width*cellSize > sWidth)
			width = sWidth/cellSize;



		JFrame result = new JFrame();
		Engine engine = new Engine(height,width);
		result.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		result.getContentPane().setLayout(new FlowLayout());
		result.getContentPane().setBackground(new Color(75,75,75));
		JPanel root = new JPanel();
		root.setBackground(new Color(75,75,75));
		root.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(5,0,5,0);

		result.getContentPane().add(root);

		Cell[][] cells = new Cell[height][width];
		JPanel mapContainer = new JPanel(new GridLayout(height,width));

		for(int op = 0 ; op < height; ++ op){
			for(int po = 0 ; po < width ; ++ po){

				Cell button = new Cell(op,po);
				button.setPreferredSize(new Dimension(cellSize,cellSize));
				button.addActionListener( (event) ->{

					button.remote();
					engine.remote(button.x,button.y);

				});
				cells[op][po] = button;
				mapContainer.add(button);


			}
		}

		new Thread( ()->{

			while(true) {
				while (!running) ;
				for (; GUI.running; ) {

					engine.step(cells);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}

		}).start();

		constraints.anchor = GridBagConstraints.PAGE_START;
		root.add(mapContainer,constraints);

		constraints.gridy =1;
		constraints.anchor = GridBagConstraints.PAGE_END;
		JButton stepButton = new JButton("STEP");
		stepButton.addActionListener(event -> {

			engine.step(cells);

		});
		root.add(stepButton,constraints);

		JLabel runningLabel = new JLabel(" NOT RUNNING ");
		runningLabel.setOpaque(true);

		runningLabel.setBackground(Color.RED);

		JButton toggleButton = new JButton("TOGGLE RUNNING");
		toggleButton.addActionListener(( event)->{
			running = !running;
			if(running) {
				runningLabel.setText("      RUNNING      ");
				runningLabel.setBackground(Color.GREEN);
			}else {
				runningLabel.setText(" NOT RUNNING " );
				runningLabel.setBackground(Color.RED);
			}
		});


		JPanel panel = new JPanel();
		panel.setBackground(new Color(75,75,75));
		panel.setLayout( new FlowLayout());
		panel.add(toggleButton);
		panel.add(runningLabel);

		constraints.gridy = 2;
		root.add(panel,constraints);


		result.setMinimumSize(new Dimension(320,240));
		result.pack();

		result.setVisible(true);

		return result;

	}



}

