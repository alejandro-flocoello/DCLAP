package gtu.g12.dao;

//import gtu.g12.dao.EMFService;
import gtu.g12.model.Solicitud;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public void addSol(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, String password, String categoria, int expediente) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Solicitud solicitud = new Solicitud(nombre,apellido1,apellido2,
					tipoDoc,codDoc,nacionalidad,domicilio,nomUniv,centroUniv,
					correoUniv,password,categoria,expediente);
			em.persist(solicitud);
			em.close();
		}
	}

	@Override
	public List<Solicitud> getSolUnivAprob(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'SOLICITADA' order by id");
		q.setParameter("userId", userId);
		List<Solicitud> solUnivAprob = q.getResultList();
		return solUnivAprob;
	}

	@Override
	public List<Solicitud> getSolBancoAprob(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'ACEPTADA' order by id");
		q.setParameter("userId", userId);
		List<Solicitud> solBancoAprob = q.getResultList();
		return solBancoAprob;
	}

	@Override
	public List<Solicitud> getSolEstampAprob(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'ASOCIADA' order by id");
		q.setParameter("userId", userId);
		List<Solicitud> solEstampAprob = q.getResultList();
		return solEstampAprob;
	}

	@Override
	public List<Solicitud> getSolUnivImp(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'REMITIDA_UNIV' order by id");
		q.setParameter("userId", userId);
		List<Solicitud> solUnivImp = q.getResultList();
		return solUnivImp;
	}

	@Override
	public List<Solicitud> getSolBancoImp(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'REMITIDA_BANCO' order by id");
		q.setParameter("userId", userId);
		List<Solicitud> solBancoImp = q.getResultList();
		return solBancoImp;
	}

	@Override
	public List<Solicitud> getSolEstampImp(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'IMPRESA' order by id");
		q.setParameter("userId", userId);
		List<Solicitud> solEstampImp = q.getResultList();
		return solEstampImp;
	}

	@Override
	public void changeEstadoSol(long id, String estado) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.id = :id");
		q.setParameter("estado", estado);
	}

	@Override
	public void addBan(long id, int cuentaBan, int pin, int cv2) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.id = :id");
		q.setParameter("cuentaBan",cuentaBan);
		q.setParameter("pin",pin);
		q.setParameter("cv2",cv2);
	}

	@Override
	public void addEstamp(long id, int numTarjeta) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.id = :id");
		q.setParameter("numTarjeta",numTarjeta);
	}

	@Override
	public List<Solicitud> listSol() {
		EntityManager em = EMFService.get().createEntityManager();
		// read the existing entries
		Query q = em.createQuery("select m from Solicitud m");
		List<Solicitud> solicitudes = q.getResultList();
		return solicitudes;
	}
	@Override
	public void removeSol(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Solicitud todo = em.find(Solicitud.class, id);
			em.remove(todo);
		} finally {
			em.close();
		}
	}
	//Dudas sobre que esté bien (¿usr?)
	@Override
	public List<String> getUsers() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select distinct t.author from Solicitud t");
		List<String> users = q.getResultList();
		return users;
	}

}
