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
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.models.Vacuna;
import mascotapp_desktop.util.MascotappUtilImpl;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase controladora que implementa las operaciones de la entidad Vacuna
 *
 * Implementa la interface VacunaControllerInterface
 *
 */
public class VacunaController implements VacunaControllerInterface {

    private MascotappUtilImpl mui;
    private ObjectMapper om;
    private URL url;
    private static Vacuna vacuna;
    private MascotaController mc;
    private List<Vacuna> vacunas;

    public VacunaController() {
        this.mc = new MascotaController();
        this.vacunas = new ArrayList();
        mui = new MascotappUtilImpl();
    }

    /**
     * Obtiene una Vacuna por su ID Utiliza el método readValue() de
     * ObjectMapper para deserializar objetos JSON
     *
     * @param id
     * @return Vacuna obtenida
     */
    @Override
    public Vacuna getVacuna(String id) {
        Vacuna vac = null;

        try {

            URL url = mui.getURL("vacunas", id);

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                vac = mui.getJSON_MAPPER().readValue(url, Vacuna.class);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vac;
    }

    /**
     * Añade una Vacuna a la Mascota
     *
     * Utiliza el método 'peticionPOST()' de MascotapUtilImpl
     *
     * @param vac
     */
    @Override
    public void addVacuna(Vacuna vac) {
        Mascota m = mc.getMascota();

        if (m != null) {
            String mascId = Long.toString(m.getId());

            try {
                if (vac != null) {
                    url = mui.getURL("vacunas/", mascId);

                    try {
                        mui.peticionPOST(url.toString(), mui.getJSON_MAPPER().writeValueAsString(vac));
                    } catch (IOException ex) {
                        Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (MalformedURLException ex) {
                Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Actualiza una Vacuna con los datos de la Vacuna que entra por parámetro
     * Utiliza el método 'peticionPUT()' de MascotapUtilImpl
     *
     * @param vac
     */
    @Override
    public void updateVacuna(Vacuna vac) {
        try {
            if (vac != null) {
                url = mui.getURL("vacunas/", Long.toString(vac.getId()));
                try {
                    mui.peticionPUT(url.toString(), mui.getJSON_MAPPER().writeValueAsString(vac));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Borra la Vacuna que le entra por parámetro Utiliza el método
     * 'peticionDELETE()' de MascotappUtilImpl
     *
     * @param vac
     */
    @Override
    public void deleteVacuna(Vacuna vac) {
        try {
            if (vac != null) {
                url = mui.getURL("vacunas/", Long.toString(vac.getId()));
                try {
                    mui.peticionDELETE(url.toString(), mui.getJSON_MAPPER().writeValueAsString(vac));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene una lista de vacunas por el id de Mascota Utiliza el método
     * readValue de ObjectMapper(), en lugar de deserializar un objeto, lo hace
     * con una colección
     *
     * @param id
     * @return lista
     */
    @Override
    public List<Vacuna> getVacunasByMascota(Long id) {
        try {
            String peticion = "vacunas?mascota_id=";
            if (id != null) {
                String recurso = Long.toString(id);

                om = mui.getJSON_MAPPER();

                URL url = mui.getURL(peticion, recurso);

                CloseableHttpResponse chr = mui.peticionGET(url.toString());
                int status = chr.getStatusLine().getStatusCode();

                if (status == HttpStatus.SC_OK) {
                    vacunas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Vacuna.class));
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VacunaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacunas;
    }

    /**
     * Obtiene la Vacuna que está almacenada en la variable estática, para que
     * pueda ser utilizada donde sea necesaria
     *
     * @return Vacuna
     */
    public Vacuna getVacuna() {
        return vacuna;
    }

    /**
     * Cambia la variable estática de Vacuna por la que le entra por parámetro
     *
     * @param vac
     */
    public void setVacuna(Vacuna vac) {
        this.vacuna = vac;
    }
}
