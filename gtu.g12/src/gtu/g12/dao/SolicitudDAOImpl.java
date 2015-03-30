package gtu.g12.dao;

import gtu.g12.model.Solicitud;
import gtu.g12.model.Usuario;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class SolicitudDAOImpl implements SolicitudDAO {
	
	private static SolicitudDAOImpl instance;

	private SolicitudDAOImpl() {
	}

	public static SolicitudDAOImpl getInstance(){
		if (instance == null)
			instance = new SolicitudDAOImpl();
		return instance;
	}
	
	
	@Override
	public boolean removeSolicitudes() {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery(Solicitud.class);
			try{
				q.deletePersistentAll();
			}
			catch (Exception e){
				return false;
			}
			return true;
		}
	}
	@Override
	public boolean addSol(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, String categoria, int expediente,boolean monedero, int cuentaBan, int pin, int cv2, int numTarjeta, String estado ) {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Solicitud solicitud = new Solicitud(nombre, apellido1, apellido2, tipoDoc, codDoc, nacionalidad, domicilio, nomUniv, centroUniv, correoUniv, categoria, expediente, monedero, cuentaBan, pin, cv2, numTarjeta,
					estado);
			try{
				pmf.makePersistent(solicitud);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				return false;
			}
			pmf.close();
			return true;
		}
	}

	@Override
	public List<Solicitud> getSolPorEstado(String estado2) {
		synchronized (this) {
			List<Solicitud> soli = new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery("select from " + "gtu.g12.model.Solicitud where estado == '" + estado2 + "'");
			try{
				soli = (List<Solicitud>)q.execute();
			}
			catch (Exception e){
				return null;
			}
			// read the existing entries
			return soli;
			}
	}
	
	
	@Override
	public List<Solicitud> getSolPorEstadoYBanco(String estado) {
		synchronized (this) {
			List<Solicitud> soli = new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery("select from " + "gtu.g12.model.Solicitud where estado == '" + estado + "' & monedero == true");
	
			try{
				soli = (List<Solicitud>)q.execute();
			}
			catch (Exception e){
				return null;
			}
			// read the existing entries
			return soli;
			}
	}
	
	@Override
	public List<Solicitud> getSolPorEstadoYNOBanco(String estado) {
		synchronized (this) {
			List<Solicitud> soli = new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery("select from " + "gtu.g12.model.Solicitud where estado == '" + estado + "' & monedero == false");
	
			try{
				soli = (List<Solicitud>)q.execute();
			}
			catch (Exception e){
				return null;
			}
			// read the existing entries
			return soli;
			}
	}
	
	

	
	
	public List<Solicitud> getSol(long id){
		synchronized (this) {
			List<Solicitud> solId= new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery(Solicitud.class);
			try{
				solId = (List<Solicitud>) q.execute();
			}
			catch (Exception e){
				return null;
			}
			// read the existing entries
			return solId;
			}
	}
	
	@Override
	public void changeEstadoSol(long id, String estado) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, id );
	        sol.setEstado(estado);
	       
	    } finally {
	        pm.close();
	    }
	}

	@Override
	public void addBan(long id, int cuentaBan, int pin, int cv2) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, id );
	        sol.setCuentaBan(cuentaBan);
	        sol.setPin(pin);
	        sol.setCv2(cv2);
	       
	    } finally {
	        pm.close();
	    }
	}

	@Override
	public void addEstamp(long id, int numTarjeta) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, id );
	        sol.setNumTarjeta(numTarjeta);
	       
	    } finally {
	        pm.close();
	    }
	}

	@Override
	public List<Solicitud> listSol() {
		synchronized (this) {
			List<Solicitud> solicitudes= new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery(Solicitud.class);
			try{
				solicitudes = (List<Solicitud>) q.execute();
			}
			catch (Exception e){
				return null;
			}
			return solicitudes;
			}
	}
	@Override
	public boolean removeSol(long id) {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery(Solicitud.class);
			try{
				q.deletePersistentAll();
			}
			catch (Exception e){
				return false;
			}
			return true;
		}
		
	}
}
