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
import mascotapp_desktop.models.Propietario;
import mascotapp_desktop.util.MascotappUtilImpl;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 *
 * Clase controladora que implementa las operaciones de la entidad Mascota
 *
 * Implementa la interface MascotaControllerInterface
 *
 */
public class MascotaController implements MascotaControllerInterface {

    private MascotappUtilImpl mui;
    private ObjectMapper om;
    private URL url;
    private static Mascota mascota;
    private PropietarioController pc;
    private VeterinarioController vc;
    private static List<Mascota> mascotas;

    public MascotaController() {
        this.pc = new PropietarioController();
        this.vc = new VeterinarioController();
        mui = new MascotappUtilImpl();
    }

    /**
     * Obtiene una Mascota por su ID Utiliza el método readValue() de
     * ObjectMapper para deserializar objetos JSON
     *
     * @param id
     * @return Mascota obtenida
     */
    @Override
    public Mascota getMascota(String id) {
        Mascota masc = null;

        try {
            URL url = mui.getURL("mascotas", id);

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                masc = mui.getJSON_MAPPER().readValue(url, Mascota.class);
                mascota = masc;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return masc;
    }

    /**
     * Añade una Mascota al Propietario
     *
     * Utiliza el método 'peticionPOST()' de MascotapUtilImpl
     *
     * @param masc
     */
    @Override
    public void addMascota(Mascota masc) {

        Propietario p = pc.getPropietario();

        if (p != null) {
            String propId = Long.toString(p.getId());

            try {
                if (masc != null) {
                    url = mui.getURL("mascotas/", propId);

                    try {
                        mui.peticionPOST(url.toString(), mui.getJSON_MAPPER().writeValueAsString(masc));
                    } catch (IOException ex) {
                        Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } catch (MalformedURLException ex) {
                Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Actualiza una Mascota con los datos de la Mascota que entra por parámetro
     * Utiliza el método 'peticionPUT()' de MascotapUtilImpl
     *
     * @param masc
     */
    @Override
    public void updateMascota(Mascota masc) {
        try {

            if (masc != null) {
                String id = Long.toString(masc.getId());
                url = mui.getURL("mascotas/", id);
                try {
                    mui.peticionPUT(url.toString(), mui.getJSON_MAPPER().writeValueAsString(masc));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Borra la Mascota que le entra por parámetro Utiliza el método
     * 'peticionDELETE()' de MascotappUtilImpl
     *
     * @param masc
     */
    @Override
    public void deleteMascota(Mascota masc) {
        try {
            if (masc != null) {
                url = mui.getURL("mascotas/", Long.toString(masc.getId()));
                try {
                    mui.peticionDELETE(url.toString(), mui.getJSON_MAPPER().writeValueAsString(masc));
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene una lista de mascotas por su nombre y el id de su Veterinario
     * Utiliza el método readValue de ObjectMapper(), en lugar de deserializar
     * un objeto, lo hace con una colección
     *
     * @param nombre
     * @return lista
     */
    @Override
    public List<Mascota> getMascotaByNombre(String nombre) {
        String vetId = Long.toString(vc.getVeterinario().getId());

        try {
            String peticion = "mascotas";
            String recurso = "?vet_id=" + vetId + "&nombre=" + nombre;

            om = mui.getJSON_MAPPER();

            URL url = mui.getURL(peticion, recurso);

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                mascotas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Mascota.class));
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mascotas;
    }

    /**
     * Obtiene una lista de mascotas por el id de su Propietario Utiliza el
     * método readValue de ObjectMapper(), en lugar de deserializar un objeto,
     * lo hace con una colección
     *
     * @param id
     * @return lista
     */
    @Override
    public List<Mascota> getMascotasByPropietario(Long id) {
        List<Mascota> listaMascotas = new ArrayList<>();
        try {
            String peticion = "mascotas";
            String recurso = "?prop_id=" + String.valueOf(id);

            om = mui.getJSON_MAPPER();

            URL url = mui.getURL(peticion, recurso);

            CloseableHttpResponse chr = mui.peticionGET(url.toString());
            int status = chr.getStatusLine().getStatusCode();

            if (status == HttpStatus.SC_OK) {
                mascotas = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Mascota.class));
                if (mascotas != null) {
                    listaMascotas = mascotas;
                } else {
                    listaMascotas = new ArrayList();
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaMascotas;
    }

    /**
     * Obtiene la Mascota que está almacenada en la variable estática, para que
     * pueda ser utilizada donde sea necesaria
     *
     * @return Mascota
     */
    public Mascota getMascota() {
        return mascota;
    }

    /**
     * Cambia la variable estática de Mascota por la que le entra por parámetro
     *
     * @param masc
     */
    public void setMascota(Mascota masc) {
        this.mascota = masc;
    }

    /**
     * Obtiene la lista de mascotas que está almacenada en la variable estática,
     * para que pueda ser utilizada donde sea necesaria
     *
     * @return lista
     */
    public List<Mascota> getMascotas() {
        return mascotas;
    }

    /**
     * Obtiene la lista de mascotas que está almacenada en la variable estática,
     * para que pueda ser utilizada donde sea necesaria
     *
     * @param mascotas
     */
    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

}
