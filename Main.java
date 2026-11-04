public class Main {
    public static void main(String[] args) {
        // Демонстрация работы класса Name
        Name n1 = new Name(null, "Клеопатра", null);
        Name n2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name n3 = new Name("Маяковский", "Владимир", null);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);

        System.out.println("-----------------------------------");

        // Демонстрация работы класса Person
        Person p1 = new Person(n1, 152);
        Person p2 = new Person(n2, 167);
        Person p3 = new Person(n3, 189);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("-----------------------------------");

        // Демонстрация передачи отчества и фамилии по цепочке отцов
        Person ivan = new Person(new Name("Чудов", "Иван", null), 180, null);
        Person petr = new Person(new Name(null, "Петр", null), 175, ivan);
        Person boris = new Person(new Name(null, "Борис", null), 170, petr);
        System.out.println(ivan);
        System.out.println(petr);
        System.out.println(boris);

        System.out.println("-----------------------------------");

        // Демонстрация работы класса Point и Polyline (изменение координат исходной точки)
        Point pt1 = new Point(1, 5);
        Point pt2 = new Point(2, 8);
        Point pt3 = new Point(5, 3);
        Polyline line1 = new Polyline(pt1, pt2, pt3);
        Polyline line2 = new Polyline(pt1, new Point(2, -5), new Point(4, -8), pt3);
        pt1.x = 10;
        pt1.y = 10;
        System.out.println(line1);
        System.out.println(line2);

        System.out.println("-----------------------------------");

        // Демонстрация расчета длины ломаной и добавления точек
        Polyline line3 = new Polyline(new Point(1, 5), new Point(2, 8), new Point(5, 3));
        System.out.println("Длина line3: " + line3.getLength());
        line3.addPoints(new Point(5, 15), new Point(8, 10));
        System.out.println("Новая длина line3: " + line3.getLength());
    }
}
