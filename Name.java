public class Name {
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