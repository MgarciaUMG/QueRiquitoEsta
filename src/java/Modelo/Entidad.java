
package Modelo;


public class Entidad {

    int idEntidad;
    String nombreEntidad;
    String nitEntidad;
    String tipoEntidad;
    String correoEntidad;
    String direccionEntidad;
    String telefonoEntidad;
    
    public Entidad (){
    
    }

    public Entidad(int idEntidad, String nombreEntidad, String nitEntidad, String tipoEntidad, String correoEntidad, String direccionEntidad, String telefono_Entidad) {
        this.idEntidad = idEntidad;
        this.nombreEntidad = nombreEntidad;
        this.nitEntidad = nitEntidad;
        this.tipoEntidad = tipoEntidad;
        this.correoEntidad = correoEntidad;
        this.direccionEntidad = direccionEntidad;
        this.telefonoEntidad = telefonoEntidad;
    }

    public int getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(int idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getNitEntidad() {
        return nitEntidad;
    }

    public void setNitEntidad(String nitEntidad) {
        this.nitEntidad = nitEntidad;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public void setTipoEntidad(String tipoEntidad) {
        this.tipoEntidad = tipoEntidad;
    }

    public String getCorreoEntidad() {
        return correoEntidad;
    }

    public void setCorreoEntidad(String correoEntidad) {
        this.correoEntidad = correoEntidad;
    }

    public String getDireccionEntidad() {
        return direccionEntidad;
    }

    public void setDireccionEntidad(String direccionEntidad) {
        this.direccionEntidad = direccionEntidad;
    }

    public String getTelefonoEntidad() {
        return telefonoEntidad;
    }

    public void setTelefonoEntidad(String telefonoEntidad) {
        this.telefonoEntidad = telefonoEntidad;
    }

   

    
    
    
    
    
    
}
