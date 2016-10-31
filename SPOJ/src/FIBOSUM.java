import java.io.*;
import java.math.BigInteger;
public class FIBOSUM {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		long fibo[]=new long[120900001];
		PrintWriter pw = new PrintWriter(System.out);
		fibo[0]=0;
		fibo[1]=1;
		for(int i=2;i<fibo.length;i++){
			fibo[i]=fibo[i-1]+fibo[i-2];
		}
		
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m= Integer.parseInt(s[1]);
			
			BigInteger bg = new BigInteger("0");
			for(int i=n;i<=m;i++){
				bg = bg.add(new BigInteger(""+fibo[i]));
			}
			pw.println(bg.mod(new BigInteger("1000000007")));
			pw.flush();
		}
	}
}
