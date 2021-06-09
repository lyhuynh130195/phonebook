package manager;

import common.*;
import model.PhoneBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManagerService {
    public static void showListPhoneBook() {
        List<PhoneBook> list = FuntionReadWrite.readFileCsv();
        for (PhoneBook phoneBook : list) {
            System.out.println(phoneBook.showInfo());
        }
    }

    public static void addNewPhoneBook() {

        PhoneBook phoneBook = inputNewPhoneBook();
        List<PhoneBook> list1 = FuntionReadWrite.readFileCsv();
        list1.add(phoneBook);
        FuntionReadWrite.writeToCsv(list1);
    }

    private static PhoneBook inputNewPhoneBook() {
        Scanner scanner = new Scanner(System.in);

        boolean flag;
        String numberPhone = null;
        do {
            System.out.println("Nhập số điện thoại");
            numberPhone = scanner.nextLine();
            try {
                Validator.isPhoneNumber(numberPhone);
                flag = false;
            } catch (NumberPhoneException e) {
                flag = true;
                e.printStackTrace();
            }
        } while (flag);

        System.out.println("Nhập nhóm");
        String group = scanner.nextLine();
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        String birthday;
        do {
            System.out.println("nhập ngày sinh");
            birthday = scanner.nextLine();
            try {
                Validator.isBirthDay(birthday);
                flag=false;
            } catch (BirthDayException e) {
                e.printStackTrace();
                flag=true;
            }

        } while (flag);

        String email = null;

        do {
            System.out.println("Nhập email");
            email = scanner.nextLine();
            try {
                Validator.isEmail(email);
                flag = false;
            } catch (EmailException e) {
                flag = true;
                e.printStackTrace();
            }

        }
        while (flag);
        return new PhoneBook(numberPhone, group, name, gender, address, birthday, email);
    }

    public static void deletePhoneBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần xóa");
        boolean flag;
        List<PhoneBook> list = FuntionReadWrite.readFileCsv();
        do {
            String phoneNumber = scanner.nextLine();
            switch (phoneNumber) {
                case "":
                    flag = false;
                    break;
                default:
                    PhoneBook phoneBook = findPhonebook(phoneNumber, list);
                    if (phoneBook == null) {
                        System.out.println("Không có số điện thoại này");
                        flag = true;
                    } else {
                        System.out.println("Bạn có đồng ý xóa nhấn Y để đồng ý");
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "Y":
                                list.remove(phoneBook);
                                System.out.println("do dai list sau khi xóa " + list.size());
                                FuntionReadWrite.writeToCsv(list);
                                System.out.println("bạn đã xóa thành công");
                                break;
                            default:
                                System.out.println("Bạn không xóa danh bạ này");
                                break;
                        }
                        flag = false;
                    }
            }
        } while (flag);

    }

    private static PhoneBook findPhonebook(String numberPhone, List<PhoneBook> list) {
        for (PhoneBook phoneBook : list) {
            if (phoneBook.getNumberPhone().equals(numberPhone)) {
                return phoneBook;
            }
        }
        return null;
    }

    public static void updatePhoneBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại cần sửa");
        boolean flag = true;

        List<PhoneBook> list = FuntionReadWrite.readFileCsv();
        do {
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.equals("")) {
                flag = false;
            } else {
                PhoneBook phoneBook = findPhonebook(phoneNumber, list);
                if (phoneBook == null) {
                    flag = true;
                    System.out.println("Không có số điện thoại này,mời nhập lại");
                } else {
                    int index = list.indexOf(phoneBook);
                    PhoneBook phoneBookNew = inputNewPhoneBook();
                    list.remove(phoneBook);
                    list.add(index, phoneBookNew);
                    FuntionReadWrite.writeToCsv(list);
                    flag = false;
                }
            }

        } while (flag);


    }

    public static void findPhoneBookOfNumberPhone() {
        Scanner scanner = new Scanner(System.in);
        List<PhoneBook> phoneBookList = FuntionReadWrite.readFileCsv();
        for (PhoneBook phoneBook : phoneBookList) {
            System.out.println(phoneBook.showInfo());
        }

        String number = null;
        boolean flag;
        do {
            System.out.println("Nhập số điện thoại cần tìm kiếm");
            number = scanner.nextLine();
            try {
                Validator.isPhoneNumber(number);
                flag = false;
            } catch (NumberPhoneException e) {
                flag = true;
                e.printStackTrace();
            }
        } while (flag);

        String[] arrNumber = number.split("");

        List<String> listNumberPhone = new ArrayList<>();
        for (int i = 0; i < phoneBookList.size(); i++) {
            listNumberPhone.add(phoneBookList.get(i).getNumberPhone());
        }

        int check = 0;
        for (String numberPhone : listNumberPhone) {
            int count = 0;
            String[] arrNumberPhone = numberPhone.split("");
            for (int j = 0; j < arrNumberPhone.length; j++) {
                if (arrNumberPhone[j].equals(arrNumber[j])) {
                    count++;
                }
            }
            if (count >= 7) {
                System.out.println("Số cần tìm là " + numberPhone);
                check++;
            }

        }
        if (check < 1) {
            System.out.println("không tồn tại số này");
        }

    }
}
