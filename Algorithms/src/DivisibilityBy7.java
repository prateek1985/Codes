import java.util.Scanner;


public class DivisibilityBy7 {

	public static void main(String args[]){
		
		Scanner s=new Scanner (System.in);
		int n = s.nextInt();
		System.out.println(divisible(n));
	}
	
	static boolean divisible(int n){
		if(n==0||n==-7||n==7){
			return true;
		}
		else if(n/10==0){
			return false;
		}
		else{
		int b = n%10;
		int a= n/10;
		
		return divisible(a-(2*b));
		
		}
		
	} 
}
