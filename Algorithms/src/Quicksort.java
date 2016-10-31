import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;


public class Quicksort {
	static int arr[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []str = br.readLine().split(" ");
		arr=new int[str.length];
		
		for(int i=0;i<str.length;i++){
			
			arr[i]=Integer.parseInt(str[i]);
			
		}
		sort(0,arr.length-1);
		for(int x: arr){
			System.out.println(x);
		}
	}
	
	public static void sort(int l,int r){
		if(l<r){
		int q = partition(l,r);
		
		sort(l,q-1);
		sort(q+1,r);
		}
	}
	public static int partition(int l,int r){
	//	System.out.println(l+" "+r);
	/*	Random rand = new Random();
		int p =rand.nextInt(r-l+1) + l;
		
		if(p!=l){
			
			int tmp=arr[l];
			arr[l]=arr[p];
			arr[p]=tmp;
		}*/
		int pivot=arr[l];
		//System.out.println(pivot);
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
