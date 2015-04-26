package gtu.g12.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;




@PersistenceCapable
public class Solicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	// El identificador es el usuario, asi nos aseguramos de que el correo es único.
	@PrimaryKey
	@Persistent
	private String correoUniv;
	@Persistent
	private String nombre;
	@Persistent
	private String apellido1;
	@Persistent
	private String apellido2;
	@Persistent
	private String tipoDoc;
	@Persistent
	private String codDoc;
	@Persistent
	private String nacionalidad;
	@Persistent
	private String domicilio;
	@Persistent
	private String nomUniv;
	@Persistent
	private String centroUniv;
	@Persistent
	private String banco;

	
	@Persistent
	private String categoria; // alunmno, profeor, PAS
	@Persistent
	private int expediente;
	@Persistent
	private boolean monedero;
	
	
	//@Persistent
	//private float cuentaBan;
	@Persistent
	private String cuentaBan;
	@Persistent
	private int pin;
	@Persistent
	private int cv2;
	
	// private String fotoFondo;
	
	/*
	@Persistent
	private int numTarjeta;*/
	
	@Persistent
	private String numTarjeta;
	@Persistent
	private String estado;
	
	
	public Solicitud(String nombre, String apellido1, String apellido2,
			String tipoDoc, String codDoc, String nacionalidad,
			String domicilio, String nomUniv, String centroUniv,
			String correoUniv, String banco, String categoria, int expediente,
			boolean monedero, String cuentaBan, int pin, int cv2, String numTarjeta,
			String estado) {
		this.setNombre(nombre);
		this.setApellido1(apellido1);
		this.setApellido2(apellido2);
		this.setTipoDoc(tipoDoc);
		this.setCodDoc(codDoc);
		this.setNacionalidad(nacionalidad);
		this.setDomicilio(domicilio);
		this.setNomUniv(nomUniv);
		this.setCentroUniv(centroUniv);
		this.setCorreoUniv(correoUniv);
		this.setBanco(banco);
		this.setCategoria(categoria);
		this.setExpediente(expediente);
		this.setMonedero(monedero);

		this.setCuentaBan(cuentaBan);
		this.setPin(pin);
		this.setCv2(cv2);
		this.setNumTarjeta(numTarjeta);
		this.setEstado(estado);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(String codDoc) {
		this.codDoc = codDoc;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getNomUniv() {
		return nomUniv;
	}

	public void setNomUniv(String nomUniv) {
		this.nomUniv = nomUniv;
	}

	public String getCentroUniv() {
		return centroUniv;
	}

	public void setCentroUniv(String centroUniv) {
		this.centroUniv = centroUniv;
	}

	public String getCorreoUniv() {
		return correoUniv;
	}

	public void setCorreoUniv(String correoUniv) {
		this.correoUniv = correoUniv;
	}
		
	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	
	

	public int getExpediente() {
		return expediente;
	}

	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isMonedero() {
		return monedero;
	}

	public void setMonedero(boolean monedero) {
		this.monedero = monedero;
	}

	/*
	public float getCuentaBan() {
		return cuentaBan;
	}
	public void setCuentaBan(float cuentaBan2) {
		this.cuentaBan = cuentaBan2;
		
	}*/
	
	
	public String getCuentaBan() {
		return cuentaBan;
	}
	public void setCuentaBan(String cuentaBan2) {
		this.cuentaBan = cuentaBan2;
		
	}
	
	
	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getCv2() {
		return cv2;
	}

	public void setCv2(int cv2) {
		this.cv2 = cv2;
	}
	/*
	public int getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(int numTarjeta) {
		this.numTarjeta = numTarjeta;
	}*/
	
	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}