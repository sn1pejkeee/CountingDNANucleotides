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
		String Token = "";
		String intron = "";
		String sample  = "";
		Map<String, String> table = new HashMap<>();
		table.put("UUU", "F"); table.put("AUU", "I");
		table.put("UUC", "F"); table.put("AUC", "I");
		table.put("UUA", "L"); table.put("AUA", "I");
		table.put("UUG", "L"); table.put("AUG", "M");
		table.put("UCU", "S"); table.put("ACU", "T");
		table.put("UCC", "S"); table.put("ACC", "T");
		table.put("UCA", "S"); table.put("ACA", "T");
		table.put("UCG", "S"); table.put("ACG", "T");
		table.put("UAU", "Y"); table.put("AAU", "N");
		table.put("UAC", "Y"); table.put("AAA", "K");
		table.put("UAA", "Stop"); table.put("AAG", "K");
		table.put("UAG", "Stop"); table.put("AGU", "S");
		table.put("UGU", "C"); table.put("AGC", "S");
		table.put("UGC", "C"); table.put("AGA", "R");
		table.put("UGA", "Stop"); table.put("AGG", "R");
		table.put("UGG", "W"); table.put("GUU", "V");
		table.put("CUU", "L"); table.put("GUC", "V");
		table.put("CUC", "L"); table.put("GUA", "V");
		table.put("CUA", "L"); table.put("GUG", "V");
		table.put("CUG", "L"); table.put("GCU", "A");
		table.put("CCU", "P"); table.put("GCC", "A");
		table.put("CCC", "P"); table.put("GCA", "A");
		table.put("CCA", "P"); table.put("GCG", "A");
		table.put("CCG", "P"); table.put("GAU", "D");
		table.put("CAU", "H"); table.put("GAC", "D");
		table.put("CAC", "H"); table.put("GAA", "E");
		table.put("CAA", "Q"); table.put("GAG", "E");
		table.put("CAG", "Q"); table.put("GGU", "G");
		table.put("CGU", "R"); table.put("GGC", "G");
		table.put("CGC", "R"); table.put("GGA", "G");
		table.put("CGA", "R"); table.put("GGG", "G");
		table.put("CGG", "R"); table.put("AAC", "N");
		StringBuffer TokenB = new StringBuffer();
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				TokenB.append(line);
				line = br.readLine();
				if ((line != null) && (line.substring(0, 1).compareTo(">") == 0))
					break;
			}
			Token = TokenB.toString();
			TokenB.delete(0, TokenB.length());
			while (line != null) {
				if (line.substring(0, 1).compareTo(">") == 0) {
					
					line = br.readLine();
					while (line != null) {
						TokenB.append(line);
						line = br.readLine();
						if ((line != null) && (line.substring(0, 1).compareTo(">") == 0))
							break;
					}
				}
			intron = TokenB.toString();	
			TokenB.delete(0, TokenB.length());
			Token = Token.replaceAll(intron, "");
			}
			Token = Token.replaceAll("T", "U");
			//out.write(Token);
			int i = 0;
			while (i + 3 <= Token.length() - 1) {
				sample = Token.substring(i, i + 3);
				sample = table.get(sample);
				if (sample.compareTo("Stop") != 0)
					out.write(sample);
				else
					break;
				i = i + 3;
			}
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
