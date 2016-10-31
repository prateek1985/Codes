import java.io.*;
public class MergeSort {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		                                                          //  not correct !!!!!!!!!!!!!!
		mergeSortArray(arr,0,arr.length-1);
		for (int x:arr){
			System.out.print(x+" ");
		}
		
		
	}
	
     static void mergeSortArray(int arr[],int p,int q){
    	 if(p<q){
    	  int r=(p+q)/2;
    	
    	  mergeSortArray(arr,p,r);
    	  mergeSortArray(arr,r+1,q);
    	  mergeArray(arr,p,r,q);
    	 // System.out.println();
    	 
    	  
    	 }
    }
     static void mergeArray(int arr[],int p,int r,int q){   //0 1 3
    	int i=p;int j=r;int k=p;   //0 2 3
    	int temp[]=new int[arr.length];
    	
    	for(int w=0;w<arr.length;w++){
    		temp[w]=arr[w];
    	}
    	
    	while(i<=r+1 && j<=q+1){
    	    if(i==r+1){arr[k]=temp[j];j++;}
    	    if(j==q+1){arr[k]=temp[i];i++;}
    	    
    		if(temp[i]<=temp[j]){
    			arr[k]=temp[i];
    			
    			i++;
    		}
    		else {
    			arr[k]=temp[j];
    			j++;
    		}
    		k++;
    		
    	}
    	for(int w=0;w<arr.length;w++){
    		arr[w]=temp[w];
    	}
     }	 
    	 }
     


