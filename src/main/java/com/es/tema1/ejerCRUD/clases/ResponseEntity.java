package com.es.tema1.ejerCRUD.clases;

import java.util.HashMap;

public class ResponseEntity {

    private String body;
    private HashMap<Integer, String> codigoRespuesta;


    public ResponseEntity(int codigo, String body) {
        this.codigoRespuesta = getCodigoRespuesta(codigo);
        this.body = body;
    }

    private HashMap<Integer, String> getCodigoRespuesta(int codigo) {

        String codigoSt = codigo+"";
        String respuesta = "";
        HashMap<Integer, String> mapa = new HashMap<Integer, String>();

        if(codigoSt.startsWith("1")) {
            switch (codigoSt) {
                case "101": respuesta = "Switching Protocols"; break;
                case "102": respuesta = "Processing"; break;
                case "103": respuesta = "Early Hints"; break;
                default: respuesta = "Continue"; break;
            }
        } else if(codigoSt.startsWith("2")) {

            switch (codigoSt) {
                case "201": respuesta = "Created"; break;
                case "202": respuesta = "Accepted"; break;
                case "203": respuesta = "Non-Authoritative Information"; break;
                case "204": respuesta = "No Content"; break;
                default: respuesta = "OK"; break;
            }

        } else if(codigoSt.startsWith("3")) {
            switch (codigoSt) {
                case "301": respuesta = "Moved Permanently"; break;
                case "302": respuesta = "Found"; break;
                case "303": respuesta = "See Other"; break;
                case "304": respuesta = "Not Modified"; break;
                default: respuesta = "Multiple Choices"; break;
            }

        } else if(codigoSt.startsWith("4")){
            switch (codigoSt) {
                case "401": respuesta = "Unauthorized"; break;
                case "402": respuesta = "Payment Required"; break;
                case "403": respuesta = "Forbidden"; break;
                case "404": respuesta = "Not Found"; break;
                case "409": respuesta = "Conflict"; break;
                default: respuesta = "Bad Request"; break;
            }

        } else if(codigoSt.startsWith("5")){
            switch (codigoSt) {
                case "501": respuesta = "Not Implemented"; break;
                case "502": respuesta = "Bad Gateway"; break;
                case "503": respuesta = "Service Unavailable"; break;
                default: respuesta = "Internal Server Error"; break;
            }

        } else {
            codigoSt = "418";
            respuesta = "I'm a teapot";
        }

        try {
            mapa.put(Integer.valueOf(codigoSt), respuesta);
        } catch (NumberFormatException e) {
            mapa.put(500, "Internal Server Error");
        }
        return mapa;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nResponseEntity {");
        sb.append("\nbody:\n").append(body);
        sb.append("\ncodigoRespuesta: ").append(codigoRespuesta);
        sb.append("}");
        return sb.toString();
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HashMap<Integer, String> getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(HashMap<Integer, String> codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
}
