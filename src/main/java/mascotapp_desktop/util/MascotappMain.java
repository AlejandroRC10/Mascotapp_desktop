/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mascotapp_desktop.util;

import mascotapp_desktop.views.Login;

/**
 *
 * @author Alejandro Rodríguez Campiñez
 * @version 2021/05/30
 * 
 * Clase que inicia la aplicación desde la pantalla de Login
 */
public class MascotappMain {

    public static void main(String[] args) throws Exception {
        
        Login log = new Login();
        log.setVisible(true);

    }

}
