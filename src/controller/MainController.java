package controller;

import common.FuntionReadWrite;
import manager.ManagerService;

import java.util.Scanner;

public class MainController {

    public static void disPlayMenu() {
        String choose = null;
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("1.\tXem danh sách \n" +
                    "2.\tThêm mới\n" +
                    "3.\tCập nhật\n" +
                    "4.\tXóa\n" +
                    "5.\tTìm kiếm\n" +
                    "6.\tExit\n");
            System.out.println("Please choose (1 - 6):");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    ManagerService.showListPhoneBook();
                    break;
                case "2":
                    ManagerService.addNewPhoneBook();
                    break;
                case "3":
                    ManagerService.updatePhoneBook();
                    break;
                case "4":
                    ManagerService.deletePhoneBook();
                    break;
                case "5":
                    ManagerService.findPhoneBookOfNumberPhone();
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Nhập lại lựa chọn ");
                    break;
            }
        } while (flag);
    }


}
