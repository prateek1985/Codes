import java.io.*;
public class Beru_taxi {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String c[]=br.readLine().split(" ");
		int x1=Integer.parseInt(c[0]);
		int y1=Integer.parseInt(c[1]);
		int n =Integer.parseInt(br.readLine());
		double min = Double.MAX_VALUE;
		for(int r=0;r<n;r++){
			String s[]=br.readLine().split(" ");
			int x = Integer.parseInt(s[0]) - x1;
			int y = Integer.parseInt(s[1]) - y1;
			
			int xz = (x*x)+(y*y);
			double d = Math.sqrt(xz);
			if(min > d/Integer.parseInt(s[2]))
				min = d/Integer.parseInt(s[2]);
		}
	System.out.println(min);
	}
}
