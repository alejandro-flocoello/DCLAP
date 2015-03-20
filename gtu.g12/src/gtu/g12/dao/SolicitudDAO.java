package gtu.g12.dao;

import java.util.List;

import gtu.g12.model.Solicitud;

public interface SolicitudDAO {
	
	//No está claro si los parámetro tiene que coger userId
	
	//usuario añade solicitud:
	public void addSol (String nombre,String apellido1,String apellido2,String tipoDoc,String codDoc,
			String nacionalidad,String domicilio,String nomUniv,String centroUniv,String correoUniv,
			String password,String categoria,int expediente);
	//lista de solicitudes para aprobar:
	public List<Solicitud> getSolUnivAprob(String userId);
	public List<Solicitud> getSolBancoAprob(String userId);
	public List<Solicitud> getSolEstampAprob(String userId);
	//lista de solicitudes para notificar que esta impresa:
	public List<Solicitud> getSolUnivImp(String userId);
	public List<Solicitud> getSolBancoImp(String userId);
	public List<Solicitud> getSolEstampImp(String userId);
	
	//cambiar estado solicitud:
	public void changeEstadoSol (long id, String estado);
	//añadir datos bancanrios solicitud:
	public void addBan (long id, int cuentaBan, int pin, int cv2);
	//añadir datos estampacion solicitud:
	public void addEstamp (long id, int numTarjeta);
	
	//administrador:
	public List<Solicitud> listSol();
	public void removeSol (long id);
	public List<String> getUsers();
}
