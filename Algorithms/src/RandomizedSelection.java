import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class RandomizedSelection {

	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []str = br.readLine().split(" ");
		int n = Integer.parseInt(br.readLine());
		
		int []arr=new int[str.length];
		
		for(int i=0;i<str.length;i++){
			arr[i]=Integer.parseInt(str[i]);
		}
		
		System.out.println(smallest(arr,0,arr.length-1,n));
		
	}	
	public static int smallest(int []arr,int l,int r,int n){
		if(r-l==0)return arr[r];
		int p = partition(arr,l,r);
		if(p+1==n) return arr[p];
		else if(p+1>n) return smallest(arr,l,p-1,n);
		else return smallest(arr,p+1,r,n);
		
		
	}
	
	public static int partition(int [] arr,int l,int r){
		Random rand = new Random();
		int p =rand.nextInt(r-l+1) + l;
		if(p!=l){
			
			int tmp=arr[l];
			arr[l]=arr[p];
			arr[p]=tmp;
		}
		int pivot=arr[l];
		
		int i=l+1;
		for(int j=l+1;j<=r;j++){
			if(arr[j]<pivot){
				int tmp=arr[j];
				arr[j]=arr[i];
				arr[i]=tmp;
				i++;
			}
		}
		arr[l]=arr[i-1];
		arr[i-1]=pivot;
		return i-1;
	}
}
