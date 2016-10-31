import java.io.*;

public class CHDOGS {
	public static void main(String args[]) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]= br.readLine().split(" ");
			double d = Double.parseDouble(s[0]);
			double v= Double.parseDouble(s[1]);
			
			System.out.println((2*d)/(v*3));
		}
		
	}
}
