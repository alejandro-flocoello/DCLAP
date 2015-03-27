package gtu.g12.dao;

import gtu.g12.model.Solicitud;
import gtu.g12.model.Usuario;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

	private static UsuarioDAOImpl instance;

	private UsuarioDAOImpl() {
	}

	public static UsuarioDAOImpl getInstance() {
		if (instance == null)
			instance = new UsuarioDAOImpl();
		return instance;
	}

	// elimina todos los usuario. Pone la base de datos a cero.
	@Override
	public boolean removeUsuarios() {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery(Usuario.class);
			try {
				q.deletePersistentAll();
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	}

	// añade un usuario a la base de datos. Si no encuentra ningun problema
	// devuelve true.
	@Override
	public boolean addUsuario(String username, String password, String rol) {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Usuario usuario = new Usuario(username, password, rol);
			try {
				pmf.makePersistent(usuario);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
			pmf.close();
			return true;
		}
	}

	// Comprueba que el usuario introducido está en la bd y que la contraseña
	// corresponde a dicho usuario.
	@Override
    public Usuario getUserPassword(String username, String password) {
		
        PersistenceManager pmf = PMF.get().getPersistenceManager();
        
        Usuario u = pmf.getObjectById(Usuario.class, username);
        
        	if(u.getPassword().equals(password) && u.getUsuario().equals(username)){
                return u;
        	}
        return null;
    }

	@Override
	public List<Usuario> listaUsuarios() {
		synchronized (this) {

			List<Usuario> usuarios = new ArrayList<Usuario>();

			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery(Usuario.class);
			try {
				usuarios = (List<Usuario>) q.execute();
			} catch (Exception e) {
				return null;
			}
			return usuarios;
		}
	}

}
