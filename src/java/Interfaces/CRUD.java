package Interfaces;

import Modelo.Muestra;
import Modelo.Usuario;
import java.util.List;

public interface CRUD {

    public List listar();

    public Usuario listarID(int nit_persona);

    public boolean Agregar(Usuario us);

    public boolean edit(Usuario us);

    public boolean eliminar(int nit_persona);
    
    
    public List listarm();

    public Muestra listarIDm(int IdSolicitud);

    public boolean Agregarm(Muestra mu);

    public boolean editm(Muestra mu);

    public boolean eliminarm(int IdSolicitud);
    
    
    

}
