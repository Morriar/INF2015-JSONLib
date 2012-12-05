/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparsing;

import net.sf.json.JSONArray;

/**
 *
 * @author morriar
 */
public class Exercice1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // On récupère le fichier au format string
        String json = FileReader.loadFileIntoString("json/catalog.json");
        // On récupère la liste des cds (un JSONArray)
        JSONArray cds = JSONArray.fromObject(json);
        // On affiche le nombre de CDs dans le catalogue
        System.out.println("Il y a " + cds.size() + " CD(s) dans le catalogues");
    }
}
