class Readcolumn {
 public static List<String> getSpecificColumn(String columnName,CSVReader reader) throws IOException {
        String [] headers=reader.readNext();
        int position=-1;
        for(int i=0;i<headers.length;i++){
            if(headers[i].trim().equals(columnName)){
                position=i;
                break;
            }
        }
        System.out.println("Position: "+position);
        List<String> column=new ArrayList<>();
        String []s;
        while((s = reader.readNext())!=null){
            column.add(s[position]);
        }
        return column;
    }
}