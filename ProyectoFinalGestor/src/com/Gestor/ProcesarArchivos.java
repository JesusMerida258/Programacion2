/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Gestor;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author guide
 */
public class ProcesarArchivos {
    
        private long totalBytes;
        private int cantidadArchivos;
        private int archivosDuplicados;
        private Map<String, Long> archivosMap; //clase map asocia claves y yo le pase 2 el string que es nombre y el long que es tamano

        // constructor
        public ProcesarArchivos() {
            this.totalBytes = 0;
            this.cantidadArchivos = 0;
            this.archivosDuplicados = 0;
            this.archivosMap = new HashMap<>();
        }

        // metodo para buscar en archivos y carpetas
        public void procesar(File archivo) {
            if (archivo.isFile()) {
                procesararchivo(archivo);
            } else if (archivo.isDirectory()) {
                File[] subArchivos = archivo.listFiles();
                if (subArchivos != null) {
                    for (File subArchivo : subArchivos) {
                        procesar(subArchivo);
                    }
                }
            }
        }

        // metodo para procesar un archivo y ver duplicados
        private void procesararchivo(File archivo) {
            String nombreArchivo = archivo.getName();
            long tamanoArchivo = archivo.length();

            // contar archivos y tamano total
            totalBytes += tamanoArchivo;
            cantidadArchivos++;

            // verificar si el archivo es duplicado
            if (archivosMap.containsKey(nombreArchivo) && archivosMap.get(nombreArchivo) == tamanoArchivo) {
                archivosDuplicados++;
            } else {
                archivosMap.put(nombreArchivo, tamanoArchivo);
            }
        }

        // getters para obtener la informacion
        public int getcantidadarchivos() {
            return cantidadArchivos;
        }

        public double gettotalgb() {
            return totalBytes / (1024.0 * 1024.0 * 1024.0);
        }

        public int getarchivosduplicados() {
            return archivosDuplicados;
        }


}
