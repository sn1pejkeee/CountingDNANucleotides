import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class Maker {

	public static void main(String[] args) {
		List<String> lines;
		//testup
		try (BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))){
			lines = Files.readAllLines(Paths.get("input.txt"), StandardCharsets.UTF_8);
			int n = Integer.parseInt(lines.get(0));
			boolean[] setA = new boolean[n + 1];
			boolean[] setB = new boolean[n + 1];
			lines.remove(0);
			int flag = 0;
			for (String s : lines) {
				if (s.substring(0, 1).equals("{"))
					flag++;
				s = s.replaceAll(Pattern.quote("}"), "");
				s = s.replaceAll(Pattern.quote("{"), "");
				s = s.replaceAll(Pattern.quote(","), "");
				for (String part : s.split(" ")) {
					if (flag < 2) 
						setA[Integer.parseInt(part)] = true;
					else
						setB[Integer.parseInt(part)] = true;
				}
				
			}

			StringBuilder Union = new StringBuilder("{");
			StringBuilder Intersection = new StringBuilder("{");
			StringBuilder notB = new StringBuilder("{");
			StringBuilder notA = new StringBuilder("{");
			StringBuilder complementA = new StringBuilder("{");
			StringBuilder complementB = new StringBuilder("{");
			for (int i = 1; i <= n; i++) {
				if (setA[i] | setB[i])
					Union.append(i + ", ");
				if (setA[i] && setB[i])
					Intersection.append(i + ", ");
				if (setA[i] && !setB[i])
					notB.append(i + ", ");
				if (!setA[i] && setB[i])
					notA.append(i + ", ");
				if (!setA[i])
					complementA.append(i + ", ");
				if (!setB[i])
					complementB.append(i + ", ");
			}
			Union.replace(Union.length() - 2, Union.length(), "}");
			Intersection.replace(Intersection.length() - 2, Intersection.length(), "}");
			notB.replace(notB.length() - 2, notB.length(), "}");
			notA.replace(notA.length() - 2, notA.length(), "}");
			complementA.replace(complementA.length() - 2, complementA.length(), "}");
			complementB.replace(complementB.length() - 2, complementB.length(), "}");
			out.write(Union.toString());
			out.newLine();
			out.write(Intersection.toString());
			out.newLine();
			out.write(notB.toString());
			out.newLine();
			out.write(notA.toString());
			out.newLine();
			out.write(complementA.toString());
			out.newLine();
			out.write(complementB.toString());
			 
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
