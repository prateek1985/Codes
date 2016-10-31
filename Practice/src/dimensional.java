import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dimensional {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		String s= br.readLine();
		
		int count=0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0;i<s.length();i++){
			if(count>0 && s.charAt(i)=='W'){
				al.add(count);
				count=0;
			}
			if(s.charAt(i)=='B')
					count++;
			if(i==s.length()-1 && count>0){
				al.add(count);
			}	
		}
		System.out.println(al.size());
		for(int xa:al){
			System.out.print(xa+" ");
		}
	}
}
