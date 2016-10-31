import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class TextDocumentAnalysis {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		String s= br.readLine();
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			if(s.charAt(i) == '(')
				al1.add(i);
			else if(s.charAt(i) == ')')
				al2.add(i);
		}
		String tmp="";
		if(al1.size()==0)
			tmp = s;
		for(int i=0;i<al1.size();i++){
			int x = al1.get(i);
			if(x!=0 && i==0)
				tmp = tmp+"_"+s.substring(0,x);
			if(i!=0){
				tmp += "_"+ s.substring(al2.get(i-1)+1 ,al1.get(i) );
			}
		}
		if(al2.size()>0 && al2.get(al2.size()-1) != s.length()-1)
			tmp += "_"+ s.substring(al2.get(al2.size()-1)+1);
		
		String out[] = tmp.split("_");
		int max=0;
		for(int i=0;i<out.length;i++){
			if(out[i].length() > max)
				max  = out[i].length();
		}
		
		String flag="";
		for(int i=0;i<al1.size();i++){
			int x = al1.get(i);
			int y = al2.get(i);
			flag = flag+"_"+s.substring(x+1,y);
			
		}
		String in[] = flag.split("_");
		int c=0;
		for(String f:in){
			//System.out.println(f);
			if(f.length()>0)
				c++;
		}
	//	System.out.println(flag);
		System.out.println(max+" "+c);
		
	}
}
