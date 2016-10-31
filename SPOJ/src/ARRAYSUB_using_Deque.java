import java.util.*;
import java.io.*;
public class ARRAYSUB_using_Deque {
	
	// http://www.geeksforgeeks.org/maximum-of-all-subarrays-of-size-k/
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		int n= Integer.parseInt(br.readLine());
	//	String ss= br.readLine();
		String s[]=br.readLine().split(" ");
		int k =Integer.parseInt(br.readLine());
		
		Deque <Integer>dq = new LinkedList<Integer>();
		
		for(int i=0;i<k;i++){
			while(!dq.isEmpty() && Integer.parseInt(s[i])>=Integer.parseInt(s[dq.peekLast()])){
				dq.removeLast();
			}
			
			dq.addLast(i);
		}
		
		for(int i=k;i<n;i++){
			pw.print(s[dq.peekFirst()]+" ");
			pw.flush();
			
			 // Remove the elements which are out of this window
			
			while(!dq.isEmpty() && dq.peekFirst()<=i-k){
				dq.removeFirst();
			}
			
			while(!dq.isEmpty() && Integer.parseInt(s[i])>=Integer.parseInt(s[dq.peekLast()])){
				dq.removeLast();
			}
			
			dq.addLast(i);
		}

		// Print the maximum element of last window
		
		pw.print(s[dq.peekFirst()]);
		pw.flush();
	}

}
