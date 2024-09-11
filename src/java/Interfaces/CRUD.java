package Interfaces;

import Modelo.Usuario;
import java.util.List;

public interface CRUD {

    public List listar();

    public Usuario listarID(int nit_persona);

    public boolean Agregar(Usuario us);

    public boolean edit(Usuario us);

    public boolean eliminar(int nit_persona);

}
