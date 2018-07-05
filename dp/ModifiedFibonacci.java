package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ModifiedFibonacci {      //   it is not dp but recursion only
static int n1,n2;
    public static void main(String[] args) throws Exception{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String s[]= br.readLine().split(" ");
        n1=Integer.parseInt(s[0]);
        n2=Integer.parseInt(s[1]);
        System.out.println(fibo(Integer.parseInt(s[2])));
    }
    static BigInteger fibo(int n){
        if(n==1){
            return new BigInteger(""+n1);
        }
        if(n==2){
            return new BigInteger(""+n2);
        }
        BigInteger b= fibo(n-1);
        b=b.pow(2);
        return ( b.add(fibo(n-2)));
    }
}