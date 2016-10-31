import java.util.*;
import java.io.*;
public class DifferentGood {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s= br.readLine();
		HashSet<Character> hs = new HashSet<Character>();
		for(int i=0;i<n;i++){
			hs.add(s.charAt(i));
		}
			
		if(s.length()>26)
			System.out.println(-1);
		else
			System.out.println(s.length()-hs.size());
		
	}
	
}
