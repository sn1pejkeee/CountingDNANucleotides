import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.HashMap;

public class Maker {
	
	public String FASTAreader(BufferedReader br) throws IOException {
		String line = "";
		StringBuffer TokenB = new StringBuffer();
		while (line != null) {
			TokenB.append(line);
			line = br.readLine();
			if ((line != null) && (line.substring(0, 1).compareTo(">") == 0))
				break;
		}
		return TokenB.toString();
	}
	
	public static void main(String[] args) {
		HashMap<String, String> transition = new HashMap<>();
		transition.put("A", "G");
		transition.put("G", "A");
		transition.put("C", "T");
		transition.put("T", "C");
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			br.readLine();
			Maker ex = new Maker();
			String Token = ex.FASTAreader(br);
			String Token2 = ex.FASTAreader(br);
			String aSymbol;
			String aSymbol2;
			double transitionR = 0;
			double transversionR = 0;
			for (int i = 0; i <= Token.length() - 1; i++) {
				aSymbol = Token.substring(i, i + 1);
				aSymbol2 = Token2.substring(i, i + 1);
				if (!aSymbol.equals(aSymbol2))
					if (transition.get(aSymbol).equals(aSymbol2))
						transitionR++;
					else 
						transversionR++;
			}
			double ratio = transitionR / transversionR;
			out.write(new Double(ratio).toString());
			out.flush();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
