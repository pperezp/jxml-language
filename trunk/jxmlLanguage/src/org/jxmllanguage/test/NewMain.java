/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jxmllanguage.test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jxmllanguage.Language;
import org.jxmllanguage.exceptions.MalformedXMLLanguegeException;
import org.jxmllanguage.exceptions.ValueNotFoundException;


/**
 *
 * @author Administrador
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Language lan = new Language("languages"+File.separator+"language.xml");
            System.out.println(lan.getValueById("nombre"));
        } catch (ValueNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | MalformedXMLLanguegeException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
