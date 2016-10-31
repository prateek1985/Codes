import java.io.*;
import java.util.*;

// make this class private static in code for input 
// then in main method 
/*
Stdin in = new Stdin();
int t=in.readInt();
	int n=in.readInt();
		int m=in.readInt();
		
works like scanner 		
*/

//

public class Stdin {
	InputStreamReader read;
	BufferedReader br;

	StringTokenizer st = new StringTokenizer("");

	private Stdin() {
		read = new InputStreamReader(System.in);
		br = new BufferedReader(read);

	}

	private String readNext() throws IOException {

		while (!st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	private int readInt() throws IOException, NumberFormatException {

		return Integer.parseInt(readNext());

	}

	private long readLong() throws IOException, NumberFormatException {

		return Long.parseLong(readNext());

	}
	private double readDouble() throws IOException, NumberFormatException {

		return Double.parseDouble(readNext());

	}
}
