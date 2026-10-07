class Name {
    String surname;
    String firstName;
    String patronymic;

    public Name(String surname, String firstName, String patronymic) {
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String toString() {
        String res = "";
        if (surname != null) res += surname + " ";
        if (firstName != null) res += firstName + " ";
        if (patronymic != null) res += patronymic + " ";
        return res.trim();
    }
}

class Person {
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
            if (s == null && father.name.surname != null) s = father.name.surname;
            if (p == null && father.name.firstName != null) p = father.name.firstName + "ович";
        }

        String res = "";
        if (s != null) res += s + " ";
        if (f != null) res += f + " ";
        if (p != null) res += p + " ";
        
        return res.trim() + ", рост: " + height;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}

class Polyline {
    Point[] points;

    public Polyline(Point... points) {
        this.points = points;
    }

    public void addPoints(Point... newPoints) {
        Point[] arr = new Point[points.length + newPoints.length];
        System.arraycopy(points, 0, arr, 0, points.length);
        System.arraycopy(newPoints, 0, arr, points.length, newPoints.length);
        this.points = arr;
    }

    public double getLength() {
        double len = 0;
        for (int i = 0; i < points.length - 1; i++) {
            len += Math.sqrt(Math.pow(points[i + 1].x - points[i].x, 2) + Math.pow(points[i + 1].y - points[i].y, 2));
        }
        return len;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i].toString());
            if (i < points.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Name n1 = new Name(null, "Клеопатра", null);
        Name n2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name n3 = new Name("Маяковский", "Владимир", null);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        Person p1 = new Person(n1, 152);
        Person p2 = new Person(n2, 167);
        Person p3 = new Person(n3, 189);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        Person ivan = new Person(new Name("Чудов", "Иван", null), 180);
        Person petr = new Person(new Name(null, "Петр", null), 175, ivan);
        Person boris = new Person(new Name(null, "Борис", null), 170, petr);
        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);

        Point pt1 = new Point(1, 5);
        Point pt2 = new Point(2, 8);
        Point pt3 = new Point(5, 3);
        Polyline line1 = new Polyline(pt1, pt2, pt3);
        Polyline line2 = new Polyline(pt1, new Point(2, -5), new Point(4, -8), pt3);
        pt1.x = 10;
        pt1.y = 10;
        System.out.println(line1);
        System.out.println(line2);

        Polyline line3 = new Polyline(new Point(1, 5), new Point(2, 8), new Point(5, 3));
        System.out.println(line3.getLength());
        line3.addPoints(new Point(5, 15), new Point(8, 10));
        System.out.println(line3.getLength());
    }
}