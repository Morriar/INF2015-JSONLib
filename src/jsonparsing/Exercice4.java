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
public class Exercice4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        // On crée la commande
        JSONObject commande = new JSONObject();
        commande.accumulate("id", "1321033823");
        commande.accumulate("total", 9.9);
        commande.accumulate("date", "11/11/2011");
        commande.accumulate("validated", true);
        
        // On prépare le cd à insérer dans la commande
        JSONObject album = new JSONObject();
        album.accumulate("id", "1");
        album.accumulate("title", "Hide your heart");
        
        // On met l'objet album dans un tableau json
        JSONArray albums = new JSONArray();
        albums.add(album);
        // puis on l'ajoute à l'objet commande
        commande.accumulate("albums", albums);
               
        // Finallement on affiche le JSON.
        System.out.println(commande);
    }
}
