public class ReadCSV {
    public static void read(String[]args) throws IOException {
        File f=new File("Wine.csv");
        CSVReader reader=new CSVReader(new BufferedReader(new FileReader(f)));
        String[] headers=reader.readNext(); //Read Headers first.
        String[]s;
        //System.out.print(Arrays.toString(headers));
        System.out.println();
        while((s = reader.readNext())!=null){
            for(String i : s){
                System.out.print(i+" ");
            }
            System.out.println();
        }
