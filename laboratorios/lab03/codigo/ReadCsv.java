
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Santiago Santacruz && Duvan Andres Ramirez
 */
public class ReadCsv {
    
         
    
    public static List<String[]> ReadCsvFile(String path) throws IOException
    {
        FileReader fr = new FileReader(path);
        List<String[]> matValues = new ArrayList<String[]>();
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String COMMA_DELIMITER = ",";
                String[] values = line.split(COMMA_DELIMITER);
                //System.out.println(values);
                matValues.add(values);
                //records.add(Arrays.asList(values));
            }
        }
        return matValues;
    }
    
    
}
