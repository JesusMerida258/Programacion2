/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Gestor;

import java.io.File;

/**
 *
 * @author guide
 */
public class FiltroArchivos {

    //aqui voy a agregar todos lo fintros de musica, video imagenes y los que se me ocurran
    
    // metodo para verificar si el archivo es de musica
    public boolean esarchivomusica(File archivo) {
        String nombre = archivo.getName().toLowerCase(); // convertir el nombre a minusculas para evitar problemas de mayusculas
        return nombre.endsWith(".mp3"); // añadir más formatos si quiero
    }
    
    /*public boolean esImagen(File archivo) {
    String extension = obtenerExtension(archivo);
    return extension.equals("jpg") || extension.equals("png") || extension.equals("gif");
}

    public boolean esVideo(File archivo) {
        String extension = obtenerExtension(archivo);
        return extension.equals("mp4") || extension.equals("avi") || extension.equals("mkv");
    }

*/
    
}
