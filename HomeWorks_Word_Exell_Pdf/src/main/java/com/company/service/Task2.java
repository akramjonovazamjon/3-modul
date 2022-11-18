package com.company.service;

import com.company.entity.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static String BASE_FOLDER="src/main/resources";

    public static void main(String[] args) {
        File file=new File(BASE_FOLDER, "posts.xlsx");
        List<Post> posts1=new ArrayList<>();
        ObjectMapper mapper=new ObjectMapper();
        try {
            Post[] posts = mapper.readValue(new File("C:\\Users\\99891\\Downloads/posts.txt"), Post[].class);
            posts1 = List.of(posts);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileOutputStream outputStream = new FileOutputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook()) {

            XSSFSheet sheet = workbook.createSheet();
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("User Id");
            headerRow.createCell(1).setCellValue("Id");
            headerRow.createCell(2).setCellValue("Title");
            headerRow.createCell(3).setCellValue("Body");

            int index=0;
            for (Post post : posts1) {
                XSSFRow row = sheet.createRow(++index);
                row.createCell(0).setCellValue(post.getUserId());
                row.createCell(1).setCellValue(post.getId());
                row.createCell(2).setCellValue(post.getTitle());
                row.createCell(3).setCellValue(post.getBody());
            }

            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\99891\\Downloads/image.jpg");
            byte[] bytes = IOUtils.toByteArray(fileInputStream);
            workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            fileInputStream.close();

            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(outputStream);
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
