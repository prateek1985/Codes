import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class PALIN_next_palindrone {
	public static void main (String args[]) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
long t = Long.parseLong(br.readLine());
		
		for (int r=0;r<t;r++){
			String str = br.readLine();
			while(true){
			
			BigInteger i=new BigInteger(str);
			BigInteger j=i.add(BigInteger.ONE);
			str=""+j;
			StringBuffer sb=new StringBuffer(str);
			sb.reverse();
			String rev=new String(sb);
			if(rev.equalsIgnoreCase(str)){
				break;
			}
			}
			System.out.println(str);
		}
	}
}
