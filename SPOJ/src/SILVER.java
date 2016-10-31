import java.util.*;
import java.math.*;
import java.io.*;
public class SILVER {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			int n=Integer.parseInt(br.readLine());
			if(n==0)
				break;
			System.out.println(Integer.toBinaryString(n).length()-1);
		}
	}
}
