class Person
{
   String name;
    Person(String n)
    {
      name = "Person:  " + n;

    }
 }
class Mother extends Person
{
   Mother(String n)
   {
     super(n);
     name = "Mother:  " + n;
   }
void FeedChildren()
  {
     System.out.println(name + " is feeding the kids ...");
  }
}
class Wife extends Person
{
  Wife(String n)
   {
       super(n);
       name = "Wife:  " + n;
    }
void CallHusband()
 {
    System.out.println(name + " is calling the husband ...");
 }
}
public class Test
{
    public static void main(String args[])
      {
          Person p = new Person("Prerna");
          Mother m = new Mother("Mahima");
          Wife w = new Wife("Raani");
          System.out.println("p is a " + p.name);
          System.out.println("m is a " + m.name);
          System.out.println("w is a " + w.name);
          m.FeedChildren();
          w.CallHusband();
      }
}