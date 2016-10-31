import java.io.*;
import java.math.*;
public class UJ {
	public static void main(String aargs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		while(true){
			String s[]= br .readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int cd = Integer.parseInt(s[1]);		
			if(n==0 && cd==0){
				return;
			}
			pw.println(new BigInteger(""+n).pow(cd));
			pw.flush();
		}	
	}
}
