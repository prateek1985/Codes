import java.io.*;
import java.util.HashSet;
public class MRECAMAN {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int arr[]=new int[500001];
		arr[0]=0;
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(0);
		for(int i=1;i<arr.length;i++){
			if(arr[i-1]-(i)>0 &&!hs.contains(arr[i-1]-(i))){
				arr[i]=arr[i-1]-(i);
				
			}
			else
				arr[i]=arr[i-1]+(i);
			hs.add(arr[i]);
		}

		
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==-1)
				return;
			pw.println(arr[n]);
			pw.flush();
		}
	}

}
