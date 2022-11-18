package com.company.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App1 {
    static String BASE_FOLDER="src/main/resources";
    static String BASE_DOCS_FOLDER="src/main/resources/docs";
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("src/main/resources/document.docx"))) {

            XWPFDocument document=new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setBold(true);
        run.setText("Java Developer At EPAM SYSTEMS");
        paragraph=document.createParagraph();
        run=paragraph.createRun();
        run.addTab();
        run.setBold(true);
        run.setText("Hello A`zamjon");

            ObjectMapper mapper=new ObjectMapper();
            Album[] albums = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/albums"), Album[].class);
            ArrayList<Album> albums1 = new ArrayList<>(List.of(albums));


            //Table creation
            XWPFTable table = document.createTable();
            XWPFTableRow row1 = table.getRow(0);
            row1.getCell(0).setText("Id");
            row1.addNewTableCell().setText("User Id");
            row1.addNewTableCell().setText("Title");
            for (int i = 0; i < albums1.size(); i++) {
                XWPFTableRow row = table.createRow();
                row.getCell(0).setText(albums1.get(i).getId().toString());
                row.getCell(1).setText(albums1.get(i).getUserId().toString());
                row.getCell(2).setText(albums1.get(i).getTitle());
            }

            //Picture adding
            XWPFParagraph paragraph1 = document.createParagraph();
            XWPFRun run1 = paragraph1.createRun();
            run1.setText("Rasm sarlovhasi");
            run1.addBreak();

            FileInputStream fileInputStream=new FileInputStream(new File("src/main/resources/PDP.jpg"));
            document.addPictureData(fileInputStream, PictureType.JPEG);
            run1.addPicture(fileInputStream, PictureType.JPEG, "src/main/resources/PDP.jpg", Units.toEMU(500), Units.toEMU(500));
            fileInputStream.close();
            document.write(fileOutputStream);
            document.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }

    }
}
