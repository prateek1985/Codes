import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
public class MARBLES {

	public static void main(String args[]) throws Exception{
		PrintWriter pw =new PrintWriter(System.out);
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int r=0;r<t;r++){
			int n=s.nextInt();
			int k=s.nextInt();
			n--;k--;
			
			BigInteger ans=new BigInteger("1");
			BigInteger fact=new BigInteger("1");
			if(n-k<k)
				k=n-k;
			for(int i=1;i<=k;i++){
				ans= ans.multiply(new BigInteger((n-i+1)+""));
				fact =fact.multiply(new BigInteger(i+""));
			}
			pw.println(ans.divide(fact));
			pw.flush();
		}
	}
}
