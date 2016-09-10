import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Maker {
	
	public static BigInteger fact(int number) {
		BigInteger result = new BigInteger("1");
		BigInteger mult = new BigInteger("2");
		
		for (int i = 2; i <= number; i++) {
			mult = BigInteger.valueOf((long)i);
			result = result.multiply(mult);
		}
		return result;
	}

	public static void main(String[] args) {
		int occG = 0, occA = 0;
		List<String> lines;
		try (BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))){
			lines = Files.readAllLines(Paths.get("input.txt"), StandardCharsets.UTF_8);
			lines.remove(0);
			for (String line : lines) {
				for (int i = 0; i <= line.length() - 1; i++) {
					if ((line.charAt(i) == 'A') || (line.charAt(i) == 'U'))
						occA++;
					else
						occG++;
				}
			}
			occA = occA / 2;
			occG = occG / 2;
			//System.out.println(fact(occA).toString());
			BigInteger res = new BigInteger("1");
			res = (res.multiply(fact(occA))).multiply(fact(occG));
			out.write(res.toString());
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
