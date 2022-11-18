package com.company.client.ui;

import com.company.client.util.ScannerUtil;
import com.company.server.entity.Contact;
import com.company.server.payload.ContactDTO;
import com.company.server.payload.EditContactDTO;
import com.company.server.payload.Result;
import com.company.server.service.ContactService;
import com.company.server.service.ContactServiceImpl;

import java.util.ArrayList;
import java.util.UUID;

public class ContactUI {
    static ContactService contactService=new ContactServiceImpl();
    public static void addContact() {
        ContactDTO contactDTO=new ContactDTO();
        System.out.println("Enter fullName: ");
        contactDTO.setFullName(ScannerUtil.SCANNER_STR.nextLine());
        System.out.println("Enter phone number(+998XXXXXXXXX): ");
        contactDTO.setPhoneNumber(ScannerUtil.SCANNER_STR.nextLine());
        Result result=contactService.CREATE_CONTACT(contactDTO);
        System.out.println(result.getMessage());
    }

    public static void showContact() {
        ArrayList<Contact> contacts=contactService.SHOW_CONTACTS();
        if (contacts!=null&&!contacts.isEmpty()){
            for (Contact contact : contacts) {
                System.out.println(contact.getFullName()+" : "+contact.getPhoneNumber()+" id: "+contact.getId());
            }
        }else {
            System.out.println("There is no contact here yet.");
        }
    }

    public static void editContact() {
        ArrayList<Contact> contacts=contactService.SHOW_CONTACTS();
        if (contacts!=null && !contacts.isEmpty()) {
            showContact();
            System.out.println("Enter contact id to edit: ");
            String id=ScannerUtil.SCANNER_STR.nextLine();
            if (hasContact(id, contacts)) {
                EditContactDTO editContactDTO=new EditContactDTO();
                System.out.println("Enter new name: ");
                editContactDTO.setFullName(ScannerUtil.SCANNER_STR.nextLine());
                System.out.println("Enter new phone number(+998XXXXXXXXX): ");
                editContactDTO.setPhoneNumber(ScannerUtil.SCANNER_STR.nextLine());
                Result result=contactService.EDIT_CONTACT(UUID.fromString(id), editContactDTO);
                System.out.println(result.getMessage());
            }else {
                System.out.println("There is no contact with this id.");
            }
        }else {
            System.out.println("There is no contact to edit.");
        }
    }

    public static void searchContact() {
        ArrayList<Contact> contacts1=contactService.SHOW_CONTACTS();
        if (contacts1==null||contacts1.isEmpty()){
            System.out.println("There is no contact.");
            return;}
        System.out.println("Enter something to search: ");
        String text=ScannerUtil.SCANNER_STR.nextLine();
        ArrayList<Contact> contacts = contactService.SEARCH_CONTACT(text);
        if (contacts.size()>0){
            for (Contact contact : contacts) {
                System.out.println(contact.getFullName()+" : "+contact.getPhoneNumber());
            }
        }else {
            System.out.println("Contact not found.");
        }
    }

    public static void deleteContact() {
        ArrayList<Contact> contacts=contactService.SHOW_CONTACTS();
        if (contacts!=null&&!contacts.isEmpty()){
            showContact();
            System.out.println("Enter contact id to delete: ");
            String id=ScannerUtil.SCANNER_STR.nextLine();
            Result result=contactService.DELETE_CONTACT(UUID.fromString(id));
            System.out.println(result.getMessage());
        }else {
            System.out.println("There is no contact to delete.");
        }
    }
    private static boolean hasContact(String id, ArrayList<Contact> contacts){
        for (Contact contact : contacts) {
            if (contact.getId().toString().equals(id)){
                return true;
            }
        }
        return false;
    }
}
