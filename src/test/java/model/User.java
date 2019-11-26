package model;

public enum User {

    Tom ("Tom", "Haverford", "tom.h76@yopmail.com", "+48732168882", "3xTOMtomTOM", "QA TEST");

    private final String name;
    private final String surname;
    private final String email;
    private final String phoneNumber;
    private final String password;
    private final String company;

    User(String name, String surname, String email, String phoneNumber, String password, String company) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.company = company;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public String getEmail() {
        return email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getCompany () {return company;}

    public String getFullName() {
        return name + " " + surname;
    }
}
