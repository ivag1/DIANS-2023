import java.util.Arrays;

public class RemoveUnimportantColumns implements Filter<String>{

    @Override
    public String execute(String input) {
        String[] fields = input.split(",");
        if(fields.length>2){
            if(fields[2]==null){
                return "";
            }else return fields[2];
        }
        else return "";
    }
}
