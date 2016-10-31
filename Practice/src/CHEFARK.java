import java.io.*;
import java.math.BigInteger;
public class CHEFARK {

	public static void main(String args[]) throws Exception	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int k =Integer.parseInt(s[1]);
			int n =Integer.parseInt(s[0]);
			String arr[]=br.readLine().split(" " );
			
			int min = Math.min(k,n);
			BigInteger a1 = BigInteger.ZERO,a2=BigInteger.ZERO;
			BigInteger b =new BigInteger("1");
			long f=1;
			int m = 1000000007;
			for(int i=1;i<=min;i++){
				b = b.multiply(new BigInteger((n-i+1)+""));
				b = b.divide(new BigInteger(""+i));
				f = (f*i)%m;
				if(i%2==0)
					a1 = (b.add(a1)).mod(new BigInteger(""+m));
				else
					a2 = (b.add(a2)).mod(new BigInteger(""+m));
			//	System.out.println(b+" "+(n-i+1));
			}
			if(min%2==0)
				System.out.println(a1.add(BigInteger.ONE));
			else
				System.out.println(a2);
		}
	}
}