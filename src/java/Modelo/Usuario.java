/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Soporte
 */
public class Usuario {
    
    int idpersona;
    String login;
    String nit_persona;
    String primer_nombre;
    String segundo_nombre;
    String primer_apellido;
    String segundo_apellido;
    String puesto;
    String rol;
    String password;
    String estado;
    String correo;
    int trabajo;
    String motivo;
    
    public Usuario() {
}

    public Usuario(int idpersona, String login, String nit_persona, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String puesto, String rol, String password, String estado, String correo,int trabajo, String motivo) {
        this.idpersona = idpersona;
        this.login = login;
        this.nit_persona = nit_persona;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.puesto = puesto;
        this.rol = rol;
        this.password = password;
        this.estado = estado;
        this.correo = correo;
        this.trabajo = trabajo;
        this.motivo = motivo;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNit_persona() {
        return nit_persona;
    }

    public void setNit_persona(String nit_persona) {
        this.nit_persona = nit_persona;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(int trabajo) {
        this.trabajo = trabajo;
    }
    

    
}


