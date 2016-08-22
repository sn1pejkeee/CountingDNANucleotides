import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

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
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			br.readLine();
			Maker ex = new Maker();
			String Token = ex.FASTAreader(br);
			String sample = ex.FASTAreader(br);
			StringBuffer indices = new StringBuffer();
			int index = 0;
			for (int i = 0; i <= sample.length() - 1; i++) {
				
				indices.append(Token.indexOf(sample.charAt(i), index + 1) + 1 + " ");
				index = Token.indexOf(sample.charAt(i), index + 1);
				
			}
			indices.delete(indices.length() - 1, indices.length()); //deleting the last space
			out.write(indices.toString());
			
			out.flush();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
