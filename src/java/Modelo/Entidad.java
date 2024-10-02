
package Modelo;


public class Entidad {

    int idEntidad;
    String nombreEntidad;
    String nitEntidad;
    String tipoEntidad;
    
    public Entidad (){
    
    }

    public Entidad(int idEntidad, String nombreEntidad, String nitEntidad, String tipoEntidad) {
        this.idEntidad = idEntidad;
        this.nombreEntidad = nombreEntidad;
        this.nitEntidad = nitEntidad;
        this.tipoEntidad = tipoEntidad;
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

    
    
    
    
    
    
}
