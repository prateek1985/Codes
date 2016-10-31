import java.io.*;
public class ADFRUITS {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while((s=br.readLine()).length() !=0){
			
			String arr[]=s.split(" ");
			String a = arr[0];
			String b= arr[1];
			int n = a.length();
			int m = b.length();
			
			int lcs[][]=new int[n+1][m+1];
			for(int i=1;i<n+1;i++){
				for(int j=1;j<m+1;j++){
					
					if(a.charAt(i-1) == b.charAt(j-1)){
						lcs[i][j] = 1+lcs[i-1][j-1];
					}
					else
						lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
			
			
			String str="";
			int i=n ,j=m;
			while(i>0 && j>0){
					if(a.charAt(i-1) == b.charAt(j-1)){
						str = a.charAt(i-1)+str;
						i--;
						j--;
					}
					else{
						if(lcs[i-1][j] > lcs[i][j-1]){
							str =  a.charAt(i-1)+str;
							i--;
						}
						else{
							str =  b.charAt(j-1)+str;
							j--;
						}
					}
					
					if(i==0 && j>0)
						str = b.substring(0,j) + str;
					
					if(j==0 && i>0)
						str = a.substring(0,i) + str;
				
			}
			
			System.out.println(str);
		}
		
	}
}
