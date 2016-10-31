import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
public class ChrisMagicSquare {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
	
		String a[][]= new String[n][n];
		for(int i=0;i<n;i++){
			a[i] = br.readLine().split(" ");
		}
		try{
		int i1=0,j1=0;
		
		for(int i=0;i<n;i++){ 
			int flag=0;
			for(int j=0;j<n;j++){
				if(Long.parseLong(a[i][j]) == 0){
					i1=i;
					j1=j;flag=2;
					break;
				}
			}
			if(flag==2)
				break;
		}
		
		
		long sum=0;
		if(n==1){
			System.out.println(1);
			return;
		}
		else if(j1+1<n){
			
			for(int i=0;i<n;i++){
				sum += Long.parseLong(a[i][j1+1]);
			}
		}
		else{
			for(int i=0;i<n;i++){
				sum += Long.parseLong(a[i][j1-1]);
			}
		}
		
		long q=0;
		for(int i=0;i<n;i++){
			q+=Long.parseLong(a[i][j1]);
		}
		if(sum!=q)
		{
			a[i1][j1] = ""+(sum-q);
			HashSet<Long> hs = new HashSet<Long>();
			for(int i=0;i<n;i++){
				long p=0;
				for(int j=0;j<n;j++){
					p += Long.parseLong(a[i][j]);
				}
				hs.add(p)	;
			}
			for(int i=0;i<n;i++){
				long p=0;
				for(int j=0;j<n;j++){
					p += Long.parseLong(a[j][i]);
				}
				hs.add(p);
			}
			long p=0;
			for(int i=0;i<n;i++){
				p += Long.parseLong(a[i][i]);
				
			}
			hs.add(p);
			p=0;
			for(int i=0;i<n;i++){
				p += Long.parseLong(a[i][n-i-1]);
				
			}
			hs.add(p);
			if(sum - q < 0 || hs.isEmpty() ||  hs.size()!=1)
				System.out.println(-1);
			else
				System.out.println(sum - q);
		}
		else
			System.out.println(-1);
		}
		catch(Exception e){
		//	System.out.println(e);
			System.out.println(-1);
		}
	}
	
}
