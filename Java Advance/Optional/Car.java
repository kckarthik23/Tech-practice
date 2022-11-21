import java.util.Optional;

public class Car {

    public Insurance insurance;
    public Person person;

   public Optional<Person> getPerson()
   {
    return Optional.ofNullable(person);
   }
   public static void main(String[] args) {
    Car car=null;
   Optional<Car> carob= Optional.of(car);
    System.out.println(carob.map(Car::getPerson));
    
   }
}
class Person{
    public Optional<Person> getInsurance()
    {
     return Optional.ofNullable(insurance);
    }
}
  
class Insurance
{
String name;

public String getName()
{
    return name;
}
    
}
