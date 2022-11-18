package com.company.client;

import com.company.client.ui.MainUI;

public class Application {
    public static void main(String[] args) {
        try {
            MainUI.run();
        } catch (Exception e) {
            System.out.println("Enter data which Integer type ");
        }
    }
}
