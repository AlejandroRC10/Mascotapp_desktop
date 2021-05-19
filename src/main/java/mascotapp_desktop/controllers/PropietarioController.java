/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import mascotapp_desktop.util.MascotappUtilImpl;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import mascotapp_desktop.controllers.interfaces.PropietarioControllerInterface;
import mascotapp_desktop.models.Propietario;

/**
 *
 * @author alex_
 */
public class PropietarioController implements PropietarioControllerInterface{

    private MascotappUtilImpl curl = new MascotappUtilImpl();
    private ObjectMapper om;
    private URL url;
    private static Propietario propietario;
    private VeterinarioController vc;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Propietario getPropietario(String id){
        Propietario prop = null;
        
        try {
            URL url = curl.getURL("propietarios/", id);
            prop = curl.getJSON_MAPPER().readValue(url, Propietario.class);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prop;
    }
    
        @Override
    public boolean getPropietarioByDni(String dni){
        Propietario prop = null;
        
        try {
            URL url = curl.getURL("propietarios?dni=", dni);
            //prop = 
              if(curl.existEntity(url.toString())){
                  return true;
              }
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void addPropietario(Propietario prop) {
        vc = new VeterinarioController();
        String vetId = Long.toString(vc.getVeterinario().getId());
        
        try {

            url = curl.getURL("propietarios/", vetId);

            try {
                curl.postJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(prop));
            } catch (IOException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePropietario(Propietario prop) {
        try {
            url = curl.getURL("propietarios/", Long.toString(prop.getId()));
            try {
                curl.putJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(prop));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePropietario(Propietario prop) {
        try {
            url = curl.getURL("propietarios/", Long.toString(prop.getId()));
            try {
                curl.deleteJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(prop));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(Map<String, String> login) {
        try {

            url = curl.getURL("propietarios/", "login");

            try {
                if (curl.loginJSON(url.toString(), curl.getJSON_MAPPER().writeValueAsString(login))) {
                    System.out.println("------->>>  " + curl.getJSON_MAPPER().writeValueAsString(login));
                    return true;
                }
            } catch (IOException ex) {
                Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
            // curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(PropietarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario prop) {
        this.propietario = prop;
    }
}
