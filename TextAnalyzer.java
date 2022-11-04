import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
// TODO: Auto-generated Javadoc

/**
 * TextAnalyser class is used to display the top 20 most frequent
 * words in the poem "Raven".
 *
 * @author Fatima Beyelhadj
 * @version 3.0
 */

public class TextAnalyzer {
	
	/**
	 *  Method countFrequencies process the poem file.
	 *  This change all characters to lower case and remove special
	 *  characters before counting the words frequencies.
	 *
	 * @param fileName the file name
	 * @param stats the stats
	 * @throws FileNotFoundException the file not found exception
	 */
	static void countFrequencies(String fileName, Map<String, Integer> stats) throws FileNotFoundException {
	
		Scanner file = new Scanner(new File(fileName));
		file.toString().equalsIgnoreCase(fileName);
		file.toString().replace("/", "");
		file.toString().replace("-", "");	
		file.toString().replace(";", "");
		file.toString().replace("”", "");
		file.toString().replace(".", "");
		file.toString().replace(",", "");
		file.toString().replace("!", "");
		file.toString().replace("“", "");
		
		
			
		while (file.hasNext() ) {
			String word = file.next();
			Integer count = stats.get(word);
			if (count != null)
				count++;
			else
				count = 1;
			stats.put(word, count);
		}
		file.close();
	}
	
	/**
	 * This is main where a map with a stream is used to display the top 20 words and their count
	 * from the most to least frequent.
	 *
	 * @param args Poem file
	 * @throws FileNotFoundException throw file not found error in case of no file found
	 */

	public static void main(String[] args) throws FileNotFoundException {
		
		Map<String, Integer> stats = new HashMap<String, Integer>();
		countFrequencies("C:\\Users\\fatim\\eclipse-workspace\\SDLC Assignment\\TheRavenPoem.txt", stats);
		System.out.println("The Reven Poem Words and their frequencies sorted ");
		stats.entrySet().stream().sorted(
			Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
		.limit(20)	 
		 .collect(Collectors.toMap(
                 Map.Entry::getKey,
                 Map.Entry::getValue,
                 (e1, e2) -> e1,
                 LinkedHashMap::new
                 
         )).forEach((s, integer) -> System.out.println(String.format("%s : %s", s, integer)));
		

	}

	

}
