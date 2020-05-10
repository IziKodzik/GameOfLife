package mainPacket;

import javax.swing.*;

public class Engine {

	boolean[][] map;

	public Engine(int height, int width){

		map = new boolean[height][width];

	}

	public void remote(int x,int y){
		map[x][y] = !map[x][y];

	}

}
