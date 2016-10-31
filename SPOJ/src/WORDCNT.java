import java.io.*;
import java.util.*;
public class WORDCNT {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw= new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split("\\s+");
			if(s.length==0)
			{
				pw.println(0);
				pw.flush();
				continue;
			}
			int len=s[0].length();
			int count=0, max =-1;
			for(int i=0;i<s.length;i++){
				if(len == s[i].length()){
					count++;
				}
				else{
				//	System.out.println(s[i]);
					if(max < count)
						max=count;
					
					count =1;
					len = s[i].length();
					//System.out.println(len);
				}
				
				if(i==s.length-1){
					if(max < count)
						max=count;
					
				}
			}
			
			pw.println(max);
			pw.flush();
			
		}
		
	}
}
