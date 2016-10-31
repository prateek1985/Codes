import java.io.*;
import java.util.*;
public class ShaassBookshelf {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		ArrayList<Integer> al1= new ArrayList<Integer>();
		ArrayList<Integer>al2= new ArrayList<Integer>();
		int sum1=0,sum2=0;
		for(int i=0;i<n;i++){
			String s[]= br.readLine().split(" ");
			if(Integer.parseInt(s[0])==1){
				al1.add(Integer.parseInt(s[1]));
				sum1+=Integer.parseInt(s[1]);
			}
			else{ 
				al2.add(Integer.parseInt(s[1]));
				sum2+=Integer.parseInt(s[1]);
			}
		}
		Collections.sort(al1);Collections.sort(al2);
		
		int i=al1.size()-1,j=al2.size()-1;
		int dp[]= new int[sum1+sum2+1];
		dp[1] = al1.get(i);
		int min =0;
		for(int w=2;w <= sum1+sum2;w++){
			
			if(i!=-1 && j!=-1){
				if(dp[w-2] + al2.get(j) > dp[w-1] + al1.get(i)){
					dp[w] = dp[w-2] + al2.get(j);
					min+=2;
					sum2-=al2.get(j);
					j--;
				}
				else if(dp[w-2] + al2.get(j) < dp[w-1] + al1.get(i)){
					dp[w] = dp[w-1] + al1.get(i);
					min+=1;
					sum1-=al1.get(i);
					i--;
				}
				else{
					dp[w] = dp[w-2] + al2.get(j);
					min+=2;
					sum2-=al2.get(j);
					j--;
				}
			}
			else if(i==-1 && j!=-1){
				//System.out.println(j);
				dp[w] = dp[w-2] + al2.get(j);
				min+=2;
				sum2-=al2.get(j);
				j--;
			}
			else if(j==-1 && i!=-1){
				dp[w] = dp[w-1] + al1.get(i);
				min+=1;
				sum1-=al1.get(i);
				i--;
			}
			
			if(w>= sum1+sum2-w){
			
				break;
			}
		}
		
		System.out.println(min);
	}
}
