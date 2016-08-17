import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Maker {

	public static void main(String[] args) {
		String aString = "";
		String sample = "";
		int index = 0;
		try {
			Scanner in = new Scanner(Paths.get("input.txt"));
			FileWriter out2= new FileWriter("output.txt");
			aString = in.nextLine();
			sample = in.nextLine();
			while (aString.indexOf(sample, index) >= 0) {
				out2.write(new Integer(aString.indexOf(sample, index) + 1).toString() + " ");
				index = aString.indexOf(sample, index) + 1;
			}
			
			in.close();
			out2.flush();
			out2.close();
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}

	}

}
