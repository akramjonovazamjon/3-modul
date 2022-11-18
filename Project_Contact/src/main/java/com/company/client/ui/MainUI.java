package com.company.client.ui;

import com.company.client.util.ScannerUtil;

public class MainUI {
    public static void run() {
        mainMenu();
    }

    private static void mainMenu() {
        while (true){
            System.out.println("0.Exit \n1.Add Contact \n2.Show Contact \n3.Edit Contact \n4.Search Contact \n5.Delete Contact ");
            switch (ScannerUtil.SCANNER_NUM.nextInt()){
                case 0: return;
                case 1:
                    ContactUI.addContact();
                    break;
                case 2:
                    ContactUI.showContact();
                    break;
                case 3:
                    ContactUI.editContact();
                    break;
                case 4:
                    ContactUI.searchContact();
                    break;
                case 5:
                    ContactUI.deleteContact();
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}
