import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Maker {

	public static void main(String[] args) {
		String LineOne = "";
		String LineTwo = "";
		int ham = 0;
		try {
			Scanner in = new Scanner(Paths.get("input.txt"));
			LineOne = in.nextLine();
			LineTwo = in.nextLine();
			for (int i = 0; i <= LineOne.length() - 1; i++) {
				if (LineOne.charAt(i) != LineTwo.charAt(i))
					ham++;
			}
			in.close();
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	
		try {
			FileWriter out2= new FileWriter("output.txt");
			out2.write(new Integer(ham).toString());
			out2.flush();
			out2.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
