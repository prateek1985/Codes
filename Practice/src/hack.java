import java.io.PrintWriter;

public class hack {
	public static void main(String args[]) throws Exception{
		String str="";
		PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
	
		
		for(int i=0;i<36300;i++){
			writer.print("100000 ");
		}
		writer.close();
	
	}
}
