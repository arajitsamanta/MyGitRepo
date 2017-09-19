/**
 * 
 */
package com.arajit.crack.code.ch08.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author as47775
 * 
 * Problem
 * =======
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move in two directions, right and down, but certain cells 
 * are "off limits" such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.
 * 
 * Solution
 * ========
 * If we picture this grid, the only way to move to spot ( r, c) is by moving to one of the adjacent spots:
 * ( r -1, c) or ( r, c -1). So, we need to find a path to either ( r-1, c) or ( r, c -1).
 * How do we find a path to those spots? To find a path to ( r-1, c) or ( r, c -1), we need to move to one of its adjacent cells. So, we need to find a path to a spot 
 * adjacent to ( r-1, c), which are coordinates ( r- 2, c) and ( r-1, c -1). or a spot adjacent to ( r, c -1). which are spot ( r- 1, c -1) and ( r, c -2).
 *
 */
public class RobotInAGrid {

	ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
			return path;
		}
		return null;
	}

	boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		System.out.println(row+" "+col);
		/* If out of bounds or not available, return. */
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (col == 0);
		System.out.println("isAtOrigin: "+isAtOrigin);

		/* If there's a path from the start to here, add my location. */
		if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}

		return false;
	}
	
	ArrayList<Point> getPathMemorization(boolean[][] maze) {
		if (maze == null || maze.length == 0)
			return null;
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		if (getPathMemorization(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
			return path;
		}
		return null;
	}
	
	boolean getPathMemorization(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
		/* If out of bounds or not available, return. */
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}

		Point p = new Point(row, col);

		/* If we've already visited this cell, return. */
		if (failedPoints.contains(p)) {
			return false;
		}

		boolean isAtOrigin = (row == 0) && (col == 0);

		/*
		 * If there's a path from start to my current loc ation, add my
		 * location.
		 */
		if (isAtOrigin || getPathMemorization(maze, row, col - 1, path, failedPoints)	|| getPathMemorization(maze, row - 1, col, path, failedPoints)) {
			path.add(p);
			return true;
		}

		failedPoints.add(p); // Cache result
		return false;
	}
	
	public static void main(String[] args) {
		boolean[][] maze={
				{true,false,true},
				{true,false,true},
				{true,false,true}
		};
		
		RobotInAGrid path=new RobotInAGrid();
		List<Point> paths=path.getPath(maze);
		if(null!=paths && paths.size()>0){
			paths.forEach(point -> {
				System.out.println(point.toString());
			});
		}else{
			System.out.println("no paths");
		}
		
		
	}
}

class Point{
	
	int row;
	int col;
	Point(int row,int col){
		this.row=row;
		this.col=col;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}