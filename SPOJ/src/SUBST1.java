import java.io.*;
import java.util.*;				// WRONG
public class SUBST1 {
	static String suf[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s=br.readLine();
			suf=new String[s.length()];
		//	PriorityQueue<String>pq=new PriorityQueue<String>();
			int e=0;
			String str="";
			for(int i=s.length()-1;i>=0;i--){
				str = s.charAt(i)+str;
				suf[e++] = str;
			}
			
			radixSort();
			for(String g:suf)
				System.out.println(g);
			int ans  = suf[0].length();
			for(int i=0;i<suf.length-1;i++){
				int lcp=0;
				for(int j=0;j<Math.min(suf[i].length(), suf[i+1].length());j++){
					if(suf[i].charAt(j)==suf[i+1].charAt(j))
						lcp++;
					else
						break;
				}
				
				ans+=(suf[i+1].length() - lcp);
			}
			
			pw.println(ans);
			pw.flush();
			
		}
	}
	static void radixSort(){
		ArrayList<ArrayList<String>> buck = new ArrayList<ArrayList<String>> ();
		for(int i=0;i<26;i++){
			buck.add(new ArrayList<String>());
		}
		
		int j=1;
		int max=suf[suf.length-1].length();
		for(int d=0;d<max;d++){
			
			for(int i=0;i<suf.length;i++){
				
				if(suf[i].length()-j>=0)
					buck.get(suf[i].charAt(suf[i].length()-j) - 'A').add(suf[i]);
			}
			
			int tmp=0;
			
			for(int i=0;i<26;i++){
				while(!buck.get(i).isEmpty()){
					suf[tmp++] = buck.get(i).remove(0);
				}
			}
			
			j++;
		}
	}
}
