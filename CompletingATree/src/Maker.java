import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Maker {
	


	public static void main(String[] args) {
		List<String> lines;
	
		try (BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))){
			lines = Files.readAllLines(Paths.get("input.txt"), StandardCharsets.UTF_8);
			Graph graph = new Graph(lines);
			int q = graph.counter();
			out.write(new Integer(q).toString());
			out.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
