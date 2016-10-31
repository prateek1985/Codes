import java.io.*;
public class BearAndBlocks {
static int arr[] , k , flag=0;;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i] =Integer.parseInt(s[i]);
		}
		k=0;
		operations(0,n-1);
		System.out.println(k);
	}

	static void operations(int i, int j){
		if(i+1==j || i==j){
			k++;
			return;
		}
		int c[]= new int[i+j+1];
		for(int p=i;p<=j;p++){
			c[p] = arr[p];
		}
		
		for(int p=i+1;p<j;p++){
			if(Math.min(arr[p-1], arr[p+1]) < arr[p]){
				c[p] = Math.min(arr[p-1], arr[p+1]);
				flag=1;
			}
			else{
				if(arr[p]>0){
					c[p]--;
					flag=1;
				}
			}
		}
		arr=c;
	/*	for(int p=i+1;p<j;p++){
			System.out.print(arr[p]+" ");
		}
		System.out.println();*/
		if(flag==1){
			k++;
			flag=0;
			operations(i+1,j-1);
		}
		
	}
}
