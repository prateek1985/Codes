import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class CrazyComputer {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int c=Integer.parseInt(s[1]);
		String arr[]=br.readLine().split(" ");
		int count=1;
		for(int i=1;i<n;i++){
			if(Integer.parseInt(arr[i]) -Integer.parseInt(arr[i-1]) <=c  )
				count++;
			else{
				count=1;
			}
		}
		System.out.println(count);
	}
}
