import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;

public class Maker {
	public int fact(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	public void binAdd (int[] array) {
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == 0) {
				array[i] = 1;
				for (int k = i + 1; k <= array.length - 1; k++)
					array[k] = 0;
				break;
			}
		}
		
	}
	public void binMult (int[] bin, int[] aPerm) {
		for (int i = 0; i <= bin.length - 1; i++) {
			aPerm[i] *= (int)Math.pow(-1, bin[i]);
		}
		
	}

	public void signer(int[] perm, BufferedWriter out) throws IOException {
		int[] bin = new int[perm.length];
		
		int[] copy = Arrays.copyOf(perm, perm.length);
		for (int i = 0; i <= (int)Math.pow(2, perm.length) - 1; i++) {
			binMult(bin, copy);
			out.write(writer(copy));
			if (i != (int)Math.pow(2, perm.length) - 1)
				out.newLine();
			binAdd(bin);
			copy = Arrays.copyOf(perm, perm.length);;
		}
	}
	public String writer(int[] n) {
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
			Maker ex = new Maker();
			int n = Integer.parseInt(Token);
			int[] perm = new int[n];
			int i = n - 2;
			int edge = ex.fact(n) - 1; // normal permutations counter
			int edgeSigned = (edge + 1) * (int)Math.pow(2, n); //signed counter
			for (int k = 0; k <= n - 1; k++) {
				perm[k] = k + 1;
			}
			out.write(new Integer(edgeSigned).toString());
			out.newLine();
			ex.signer(perm, out);
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
				ex.signer(perm, out);
				if (z!= edge)
					out.newLine();
			}
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
