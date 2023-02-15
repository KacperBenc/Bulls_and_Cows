class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        // write your code here
        String tempname;
        int tempage;
        tempage = p1.age;
        tempname = p1.name;
        p1.age = p2.age;
        p1.name = p2.name;
        p2.name = tempname;
        p2.age = tempage;
        return;


    }
}