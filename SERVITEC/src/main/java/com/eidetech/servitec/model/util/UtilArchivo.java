/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

import com.eidetech.servitec.model.domain.entity.Archivo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laptop-w8
 */
public class UtilArchivo {

    public static String tipoAdministivo = "ADMINISTRATIVO";
    public static String tipoEmpresa = "EMPRESA";
    public static String tipoEgresado = "EGRESADO";
    public static String tipoPublicacion = "PUBLICACION";
    public static String tipoTemp = "TEMP";
    public static String tipoDefault = "DEFAULT";

    public static String carpetaAdministrativo = "administrativo/";
    public static String carpetaOcaa = "ocaa/";
    public static String carpetaBienestar = "bienestar/";
    public static String carpetaReporte = "reporte/";
    public static String carpetaEgresado = "egresado/";
    public static String carpetaEgresadoCV = "cv/";
    public static String carpetaEgresadoImg = "img/";
    public static String carpetaEgresadoInvestigacion = "investigacion/";
    public static String carpetaEmpresa = "empresa/";
    public static String carpetaEmpresaImg = "img/";
    public static String carpetaEmpresaConvocatoria = "convocatoria/";
    public static String carpetaPublicacion = "publicacion/";
    public static String carpetaTemporal = "temp/";

    public static void copyFile(String fileName, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(fileName));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String extensionArchivo(String contentType) {
        if (contentType.equals("image/png")) {
            return "png";
        }
        if (contentType.equals("image/jpeg")) {
            return "jpg";
        }
        if (contentType.equals("image/gif")) {
            return "gif";
        }
        if (contentType.equals("application/pdf")) {
            return "pdf";
        }
        if (contentType.equals("application/msword")) {
            return "docx";
        }
        if (contentType.equals("application/vnd.ms-excel")) {
            return "csv";
        }
        return "jpg";
    }

    public static byte[] readBytesFromFile(String filePath) throws IOException {
        File inputFile = new File(filePath);
        FileInputStream inputStream = new FileInputStream(inputFile);

        byte[] fileBytes = new byte[(int) inputFile.length()];
        inputStream.read(fileBytes);
        inputStream.close();

        return fileBytes;
    }

    public static byte[] obtenerArchivo(List<Archivo> la, String nombreArchivo) {
        byte[] b = null;
        if (la != null && !la.isEmpty()) {
            for (Archivo a : la) {
                if (a.getDnombre().equals(nombreArchivo)) {
                    return a.getBarchivo();
                }
            }
        }
        return b;
    }
    
    public static InputStream getInputStream(byte[] b) {
        InputStream is=new ByteArrayInputStream(b);        
        return is;
    }
    
    public static byte[] getBytes(InputStream is){
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            
            int nRead;
            byte[] data = new byte[1024];
            
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            
            buffer.flush();
            
            return buffer.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(UtilArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


}
