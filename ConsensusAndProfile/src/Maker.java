import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.stream.IntStream;

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
	
	public String printer(int[] arr) {
		StringBuffer B = new StringBuffer();
		for (int i = 0; i < arr.length - 1; i++) {
			B.append(arr[i] + " ");
		}
		B.append(arr[arr.length - 1]);
		return B.toString();
	}
	public int Cons(int[] arr) {
		int counter = 0;
		for (int i = 1; i <= arr.length - 1; i++) {
			if (arr[i] > arr[counter])
				counter = i;
		}
		return counter;
	}
	
	public int[] getColumn(int[][] matrix, int column) {
	    return IntStream.range(0, matrix.length)
	        .map(i -> matrix[i][column]).toArray();
	}
	
	
	public static void main(String[] args) {
		String symb = "ACGT";
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			br.readLine();
			Maker ex = new Maker();
			String Token = ex.FASTAreader(br);
			
			int[][] profile = new int[4][Token.length()];
			while (!Token.equals("")) {
				for (int i = 0; i <= Token.length() - 1; i++) {
					switch (Token.charAt(i)) {
					case 'A' :
						profile[0][i]++;
						break;
					case 'C' :
						profile[1][i]++;
						break;
					case 'G' :
						profile[2][i]++;
						break;
					case 'T' :
						profile[3][i]++;
						break;
					}
				}
				
				Token = ex.FASTAreader(br);
			}

			StringBuffer TokenB = new StringBuffer();
			int number;
			for (int i = 0; i <= profile[1].length - 1; i++) {
				number = ex.Cons(ex.getColumn(profile, i));
				TokenB.append(symb.substring(number, number + 1));
			}
			out.write(TokenB.toString());
			out.newLine();
			for (int i = 0; i < 3; i++) {
				out.write(symb.charAt(i) + ": " + ex.printer(profile[i]));
				out.newLine();
			}
			out.write(symb.charAt(3) + ": " + ex.printer(profile[3]));
			out.flush();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
