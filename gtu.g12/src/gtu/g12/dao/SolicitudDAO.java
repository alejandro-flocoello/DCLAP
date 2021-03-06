package gtu.g12.dao;

import java.util.List;

import gtu.g12.model.Solicitud;

public interface SolicitudDAO {
		
	//Usuario a�ade solicitud:
	boolean addSol(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, String banco, String categoria, int expediente,
			boolean monedero, String cuentaBan, int pin, int cv2, String numTarjeta,
			String estado);
	
	//Lista de solicitudes dependiendo del estado:
	List<Solicitud> getSolPorEstado(String estado);
	
	//Extrae la solicitud de un usuario dependiendo del correo
	public Solicitud getSol(String email);
	
	//Lista de solicitudes
	public List<Solicitud> getSolEstadoBanco(String banco, String estado);
	
	//Lista de solicitudes
	public List<Solicitud> getSolPorEstadoYBanco(String banco, String estado);
	
	//Lista de solicitudes
	public List<Solicitud> getSolPorEstadoYNOBanco(String estado);
		
	//Cambiar estado solicitud:
	public void changeEstadoSol (String correo, String estado);
	
	//A�adir datos bancarios solicitud:
	public void addBan(String email, String cuentaB, int pin, int cv);
	
	//A�adir datos estampacion solicitud:
	public void addEstamp (String correo, String numTarjeta);
	
	//Modifica el campo del servicio dual a true si el usuario lo solicita o a false si no lo hace.
	public void changeMonederoSol(String correo, boolean dual);
	//Modifica el campo de banco dependiendo de la selecci�n del usuario.
	public void changeBancoSol(String correo, String banco);
	
	//Administrador:
	public List<Solicitud> listSol();
	public boolean removeSol (String correo);
	boolean removeSolicitudes();
}