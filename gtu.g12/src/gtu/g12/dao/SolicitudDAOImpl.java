package gtu.g12.dao;

import gtu.g12.model.Solicitud;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
	
	/*
	@Override
	public boolean addSol(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, byte[] foto, String banco, String categoria, int expediente,boolean monedero, int cuentaBan, int pin, int cv2, int numTarjeta, String estado ) {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Solicitud solicitud = new Solicitud(nombre, apellido1, apellido2, tipoDoc, codDoc, nacionalidad, domicilio, nomUniv, centroUniv, correoUniv, foto,banco, categoria, expediente, monedero, cuentaBan, pin, cv2, numTarjeta,
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
	}*/
	
	
	@Override
	public boolean addSol(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, String banco, String categoria, int expediente,boolean monedero, String cuentaBan, int pin, int cv2, String numTarjeta, String estado ) {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Solicitud solicitud = new Solicitud(nombre, apellido1, apellido2, tipoDoc, codDoc, nacionalidad, domicilio, nomUniv, centroUniv, correoUniv, banco, categoria, expediente, monedero, cuentaBan, pin, cv2, numTarjeta,
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
	public Solicitud getSol(String email) {
		PersistenceManager pmf = PMF.get().getPersistenceManager();
		try{
			Solicitud s = pmf.getObjectById(Solicitud.class, email);
			return s;
		} catch (Exception e){
			return null;
		}
	}
	
	//Extrae la solicitud por el estado
	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> getSolPorEstado(String estado) {
		synchronized (this) {
			List<Solicitud> sol = new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			//Query q = pmf.newQuery(Solicitud.class, estado);
			Query q = pmf.newQuery("select from " + "gtu.g12.model.Solicitud where estado == '" + estado + "'");
			try{
				sol = (List<Solicitud>) q.execute();
			}
			catch (Exception e){
				return null;
			}
			return sol;
			}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Solicitud> getSolEstadoBanco(String banco, String estado) {
		synchronized (this) {
			List<Solicitud> soli = new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery("select from " + "gtu.g12.model.Solicitud where estado == '" + estado + "' & banco == '" + banco + "' ");
	
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> getSolPorEstadoYBanco(String banco, String estado) {
		synchronized (this) {
			List<Solicitud> soli = new ArrayList<Solicitud>();
			
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			Query q = pmf.newQuery("select from " + "gtu.g12.model.Solicitud where estado == '" + estado + "' & monedero == true & banco == '" + banco + "' ");
	
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
	
	@SuppressWarnings("unchecked")
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
	
	@Override
	public void changeMonederoSol(String correo, boolean monedero) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, correo);
	        sol.setMonedero(monedero);
	       
	    } catch (Exception e) {
	    	pm.close();
	    }
	}
	
	
	@Override
	public void changeEstadoSol(String correo, String estado) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, correo);
	        sol.setEstado(estado);
	        sendEmail(sol);
	    } finally {
	        pm.close();
	    }
	}
	
	
	private void sendEmail(Solicitud sol) {
		final String username = "dclap.gtu12@gmail.com";
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        Message simpleMessage = new MimeMessage(session);
        
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(username);
			toAddress = new InternetAddress(sol.getCorreoUniv());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject("Su solicitud ha cambiado de estado");
			simpleMessage.setText("El estado de su solicitud es: " + sol.getEstado());

			Transport.send(simpleMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void changeBancoSol(String correo, String banco) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, correo);
	        sol.setBanco(banco);
	       
	    } catch (Exception e) {
	    	pm.close();
	    }
	}


	@Override
	public void addBan(String correo, String cuentaBan, int pin, int cv2) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, correo);
	        sol.setCuentaBan(cuentaBan);
	        sol.setPin(pin);
	        sol.setCv2(cv2);
	       
	    } finally {
	        pm.close();
	    }
	}
	
	/*
	@Override
	public void addBan(String correo, Float cuentaBan, int pin, int cv2) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, correo);
	        sol.setCuentaBan(cuentaBan);
	        sol.setPin(pin);
	        sol.setCv2(cv2);
	       
	    } finally {
	        pm.close();
	    }
	}*/

	/*
	@Override
	public void addEstamp(String correo, int numTarjeta) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, correo);
	        sol.setNumTarjeta(numTarjeta);
	       
	    } finally {
	        pm.close();
	    }
	}*/
	
	@Override
	public void addEstamp(String correo, String numTarjeta) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    try {
	        Solicitud sol = pm.getObjectById(Solicitud.class, correo);
	        sol.setNumTarjeta(numTarjeta);
	       
	    } finally {
	        pm.close();
	    }
	}

	@SuppressWarnings("unchecked")
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
	public boolean removeSol(String correo) {
		synchronized (this) {
			PersistenceManager pmf = PMF.get().getPersistenceManager();
			try{
				pmf.deletePersistent(correo);
			}
			catch (Exception e){
				return false;
			}
			return true;
		}
		
	}
}