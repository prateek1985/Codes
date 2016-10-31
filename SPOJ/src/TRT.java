import java.math.BigInteger;
import java.util.*;
public class TRT {

static int arr[];
	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		int n =s.nextInt();
		 arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
			
			
		}
		int i=0,j=arr.length-1;
		 
		 long days=0;
		 
		
		System.out.println(party(i,j,days));
		
	}
	static BigInteger party(int i,int j, long days){
	//	System.out.println(9);
		BigInteger ans=new BigInteger("0");
		while(i<=j){
			days++;
			if(arr[i]>arr[j])
			{
				ans=ans.add(new BigInteger(""+days*arr[j]));
				j--;
			}
			else if(arr[j]>arr[i]){
				ans=ans.add(new BigInteger(""+days*arr[i]));
				i++;
			}
			else{
				ans=ans.add(new BigInteger(""+days*arr[j]));
				BigInteger b1=party(i+1,j, days);
				BigInteger b2 =party(i,j-1,days);
				if(b1.compareTo(b2)>=0){
					return ans.add(b1);
				}
				else
					return ans.add(b2);
			}
		}
		
		return ans;
	}
}
