import java.io.*;
import java.util.HashSet;
public class MakingString {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String s[]= br.readLine().split(" ");
		HashSet<Integer> hs = new HashSet<Integer>();
		long an=0;
		for(int i=0;i<n;i++){
			while(hs.contains(Integer.parseInt(s[i])) && Integer.parseInt(s[i])>0){
				s[i] = (Integer.parseInt(s[i]) - 1)+"";
			}
			hs.add(Integer.parseInt(s[i]));
			an += Integer.parseInt(s[i]);
		}
	System.out.println(an);
	}
}
