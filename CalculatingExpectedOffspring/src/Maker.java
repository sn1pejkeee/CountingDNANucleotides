import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

public class Maker {

	public static void main(String[] args) throws FileNotFoundException{
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			ArrayList<Integer> number= new ArrayList<>();
			for (String field : Token.split(" "))
				number.add(Integer.parseInt(field));
			double res = 2 * number.get(0) + 2 * number.get(1) + 2 * number.get(2) 
							+ 1.5 * number.get(3) + number.get(4);
			
			out.write(new Double(res).toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
