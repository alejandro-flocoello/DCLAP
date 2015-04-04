package gtu.g12.dao;

import java.util.List;

import gtu.g12.model.Solicitud;

public interface SolicitudDAO {
		
	//Usuario añade solicitud:
	boolean addSol(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, byte[] foto, String categoria, int expediente,
			boolean monedero, int cuentaBan, int pin, int cv2, int numTarjeta,
			String estado);
	
	//Lista de solicitudes dependiendo del estado:
	List<Solicitud> getSolPorEstado(String estado);
	
	//Extrae la solicitud de un usuario dependiendo del correo
	public Solicitud getSol(String email);
	
	//Lista de solicitudes
	public List<Solicitud> getSolPorEstadoYBanco(String estado);
	
	//Lista de solicitudes
	public List<Solicitud> getSolPorEstadoYNoBanco(String estado);
	
	//Lista de solicitudes
	public List<Solicitud> getSolPorEstadoYNOBanco(String estado);
		
	//Cambiar estado solicitud:
	public void changeEstadoSol (long id, String estado);
	
	//Añadir datos bancanrios solicitud:
	public void addBan (long id, int cuentaBan, int pin, int cv2);
	
	//Añadir datos estampacion solicitud:
	public void addEstamp (long id, int numTarjeta);
	
	//Modifica el campo del servicio dual a true si el usuario lo solicita o a false si no lo hace.
	public void changeMonederoSol(String correo, boolean dual);
	
	//Administrador:
	public List<Solicitud> listSol();
	public boolean removeSol (long id);
	boolean removeSolicitudes();
}
