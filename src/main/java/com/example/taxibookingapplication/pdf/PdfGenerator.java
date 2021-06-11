package com.example.taxibookingapplication.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.context.annotation.Configuration;

import java.io.FileOutputStream;
import java.io.IOException;

@Configuration
public class PdfGenerator {

    public void createPdf(String name, String email, Integer price) throws IOException, DocumentException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(name +".pdf"));

        document.open();
        document.add(new Chunk());


        String para
                = "Taxi Booking Applicaiton";
        // Creating Paragraph object
        Paragraph paragraph_obj
                = new Paragraph(para);

        String para1 = "Your total amount is " + price;
        // Creating Paragraph object
        Paragraph paragraph_obj1
                = new Paragraph(para1);
        Image image = Image.getInstance("download.png");

        // Adding paragraphs to document

        document.add(image);
        document.add(paragraph_obj);
        document.add(paragraph_obj1);

        document.close();
    }
}
