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
			String correoUniv, String password, String categoria, int expediente,boolean monedero) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Solicitud solicitud = new Solicitud(nombre,apellido1,apellido2,
					tipoDoc,codDoc,nacionalidad,domicilio,nomUniv,centroUniv,
					correoUniv,password,categoria,expediente,monedero);
			em.persist(solicitud);
			em.close();
		}
	}

	@Override
	public List<Solicitud> getSolUnivAprob() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'SOLICITADA' order by id");
		List<Solicitud> solUnivAprob = q.getResultList();
		return solUnivAprob;
	}

	@Override
	public List<Solicitud> getSolBancoAprob() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'ACEPTADA' order by id");
		List<Solicitud> solBancoAprob = q.getResultList();
		return solBancoAprob;
	}

	@Override
	public List<Solicitud> getSolEstampAprob() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'ASOCIADA' order by id");
		List<Solicitud> solEstampAprob = q.getResultList();
		return solEstampAprob;
	}

	@Override
	public List<Solicitud> getSolUnivImp() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'REMITIDA_UNIV' order by id");
		List<Solicitud> solUnivImp = q.getResultList();
		return solUnivImp;
	}

	@Override
	public List<Solicitud> getSolBancoImp() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'REMITIDA_BANCO' order by id");
		List<Solicitud> solBancoImp = q.getResultList();
		return solBancoImp;
	}

	@Override
	public List<Solicitud> getSolEstampImp() {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.estado = 'IMPRESA' order by id");
		List<Solicitud> solEstampImp = q.getResultList();
		return solEstampImp;
	}
	
	public Solicitud getSol(long id){
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Solicitud t where t.id = :id");
		Solicitud sol = (Solicitud) q.getSingleResult();
		return sol;
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
			Solicitud solicitud = em.find(Solicitud.class, id);
			em.remove(solicitud);
		} finally {
			em.close();
		}
	}
}
