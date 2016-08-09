import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

import java.nio.file.Paths;
public class Maker {

	public static void main(String[] args) {
		String Token = "";
		try {
			Scanner in = new Scanner(Paths.get("input.txt"));
			Token = in.next();
			Token = Token.replace('T', 'U');
			in.close();
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	
		try {
			FileWriter out2= new FileWriter("output.txt");
			out2.write(Token);
			out2.flush();
			out2.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
