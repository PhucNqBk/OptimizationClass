import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;
public class CovidQuarantine {
	 private final static String FILE_URL = "/home/tamvo/IdeaProjects/Hackerrank/src/com/company/data.txt";
	 	
		 int N;
		 int M;
		 int[] s = new int[1005];
		 int[] c = new int[1005];
	 	public void ReadFile(String path_) {
	 		// doc du lieu tu file
	 		// Input:
	 		//Dong dau chua 2 so nguyen N, M
	 		//Dong thu 2 chua N so nguyen la so luong nguoi s cua moi doan khach
	 		// Dong thu 3 chua M so nguyen la gioi han c nguoi cua khu cach ly
	 		// Ham doc file doc tu 1.
	 		Scanner sc;
			try {
				sc = new Scanner(new File(path_));
				 N = sc.nextInt();
		
			     M = sc. nextInt();
			     
			     System.out.println(N);
			     System.out.println(M);
			     
			       for(int i = 1; i <= N; i++) {
			    	   s[i] = sc.nextInt();
			    	  // System.out.println(i+" : " +s[i]);
			       }
			       for(int i = 1; i <= M; i++) {
			    	   c[i] = sc.nextInt();
			    	   //System.out.println(i+" : " +c[i]);
			       }	 
			       //System.out.println("Reading Complete!");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 		
	 	}
	 	
	 	public void WriteFile(String path_) {
	 		try {
	 		      FileWriter myWriter = new FileWriter(path_);
	 		      myWriter.write(N +" " + M + System.getProperty( "line.separator") );	 	
	 		      for(int i = 0; i < N; i++) {
	 		    	 myWriter.write(s[i] + " ");
	 		      }
	 		     myWriter.write(System.getProperty( "line.separator"));	
	 		    for(int i = 0; i < M; i++) {
	 		    	 myWriter.write(c[i] + " ");
	 		      }
	 		      myWriter.close();
	 		      System.out.println("Successfully wrote to the file.");
	 		    } catch (IOException e) {
	 		      System.out.println("An error occurred.");
	 		      e.printStackTrace();
	 		    }
	 	}
	 	public void Generate(int n, int m, int mins, int maxs, int minc, int maxc) {
	 		this.N = n;
	 		this.M = m;
	 		Random ran = new Random();
	 		
	 		for(int i = 0; i < N; i++) {
	 			s[i] = ran.nextInt(maxs - mins) + mins;
	 		}
	 		
	 		for(int i = 0; i < M; i++) {
	 			c[i] = ran.nextInt(maxc - minc) + minc;
	 		}
	 	}
	    public static void main(String[] args) {
	     // String path = "C:\\Users\\Fourier_Sp\\Downloads\\Compressed\\Input.txt";
	      String oup = "C:\\Users\\Fourier_Sp\\Downloads\\Compressed\\Output.txt";
	      CovidQuarantine app = new CovidQuarantine();
	      //app.ReadFile(oup);
	      app.Generate(1000,750, 10, 200, 90, 700);
	      app.WriteFile(oup);
	    }

}
