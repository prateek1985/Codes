import java.util.*;
public class Weather {

	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		if(n==2){
			int c=0;
			if(arr[0]>=0) c++;
			if(arr[1]<=0) c++;
			System.out.println(c);
			return;
		}
		int leftP[]=new int[n];
		int rightN[]=new int[n];
		for(int i=1;i<n;i++){
			if(arr[i-1] >= 0)
				leftP[i] = leftP[i-1] +1;
			else
				leftP[i] = leftP[i-1];
		}
		
		for(int i=n-2;i>=0;i--){
			if(arr[i+1] <=0)
				rightN[i] = rightN[i+1]+1;
			else
				rightN[i]=rightN[i+1];
		}
		int min=Integer.MAX_VALUE;
		for(int i=1;i<n-1;i++){
			if(arr[i]!=0){
				if(min > leftP[i]+rightN[i])
					min = leftP[i]+rightN[i];
			}
			else{
				if(min > leftP[i]+rightN[i]+1)
					min = leftP[i]+rightN[i]+1;
			}
				
					
		}
		System.out.println(min);
	}
}
