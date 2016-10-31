import java.util.*;
public class Sanatorium {

	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		long b=s.nextLong();
		long l = s.nextLong();
		long d = s.nextLong();
		long max =Math.max(b, Math.max(l, d));
		
		long ans=0;
		if(max - b > 1)
			ans += max -b-1;
		if(max - l > 1)
			ans += max -l-1;
		if(max - d > 1)
			ans += max -d-1;
		
		System.out.println(ans);
	}
}
