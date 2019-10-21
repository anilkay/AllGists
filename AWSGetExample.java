public class AWSGetExample {
String bucketName="your bucket name";
String objectName="wanted object name"
public void dowload(){
    GetObjectRequest objectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectName)
                .build();
   response1 = s3Client.getObject(objectRequest, Paths.get("/path/from/your/pc/"+objectName));
     System.out.println("response " + response1.toString()); 
  //it is work just fine
}
}