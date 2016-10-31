import java.io.*;
import java.util.HashSet;
import java.util.TreeSet;

public class ReberlandLinguistics {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		if(s.length()<=6){
			System.out.println(0);
			return;
		}
		
		String str=s.substring(5);
		TreeSet<String>hs = new TreeSet<String>();
		hs.add(str.substring((str.length()-2)));
		if(str.length()>=3)
			hs.add(str.substring((str.length()-3)));
		
		for(int i=1;i<=str.length()-3;i++){
			if(i!=1){
				hs.add(str.substring(i-2,i+1));
			}
			hs.add(str.substring(i-1,i+1));
		}
		PrintWriter pw = new PrintWriter(System.out);
		
		pw.println(hs.size());
		pw.flush();
		for(String x:hs){
			pw.println(x);
			pw.flush();
		}
	}
}
