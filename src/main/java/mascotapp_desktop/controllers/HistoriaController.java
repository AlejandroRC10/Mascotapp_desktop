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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mascotapp_desktop.controllers.interfaces.HistoriaControllerInterface;
import mascotapp_desktop.models.Historia;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author alex_
 */
public class HistoriaController implements HistoriaControllerInterface{

    private MascotappUtilImpl curl = new MascotappUtilImpl();
    private ObjectMapper om;
    private URL url;
    private static Historia historia;
    private MascotaController mc;
    private List<Historia> historias;

    public HistoriaController() {
        this.mc = new MascotaController();
        this.historias = new ArrayList<>();
    }

    /**
     *
     * @param id
     * @return
     */
    public Historia getHistoria(String id) {
        Historia hist = null;

        try {
            //URL url = curl.getURL("mascotas/", id);
            URL url = curl.getURL("historias", id);
            hist = curl.getJSON_MAPPER().readValue(url, Historia.class);

        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hist;
    }

    @Override
    public void addHistoria(Historia hist) {
        //pc = new PropietarioController();
        String mascId = Long.toString(mc.getMascota().getId());

        try {

            url = curl.getURL("historias/", mascId);

            try {
                curl.postJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(hist));
            } catch (IOException ex) {
                Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateHistoria(Historia hist) {
        try {
            url = curl.getURL("historias/", Long.toString(hist.getId()));
            try {
                curl.putJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(hist));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteHistoria(Historia hist) {
        try {
            url = curl.getURL("historias/", Long.toString(hist.getId()));
            try {
                curl.deleteJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(hist));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Historia> getHistoriasByMascota(Long id) {
        System.out.println("holaaa estoy en --> getHistoriasByMascota");
        try {
            String peticion = "historias?mascota_id=";
            if (id != null) {
                String recurso = Long.toString(id);

                om = curl.getJSON_MAPPER();

                URL url = curl.getURL(peticion, recurso);
                historias = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Historia.class));
                //System.out.println(clientes.toString());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return historias;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia hist) {
        this.historia = hist;
    }
}
