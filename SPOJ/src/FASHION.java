import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public abstract class FASHION {

	public static void main (String args[]) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			
			for(int x=0;x<t;x++){
				String s=br.readLine();
				String m[]=br.readLine().split(" ");
				String w[]=br.readLine().split(" ");
				
				List <Integer>l1=sortlist(m);
				List <Integer>l2=sortlist(w);
				
				int p=0;
				for(int i=0;i<m.length;i++){
					p+=(l1.get(i)*l2.get(i));
				}
				System.out.println(p);
			}
	}
	public static List<Integer> sortlist(String arr[]){
		ArrayList<Integer> a= new ArrayList<Integer>();
		for(String x: arr){
			a.add(Integer.parseInt(x));
		}
	 Collections.sort(a);
	 return a;
	}
}
