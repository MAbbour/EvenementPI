/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Utils;


import com.esprit.Entite.Inscription_evenement;
import com.esprit.Service.ServiceEnfant;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
/**
 *
 * @author Acer
 */
public class Pdf {
  Connection con;
    Statement ste;

    public Pdf() {
        con = DataBase.getInstance().getConnection();
    }

    public void pdf(int i) throws SQLException, FileNotFoundException, DocumentException, IOException {
        Document doc = new Document();

        ste = con.createStatement();

        ResultSet rs = ste.executeQuery("select * from Inscription_evenement where id_insc='" + i + "'");
        PdfWriter.getInstance(doc, new FileOutputStream("./Liste Inscription_evenement.pdf"));

        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph(" Inscription à l'événement  ", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLDITALIC)));
        doc.add(new Paragraph("   "));

        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(40);
        PdfPCell cell;

        cell = new PdfPCell(new Phrase("Inscription à l'événement ", FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(cell);
        while (rs.next()) {

            int id_insc = rs.getInt(1);
            Float prix = rs.getFloat(2);
            int Id_enfant = rs.getInt(3);
            int Id_event = rs.getInt(4);
            String dat = rs.getString(5);
        
            
            ServiceEnfant sere = new ServiceEnfant();

           String nom = sere.getEnfant(Id_enfant).getNom() + "  " + sere.getEnfant(Id_enfant).getPrenom();
           
            System.out.println(nom);

            Inscription_evenement ins_ev = new Inscription_evenement();
       
            System.out.println(ins_ev.getNom_enfant());
            String sjk = Float.toString(ins_ev.getPrix());
            System.out.println(ins_ev.getNom_evenemment());
            

            cell = new PdfPCell(new Phrase(String.valueOf(ins_ev.getNom_enfant()),FontFactory.getFont("Comic Sans MS",12)));
             cell = new PdfPCell(new Phrase(String.valueOf(ins_ev.getDate_insc()),FontFactory.getFont("Comic Sans MS",12)));
            // cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //table.addCell(cell);
            doc.add(new Paragraph(" ", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC)));
            doc.add(new Paragraph(" ", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC)));
            doc.add(new Paragraph(" ", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC)));
            doc.add(new Paragraph(" ", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC)));
            
            doc.add(new Paragraph("Inscription du :                                  " + dat, FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC)));
           
            doc.add(new Paragraph("Nom de l'enfant :                                 " + nom, FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC)));
            
        //    doc.add(new Paragraph("Le nombre de jour d'inscription :                  " + snbj, FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC)));
            
            doc.add(new Paragraph("Le prix payé:                                      " + sjk + " Dinars", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC)));
            
        }  // doc.add(table);
        doc.close();
        Desktop.getDesktop().open(new File("./Liste Inscription_evenement.pdf"));
    }
 
    
}
