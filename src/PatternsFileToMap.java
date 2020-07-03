import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PatternsFileToMap {
    public static HashMap<String, Integer> FileToMap(String FileLocation) throws IOException {

        FileReader fr=new FileReader(FileLocation);
        BufferedReader bfr = new BufferedReader(fr);

        HashMap<String, Integer> PatternsMap = new HashMap <String, Integer>();

        String str;
        while ((str=bfr.readLine()) != null){
            str.trim();
            String [] Patterns = str.split(",");
            for (String OnePattern : Patterns ) {
                //System.out.println(OnePattern);
                PatternsMap.put(OnePattern, 0);
            }
        } // End of while
        bfr.close();
        fr.close();
        return PatternsMap;
    } // End of public static void main(String[] args) throws IOException
}
