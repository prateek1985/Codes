import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
public class LongestRegularBracketSequence {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char c[]= br.readLine().toCharArray();
		int max =0;
		//boolean dp[][]= new boolean[c.length][c.length];
		HashSet<String>hs = new HashSet<String>();
		for(int l=2;l<=c.length;l++){
			for(int i=0;i<c.length-l+1;i++){
				int j = i+l-1;
				if(l==2){
					if(c[i]=='('&& c[j]==')'){
						hs.add(i+" "+j);
						if(max<l)
							max=l;
					}
						
				}
				else{
					if(hs.contains(i+1+" "+(j-1))){
						if(c[i]=='('&& c[j]==')'){
							hs.add(i+" "+j);
							if(max<l)
								max =l;
						}
					}
					else{
						for(int k=i+1;k<j;k++){
							if(hs.contains(i+" "+k) && hs.contains(k+1+" "+j)){
								hs.add(i+" "+j);
								if(max<l)
									max =l;
								break;
							}
						}
					}
				}
			}
		}
		int count =0;
		if(max ==0){
			System.out.println(0+" "+1);
			return;
		}
		for(int i=0;i<c.length-max+1;i++){
			int j = i+max-1;
			if(hs.contains(i+" "+j) )
				count++;
		}
	/*	HashSet<String> hs= new HashSet<String>();
		HashSet<String> hs2= new HashSet<String>();
		int count=0;
		for(int l=2;l<=c.length;l++){
			for(int i=0;i<c.length-l+1;i++){
				int j = i+l-1;
				if(l==2){
					if(c[i]=='('&& c[j]==')'){
						hs.add(i+" "+j);
						if(max<l){
							count=1;
							max=l;
						}
						else if(max==l)
							count++;
					}
					else
						hs2.add(i+" "+j);
						
				}
				else if(hs.contains(i+1+" "+(j-1))){
					if(c[i]=='('&& c[j]==')'){
						if(max<l){
							count=1;
							max=l;
						}
						else if(max==l)
							count++;
					}
					else
						hs2.add(i+" "+j);
				}
				else if(l%2==0 && !hs2.contains((i+1)+" "+(j-1))){
					if(c[i]==')')
						continue;
					boolean flag=true;
					Stack <Character> st=new Stack<Character>();
					for(int k=i;k<=j;k++){
						if(c[k]=='(')
							st.push('(');
						else{
							if(st.isEmpty()){
								flag=false;
								break;
							}
							else
								st.pop();
						}
					}
					if(flag&&st.isEmpty()){
						hs.add(i+" "+j);
						if(max<l){
							count=1;
							max=l;
						}
						else if(max==l)
							count++;
					}
					else{
						hs2.add(i+" "+j);
					}
				}
				else
					hs2.add(i+" "+j);
			}
		}
		if(max ==0){
			System.out.println(0+" "+1);
			return;
		}
		*/
		System.out.println(max+" "+count);
	}
}
