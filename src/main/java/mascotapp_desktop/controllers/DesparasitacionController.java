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
import mascotapp_desktop.controllers.interfaces.DesparasitacionControllerInterface;
import mascotapp_desktop.models.Desparasitacion;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author alex_
 */
public class DesparasitacionController implements DesparasitacionControllerInterface{
     private MascotappUtilImpl curl = new MascotappUtilImpl();
    private ObjectMapper om;
    private URL url;
    private static Desparasitacion desparasitacion;
    private MascotaController mc;
    private List<Desparasitacion> desparasitaciones;

    public DesparasitacionController() {
        this.mc = new MascotaController();
        this.desparasitaciones = new ArrayList<>();
    }

    /**
     *
     * @param id
     * @return
     */
     @Override
    public Desparasitacion getDesparasitacion(String id) {
        Desparasitacion des=  null;

        try {
            //URL url = curl.getURL("mascotas/", id);
            URL url = curl.getURL("desparasitaciones", id);
            des = curl.getJSON_MAPPER().readValue(url, Desparasitacion.class);

        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return des;
    }

    @Override
    public void addDesparasitacion(Desparasitacion vac) {
        //pc = new PropietarioController();
        String mascId = Long.toString(mc.getMascota().getId());

        try {

            url = curl.getURL("desparasitaciones/", mascId);

            try {
                curl.postJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(vac));
            } catch (IOException ex) {
                Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateDesparasitacion(Desparasitacion des) {
        try {
            url = curl.getURL("vacunas/", Long.toString(des.getId()));
            try {
                curl.putJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(des));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @Override
    public void deleteDesparasitacion(Desparasitacion des) {
        try {
            url = curl.getURL("desparasitaciones/", Long.toString(des.getId()));
            try {
                curl.deleteJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString(des));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Desparasitacion> getDesparasitacionesByMascota(Long id) {
        System.out.println("holaaa estoy en --> getDesparasitacionesByMascota");
        try {
            String peticion = "desparasitaciones?mascota_id=";
            if (id != null) {
                String recurso = Long.toString(id);

                om = curl.getJSON_MAPPER();

                URL url = curl.getURL(peticion, recurso);
                desparasitaciones = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Desparasitacion.class));
                //System.out.println(clientes.toString());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DesparasitacionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return desparasitaciones;
    }

    public Desparasitacion getDesparasitacion() {
        return desparasitacion;
    }

    public void setVacuna(Desparasitacion des) {
        this.desparasitacion = des;
    }
}
