package com.company.service;

import com.company.entity.Photo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    static String BASE_FOLDER="src/main/resources";

    public static void main(String[] args) {
        File file=new File(BASE_FOLDER, "photos.pdf");

        ArrayList<Photo> photos1=new ArrayList<>();
        ObjectMapper mapper=new ObjectMapper();
        try {
            Photo[] photos = mapper.readValue(new File("C:\\Users\\99891\\Downloads/photos.json"), Photo[].class);
            photos1 = new ArrayList<>(List.of(photos));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (PdfDocument pdfDocument = new PdfDocument(new PdfWriter(file));
             Document document=new Document(pdfDocument)) {

            float[] size={50, 50,200,200,200};
            Table table=new Table(size);

            table.addCell("Album Id");
            table.addCell("Id");
            table.addCell("Title");
            table.addCell("URL");
            table.addCell("ThumbnailUrl");

            for (Photo photo : photos1) {
                table.addCell(String.valueOf(photo.getAlbumId()));
                table.addCell(String.valueOf(photo.getId()));
                table.addCell(photo.getTitle());
                table.addCell(photo.getUrl());
                table.addCell(photo.getThumbnailUrl());
            }

            document.add(table);
            Desktop.getDesktop().open(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
