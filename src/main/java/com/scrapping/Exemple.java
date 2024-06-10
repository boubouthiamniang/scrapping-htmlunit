package com.scrapping;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class Exemple {
    
   public static void main(String[] args) throws IOException {
      
            WebClient webClient = new WebClient();
            // Disable JavaScript to speed up page loading (if not needed)
            //webClient.get

            // Fetch the webpage with the form
            HtmlPage page = (HtmlPage) webClient.getPage("https://www.facebook.com/"); // Replace with your form URL

            // Find the form by its name or ID
            HtmlForm form = page.getFormByName("myForm"); // Replace "myForm" with the actual form name or ID

            // Fill in the form fields
            HtmlTextInput textField = (HtmlTextInput) form.getInputByName("boubouniang@yahoo.fr"); // Replace "username" with your field name or ID
            textField.setValueAttribute("myUsername"); // Replace with the value you want to set

            HtmlPasswordInput passwordField = (HtmlPasswordInput) form.getInputByName("Polytech14"); // Replace "password" with your field name or ID
            passwordField.setValueAttribute("myPassword"); // Replace with the password you want to set

            // Submit the form by clicking the submit button
            HtmlSubmitInput submitButton = (HtmlSubmitInput) form.getInputByValue("Submit"); // Replace "Submit" with the text on your submit button
            HtmlPage resultPage = (HtmlPage) submitButton.click();

            // Get the title of the resulting page
            String pageTitle = resultPage.getTitleText();
            System.out.println("Page Title: " + pageTitle);
    }

    
}
