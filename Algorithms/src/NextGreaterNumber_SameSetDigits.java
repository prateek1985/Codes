import java.util.*;
public class NextGreaterNumber_SameSetDigits {

	public static void main(String args[]) throws Exception{
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		char c[]= (""+n).toCharArray();
		int d=-1;
		for(int i=c.length-2;i>=0;i--){
			if(c[i]<c[i+1]){
				d=i;
				break;
			}
		}
		
		if(d==-1){
			System.out.println("Not Possible");
			return;
		}
		int min =Integer.MAX_VALUE;
		int x=-1;
		for(int i=d+1;i<c.length;i++){
			if(min > Integer.parseInt(c[i]+"") && min > Integer.parseInt(c[d]+"") ){
				min = Integer.parseInt(c[i]+"");
				x = i;
			}
		}
		
		char tmp = c[d];
		c[d] = c[x];
		c[x] = tmp;
		Arrays.sort(c, d+1, c.length);
		
		System.out.println(new String(c));
	} 
}