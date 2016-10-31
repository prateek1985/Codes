import java.io.*;import java.util.*;
public class HISTOGRA {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		while(true){
			String h[]=br.readLine().split(" ");
			if(Long.parseLong(h[0])==0){
				return;
			}
			Stack<Integer> st = new Stack<Integer>();
			long areaMax=0;
			int i=1;
			while(i<h.length){
				if(st.isEmpty()){
					st.push(i++);
				}
				else{
					long curHeight=Long.parseLong(h[i]);
					if(Long.parseLong(h[st.peek()])<=curHeight){
						st.push(i++);
						
					}
					else{
							int x =st.pop();
							long area=0;
							if(st.isEmpty())
								area = Long.parseLong(h[x])*(i-1);
							else{
								area = Long.parseLong(h[x])*(i-st.peek()-1);
							}
							
							if(areaMax<area)
								areaMax=area;
						}
						
					}
				}
				
			//	System.out.println(st);
				while(!st.isEmpty()){
					int y = st.pop();
					long curHeight = Long.parseLong(h[y]);
					long area=0;
					if(st.isEmpty())
						area= curHeight*(i-1);
					else{
						area = curHeight*(i-st.peek()-1);
					}
					if(areaMax<area)
						areaMax=area;
				}

			pw.println(areaMax);
			pw.flush();
		}
	}

}
