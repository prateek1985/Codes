import java.util.*;
import java.io.*;
public class RPLC {
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		
		for(int r=0;r<t;r++){
			int n= Integer.parseInt(br.readLine());
			String arr[]=br.readLine().split(" ");
			long ans=1;
			long sum=1;
			for(int i=0;i<n;i++){
				int p = Integer.parseInt(arr[i]);
				if(p>=0){
					sum+=p;
				}
				else{
					if(sum<= -p){
						ans+=(-p - sum + 1);
						sum=1;
					}
					else
						sum+=p;
				}
			}
			pw.println("Scenario #"+(r+1)+": "+ans);
			pw.flush();
		}
	}
}
