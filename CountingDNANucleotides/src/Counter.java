import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Paths;

public class Counter {

	public static void main(String[] args) {
		int[] counterArray = new int[4];
		String nextToken;
		char nextT;
		
		try {
		Scanner in = new Scanner(Paths.get("input.txt"));
		while (in.hasNext()) {
			nextToken = in.next();
			for (int i = 0; i <= nextToken.length() - 1; i++) {
				nextT = nextToken.charAt(i);
				switch (nextT) {
				case 'A':
					counterArray[0]++;
				
					break;
				case 'C':
					counterArray[1]++;
					break;
				case 'G':
					counterArray[2]++;
					break;
				case 'T':
					counterArray[3]++;
					break;
				default :
					in.close();
					throw new IOException();
				
				}
			}
		}
		in.close();
		}
		
		catch (IOException exception) {
			System.out.print("No file found/wrong tokens in file");
			exception.printStackTrace();
		}

		
		try {
			FileWriter out2= new FileWriter("output.txt");
			for (int element : counterArray) {
				out2.write(element + " ");
			}
			out2.flush();
			out2.close();
		}
		catch (IOException e) {
			System.out.print("NoFileFound");
			e.printStackTrace();
		}


	}

}
