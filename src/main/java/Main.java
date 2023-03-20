public class Main {

    public static void main(String[] args) {
        String filename = args[0];
        String searchCriteria = args[1];
        String searchValue = args[2];

        BatchController batchController = new BatchController(filename,searchCriteria, searchValue);
        batchController.processFile();
    }
}
