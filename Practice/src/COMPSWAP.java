import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class COMPSWAP {
	
	static String s[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			int n = Integer.parseInt(br.readLine().trim());
			s=br.readLine().split(" ");
			
		
			int c=Integer.MAX_VALUE;
			int count=0;
			for(int i=0;i<n;i++){
				if(Integer.parseInt(s[i]) < c){
					c = Integer.parseInt(s[i]);
					count++;
				}
			}
			
		//	System.out.println(com+" "+sw);
			pw.println(n-count);
			pw.flush();
		}		
	}

}
