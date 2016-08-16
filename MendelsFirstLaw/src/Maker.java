import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Maker {

	public static void main(String[] args) {
		//String Token = "";
		int k = 0;
		int m = 0;
		int n = 0;
		double prob = 0;
		double probN = 0;
		
		try {
			Scanner in = new Scanner(Paths.get("input.txt"));
			k = in.nextInt();
			m = in.nextInt();
			n = in.nextInt();
			prob = (m * n + m * (m - 1) * 0.25 + n * (n - 1)) / ((k + m + n) * (k + m + n - 1));
			probN = 1 - prob;
			
			in.close();
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	
		try {
			FileWriter out2= new FileWriter("output.txt");
			out2.write(new Double(probN).toString());
			out2.flush();
			out2.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
