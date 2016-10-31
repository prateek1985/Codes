import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class InterestingDrink {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]= Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		
		int shop = Integer.parseInt(br.readLine());
		for(int i=0;i<shop;i++){
			int m = Integer.parseInt(br.readLine());
			int ind = Arrays.binarySearch(arr, m);
			
			if(ind>=0){
				while(ind <n-1 && arr[ind]==arr[ind+1])
					ind++;
				pw.println(ind+1);
			}
			else{
				ind=-ind-1;
				pw.println(ind);
			}
			pw.flush();
		}
	}
}