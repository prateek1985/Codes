import java.io.*;
import java.util.Stack;
public class ANARC09A {

	public static void main(String[] args) throws Exception{
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long serial=1;
		while(true){
			String a=br.readLine();
			if(a.charAt(0)=='-')
				return;
			int count=0;
			Stack<Character> st=new Stack<Character>();
			for(int i=0;i<a.length();i++){
				if(a.charAt(i)=='{'){
					st.add('{');
				}
				else{
					if(!st.isEmpty()){
						st.pop();
					}
					else{
						count++;
						st.add('{');
					}
				}
			}
			
			if(!st.isEmpty()){
				count+=st.size()/2;
			}
			pw.println(serial++ +". "+count);
			pw.flush();
			
		}
	}

}
