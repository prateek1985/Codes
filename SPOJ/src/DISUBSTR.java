import java.io.*;
import java.util.*;
public class DISUBSTR {

	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		PriorityQueue <String> pq = new PriorityQueue<String>();
		for(int r=0;r<t;r++){
			String s=br.readLine();
			String str[]=new String[s.length()];
			
			String suf="";
			for(int i=s.length()-1;i>=0;i--){
				suf=s.charAt(i)+suf;
				pq.add(suf);
			}
			int i=0;
			while(!pq.isEmpty()){
				str[i++]=pq.poll();
			}
			
			int ans=str[0].length();
			
			for(int j=0;j<str.length-1;j++){
				int x = lcp(str[j],str[j+1]);
				ans+=str[j+1].length()-x;
			}
			pw.println(ans);
			pw.flush();
		}
	}
	static int lcp(String s1, String s2){
		int count=0;
		int len=Math.min(s1.length(), s2.length());
		for(int i=0;i<len;i++){
			if(s1.charAt(i)==s2.charAt(i)){
				count++;
			}
			else
				break;
		}
		return count;
	}
}
