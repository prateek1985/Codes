
public class PermutationOfString {

	public static void main(String args[]){
		String s = "pratik";
		
		permute(s.toCharArray() , 0 , s.length()-1);
		
	}
	
	static void permute(char arr[] , int k , int n){
		if(n==k){
			System.out.println(new String (arr));
		}
		else{
			for(int i=k;i<arr.length;i++){
				
				char tmp=arr[k];
				arr[k]=arr[i];
				arr[i] = tmp;
				
				permute(arr , k+1 , n);
				
				char tmp2=arr[k];
				arr[k]=arr[i];
				arr[i] = tmp2;
				
			}
		}
	}
}
