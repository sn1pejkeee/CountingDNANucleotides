import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Maker {

	public static void main(String[] args) {
		String Token = "";
		try {
			Scanner in = new Scanner(Paths.get("input.txt"));
			Token = in.next();
			StringBuffer TokenBuffer = new StringBuffer(Token);
			TokenBuffer = TokenBuffer.reverse();
			//Token = TokenBuffer.toString();
			for (int i = 0; i <= TokenBuffer.length() - 1; i++) {
				switch (TokenBuffer.charAt(i)) {
				case 'A':
					TokenBuffer.replace(i, i + 1, "T");
					break;
				case 'T':
					TokenBuffer.replace(i, i + 1, "A");
					break;
				case 'C':
					TokenBuffer.replace(i, i + 1, "G");
					break;
				case 'G':
					TokenBuffer.replace(i, i + 1, "C");
					break;
				}
			}
			Token = TokenBuffer.toString();
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
