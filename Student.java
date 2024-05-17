package Interface;

public class Student implements Method, Comparable<Student> {

    private int Marks;
    private String Name;

    public Student(int marks, String name) {
        Marks = marks;
        Name = name;
    }

//    public int getMarks() {
//        return Marks;
//    }
//
//    public void setMarks(int marks) {
//        Marks = marks;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }

    @Override
    public void displayName() {
        System.out.println(Name);
    }

    @Override
    public void showMarks() {
        System.out.println(Marks);
    }

    @Override
    public int compareTo(Student st) {
        int a;
        if(Marks >st.Marks){
            a= 1;
        }
        else if(Marks==st.Marks){
            a=2;
        }
        else {
            a = 3;
        }
        return a;
    }
}