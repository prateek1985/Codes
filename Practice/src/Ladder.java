	import java.io.*;
	import java.util.Arrays;
	
	public class Ladder {
	
		public static void main(String args[]) throws Exception{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			String s[]=br.readLine().split(" ");
			PrintWriter pw = new PrintWriter(System.out);
			int n=Integer.parseInt(s[0]);
			String arr[]=br.readLine().split(" ");
			int left[]=new int[n];
			int right[] = new int[n];
			left[0]=1;
			right[n-1] = n;
			for(int i=1;i<n;i++){
				
				if(Integer.parseInt(arr[i])>Integer.parseInt(arr[i-1]))
				{
					left[i] = i+1;
				}
				else
					left[i]=left[i-1];
				
			}
			
			for(int i=n-2;i>=0;i--){
			
				if(Integer.parseInt(arr[i])>Integer.parseInt(arr[i+1])){
					right[i] = i+1;
				}
				else
					right[i]=right[i+1];
			
			}
			
			
			for(int q=0;q<Integer.parseInt(s[1]);q++){
	
				String query[]=br.readLine().split(" ");
				int l = Integer.parseInt(query[0]);
				int r=Integer.parseInt(query[1]);
				
				if(right[l-1]>=left[r-1])
					pw.println("Yes");
				else
					pw.println("No");
				pw.flush();
			}
		}
	}