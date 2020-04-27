import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhoneBook implements ProcessingFile {
    public static Scanner scanner = new Scanner(System.in);
    private static ProcessingFile processingFile;

    public PhoneBook(List<Phone> phoneList) throws Exception {
        processingFile = new ProcessingFile();
        processingFile.write("file.txt", phoneList);
        processingFile.read(phoneList);
    }

    public void addPhone(List<Phone> phoneList) throws Exception {
        int number = inputNumber();
        String name = inputName();
        boolean sex = inputSex();
        String address = inputAddress();
        String email = inputEmail();
        Phone phone = new Phone(number, name, sex, address, email);
        phoneList.add(phone);
        processingFile.write("file.txt", phoneList);
    }

    public void deletePhone(List<Phone> phoneList, int number) throws Exception {
        Phone phone = null;
        for (Phone value : phoneList) {
            if (value.getNumber() == number) {
                phone = value;
                break;
            }
        }
        if (phone != null) {
            phoneList.remove(phone);
            processingFile.write("file.txt", phoneList);
            show(phoneList);
        } else {
            System.out.println("Sdt khong ton tai !");
        }
    }

    public void editPhone(List<Phone> phoneList, int number) throws IOException {
        boolean isExisted = false;
        for (Phone phone : phoneList) {
            if (phone.getNumber() == number) {
                isExisted = true;
                try {
                    phone.setNumber(inputNumber());
                    phone.setName(inputName());
                    phone.setSex(inputSex());
                    phone.setAddress(inputAddress());

                    show(phoneList);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (!isExisted) {
            System.out.println("Sdt khong hop le!");
        }
        processingFile.write("file.txt", phoneList);
    }
    public void searchName(List<Phone> phoneList, String name) {
        for (Phone phone : phoneList) {
            if (phone.getName().equalsIgnoreCase(name)) {
                phone.display();
            }
        }
    }
    public void searchNumber(List<Phone> phoneList, int number){
        for (Phone phone : phoneList){
            if(phone.getNumber() == number){
                phone.display();
            }
        }
    }
    public void shortPhoneName(List<Phone> phoneList){
        Collections.sort(phoneList, new ShortPhoneName());
        show(phoneList);
    }
    public int inputNumber(){
        System.out.println("Nhap SDT");
        while (true){
            try {
                int Number = Integer.parseInt(scanner.nextLine());
                return Number;
            }catch (NumberFormatException e){
                System.out.println("Khong hop le moi nhap lai");
            }
        }
    }
    public String inputName() {
        System.out.println("Nhap ten");
        while (true){
            try {
                return scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Ten nhap khong hop le moi ban nhap lai.");
            }
        }
    }
    public String inputAddress(){
        System.out.println("Nhap dia chi");
        while (true){
            try {
                String address = scanner.nextLine();
                if(address.isEmpty() || address.length() > 20){
                    System.out.println("Dia chi qua dai");
                }
                return address;
            }catch (NumberFormatException e){
                System.out.println("dia chi nhap vao khong hop le, ban vui long hap lai !");
            }
        }
    }
    public boolean inputSex(){
        System.out.println("Nhap gioi tinh");
        return false;
    }
    public String inputEmail(){
        System.out.println("nhap email");
        while (true){
            try {
                return scanner.nextLine();
            }catch (NumberFormatException e) {
                System.out.println("Email nhap khong hop le moi ban nhap lai.");
            }
        }
    }
    public void show(List<Phone> phoneList){
        for (Phone phone : phoneList){
            System.out.format("SDT | ", phone.getNumber());
            System.out.format("Ten danh ba %30s | ", phone.getName());
            System.out.format("Gioi tinh | ", phone.getSex());
            System.out.format("Dia chi :%10s | ", phone.getAddress());
            System.out.format("Email :%10s | " , phone.getEmail());
            System.out.println();

        }
    }

}
