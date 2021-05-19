/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.views;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mascotapp_desktop.util.MascotappUtilImpl;
import mascotapp_desktop.controllers.VeterinarioController;
import mascotapp_desktop.models.Propietario;
import mascotapp_desktop.models.Mascota;
import mascotapp_desktop.models.Veterinario;

/**
 *
 * @author alex_
 */
public class PruebaJSON {

    public static void main(String[] args) throws Exception {
        
        Login1 log = new Login1();
        log.setVisible(true);
        
//        MascotappUtilImpl curl = new MascotappUtilImpl();
//        ObjectMapper om;
//
//        //Obtener entidad 
////        String peticion = "veterinarios/";
////        String recurso = "1";
////        String metodo = "GET";
////        //curl.peticionHttp(peticion, recurso, metodo);
////        
////        URL url = curl.getURL(peticion, recurso);
////        Veterinario cli = curl.getJSON_MAPPER().readValue(url, Veterinario.class);
////        System.out.println(cli.toString());
//
//        //Obtener lista de entidades por id de otra entidad (clientes por id veterinario)
////        String peticion = "clientes/";
////        String recurso = "?vet_id=1";
////
////        om = curl.getJSON_MAPPER();
////
////        URL url = curl.getURL(peticion, recurso);
////        List<Cliente> clientes = om.readValue(url, om.getTypeFactory().constructCollectionType(ArrayList.class, Propietario.class));
////        System.out.println(clientes.toString());
//        //Obtener Mascotas
////        String peticion = "mascotas/";
////        String recurso = "2";
////        String metodo = "GET";
////
////        //curl.peticionHttp(peticion, recurso, metodo);
////
//        String peticion = "veterinarios";
//        String recurso = "1";
//        URL url = curl.getURL(peticion, recurso);
////        Mascota masc = curl.getJSON_MAPPER().readValue(url, Mascota.class);
////
////        System.out.println(masc.toString());
//
// //       Veterinario vet = new Veterinario("Pep", "Fernandez", "Pep vet", 12345, "PepFer", "1234", "aaaaa", "123456789");
//        
////        Veterinario vetChange1 = new Veterinario("Pep", "Fernandez", "Pep vet", 12345L, "Pepito", "1234", "aaaaa", "123456780");
////        Veterinario vetChange = new Veterinario("Paco", "Mer Ienda", "Pep vet", 124L, "PepFer", "1234", "C/aaa", "999888777");
//      VeterinarioController vc = new VeterinarioController();
//        vc.getVeterinario(recurso);
////        vetChange.setId(Long.parseLong(recurso));
////        //vetChange.setNumColegiado(12346);
////        vetChange.setApellidos("Campiñez");
//       // System.out.println(vetChange.toString());
//        //curl.postJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString( vetChange1));
//        
//        //curl.putJson(url.toString(), curl.getJSON_MAPPER().writeValueAsString( vetChange));
//        
//       // System.out.println("PJ--------->" + curl.getJSON_MAPPER().writeValueAsString( vetChange));
//        
        //System.out.println("------------------>>>> "+vc.login("Pepito", "1234"));

    }

}
