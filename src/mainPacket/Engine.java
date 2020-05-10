package mainPacket;

import javax.swing.*;
import java.util.Arrays;

public class Engine {

	boolean[][] map;

	public Engine(int height, int width){

		map = new boolean[height][width];

	}

	public void remote(int x,int y){
		map[x][y] = !map[x][y];
	}
	public void step(Cell[][] cells){
		boolean[][] updatedMap = new boolean[map.length][map[0].length];

		for(int op = 0 ; op < map.length ; ++ op){
			for(int po = 0 ; po < map[op].length ; ++ po){

				int neighbours = countNeighbours(cells[op][po]);
				System.out.print(neighbours + " ");

				if(map[op][po]){

					if(neighbours >)

				}

			}
			System.out.println();
		}

	}

	private int countNeighbours(Cell cell){

		int result = 0;
			for (int op = -1; op < 2; ++op) {
				for (int po = -1; po < 2; ++po) {

					try {
						if (map[cell.x + op][cell.y + po] && !(op == 0  && po == 0))
							++result;
					}catch (IndexOutOfBoundsException ignore){}

				}
			}
		return result;
	}



}
