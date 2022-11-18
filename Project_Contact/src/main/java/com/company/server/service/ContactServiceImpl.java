package com.company.server.service;

import com.company.server.entity.Contact;
import com.company.server.payload.ContactDTO;
import com.company.server.payload.EditContactDTO;
import com.company.server.payload.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactServiceImpl implements ContactService{
    @Override
    public Result CREATE_CONTACT(ContactDTO contactDTO) {
        String s = checkParametr(contactDTO);
        if (s.equals("ok")) {

            List<Contact> contacts=SHOW_CONTACTS();
            if (contacts==null||contacts.isEmpty()){
                contacts=new ArrayList<>();
            }

            if (!hasNumber(contacts, contactDTO.getPhoneNumber())){
                Contact contact=new Contact();
                contact.setId(UUID.randomUUID());
                contact.setFullName(contactDTO.getFullName());
                contact.setPhoneNumber(contactDTO.getPhoneNumber());
                contacts.add(contact);
                try (PrintWriter writer = new PrintWriter(CONTACTS_FILE)) {
                    Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
                    writer.write(gson.toJson(contacts));
                    return new Result(true, "Contact successfully created\uD83D\uDC4D\uD83D\uDC4F.");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else {
                return new Result(false, "This contact is already exist");
            }


        }else {
            return new Result(false, s);
        }
    }

    @Override
    public Result DELETE_CONTACT(UUID id) {
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        ArrayList<Contact> contacts=SHOW_CONTACTS();
        for (Contact contact : contacts) {
            if (contact.getId().equals(id)) {
                contacts.remove(contact);
                try (PrintWriter writer = new PrintWriter(CONTACTS_FILE)) {
                    writer.println(gson.toJson(contacts));
                    return new Result(true, "Contact successfully deleted.");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new Result(false, "There is no coontact with this id.");
    }

    @Override
    public ArrayList<Contact> SHOW_CONTACTS() {
        ArrayList<Contact> contacts=new ArrayList<>();
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACTS_FILE))) {
            Type type=new TypeToken<List<Contact>>(){}.getType();
            contacts = gson.fromJson(reader, type);

            Contact[] contacts1 = gson.fromJson(reader, Contact[].class);
            ArrayList<Contact> contacts2 = new ArrayList<>(List.of(contacts1));

            return contacts;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public Result EDIT_CONTACT(UUID id, EditContactDTO editContactDTO) {
        if (checkParam(editContactDTO).equals("ok")) {
            ArrayList<Contact> contacts = SHOW_CONTACTS();
            for (Contact contact : contacts) {
                if (contact.getId().equals(id)) {
                    if (!hasNumber(contacts, editContactDTO.getPhoneNumber())) {
                        contact.setPhoneNumber(editContactDTO.getPhoneNumber());
                        contact.setFullName(editContactDTO.getFullName());
                        try (PrintWriter writer = new PrintWriter(new FileWriter(CONTACTS_FILE))) {
                            Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
                            writer.write(gson.toJson(contacts));
                            return new Result(true, "Contact successfully edited.");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        return new Result(false, "There is a contact with this number.");
                    }
                }
            }
            return new Result(false, "There is no coontact with this id.");
        }else {
            return new Result(false, checkParam(editContactDTO));
        }
    }

    @Override
    public ArrayList<Contact> SEARCH_CONTACT(String text) {
        ArrayList<Contact> foundContacts=new ArrayList<>();
        ArrayList<Contact> contacts=SHOW_CONTACTS();
        for (Contact contact : contacts) {
            if (contact.getFullName().contains(text)||contact.getPhoneNumber().contains(text)) {
                foundContacts.add(contact);
            }
        }
        return foundContacts;
    }

    private String  checkParametr(ContactDTO contactDTO){
        if (contactDTO==null){
            return "Data not found";
        }
        if (contactDTO.getPhoneNumber()==null || contactDTO.getPhoneNumber().isBlank()){
            return "Phone Number is required";
        }
        if (!contactDTO.getPhoneNumber().matches("\\+998[\\d]{9}")){
            return "Wrong phone number format";
        }
        if (contactDTO.getFullName()==null){
            return "Fullname data not found";
        }
        if (contactDTO.getFullName().isBlank()){
            contactDTO.setFullName(contactDTO.getPhoneNumber());
        }
        return "ok";
    }

    private String checkParam(EditContactDTO editContactDTO){
        if (editContactDTO==null){
            return "Data not found";
        }

        if (editContactDTO.getPhoneNumber()==null||editContactDTO.getPhoneNumber().isBlank()){
            return "Phone number is required";
        }

        if (!editContactDTO.getPhoneNumber().matches("\\+998[\\d]{9}")){
            return "Wrong phone number format";
        }

        if (editContactDTO.getFullName()==null){
            return "FullName data not found";
        }

        if (editContactDTO.getFullName().isBlank()){
            editContactDTO.setFullName(editContactDTO.getPhoneNumber());
        }
        return "ok";
    }

    private boolean hasNumber(List<Contact> contacts, String number){
        if (contacts==null||contacts.isEmpty())return false;
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(number)){
                return true;
            }
        }
        return false;
    }
}
