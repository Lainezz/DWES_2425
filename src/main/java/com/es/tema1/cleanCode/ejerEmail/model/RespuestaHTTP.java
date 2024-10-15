package com.es.tema1.cleanCode.ejerEmail.model;

public class RespuestaHTTP {
    private int codigoRespuesta;
    private String mensajeRespuesta;
    private UserEmail userEmail;

    public RespuestaHTTP(int codigoRespuesta, String mensajeRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public RespuestaHTTP(int codigoRespuesta, String mensajeRespuesta, UserEmail u) {
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
        this.userEmail = u;
    }

    public int getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(int codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public UserEmail getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(UserEmail userEmail) {
        this.userEmail = userEmail;
    }
}
