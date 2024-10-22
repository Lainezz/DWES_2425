package com.es.tema1.cleanCode.ejerIsAdmin.model;

import java.util.Objects;

public class Usuario {

    private String correo;
    private String password;
    private boolean isAdmin;

    public Usuario(String correo, String password, boolean isAdmin) {
        this.correo = correo;
        this.password = password;
        this.isAdmin = isAdmin;
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return Objects.equals(correo, usuario.correo);
    }

    @Override
    public int hashCode() {
        return correo != null ? correo.hashCode() : 0;
    }
}
