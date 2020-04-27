import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
            showMenu();
            List<Phone> phoneList = new ArrayList<>();
            int choose;
            int phoneNumber;
            String phoneName;
            PhoneBook phoneBook = new PhoneBook(phoneList);
            while (true){
                choose = Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        phoneBook.show(phoneList);
                        break;
                    case 2:
                        phoneBook.addPhone(phoneList);
                        break;
                    case 3:
                        phoneNumber = phoneBook.inputNumber();
                        phoneBook.deletePhone(phoneList, phoneNumber);
                        break;
                    case 4:
                        phoneName = phoneBook.inputName();
                        phoneBook.searchName(phoneList, phoneName);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Ban vui long chon lai !");
                        break;

                }
                showMenu();
            }
        }

        private static void showMenu() {
            System.out.println("-----------------Chuong trinh quan li danh ba---------------");
            System.out.println("Chon chuc nang theo so de tiep tuc");
            System.out.println("1: Xem danh sach ");
            System.out.println("2: Them moi ");
            System.out.println("3: Xoa ");
            System.out.println("4: Tm kiem ");
            System.out.println("Chon chuc nang:");
        }
    }

