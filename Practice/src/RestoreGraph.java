import java.util.*;
import java.io.*;
public class RestoreGraph {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" " );
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		String arr[]=br.readLine().split(" ");
		pair d[]=new pair[n];
		for(int i=0;i<n;i++){
			
			d[i] = new pair(i+1,Integer.parseInt(arr[i]));
		}
		Arrays.sort(d);
		int prev=d[0].v;
		int dis = d[0].d;
		if(dis!=0){
			System.out.println(-1);
			return;
		}
		int prevDis=1;
		ArrayList<String>al=new ArrayList<String>();
		Queue<Integer>q1 = new LinkedList<Integer>();
		Queue<Integer>q2  = new LinkedList<Integer>();
		int deg[]=new int[n+1];
		for(int i=1;i<n;i++){
			int u = d[i].v;
			dis = d[i].d;
			if(dis==prevDis){
				q2.add(u);
				deg[prev]++;
				deg[u]++;
				if(deg[prev]>k || deg[u]>k){
					if(deg[prev]>k && deg[u]>k){
						deg[prev]--;
						deg[u]--;
					}
					else if(deg[prev]>k)
						deg[prev]--;
					else{
						deg[prev]--;
						deg[u]--;
					}
					if(q1.isEmpty()){
						System.out.println(-1);
						return;
					}
					else{
						prev = q1.poll();
						try{
							while(deg[prev]>=k)
								prev = q1.poll();
						}
						catch(Exception e){
							System.out.println(-1);
							return;
						}
					}
					
				}
				al.add(prev + " "+ u);
				
			}
			else{
				i--;
				if(dis-1!=prevDis){
					System.out.println(-1);
					return;
				}
				else{
				//	System.out.println(q2);
					q1=q2;
				//	System.out.println(q1);
					q2 = new LinkedList<Integer>();
				//	System.out.println(q1);
					prevDis=dis;
					if(q1.size()==0){
						System.out.println(-1);
						return;
					}
					else{
						prev =  q1.poll();
						try{
							while(deg[prev]>=k)
								prev = q1.poll();
						}
						catch(Exception e){
							System.out.println(-1);
							return;
						}
					}
				}
			}
			
			//System.out.println(al);
		}
		System.out.println(al.size());
		for(String x:al)
			System.out.println(x);
	}
	private static class pair implements Comparable<pair>{
		int v;
		int d;
		
		public pair(int v, int d){
			this.v=v;
			this.d=d;
		}
		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			return d-p.d;
		}}
}
