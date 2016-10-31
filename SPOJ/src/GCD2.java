import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class GCD2 {

	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String str[]= br.readLine().split(" ");
			
			System.out.println(gcd(str[0],str[1]));
		}
		
	}
	
	public static BigInteger gcd(String a,String b){
		if(a.equalsIgnoreCase(b)  || b.equalsIgnoreCase("0")){
			return new BigInteger(a);
		}
		
		else{
			BigInteger A = new BigInteger(a);
			BigInteger B = new BigInteger(b);
		
			return gcd(""+B,""+A.mod(B));
		}
	}
}
