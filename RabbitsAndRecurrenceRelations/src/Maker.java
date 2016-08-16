import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Maker {

	public static void main(String[] args) {
		//String Token = "";
		int k = 0;
		int n = 0;
		long now = 1;
		long prev = 1;
		long help = 0;
		
		try {
			Scanner in = new Scanner(Paths.get("input.txt"));
			n = in.nextInt();
			k = in.nextInt();
			for (int i = 2; i <= n - 1; i++) {
					help = prev;
					prev = now;
					now = now + k * help;
			}
			
			in.close();
		}
		catch (IOException exception) {
			exception.printStackTrace();
		}
	
		try {
			FileWriter out2= new FileWriter("output.txt");
			out2.write(new Long(now).toString());
			out2.flush();
			out2.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
