package inheritance.HierarchicalInheritance;

class Main{
    public static void main(String args[]){
        Cat c=new Cat();
        c.meow();
        c.eat();

        Dog d = new Dog();
        d.bark();
        d.eat();
//c.bark();//C.T.Error
    }}