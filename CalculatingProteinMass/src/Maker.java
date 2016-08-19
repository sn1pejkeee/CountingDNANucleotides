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
		
		Map<String, Double> table = new HashMap<>();
		table.put("F", 147.06841);
		table.put("L", 113.08406);
		table.put("S", 87.03203);
		table.put("Y", 163.06333);
		table.put("C", 103.00919);
		table.put("W", 186.07931);
		table.put("P", 97.05276);
		table.put("H", 137.05891);
		table.put("Q", 128.05858);
		table.put("R", 156.10111);
		table.put("I", 113.08406);
		table.put("M", 131.04049);
		table.put("T", 101.04768);
		table.put("N", 114.04293);
		table.put("K", 128.09496);
		table.put("V", 99.06841);
		table.put("A", 71.03711);
		table.put("D", 115.02694);
		table.put("E", 129.04259);
		table.put("G", 57.02146);
		
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			double mass = 0;
			for (int i = 0; i <= Token.length() - 1; i++) {
				mass += table.get(Token.substring(i, i + 1));
			}
			out.write(new Double(mass).toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
