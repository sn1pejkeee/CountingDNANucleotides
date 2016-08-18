import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Maker {

	public static void main(String[] args) {
		int counter = 3;
		Map<String, Integer> table = new HashMap<>();
		table.put("F", 2);
		table.put("L", 6);
		table.put("S", 6);
		table.put("Y", 2);
		table.put("C", 2);
		table.put("W", 1);
		table.put("P", 4);
		table.put("H", 2);
		table.put("Q", 2);
		table.put("R", 6);
		table.put("I", 3);
		table.put("M", 1);
		table.put("T", 4);
		table.put("N", 2);
		table.put("K", 2);
		table.put("V", 4);
		table.put("A", 4);
		table.put("D", 2);
		table.put("E", 2);
		table.put("G", 4);
		
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			
			for (int i = 0; i <= Token.length() - 1; i++) {
				counter = counter * table.get(Token.substring(i, i + 1));
				counter = counter % 1000000;
			}
			out.write(new Integer(counter).toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
