package com.company.service;

import com.company.entity.Comment;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    static String BASE_FOLDER="src/main/resources";
    public static void main(String[] args) {
        File file=new File(BASE_FOLDER, "comments.docx");

        List<Comment> comments1;
        ObjectMapper mapper=new ObjectMapper();
        try {
            Comment[] comments = mapper.readValue(new File("C:\\Users\\99891\\Downloads/comments.json"), Comment[].class);
            comments1 = List.of(comments);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (FileOutputStream outputStream = new FileOutputStream(file);
             XWPFDocument document=new XWPFDocument()) {

            XWPFTable table = document.createTable();
            table.setWidth("100%");
            XWPFTableRow headerRow = table.getRow(0);
            XWPFTableCell cell = headerRow.getCell(0);
            cell.setWidth("10%");
            cell.setText("Post Id");

            XWPFTableCell cell1 = headerRow.createCell();
            cell1.setWidth("10%");
            cell1.setText("Id");

            XWPFTableCell cell2 = headerRow.createCell();
            cell2.setWidth("25%");
            cell2.setText("Name");

            XWPFTableCell cell3 = headerRow.createCell();
            cell3.setWidth("20%");
            cell3.setText("Email");

            XWPFTableCell cell4 = headerRow.createCell();
            cell4.setWidth("35%");
            cell4.setText("Body");

            for (Comment comment : comments1) {
                XWPFTableRow row = table.createRow();
                row.getCell(0).setText(String.valueOf(comment.getPostId()));
                row.getCell(1).setText(String.valueOf(comment.getId()));
                row.getCell(2).setText(comment.getName());
                row.getCell(3).setText(comment.getEmail());
                row.getCell(4).setText(comment.getBody());
            }

            document.write(outputStream);

            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
