import java.util.*;
import java.io.*;

public class APAC {
static ArrayList<ArrayList<Integer>> al;

	public static void main(String args[]) throws Exception{
		BufferedWriter output = new BufferedWriter(new FileWriter("output.txt")); 
        /*
        output.append("Case #"+y+": "+arr[min]);
        output.newLine();
        output.close();*/
		Scanner s  = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int y=1;y<=t;y++){
			int n= s.nextInt();
			String v="";
			int p=0;
			al= new ArrayList<ArrayList<Integer>>();
			Queue<Integer> q = new LinkedList<Integer>();
			HashSet<Integer> hs = new HashSet<Integer>();
			HashMap<String ,Integer> hm = new HashMap<String , Integer>();
			for(int i=0;i<n;i++){
				String ss[]=s.next().split("=");
				v=ss[0];
				if(!hm.containsKey(v)){
					hm.put(v,p++);
					al.add(new ArrayList<Integer>());
				}
				int v2 = hm.get(v);
				try{
					
					String sss[]= ss[1].split("\\(")[1].split("\\)")[0].split(",");
					
					for(String x:sss){
						if(!hm.containsKey(x)){
							hm.put(x,p++);
							al.add(new ArrayList<Integer>());
						}
					}
					
					for(String x:sss){
							int u = hm.get(x);
							al.get(u).add(v2);
					}
				
				}
				catch(Exception e){
					hs.add(v2);
					q.add(v2);
				}
			}
			
			if(q.isEmpty()){
				output.append("Case #"+y+": BAD");
			}
			else{
				while(!q.isEmpty()){
					int u = q.poll();
					for(int i=0;i<al.get(u).size();i++){
						int v1 = al.get(u).get(i);
						if(!hs.contains(v1)){
							q.add(v1);
							hs.add(v1);
						}
					}
				}
		//	System.out.println(hm);
				if(hs.size()==hm.size())
					output.append("Case #"+y+": GOOD");
				else
					output.append("Case #"+y+": BAD");
			}
			
			
			
			
			//output.append("Case #"+y+": "+count);
		    output.newLine();
		}
		 output.close();
	}
}
