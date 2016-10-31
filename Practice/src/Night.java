import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Night {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		char p = 'a';
		int count=0;
		for(int i=0;i<s.length();i++){
			count += Math.min(Math.abs(p-s.charAt(i)), 26-Math.abs(p-s.charAt(i)));
			//System.out.println(p-s.charAt(i));
			p= s.charAt(i);
		//	System.out.println(Math.min(Math.abs(p-s.charAt(i)),26- Math.abs(p-s.charAt(i) )));
		}
		System.out.println(count);
	}
}
