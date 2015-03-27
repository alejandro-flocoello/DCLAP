package gtu.g12.dao;

import java.util.List;

import gtu.g12.model.Solicitud;
import gtu.g12.model.Usuario;

public interface UsuarioDAO {
	//metodo que elimia usuarios
	public boolean removeUsuarios();
	
	//metodo que añade un usuario
	public boolean addUsuario(String username, String password, String rol);
	
	//metodo que comprueba correspondencia usuario-contraseña. Si no existe un usuario con esa contraseña devuelve null
	// devuelve Usuario, con sus valores de username, password y rol
	public Usuario getUserPassword(String username, String password);
	
	// muestra lista con todos los usuarios en la bd
	public List<Usuario> listaUsuarios();
}
