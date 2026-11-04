public class Person {
    Name name;
    int height;
    Person father;

    public Person(Name name, int height) {
        this(name, height, null);
    }

    public Person(Name name, int height, Person father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public String toString() {
        String s = name.surname;
        String f = name.firstName;
        String p = name.patronymic;

        if (father != null) {
            if (s == null) {
                Person curr = father;
                while (curr != null) {
                    if (curr.name.surname != null) {
                        s = curr.name.surname;
                        break;
                    }
                    curr = curr.father;
                }
            }
            if (p == null && father.name.firstName != null) {
                p = father.name.firstName + "ович";
            }
        }

        String res = "";
        if (s != null) res += s + " ";
        if (f != null) res += f + " ";
        if (p != null) res += p + " ";
        
        return res.trim() + ", рост: " + height;
    }
}