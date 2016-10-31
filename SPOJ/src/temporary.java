import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class temporary {

	public static void main(String args[]) throws IOException{
		File file2 = new File("C:\\Users\\Prateek Goel\\Documents\\Desktop\\Summer Project\\Stanford_datasetAndStuff\\1.txt");
		
		Scanner scan2 = new Scanner(file2);
		
		File file3 = new File("C:\\Users\\Prateek Goel\\Documents\\Desktop\\Summer Project\\Stanford_datasetAndStuff\\2.txt");
		
		Scanner scan3 = new Scanner(file3);
		BufferedWriter output = new BufferedWriter(new FileWriter("C:\\Users\\Prateek Goel\\Documents\\Desktop\\Summer Project\\Stanford_datasetAndStuff\\trainingSet_Stanford.txt",true)); 
        
		while(scan3.hasNextLine()){
			output.append(scan2.nextLine()+scan3.nextLine());
			output.newLine();
	        
		}
		output.close();
	}
}
