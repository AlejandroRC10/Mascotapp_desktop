/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import mascotapp_desktop.util.MascotappUtilImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mascotapp_desktop.controllers.interfaces.VeterinarioControllerInterface;
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.models.Veterinario;

/**
 *
 * @author alex_
 */
public class VeterinarioController implements VeterinarioControllerInterface {

    private MascotappUtilImpl curl = new MascotappUtilImpl();
    private ObjectMapper om;
    private URL url;
    private static Veterinario veterinario;

    @Override
    public Veterinario getVeterinario(String id) {
        Veterinario vet = null;
        try {
            url = curl.getURL("veterinarios/", id);
            vet = curl.getJSON_MAPPER().readValue(url, Veterinario.class);
            System.out.println("-----VetController------>\t" + vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vet;
    }

    @Override
    public void addVeterinario(Veterinario vet) {

        try {

            url = curl.getURL("veterinarios", "");

            try {
                curl.postJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(vet));
            } catch (IOException ex) {
                Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (JsonProcessingException ex) {
//            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    @Override
    public void updateVeterinario(Veterinario vet) {
        try {
            url = curl.getURL("veterinarios/", Long.toString(vet.getId()));
            System.out.println("vetId ---------->> " + vet.getId());
            try {
                curl.putJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(vet));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteVeterinario(Veterinario vet) {
        try {
            url = curl.getURL("veterinarios/", Long.toString(vet.getId()));
            try {
                curl.deleteJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(vet));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(Map<String, String> login) {
           try {

            url = curl.getURL("veterinarios/", "login");

            try {
                if(curl.loginJSON(url.toString(), curl.getJSON_MAPPER().writeValueAsString(login))){                    
                    System.out.println("------->>>  "+curl.getJSON_MAPPER().writeValueAsString(login));
                    return true;
                }
            } catch (IOException ex) {
                Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
           // curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           
        //String recurso = "usuario=" + usuario + "&password=" + password;
//        try {
//
//            url = curl.getURL("veterinarios?", "login");
//            System.out.println("URL s/decode  -> "+url);
//            //url = curl.convertToURLEscapingIllegalCharacters(url.toString());
//            System.out.println("URL decode --> "+url);
//            if(curl.loginJSON(url.toString(), )){     
//            veterinario = curl.getJSON_MAPPER().readValue(url, Veterinario.class);
//                System.out.println("login-------------> "+ url);
//            return true;
//            }
//            
//            System.out.println("-----VetController------>\t" + veterinario);
//
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(VeterinarioController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return false;

    }
    
    public Veterinario getVeterinario(){
        return veterinario;
    }
    
    public void setVeterinario(Veterinario vet){
        this.veterinario = vet;
    }


}
