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
import mascotapp_desktop.controllers.interfaces.MascotaControllerInterface;
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.util.MascotappUtilImpl;

/**
 *
 * @author alex_
 */
public class MascotaController implements MascotaControllerInterface {

    private MascotappUtilImpl curl = new MascotappUtilImpl();
    private ObjectMapper om;
    private URL url;
    private static Mascota mascota;
    private PropietarioController pc;
    private static List<Mascota> mascotas;

    public MascotaController() {
        this.pc = new PropietarioController();
        //this.mascotas = new ArrayList<>();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Mascota getMascota(String id) {
        Mascota masc = null;

        try {
            //URL url = curl.getURL("mascotas/", id);
            URL url = curl.getURL("mascotas", id);
            System.out.println("-----------> url "+ url.toString());
            masc = curl.getJSON_MAPPER().readValue(url, Mascota.class);

        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return masc;
    }

    @Override
    public void addMascota(Mascota masc) {
        //pc = new PropietarioController();
        String propId = Long.toString(pc.getPropietario().getId());

        try {

            url = curl.getURL("mascotas/", propId);

            try {
                curl.peticionPOST(url.toString(), curl.getJSON_MAPPER().writeValueAsString(masc));
            } catch (IOException ex) {
                Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //curl.getJSON_MAPPER().writeValueAsString(vet);

        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateMascota(Mascota masc) {
        try {
            String id = Long.toString(masc.getId());
            url = curl.getURL("mascotas/", id);
            try {
                curl.peticionPUT(url.toString(), curl.getJSON_MAPPER().writeValueAsString(masc));
                
                System.out.println("Estoy en update Mascota para ver la fecha que mando --> "+masc.getFecha_nac().toString());
                System.out.println("Estoy en update Mascota para ver la fecha que mando --> "+masc.getFecha_nac());

            } catch (JsonProcessingException ex) {
                Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteMascota(Mascota prop) {
        try {
            url = curl.getURL("mascotas/", Long.toString(prop.getId()));
            try {
                curl.peticionDELETE(url.toString(), curl.getJSON_MAPPER().writeValueAsString(prop));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Mascota> getMascotaByNombre(String nombre) {
        try {
            String peticion = "mascotas";
            String recurso = "?name=" + nombre;

            om = curl.getJSON_MAPPER();

            URL url = curl.getURL(peticion, recurso);
            mascotas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Mascota.class));
            System.out.println("++++++-----getMascotaByNombre------>>>>>>>>>>>"+mascotas.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mascotas;
    }

    @Override
    public List<Mascota> getMascotasByPropietario(Long id) {
        System.out.println("holaaa estoy en --> getMascotasByPropietario");
        List<Mascota>listaMascotas = null;
        try {
            String peticion = "mascotas";
            String recurso = "?prop_id=" + Long.toString(id);

            om = curl.getJSON_MAPPER();

            URL url = curl.getURL(peticion, recurso);
            mascotas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Mascota.class));
            if(mascotas!=null){
                listaMascotas = mascotas;
            }else{
                listaMascotas = new ArrayList();
            }
            //System.out.println(clientes.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaMascotas;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota masc) {
        this.mascota = masc;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    
    
   
}
