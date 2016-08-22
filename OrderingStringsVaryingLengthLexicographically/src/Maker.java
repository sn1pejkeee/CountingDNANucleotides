import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class Maker {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			Token = Token.replaceAll(" ", "");
			int i = Token.length();
			int n = Integer.parseInt(br.readLine());
			int max = (int)Math.pow(i, n);
			StringBuffer kmer = new StringBuffer();
			for (int k = 0; k <= n - 1; k++) {
				kmer.append(Token.substring(0, 1));
				out.write(kmer.toString());
				out.newLine();
			}
			
			int c = n - 1;
			int help;
			for (int k = 1; k <= max - 1; k++) {
				while (Token.substring(i - 1).equals(kmer.substring(c, c + 1))) {
					c--;
				}
				help = Token.indexOf(kmer.substring(c, c + 1)) + 1;
				kmer.replace(c, c + 1, Token.substring(help, help + 1));
				for (int z = c + 1; z <= n - 1; z++) {
					kmer.replace(z, z + 1, Token.substring(0, 1));
				}
				if (c < n - 1)
					for (int j = c; j < n - 1; j++) {
						out.write(kmer.substring(0, j + 1));
						out.newLine();
					}
				out.write(kmer.toString());
				if (k != max - 1)
					out.newLine();
				c = n - 1;
			}
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
