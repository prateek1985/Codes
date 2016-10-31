import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AddingReversedNumbers {

	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int r=0;r<t;r++){
			String str = br.readLine();
			StringBuffer bf = new StringBuffer(str).reverse();
			//System.out.println(bf.reverse());
			String[] arr = bf.toString().split(" ");
			int sum = Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
			System.out.println(Integer.parseInt(new StringBuffer(""+sum).reverse().toString()));
		}
	}
}
