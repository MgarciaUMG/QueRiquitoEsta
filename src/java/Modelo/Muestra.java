/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;


public class Muestra {

    int idSolicitud;
    String tipoSolicitud;
    String tipoEntidad;
    Date fechaSolicitud ;
    String tipoDocumento;
    String numeroDocumento;
    String nitProveedor;
    String nombreProveedor;
    String correoproveedor;
    String correoSolicitante;
    String direccionProveedor;
    String telefonoProveedor;
    String nitSolicitante;
    String nombreSolicitante;
    String noMuestra;
    String descripcionProducto;
    
    public Muestra (){
    
    }

    public Muestra(int idSolicitud, String tipoSolicitud, String tipoEntidad, Date fechaSolicitud, String tipoDocumento, String numeroDocumento, String nitProveedor, String nombreProveedor, String correoproveedor, String correoSolicitante, String direccionProveedor, String telefonoProveedor, String nitSolicitante, String nombreSolicitante, String noMuestra, String descripcionProducto) {
        this.idSolicitud = idSolicitud;
        this.tipoSolicitud = tipoSolicitud;
        this.tipoEntidad = tipoEntidad;
        this.fechaSolicitud = fechaSolicitud;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nitProveedor = nitProveedor;
        this.nombreProveedor = nombreProveedor;
        this.correoproveedor = correoproveedor;
        this.correoSolicitante = correoSolicitante;
        this.direccionProveedor = direccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.nitSolicitante = nitSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.noMuestra = noMuestra;
        this.descripcionProducto = descripcionProducto;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCorreoproveedor() {
        return correoproveedor;
    }

    public void setCorreoproveedor(String correoproveedor) {
        this.correoproveedor = correoproveedor;
    }

    public String getCorreoSolicitante() {
        return correoSolicitante;
    }

    public void setCorreoSolicitante(String correoSolicitante) {
        this.correoSolicitante = correoSolicitante;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getNitSolicitante() {
        return nitSolicitante;
    }

    public void setNitSolicitante(String nitSolicitante) {
        this.nitSolicitante = nitSolicitante;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getNoMuestra() {
        return noMuestra;
    }

    public void setNoMuestra(String noMuestra) {
        this.noMuestra = noMuestra;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    
    

}
