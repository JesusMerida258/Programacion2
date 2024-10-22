/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Gestor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
 *
 * @author guide
 */
public class ExtraerMetadatos {
 

    // Metodo para extraer los metadatos de un archivo
    public Map<String, String> extraerMetadatos(File archivo) {
        Map<String, String> metadatos = new HashMap<>(); // Guardar los metadatos extraidos
        
        try {
            AudioFile audioFile = AudioFileIO.read(archivo); // leer el archivo de audio
            Tag tag = audioFile.getTag(); // obtener los metadatos
               
            int tiempoSegundos = audioFile.getAudioHeader().getTrackLength();
            int minutes = tiempoSegundos / 60;//dividir en minutos 
            int seconds = tiempoSegundos % 60;//dividir en segundos
            String enMinutos = String.format("%d:%02d", minutes, seconds);//formatear a minutos

            
            // Extraer los campos que me interesan y almacenarlos en el mapa
            if (tag != null) {
                metadatos.put("nombre", archivo.getName());
                metadatos.put("artista", tag.getFirst(FieldKey.ARTIST));
                metadatos.put("album", tag.getFirst(FieldKey.ALBUM));
                metadatos.put("genero", tag.getFirst(FieldKey.GENRE));
                metadatos.put("anio", tag.getFirst(FieldKey.YEAR));
                metadatos.put("duracion", enMinutos + "s");
                metadatos.put("tamanio", String.valueOf(archivo.length() / (1024 * 1024)) + " MB"); // tamanio en MB
            } else {
                // Si no hay metadatos, agregar valores por defecto
                metadatos.put("nombre", archivo.getName());
                metadatos.put("artista", "Desconocido");
                metadatos.put("album", "Desconocido");
                metadatos.put("genero", "Desconocido");
                metadatos.put("anio", "Desconocido");
                metadatos.put("duracion", "0");
                metadatos.put("tamanio", String.valueOf(archivo.length() / (1024 * 1024)) + " MB");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de audio: " + e.getMessage());
        }

        return metadatos;
    }

}
