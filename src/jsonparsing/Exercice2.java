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
public class Exercice2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // On récupère le fichier au format string
        String json = FileReader.loadFileIntoString("json/catalog.json");
        // On récupère la liste des cds (un JSONArray)
        JSONArray cds = JSONArray.fromObject(json);

        System.out.println("Albums parus depuis 1990:");
        int cpt = 0;
        for(int i = 0; i < cds.size(); i++) {
            // On récupère l'objet à l'index i
            JSONObject cd = cds.getJSONObject(i);
            
            if(cd.getInt("year") >= 1990) {
                   cpt += 1;
                   System.out.println(" - " + cd.getString("title"));
            }
        }
        
        // On affiche le nombre de CDs dans le catalogue
        System.out.println("Il y a " + cds.size() + " CD(s) dans le catalogues dont " + cpt + " parus depuis 1990");
        
    }
}
