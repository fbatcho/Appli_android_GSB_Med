/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sio
 */
public class DAO {
   private static final String url="http://gaemedecins.appspot.com/Controleur/medParDep/listeDep"; 
   
   public static List getlesDeps() {
       List<String> lesDeps=new ArrayList<String>();
       try {
           
           
           URL myURL=new URL (url);
           Document doc;
           DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance ();
           DocumentBuilder db= dbf.newDocumentBuilder();
           doc = db.parse(myURL.openStream());
           Element racine =(Element) doc.getDocumentElement();
           NodeList listeMed=racine.getElementsByTagName("Departement");
           for (int i=0;i<listeMed.getLength();i++){
               Node medecin=listeMed.item(i);
               NodeList lesProprietes =medecin.getChildNodes();
               for(int j=0;j<lesProprietes.getLength();j++){
                   if(lesProprietes.item(j).getNodeName().equals("num")){
                       lesDeps.add(lesProprietes.item(j).getTextContent().trim());
                       break;
                   }
               }
           }
           
           
       } catch (MalformedURLException ex) {
           Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParserConfigurationException ex) {
           Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SAXException ex) {
           Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       return lesDeps;
       
        
   }
}
   

