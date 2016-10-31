import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CompleteWord {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c[]=br.readLine().toCharArray();
		int n =c.length;
		int ans=0;
		int ind=0;
		for(int i=0;i<n-25;i++){
			
			int d=0;
	
			int q=0;
			HashSet<Character> hs = new HashSet<Character>();
			for(int j=i;j<i+26;j++){
				if(c[j]!='?'){
					hs.add(c[j]);			
				}
				else q++;
				
			}
			
			int x = 26-hs.size();
			if(x==26 && hs.size()!=0){
				ans=1;
				ind =i;
				break;
			}
			else if(x == q){
				ans=2;
				ind =i;
				break;
			}
		}
		
		if(ans ==0)
			System.out.println(-1);
		else if(ans ==1){
			for(int i=0;i<n;i++){
				if(c[i]=='?')
					c[i]='A';
			}
			System.out.println(new String(c));
		}
		else{
			boolean a[]=new boolean[26];
			for(int i=ind;i<ind+26;i++){
				if(c[i]!='?')
					a[c[i]-'A']=true;
			}
			ArrayList<Character> al = new ArrayList<Character>();
			for(int i=0;i<26;i++){
				if(!a[i]){
					al.add((char)(i+'A'));
				}
			}
			int index=0;
			for(int i=ind;i<ind+26;i++){
				if(c[i]=='?')
					c[i]=al.get(index++);
			}
			for(int i=0;i<n;i++){
				if(c[i]=='?')
					c[i]='A';
			}
			System.out.println(new String(c));
		}
	}
}
