package studio4;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Flag {
	public static void drawFlag(double[] position) {
		StdDraw.clear();
		StdDraw.setPenColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
		StdDraw.filledCircle(position[0], position[1], 0.3);
		StdDraw.setPenColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
		StdDraw.filledCircle(1-position[0], position[1], 0.3);
		StdDraw.setPenColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
		StdDraw.filledCircle(1-position[0], 1-position[1], 0.3);
		StdDraw.setPenColor((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
		StdDraw.filledCircle(position[0], 1- position[1], 0.3);
		StdDraw.show();
	}
	
	public static void updateFlag(boolean[] directions, double[] position, double distance) {
		if(directions[0]) {
			position[1] += distance;
		}
		else {
			position[1] -= distance;
		}
		if(directions[2]) {
			position[0] -= distance;
		}
		else {
			position[0] += distance;
		}
		if(position[1] >= 0.7) {
			directions[1] = true;
			directions[0] = false;
		}
		if(position[1] < 0.3) {
			directions[0] = true;
			directions[1] = false;
		}
		if(position[0] >= 0.7) {
			directions[2] = true;
			directions[3] = false;
		}
		if(position[0] < 0.3) {
			directions[3] = true;
			directions[2] = false;
		}
	}
	
	public static void main(String[] args) {
		boolean[] dir = new boolean[4];
		double[] pos = new double[2];
		pos[0] = 0.3;
		pos[1] = 0.5;
		int up = 0;
		int down = 1;
		int left = 2;
		int right = 3;
		dir[up] = true;
		dir[down] = false;
		dir[left] = true;
		dir[right] = false;
		while(true) {
			drawFlag(pos);
			updateFlag(dir, pos, 0.0005);
		}
	}
}