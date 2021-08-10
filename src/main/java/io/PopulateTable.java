package io;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

public class PopulateTable {



    public static void main(String[] args) {
        final String[] hd = {"Code","Name","Lect","Venue","Time & Day"};
        final String[][] bd = {{"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"},
                {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"},
                {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"},
                {"Cps101","Computer Programming 1","Fred","Pb103","Fridays/9am"}};

        try {
            createSamplePDF(hd,bd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createSamplePDF(String[] header, String[][] body) throws Exception{
        Document documento = new Document();

        //
        File file = new File("/home/muhammed/Output/newDoc.pdf");
        FileOutputStream fop = new FileOutputStream(file);
        PdfWriter.getInstance(documento,fop);
        documento.open();
        //Fonts
        Font fontHeader = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
        Font fontBody = new Font(Font.FontFamily.COURIER,12,Font.NORMAL);
        //Table for header
        PdfPTable cabetabla = new PdfPTable(header.length);
        for(int j = 0; j < header.length; j++){
            Phrase frase = new Phrase(header[j],fontHeader);
            PdfPCell cell = new PdfPCell(frase);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cabetabla.addCell(cell);

        }
        documento.add(cabetabla);
        //Table body
        PdfPTable tabla = new PdfPTable(header.length);
        for(int i = 0; i < body.length; i++){
            for(int i2 = 0; i2 < body.length; i2++){
                tabla.addCell(new Phrase(body[i][i2],fontBody));
            }
        }
        documento.add(tabla);
        documento.close();
        fop.flush();
        fop.close();

    }
}
