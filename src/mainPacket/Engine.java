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

				int neighbours = 0;

				for(int pop = -1; pop < 2; ++ pop){

					for(int opo = -1; opo < 2 ; ++ opo){
						System.out.println("XD");
						if(map[op-pop][po-opo])
							++neighbours;

						if(map[op][po]){

							if(neighbours == 2 || neighbours == 3)
								updatedMap[op][po] = true;
							else
								updatedMap[op][po] = false;

						}else{

							if(neighbours == 3)
								updatedMap[op][po] = true;

						}

					}

				}

			}
		}

	}



}
