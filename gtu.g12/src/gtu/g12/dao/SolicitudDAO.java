package gtu.g12.dao;

import java.util.List;

import gtu.g12.model.Solicitud;

public interface SolicitudDAO {
	
	//usuario añade solicitud:
	boolean addSol(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, String categoria, int expediente,
			boolean monedero, int cuentaBan, int pin, int cv2, int numTarjeta,
			String estado);
	//lista de solicitudes dependiendo del estado:
	public List<Solicitud> getSolPorEstado(String estado);
	
	//Obtener datos de la solicitud (por correo):
	public Solicitud getSol(String correo);
	
	//cambiar estado solicitud:
	public void changeEstadoSol (String correo, String estado);
	//añadir datos bancanrios solicitud:
	public void addBan (String correo, int cuentaBan, int pin, int cv2);
	//añadir datos estampacion solicitud:
	public void addEstamp (String correo, int numTarjeta);
	
	//administrador:
	public List<Solicitud> listSol();
	public boolean removeSol (String correo);
	boolean removeSolicitudes();
	boolean removeSol();

	

	
}
