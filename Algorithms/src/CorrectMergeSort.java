import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CorrectMergeSort {

	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		                                              
		arr=mergeSort(arr);
		for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
}
	public static int[] mergeSort(int arr[]){
		if(arr.length==1){
			return arr;
		}
		else{
		int r=arr.length/2;
		int arr1[]=new int [r];
		int arr2[]=new int [arr.length-r];
	
		
		for(int i=0;i<arr.length;i++){
			if(i<r){
				arr1[i]=arr[i];
			}
			else{
				arr2[i-r]=arr[i];
			}
	
		}
		arr1=mergeSort(arr1);
		arr2=mergeSort(arr2);
		
		arr=merge(arr1,arr2);
		
		return arr;
		}
	}
	public static int[] merge(int arr1[],int arr2[]){
		int mergeArray[]=new int [arr1.length+arr2.length];
		int a=0,b=0;
		
		for(int i=0;i<mergeArray.length;i++){
			if(a==arr1.length){
				mergeArray[i]=arr2[b];
				b++;
			}
			else if(b==arr2.length){
				mergeArray[i]=arr1[a];
				a++;
			}
			else if(arr1[a]>arr2[b]){
				mergeArray[i]=arr2[b];
				b++;
				
			}
			else if (arr1[a]<=arr2[b]){
				mergeArray[i]=arr1[a];
				a++;
			}
		}
		return mergeArray;
		
	}
	
}
