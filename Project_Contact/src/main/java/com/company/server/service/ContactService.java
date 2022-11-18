package com.company.server.service;

import com.company.server.entity.Contact;
import com.company.server.payload.ContactDTO;
import com.company.server.payload.Result;
import com.company.server.payload.EditContactDTO;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public interface ContactService {
    File CONTACTS_FILE=new File("src/main/resources/contacts.json");
    Result CREATE_CONTACT(ContactDTO contactDTO);
    Result DELETE_CONTACT(UUID id);
    ArrayList<Contact> SHOW_CONTACTS();
    Result EDIT_CONTACT(UUID id, EditContactDTO editContactDTO);
    ArrayList<Contact> SEARCH_CONTACT(String text);
}
