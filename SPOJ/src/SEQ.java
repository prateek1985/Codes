import java.io.*;


public class SEQ {  //sequence recursion

	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t =Integer.parseInt(br.readLine());
		 for(int r=0;r<t;r++){
			 int k= Integer.parseInt(br.readLine())-1;
		     String b[]= br.readLine().split(" ");
		     String c[]=br.readLine().split(" ");
		     int n = Integer.parseInt(br.readLine())-1;
		     
		     long a[]=new long [n+1];
		     int tmp2=k;
		     
		     if(n<k){tmp2=n;}
		     
		     for (int i=0;i<=tmp2;i++){
		    	 
		    	 a[i]=Long.parseLong(b[i])%1000000000;
		    	 
		    	// System.out.println("gogo");
		     }
		    
		     long fin[]=computingValues(a,k,n,c);
		     System.out.println(fin[n]);
		 }
	}
	public static long[] computingValues(long a[],int k,int n,String c[]){
		
		if(n<=k){
			return a;
		}
		else{
			 a= computingValues(a,k,n-1,c);
			 int tmp=0;
			 int flag=n-1;
		     for(int i=0;i<=k;i++){
		    	 a[n]+=(a[flag--]*Long.parseLong(c[tmp++]))%1000000000;
		     }
		     return a;
		}
		
	}
}
