public class DropboxUpload {

 public  String uploadandsharelink(DbxClientV2 client,String filepath) throws FileNotFoundException, DbxException {
        InputStream in=new FileInputStream(filepath);
        File file=new File(filepath);
        String fileName=file.getName();
        String uploadPath="/upload/"+fileName;
        try {
            FileMetadata fileMetadata=client.files().uploadBuilder(uploadPath).uploadAndFinish(in);
            String all=fileMetadata.toStringMultiline();
            System.out.println(all);
        } catch (IOException e) {
            e.printStackTrace();
            return "Can't work"
        }
        var result=client.files().getTemporaryLink(uploadPath);
        String link=result.getLink();
        System.out.println(link);
        return link; 

    }

}