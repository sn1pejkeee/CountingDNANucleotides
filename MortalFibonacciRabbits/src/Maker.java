import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;

public class Maker {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			ArrayList<Integer> number= new ArrayList<>();
			for (String field : Token.split(" "))
				number.add(Integer.parseInt(field));
			int n = number.get(0);
			int m = number.get(1);
			BigInteger[] gen = new BigInteger[m];
			gen[0] = BigInteger.valueOf(1);
			for (int i = 1; i <= m - 1; i++)
				gen[i] = BigInteger.valueOf(0);
			BigInteger sum = BigInteger.valueOf(0);
			for (int i = 2; i <= n; i++) {
				for (int k = m - 1; k >= 1; k--) {
					sum = sum.add(gen[k]);
					gen[k] = gen [k - 1];
				}
				gen[0] = sum;
				sum = BigInteger.valueOf(0);
			}
			for (int i = 0; i <= m - 1; i++)
				sum = sum.add(gen[i]);
			out.write(sum.toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
