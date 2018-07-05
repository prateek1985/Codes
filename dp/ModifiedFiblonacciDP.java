package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ModifiedFiblonacciDP {

    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String s[]= br.readLine().split(" ");
        
        BigInteger fibo[] = new BigInteger[Integer.parseInt(s[2])];
        fibo[0]=new BigInteger(s[0]);
        fibo[1]=new BigInteger(s[1]);
      
        
        for(int i=2;i<fibo.length;i++){
        	BigInteger b= fibo[i-1].pow(2);
        	
        	fibo[i] = b.add(fibo[i-2]);
        
      
    }
        
        System.out.println(fibo[Integer.parseInt(s[2])-1]);
    }
}
