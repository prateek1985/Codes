import java.util.*;
import java.io.*;
public class MAJOR {

	public static void main(String[] args) throws IOException{
	      
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			int n = Integer.parseInt(br.readLine());
		//	HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
			int arr[]=new int[2001];
			String s[]=br.readLine().split(" ");
			boolean flag=false;
			int ans =0;
			for(int i=0;i<n;i++){
				int c= Integer.parseInt(s[i]);
				arr[c+1000]++;
				
			}
			for(int i=0;i<arr.length;i++){
				if(arr[i]>n/2){
					flag=true;
					ans = i-1000;
					break;
				}
			}
			if(flag){
				pw.println("YES "+ans);
				
				
			}
			else{
				pw.println("NO");
				
			}
			pw.println();
			pw.flush();
			
		}
	}

}
