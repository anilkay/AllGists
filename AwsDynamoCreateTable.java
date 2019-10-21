public class AwsDynamoCreateTable{
 public void createTableExample(){
     DynamoDbClient dbClient=DynamoDbClient.create(); 
     KeySchemaElement element1=KeySchemaElement.builder()
                .attributeName("title")
                .keyType(KeyType.HASH) //Primary key
                .build();
        KeySchemaElement element2=KeySchemaElement.builder()
                .attributeName("article")
                .keyType(KeyType.RANGE) //Other key (not foreign key)
                .build();
    AttributeDefinition attribute1=
                AttributeDefinition.builder()
                        .attributeName("title") //Attirubute definition
                        .attributeType(ScalarAttributeType.S)
                        .build();
        AttributeDefinition attribute2=AttributeDefinition.builder()
                .attributeName("article") //Other attiribute definition
                .attributeType(ScalarAttributeType.S)
                .build();
   CreateTableRequest request=CreateTableRequest.builder()
                .tableName("deneme")
                .attributeDefinitions(attribute1,attribute2)
                .keySchema(element1,element2)
                .billingMode(BillingMode.PAY_PER_REQUEST) //it's not default. Some situation it's not ideal.
                .build();
    CreateTableResponse response=dbClient.createTable(request);
    String result=response.toString();
 }  
  
}