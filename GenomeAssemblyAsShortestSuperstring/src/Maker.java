import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Maker {
	
    private static int overlap(String s1, String s2)
    {
      int s1last = s1.length() - 1;
      int s2len = s2.length();
      int overlap = 0;
      for (int i = s1last, j = 1; i > 0 && j < s2len; i--, j++)
      {
        String suff = s1.substring(i);
        String pref = s2.substring(0, j);
        if (suff.equals(pref)) overlap = j; 
      }
      return overlap;
    }
    
    private static String merge(String s1, String s2, int overlap) {
    	String LUL = s2.substring(overlap);
    	return s1 + LUL;
    }

	public static void main(String[] args) {
		  List<String> lines;
		  LinkedList<String> strings = new LinkedList<>();
		  LinkedList<String> copy = new LinkedList<>();
		try (BufferedWriter out = Files.newBufferedWriter(FileSystems.getDefault().getPath("output.txt"))){
			lines = Files.readAllLines(Paths.get("input.txt"), StandardCharsets.UTF_8);
			String superString;
			StringBuilder reader = new StringBuilder();
			lines.remove(0);
			for (String line : lines) {
				if (line.startsWith(">")) {
					strings.add(reader.toString());
					copy.add(reader.toString());
					reader.delete(0, reader.length());
					continue;
				}
				reader.append(line);
			}
			strings.add(reader.toString());
			copy.add(reader.toString());
			int maxoverlap = 0;
			String i1, i2;
			int helper;
			while (strings.size() > 1) {
				i1 = strings.get(0);
				i2 = strings.get(1);
				for (String s1 : strings)
					for (String s2 : strings) {
						if (s1.equals(s2))
							continue;
						helper = overlap(s1, s2);
						if (helper >= maxoverlap) {
							i1 = s1;
							i2 = s2;
							maxoverlap = helper;
						}
					}
				strings.add(merge(i1, i2, maxoverlap));
				
				strings.remove(i1);
				strings.remove(i2);
				maxoverlap = 0;
			} 

			superString = strings.get(0);
			out.write(superString);
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
