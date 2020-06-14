/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.esprit.Entite.Evenement;
import com.esprit.Entite.Inscription_evenement;
import com.esprit.Entite.Parent;
import com.esprit.Entite.enfant;
import com.esprit.Service.ServiceEnfant;

import com.esprit.Service.ServiceEvenement;
import com.esprit.Service.ServiceInscription_evenement;
import com.esprit.Service.ServiceParent;

import com.esprit.Utils.DataBase;
import com.esprit.Utils.JavamailUtil_1;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class Test {
    
    public static void main(String[] args) throws SQLException {
        
        try {
            JavamailUtil_1 mail = new JavamailUtil_1();
            
            mail.sendMail("maroua.abbour@esprit.tn");
            
            //ServiceEvenement sv = new ServiceEvenement();
            //ServiceInscription_evenement svi = new ServiceInscription_evenement();
            //Inscription_evenement is = new Inscription_evenement(2, 1, 6);
            //List<Evenement> listinsc= sv.chercher("nom", "Mu");
            // System.out.println(listinsc);
//        svi.chercher(1);
//sv.delete1(8);
// Evenement ev = new Evenement("ll", "kkk", 12, 12, 12-12-2019);
//sv.ajouter(new Evenement("gm", "musique", 12, 12, 20/27/20));
//read all
//System.out.println( sv.readAll());
//sv.update(new Evenement(16, "llllll", "ppppp", 12, 17, "2020-12-19"));
//trie
// sv.trierEvenement("nom");




//modification
// sv.update(new Evenement(8, "gabes", "karim event", 100,100, "13-12-2019"));

//suppression
//  sv.delete1(9);

//recherche
// sv.chercher("kkk");
//sv.chercher("kkk");

//ajout
//sv.ajouter(ev);

/*read all
Inscription_evenement is = new Inscription_evenement(2, 1, 6);
List<Inscription_evenement> listinsc= svi.readAll();
System.out.println(listinsc);

*/
//ajout
// svi.ajouter(is);

//recherche
//svi.chercher(1);

//affichege
//System.out.println(svi.getInscription(2));
//read all
// List<Evenement> listeven = sv.readAll();
//System.out.println(listeven);

//modification
//svi.update(new Inscription_evenement(4, 12));

//suppression
//svi.delete(4);

//sv.trierEvenement("t");

//sv.ajouter(new Evenement("hhh", "hhhh", 12, 11, "12-12-12"));
/*  } catch (Exception ex) {
Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
}*/

// Parent p = new Parent(10, "hjg", "gh", "ghh", 2162, 44, "hjfds");
// ServiceParent serp = new ServiceParent();
//   serp.ajouter(p);

//ServiceEnfant ser = new ServiceEnfant();
// enfant enf = new enfant("bhjc", "ncjkcdhs", "12/12/2020", "djk", 12,7);
//ser.ajouter(enf);

ServiceInscription_evenement ss = new ServiceInscription_evenement();
ss.delete(9);

//ss.ajouter(new Inscription_evenement(12, 1, 26));

//ss.ajouter(new Inscription_evenement(9, 15, 1, 26, "12/12/2020", "bhjc", "Musique"));
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
       
    }
    
    }
