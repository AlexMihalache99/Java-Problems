import java.io.*;
import java.util.*;

/**
 * 
 * A drone starts from (0,0) position in a matrix and goes to (n-1,m-1) position.
 * The drone can go just down or right. Get the minimum value of every path 
 * that goes from (0,0) to (n-1, m-1) and then find the maximum of those values.
 * Example : 5 4
                3 5 1 9
                4 5 10 5
                9 3 1 2
                6 8 4 7
                4 5 1 2
         Result : 4 
         Explanation: 3-> 4 -> 9 -> 6 -> 8 -> 4 -> 7 -> 2     
 * */
public class Drone {

	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner in = null;
		File file = null;
		int rows = -1;
		int columns = -1;
		int matrix [][] = null;
		
		try {
		 file = new File("data.txt");
		 
		 in = new Scanner (file);
		 
		  rows = in.nextInt();
		  columns = in.nextInt();
		  matrix = new int [rows][columns]; 
		 
		 for (int i = 0; i < rows; i++) {
		  for(int j = 0; j < columns; j++) {
			  matrix[i][j] = in.nextInt();
		  }
		 }
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int solution [] [] = new int[rows][columns];
		
		solution[0][0] = matrix[0][0];
		solution[0][1] = matrix[0][1];
		solution[1][0] = matrix[1][0];
		
		for(int i = 2 ; i < columns; i++) {
			solution[0][i] = Math.min( solution[0][i-1], matrix[0][i]);
		}
		
		for(int i = 2 ; i < rows; i++) {
			solution[i][0] = Math.min( solution[i-1][0], matrix[i][0]);
		}
		
		for(int i = 1; i < rows;i++) {
			for(int j = 1; j < columns; j++) {
				
				  if(i == rows -1 && j == columns -1) {
					  solution[i][j] = Math.max(solution[i-1][j],solution[i][j-1]);
				  }else{
					  solution[i][j] = Math.min( Math.max(solution[i-1][j],solution[i][j-1]), matrix[i][j]);
				  }

			}
		}
		
		System.out.print(solution[rows-1][columns -1]);

		
		
	}

}















