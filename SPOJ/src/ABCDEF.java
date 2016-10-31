import java.io.*;
import java.util.*;

public class ABCDEF {
	public static void main(String[] args) throws IOException{
	      
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n =Integer.parseInt(br.readLine());
		int arr[]= new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		HashMap<Integer, Integer> hm1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hm2 = new HashMap<Integer, Integer>();
		for(int i=0;i<n;++i){
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++){
					int x = (arr[i]*arr[j])+arr[k];
					int y = (arr[i]+arr[j])*arr[k];
					if(hm1.containsKey(x)){
						hm1.put(x,hm1.get(x)+1);
					}
					else
						hm1.put(x,1);
					
					if(hm2.containsKey(y)){
						hm2.put(y,hm2.get(y)+1);
					}
					else
						hm2.put(y,1);
				}
			}
		}
		long ans=0;
		for(Map.Entry<Integer, Integer> entry : hm1.entrySet()){
			if(hm2.containsKey(entry.getKey())){
				ans+=entry.getValue()*hm2.get(entry.getKey());
			}
		}
		pw.println(ans);
		pw.flush();
	}
	
}
