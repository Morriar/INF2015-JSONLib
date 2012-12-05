/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparsing;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author morriar
 */
public class Exercice3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // On récupère le fichier au format string
        String json = FileReader.loadFileIntoString("json/catalog.json");
        // On récupère la liste des cds (un JSONArray)
        JSONArray cds = JSONArray.fromObject(json);

        System.out.println("Prix des albums en stock:");
        int cpt = 0;
        for(int i = 0; i < cds.size(); i++) {
            JSONObject cd = cds.getJSONObject(i);
            
            if(cd.getBoolean("instock")) {
                   cpt += 1;
                   System.out.println(" - " + cd.getString("title") + ": " + cd.getDouble("price") + "$");
            }
        }
        
        // On affiche le nombre de CDs dans le catalogue
        System.out.println("Il y a " + cpt + " CD(s) en stock");
        
    }
}
