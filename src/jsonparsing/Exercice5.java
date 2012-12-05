/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonparsing;

import java.text.DecimalFormat;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author morriar
 */
public class Exercice5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
         // On récupère le fichier au format string
        String json = FileReader.loadFileIntoString("json/catalog.json");
        // On récupère la liste des cds (un JSONArray)
        JSONArray cds = JSONArray.fromObject(json);

        // On prépare la liste des cds à inclure dans la commande
        JSONArray albums = new JSONArray();
        
        double total = 0.0;
        for(int i = 0; i < cds.size(); i++) {
            JSONObject cd = cds.getJSONObject(i);
            
            if(cd.getString("id").equals("1") || cd.getString("id").equals("2") || cd.getString("id").equals("4")) {
                   total += cd.getDouble("price");
                   albums.add(cd);
            }
        }
        
        // Uniquement utile pour formatter le total avec 2 chiffres après la virgule
        DecimalFormat format = new DecimalFormat();
        format.setMinimumFractionDigits(2);
        String totalStr = format.format(total);

        // On crée la commande
        JSONObject commande = new JSONObject();
        commande.accumulate("id", "1321033823");
        commande.accumulate("total", totalStr);
        commande.accumulate("date", "11/11/2011");
        commande.accumulate("validated", true);
        commande.accumulate("albums", albums);
                
        System.out.println(commande);
    }
}
