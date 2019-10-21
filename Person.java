final class Person {
    private String Name;
    private String Description;
    private int Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    Person(Person p){
        this.Age=p.Age;
        this.Description=p.Description;
        this.Name=p.Name;
    }
   //Can't implement all getter setter because of clearity.
   Person(String name, String description, int age) {
        Name = name;
        Description = description;
        Age = age;
    }
}
class Test {
   public void TestCopyConstructor(){
       Person p=new Person("Anil","Comptuer Engineer",100);
       Person clone=new Person(p);
       System.out.println(clone.getName()); //print Anil
   }
     }