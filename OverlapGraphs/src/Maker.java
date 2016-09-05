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
			String name = "";
			StringBuilder builder = new StringBuilder();
			String help;
			Graph graph = new Graph();
			boolean cs = false;
			for(String line: lines){
				
				if (line.substring(0, 1).equals(">")) {
					if (cs) {
						
						help = builder.toString();
						builder.delete(0, builder.length());
						Node newOne = new Node(name, help.substring(0, 3), help.substring(help.length() - 3));
						graph.addNew(newOne);
						}
					name = line.substring(1);
				}
				else {
					builder.append(line);
					cs = true;
				}
			}
			help = builder.toString();
			Node lastOne = new Node(name, help.substring(0, 3), help.substring(help.length() - 3));
			graph.addNew(lastOne);
			for (String line : graph.getInfo()) {
				out.write(line);
				out.newLine(); //last space TODO maybeee
			}
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
