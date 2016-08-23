import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

public class Maker {
	
	public ArrayList<Double> parser(String token) {
		ArrayList<Double> list = new ArrayList<>();
		for (String field :token.split(" "))
			list.add(Double.parseDouble(field));
		return list;
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			StringBuffer TokenB = new StringBuffer();
			for (int i = 0; i <= Token.length() - 1; i++) {
				switch (Token.charAt(i)) {
				case 'A':
					TokenB.append(1);
					break;
				case 'C':
					TokenB.append(0);
					break;
				case 'G':
					TokenB.append(0);
					break;
				case 'T':
					TokenB.append(1);
					break;
					
				}
			}
			String tokenParsed = TokenB.toString();
			
			Maker ex = new Maker();
			ArrayList<Double> list = ex.parser(br.readLine());
			double prob = 1;
			double probGC, probOther;
			for (int i = 0; i <= list.size() - 1; i++) {
				probGC = list.get(i) / 2;
				probOther = 0.5 - probGC;
				for (int k = 0; k <= Token.length() - 1; k++) {
					switch (tokenParsed.charAt(k)) {
					case '1':
						prob *= probOther;
						break;
					case '0':
						prob *= probGC;
						break;
					}
				}
				out.write(new Double(Math.log10(prob)).toString() + " ");
				prob = 1;
			}
			out.flush();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
