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
import mascotapp_desktop.controllers.interfaces.CitaControllerInterface;
import mascotapp_desktop.models.Cita;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author alex_
 */
public class CitaController implements CitaControllerInterface {

    private MascotappUtilImpl curl = new MascotappUtilImpl();
    private ObjectMapper om;
    private URL url;
    private static Cita cita;
    private MascotaController mc;
    private List<Cita> citas;

    public CitaController() {
        this.mc = new MascotaController();
        this.citas = new ArrayList<>();
    }

    /**
     *
     * @param id
     * @return
     */
    public Cita getCita(String id) {
        Cita cita = null;

        try {
            //URL url = curl.getURL("mascotas/", id);
            URL url = curl.getURL("citas", id);
            cita = curl.getJSON_MAPPER().readValue(url, Cita.class);

        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cita;
    }

    @Override
    public void addCita(Cita cita) {
        //pc = new PropietarioController();
        String mascId = Long.toString(mc.getMascota().getId());

        try {

            url = curl.getURL("citas/", mascId);

            try {
                curl.postJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(cita));
            } catch (IOException ex) {
                Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateCita(Cita cita) {
        try {
            url = curl.getURL("citas/", Long.toString(cita.getId()));
            try {
                curl.putJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(cita));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteCita(Cita cita) {
        try {
            url = curl.getURL("citas/", Long.toString(cita.getId()));
            try {
                curl.deleteJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(cita));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cita> getCitasByMascota(Long id) {
        System.out.println("holaaa estoy en --> getCitasByMascota");
        try {
            String peticion = "citas?mascota_id=";
            if(id!=null){
            String recurso = Long.toString(id);

            om = curl.getJSON_MAPPER();

            URL url = curl.getURL(peticion, recurso);
            citas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Cita.class));
            //System.out.println(clientes.toString());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CitaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return citas;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

}
