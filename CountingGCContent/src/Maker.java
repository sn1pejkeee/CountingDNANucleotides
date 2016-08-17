import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class Maker {

	public static void main(String[] args) throws FileNotFoundException {
		String Token = "";
		StringBuffer TokenB = new StringBuffer();
		String maxNumber = "";
		String currentNumber = "";
		double maxGC = 0;
		double currentGC = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String line = br.readLine();
			maxNumber = line;
			while (line != null) {
				if (line.substring(0, 1).compareTo(">") == 0) {
					currentNumber = line;
					line = br.readLine();
					while (line != null) {
						TokenB.append(line);
						line = br.readLine();
						if ((line != null) && (line.substring(0, 1).compareTo(">") == 0))
							break;
					}
				}
				Token = TokenB.toString();
				TokenB.delete(0, TokenB.length());
				for (int i = 0; i <= Token.length() - 1; i++) {
					if ((Token.charAt(i) == 'G') || (Token.charAt(i) == 'C'))
						currentGC++;
				}
				currentGC = currentGC / Token.length();
				if (currentGC > maxGC) {
					maxNumber = currentNumber;
					maxGC = currentGC;
				}
				currentGC = 0;
			}
			out.write(maxNumber.substring(1));
			out.newLine();
			out.write(new Double(maxGC * 100).toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}


		
	}

}
