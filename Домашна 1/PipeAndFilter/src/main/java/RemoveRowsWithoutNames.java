public class RemoveRowsWithoutNames implements Filter<String>{

    @Override
    public String execute(String input) {
        //String[] fields = input.split(",");

            if(input==null||input.equals("")){
                return "";}
            else{
                PipeAndFilterProblem.names.add(input);
                return input;
                }

    }
}
