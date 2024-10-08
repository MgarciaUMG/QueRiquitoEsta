
package Modelo;


public class Solicitante {

    int idSolicitante;
    String nombreSolicitante;
    String nitSolicitante;
    String correoSolicitante;

    public Solicitante() {
    }

    public Solicitante(int idSolicitante, String nombreSolicitante, String nitSolicitante, String correoSolicitante) {
        this.idSolicitante = idSolicitante;
        this.nombreSolicitante = nombreSolicitante;
        this.nitSolicitante = nitSolicitante;
        this.correoSolicitante = correoSolicitante;
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public String getNitSolicitante() {
        return nitSolicitante;
    }

    public void setNitSolicitante(String nitSolicitante) {
        this.nitSolicitante = nitSolicitante;
    }

    public String getCorreoSolicitante() {
        return correoSolicitante;
    }

    public void setCorreoSolicitante(String correoSolicitante) {
        this.correoSolicitante = correoSolicitante;
    }
    
    
    
    
    
    
    
    
}
