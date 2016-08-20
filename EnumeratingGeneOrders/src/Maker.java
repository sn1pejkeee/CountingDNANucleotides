import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class Maker {
	public static int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	
	public static String writer(int[] n) {
		StringBuffer q = new StringBuffer();
		for (int i = 0; i <= n.length - 1; i++) {
			q.append(n[i] + " ");
		}
		String res = q.toString();
		return res;
	}

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
				BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))) {
			String Token = br.readLine();
			int n = Integer.parseInt(Token);
			int[] perm = new int[n];
			int i = n - 2;
			int edge = fact(n) - 1;
			for (int k = 0; k <= n - 1; k++) {
				perm[k] = k + 1;
			}
			out.write(new Integer(edge + 1).toString());
			out.newLine();
			out.write(writer(perm));
			out.newLine();
			for (int z = 1; z <= edge; z++) {
				i = n - 2;
				while (i >= 0 && perm[i] >= perm[i + 1]) 
					i = i - 1;
				
				if (i >= 0) {
					int j = n - 1;
					while (perm[i] > perm[j]) 
						j = j - 1;
					int temp = perm[i];
					perm[i] = perm[j];
					perm[j] = temp;

				}

				for (int l = i + 1, k = n - 1; l < k; l = l + 1, k = k - 1) {
					int temp = perm[l];
					perm[l] = perm[k];
					perm[k] = temp;
				}
				out.write(writer(perm));
				if (z != edge) 
					out.newLine();
			}
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
