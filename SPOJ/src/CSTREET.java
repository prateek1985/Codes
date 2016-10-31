import java.util.*;
import java.io.*;
public class CSTREET {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t =Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			int p =Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int m =Integer.parseInt(br.readLine());
			Streets arr[]= new Streets[m];
			for(int i=0;i<m;i++){
				String s[]=br.readLine().split(" ");
				arr[i] = new Streets(Integer.parseInt(s[0]),Integer.parseInt(s[1]), Integer.parseInt(s[2]));
			}
			
			Arrays.sort(arr);
			
			HashSet<HashSet<Integer>> hsMain = new HashSet<HashSet<Integer>>();
			for(int i=1;i<=n;i++){
				HashSet<Integer> hs = new HashSet<Integer>();
				hs.add(i);
				hsMain.add(hs);
			}
			
			long mst=0;
			int i=0,j=0;
			while(i<n-1){
				Streets edge = arr[j++];
				HashSet<Integer> hs1 = null , hs2 = null;
				int flag=0;
				for(HashSet<Integer> hs : hsMain){
					if(hs.contains(edge.u) && hs.contains(edge.v)){
						break;
					}
					else if(hs.contains(edge.u)){
						hs1 = hs;
						flag++;
					}
					else if(hs.contains(edge.v)){
						hs2=hs;
						flag++;
					}
					
					if(flag==2)
						break;
				}
				
				if(flag==2){
					i++;
					mst+=edge.w;
					hsMain.remove(hs2);
					hsMain.remove(hs1);
					hs1.addAll(hs2);
					
					hsMain.add(hs1);
				}
			}
			pw.println(mst*p);
			pw.flush();
			
		}

	}
private static class Streets implements Comparable<Streets>{
	int u,v,w;
	public Streets (int u, int v,int w){
		this.u=u;
		this.v=v;
		this.w= w;
		
	}
	
	public int compareTo(Streets s){
		return w-s.w;
	}
	
}
}
