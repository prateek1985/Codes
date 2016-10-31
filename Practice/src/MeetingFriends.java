import java.util.Arrays;
import java.util.Scanner;

public class MeetingFriends {
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		int arr[]= new int[3];
		arr[0]= s.nextInt();
		arr[1] =s.nextInt();
		arr[2] = s.nextInt();
		Arrays.sort(arr);
		System.out.println(arr[2]-arr[1] + arr[1]-arr[0]);
	}
}
