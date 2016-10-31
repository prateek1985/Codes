import java.util.*;
import java.io.*;
public class BUGLIFE {

static boolean flag;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		int t= Integer.parseInt(br.readLine());
		
		for(int r=1;r<=t;r++){
			String s[]=br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			flag=false;
			int arr[]=new int[n+1];
			Arrays.fill(arr,2);
			HashSet<String>hs =new HashSet<String>();
			for(int i=0;i<m;i++){
				String a[]=br.readLine().split(" ");
				int  u =Integer.parseInt(a[0]);
				int v= Integer.parseInt(a[1]);
				
				if(i==0 && arr[u]==2&& arr[v]==2){
					arr[u]=0;
					arr[v]=1;
				}
				else if(arr[u]==2&& arr[v]==2){
					hs.add(u+" "+v);
				}
				else if(arr[u]!=2 && arr[v]!=2){
					if(arr[v]==arr[u])
						flag=true;
				}
				else if(arr[v]!=2){
					arr[u]=1-arr[v];
				}
				else if(arr[u]!=2){
					arr[v]=1-arr[u];
				}
			}
			
			
			pw.println("Scenario #"+r+":");
			pw.flush();
			
			if(flag){
					
				pw.println("Suspicious bugs found!");
				pw.flush();
			}
			else{
				boolean tmp=false;
				if(!hs.isEmpty()){
					
					for(String h:hs){
						String b[]=h.split(" ");
						
						if(arr[Integer.parseInt(b[0])]==arr[Integer.parseInt(b[1])] && arr[Integer.parseInt(b[1])]!=2){
							pw.println("Suspicious bugs found!");
							pw.flush();
							tmp=true;
							break;
						}
					}
					
				}
				if(!tmp){
					pw.println("No suspicious bugs found!");
					pw.flush();
				}
			}
			
			
		}
		
	}
}