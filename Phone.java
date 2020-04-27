public class Phone {
    private int number;
    private String name;
    private boolean sex;
    private String address;
    private String email;
    public Phone(){

    }

    public Phone(int number, String name, boolean sex, String address, String email) {
        number = number;
        name = name;
        sex = sex;
        address = address;
        email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        address = address;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        email = email;
    }
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "Number=" + number +
                ", Name='" + name + '\'' +
                ", Sex='" + sex + '\'' +
                ", Address='" + address + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}

