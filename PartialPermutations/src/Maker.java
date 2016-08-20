import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
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
			int k = number.get(1);
			int res = n;
			for (int i = 1; i <= k - 1; i++) {
				res *= (n - i);
				res = res % 1000000;
			}
			out.write(new Integer(res).toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
