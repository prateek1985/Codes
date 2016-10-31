import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortByMe {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []str = br.readLine().split(" ");
		int arr[]=new int[str.length];
		
		for(int i=0;i<str.length;i++){
			arr[i]=Integer.parseInt(str[i]);
		}
		
		int a[]=divide(arr);
		for(int x:a){
			System.out.println(x);
		}
	}
	
	public static int[] divide(int arr[]){
	  if(arr.length==1){
		  return arr;
	  }	
	  else{
		int n = arr.length/2;
		int arr1[] = new int[n];
		int arr2[] = new int[arr.length-n];
		
		for(int i=0;i<n;i++){
			arr1[i]=arr[i];
		}
		for(int i=0;i<arr.length-n;i++){
			arr2[i]=arr[i+n];                     // if n is not added first element is printed only
		}
		
		int m1[]=divide(arr1);
		int m2[]=divide(arr2);
		
		return merge(m1,m2);
	  }
	}
	
	public static int[] merge(int []m1,int []m2){
		
		int []m=new int[m1.length+m2.length];
		
		int n1=0,n2=0;
		int i=0;
		while(i<m.length){
			
			if(m1[n1]<=m2[n2]){
				m[i++]=m1[n1];
				n1++;
			}
			else{
				m[i++]=m2[n2];
				n2++;
			}
			
			
			if(n1==m1.length){
				for(int j=n2;j<m2.length;j++){
					m[i++]=m2[j];
				}
			}
			else if(n2==m2.length){
				for(int j=n1;j<m1.length;j++){
					m[i++]=m1[j];
				}
			}
		}
		
		
		
		return m;
	}
}
