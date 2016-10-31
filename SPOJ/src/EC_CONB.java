import java.util.*;
import java.lang.*;
import java.io.*;

class EC_CONB
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
		    
		    int n=Integer.parseInt(br.readLine());
		    if(n%2==0){
		    	String s=Integer.toBinaryString(n);
		    	StringBuilder sb=new StringBuilder(s);
		    	sb.reverse();
		    	s=sb.toString();
		    	pw.println(Integer.parseInt(s,2));
		    	
		    }
		    else
		    	pw.println(n);
		    pw.flush();
		    
		}
	}
}
