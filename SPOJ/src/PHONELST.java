import java.io.*;
import java.util.*;
public class PHONELST {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			int n=Integer.parseInt(br.readLine());
			String s[]=new String[n];
			for(int i=0;i<n;i++){
				s[i]=br.readLine();
				
			}
			Arrays.sort(s);
			boolean tmp=true;
			for(int i=0;i<n-1;i++){
				String s1=s[i];
				String s2=s[i+1];
				if(s1.length()<=s2.length()){
					boolean flag=false;
					for(int j=0;j<s1.length();j++){
						if(s1.charAt(j)!=s2.charAt(j)){
							flag=true;
							break;
						}
					}
					if(!flag){
						tmp=false;
						pw.println("NO");
						pw.flush();
						break;
					}
				}
			}
			if(tmp){
				pw.println("YES");
				pw.flush();
			}
			
		}

	}

}
