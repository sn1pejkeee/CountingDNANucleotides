import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

public class Maker {

	public static double BinC (int n, int k) {
		double res = 1;
		for (int i = 0; i <= k - 1; i++) {
			res = res * (n - i) / (i + 1);
		}
		return res;
	}
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			ArrayList<Integer> number= new ArrayList<>();
			for (String field : Token.split(" "))
				number.add(Integer.parseInt(field));
			int k = number.get(0);
			int N = number.get(1);
			double prob = 0;
			int gen = (int)Math.pow(2, k);
			for (int i = 0; i <= N - 1; i++) {
				prob += BinC(gen, i) * Math.pow(0.25, i) * Math.pow(0.75, gen - i);
			}
			prob = 1 - prob;
			out.write(new Double(prob).toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();

		}
	}

}
