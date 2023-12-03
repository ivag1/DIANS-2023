import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PipeAndFilterProblem {
public static List<String> names = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        ClassLoader loader = PipeAndFilterProblem.class.getClassLoader();

           File file = new File("C:\\Users\\Desktop\\Downloads\\data-4.csv");
           FileReader fr = new FileReader(file);
           BufferedReader bufferedReader = new BufferedReader(fr);
           String line;
           String[] array;

           while((line=bufferedReader.readLine())!=null){
               Pipe<String> pipe = new Pipe();
               pipe.addFilter(new RemoveUnimportantColumns());
               pipe.addFilter(new RemoveRowsWithoutNames());
               System.out.println(pipe.runFilters(line));
           }
        bufferedReader.close();
FileWriter writer = new FileWriter("data.csv");
String collect = String.join(",", names);
        writer.write(collect);
        writer.close();

        FileReader f = new FileReader("data.csv");
        BufferedReader br = new BufferedReader(f);
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
}
