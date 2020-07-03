import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String InputDirectory = "D:\\Java\\PubMed_2016_Parsed";
        String OutputDirectory = "D:\\Java\\PubMed_2016_Parsed_Statistic";
        String Criteria = "_WordCnt_NoStopwords.txt";
        String StopwordsFileLocation = "D:\\Java\\common-english-words.txt";
        HashMap Stopwords = new HashMap<String,Integer>();
        Stopwords =PatternsFileToMap.FileToMap(StopwordsFileLocation);

        File folder = new File(InputDirectory);
        int a=0;
        for (final File fileEntry : folder.listFiles()) {
            String OneFile = fileEntry.getName();
            String InputFileName = OneFile;
            String InputFileLocation = InputDirectory+"\\"+InputFileName;
            String [] InputFileNameInfo = InputFileName.split("\\.");
            String OutputFileName = InputFileNameInfo[0]+Criteria;
            String OutputFileLocation = OutputDirectory+"\\"+OutputFileName;

            int limit=50;
            String str;
            int count = 0;
            FileReader file = new FileReader(InputFileLocation);
            BufferedReader bfr = new BufferedReader(file);
            TreeMap wordcount = new TreeMap<String,Integer>();

            while ((str = bfr.readLine()) != null) {
                count++;
                String[] Items = new String(str).trim().split("##");
                if (Items.length>=3){
                    String[] Items_words = new String(str).trim().replaceAll("\\d+", "").split("\\W+");
                    for (int i = 0; i < Items_words.length; i++) {
                        String s1="";
                        String OneWordLower = Items_words[i].toLowerCase();
                        if (OneWordLower.equals(s1)){

                        }
                        else if  (!Stopwords.containsKey(OneWordLower)){
                            if(wordcount.containsKey(OneWordLower)) {
                                Integer number = (int) wordcount.get(OneWordLower);
                                number++;
                                wordcount.put(OneWordLower, number);
                            } else {
                                wordcount.put(OneWordLower, 1);
                            }
                        }
                    }
                }
            }
            file.close();
            FileWriter fw = new FileWriter(OutputFileLocation);
            BufferedWriter bfw = new BufferedWriter(fw);
            Map sortedMap = sortByValues(wordcount);
            Set set = sortedMap.entrySet();
            Iterator i = set.iterator();
            int cnt=0;
            a++;
            for (int j=1;j<=12;j++) {
                if (a == 1) {
                    System.out.println("January-------------------Top 50 ");
                    System.out.println();
                    bfw.write("January-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 2) {
                    System.out.println("February-------------------Top 50 ");
                    System.out.println();
                    bfw.write("February-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 3) {
                    System.out.println("March-------------------Top 50 ");
                    System.out.println();
                    bfw.write("March-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 4) {
                    System.out.println("April-------------------Top 50 ");
                    System.out.println();
                    bfw.write("April-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 5) {
                    System.out.println("May-------------------Top 50 ");
                    System.out.println();
                    bfw.write("May-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 6) {
                    System.out.println("June-------------------Top 50 ");
                    System.out.println();
                    bfw.write("June-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 7) {
                    System.out.println("July-------------------Top 50 ");
                    System.out.println();
                    bfw.write("July-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 8) {
                    System.out.println("August-------------------Top 50 ");
                    System.out.println();
                    bfw.write("August-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 9) {
                    System.out.println("September-------------------Top 50 ");
                    System.out.println();
                    bfw.write("September-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 10) {
                    System.out.println("October-------------------Top 50 ");
                    System.out.println();
                    bfw.write("October-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else if (a == 11) {
                    System.out.println("November-------------------Top 50 ");
                    System.out.println();
                    bfw.write("November-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                } else {
                    System.out.println("December-------------------Top 50 ");
                    System.out.println();
                    bfw.write("December-------------------Top 50 ");
                    bfw.newLine();
                    bfw.newLine();
                    break;
                }
            }
            while(i.hasNext() && cnt<limit) {
                cnt++;
                Map.Entry me = (Map.Entry)i.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
                bfw.write(me.getKey() + ": " + me.getValue());
                bfw.newLine();
                bfw.flush();
            }
        }
        System.out.println(" ");
    }
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map)
    {
        Comparator<K> valueComparator = new Comparator<K>()
        {
            public int compare(K k1, K k2) {
                int compare =  map.get(k2).compareTo(map.get(k1));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };

        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
