package com.scrapping;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jaxen.JaxenException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

public class Main {
    //record Joueur(String nom, String id, int cote, int coteRapide){};
    public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException, JaxenException {
        
        WebClient client = new WebClient();
        client.setJavaScriptEnabled(false);
        HtmlPage searchPage = (HtmlPage) client.getPage("https://new.uschess.org/player-search");

        HtmlForm form = (HtmlForm) searchPage.getByXPath("//form").get(0);
        HtmlInput displayNameField = form.getInputByName("display_name");
        HtmlInput submitButton = form.getInputByName("op");
        displayNameField.type("Carlsen");
        HtmlPage resultsPage = (HtmlPage) submitButton.click();
        List<Joueur> joueurs = parseResults(resultsPage);

        for(Joueur joueur : joueurs) {
            System.out.println(joueur);
        }

    }

    
    private static List<Joueur> parseResults(HtmlPage resultsPage) throws JaxenException {
        HtmlTable table = (HtmlTable) resultsPage.getByXPath("//table").get(0);

        List<Joueur> joueurs = new ArrayList<>();
        List<HtmlTableRow> rows = table.getRows();
        for (int i=1 ; i<rows.size() ; i++) {
            HtmlTableRow row = rows.get(i);
            String nom = row.getCell(0).asText();
            String id = row.getCell(1).asText();
            String coteStr = row.getCell(2).asText();
            int cote = coteStr.length() == 0 ? 0 : Integer.parseInt(coteStr);
            String coteRapideStr = row.getCell(3).asText();
            int coteRapide = coteRapideStr.length() == 0 ? 0 : Integer.parseInt(coteRapideStr);

            Joueur joueur = new Joueur(nom, id, cote, coteRapide);

            joueurs.add(joueur);
        }
        
        return joueurs;
    }
}