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
import mascotapp_desktop.controllers.interfaces.VacunaControllerInterface;
import mascotapp_desktop.models.Vacuna;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author alex_
 */
public class VacunaController implements VacunaControllerInterface {

    private MascotappUtilImpl curl = new MascotappUtilImpl();
    private ObjectMapper om;
    private URL url;
    private static Vacuna vacuna;
    private MascotaController mc;
    private List<Vacuna> vacunas;

    public VacunaController() {
        this.mc = new MascotaController();
        this.vacunas = new ArrayList();
    }

    /**
     *
     * @param id
     * @return
     */
    public Vacuna getVacuna(String id) {
        Vacuna vac = null;

        try {
            //URL url = curl.getURL("mascotas/", id);
            if (!id.isEmpty() && id!=null) {
                URL url = curl.getURL("vacunas", id);
                vac = curl.getJSON_MAPPER().readValue(url, Vacuna.class);
            } else {
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vac;
    }

    @Override
    public void addVacuna(Vacuna vac) {
        //pc = new PropietarioController();
        String mascId = Long.toString(mc.getMascota().getId());

        try {

            url = curl.getURL("vacunas/", mascId);

            try {
                curl.peticionPOST(url.toString(), curl.getJSON_MAPPER().writeValueAsString(vac));
            } catch (IOException ex) {
                Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateVacuna(Vacuna vac) {
        try {
            url = curl.getURL("vacunas/", Long.toString(vac.getId()));
            try {
                curl.peticionPUT(url.toString(), curl.getJSON_MAPPER().writeValueAsString(vac));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteVacuna(Vacuna vac) {
        try {
            url = curl.getURL("vacunas/", Long.toString(vac.getId()));
            try {
                curl.peticionDELETE(url.toString(), curl.getJSON_MAPPER().writeValueAsString(vac));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Vacuna> getVacunasByMascota(Long id) {
        System.out.println("holaaa estoy en --> getVacunasByMascota");
        try {
            String peticion = "vacunas?mascota_id=";
            if (id != null) {
                String recurso = Long.toString(id);

                om = curl.getJSON_MAPPER();

                URL url = curl.getURL(peticion, recurso);
                vacunas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Vacuna.class));
                //System.out.println(clientes.toString());
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacunas;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vac) {
        this.vacuna = vac;
    }
}
