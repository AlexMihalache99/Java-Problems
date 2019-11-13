import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Find a subset of a set with the maximum sum and a minimum length of k. 
 * Give the start and last index of the set and the maximum sum.
 *  
 * */
  
 
  public class Main {
    
	    public static int n = 0;
		public static int k = 0;
		public static int bufferSize = 8*1024;
		public static int [] sum = new int [50000];
		public static int s = 0; 
		public static int max = 0;
		public static int startIndex = 1;
		public static int lastIndex = 0;
		public static int auxIndex =1;
	
		public static void main(String[] args) throws IOException {
		
		
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			
			fr = new FileReader("secv2.in");
		    br = new BufferedReader(fr, bufferSize);
		    
		    String line = br.readLine();
		    String [] lines = line.split(" ");
		    
		    n = Integer.parseInt(lines[0]);
		    k = Integer.parseInt(lines[1]);
		    
		    line = br.readLine();
		    lines = line.split(" ");
		    sum[1] = Integer.parseInt(lines[0]);
		    
		    for(int i = 2 ;i <= k; i++) {
		    	sum[i] = sum[i-1] + Integer.parseInt(lines[i-1]);
		    }
		    s=max=sum[k];
		    lastIndex = k;
		    
		    
		    for(int i = k+1;i <= n; i++) {
		    	
		    	sum[i] = sum[i-1] + Integer.parseInt(lines[i-1]);
		    	
		    	if(sum[i] - sum[i-k] > s + Integer.parseInt(lines[i-1])) {
		    		
		    		s = sum[i] - sum [i-k];
		    		auxIndex = i - k + 1;
		    	
		    	}else {
		    		
		    		s+=Integer.parseInt(lines[i-1]);
		    	}
		    	
		    	if(s > max) {
		    		
		    		max = s;
		    		startIndex = auxIndex;
		    		lastIndex = i;
		    	
		    	}
		    }
		    
		    PrintWriter writer = new PrintWriter("secv2.out");
		    
		    writer.print(startIndex+" "+lastIndex+" "+max);
		    writer.close();
		    
		    
		    
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
