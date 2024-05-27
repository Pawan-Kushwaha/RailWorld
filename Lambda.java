import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(31);

        arrayList.forEach(
                n-> {if(n%10==0){
                    System.out.println(n);
                }
                });
        arrayList.forEach(n-> System.out.println(n));

        List<Person> people= Arrays.asList(new Person("shri",20),new Person("shri2",15),new Person("shri3",23));

        List<Person> filteredList = people.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());

        filteredList.forEach(System.out::println);
        List<Integer> ages = people.stream()
                .map(person -> person.getAge())
                .collect(Collectors.toList());

        ages.forEach(System.out::println);
//        for(int i=0;i<5;i++){
//            System.out.println(i);
//        }

        int totalAge = people.stream()
                .map(person -> person.getAge())
                .reduce(0, (age1, age2) -> age1 + age2);

        System.out.println("Total age: " + totalAge);


    }
}