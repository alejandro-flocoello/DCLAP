package gtu.g12.model;

import java.io.Serializable;

import javax.jdo.annotations.PrimaryKey;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitud implements Serializable {
		private static final long serialVersionUID = 1L;
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		@PrimaryKey
		private String correoUniv;
		
		private String nombre;
		private String apellido1;
		private String apellido2;
		private String tipoDoc;
		private String codDoc;
		private String nacionalidad;
		private String domicilio;
		//private String fotografia;
		private String nomUniv;
		private String centroUniv;
		
		//private String password;
		private String categoria; //alunmno, profeor, PAS
		private int expediente;
		private boolean monedero;
		
		private int cuentaBan;
		private int pin;
		private int cv2;
		
		//private String fotoFondo;
		private int numTarjeta;
		
		private String estado; //NULO, SOLICITADA, ACEPTADA_UNIV, RECHAZADA_UNIV, ASOCIADA_BANCO, RECHAZADA_BANCO, IMPRESA_ESTAMP, RECHAZADA_ESTAMP, REMITIDA_BANCO, REMITIDA_UNIV, REMITIDA_USR
		
		public Solicitud(String nombre,String apellido1,String apellido2,String tipoDoc,String codDoc,
				String nacionalidad,String domicilio,String nomUniv,String centroUniv,String correoUniv,String categoria, int expediente, boolean monedero, int cuentaBan, int pin, int cv2, int numTarjeta, String estado) {
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
			//this.setPassword(password);
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

		public int getCuentaBan() {
			return cuentaBan;
		}

		public void setCuentaBan(int cuentaBan) {
			this.cuentaBan = cuentaBan;
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

		public int getNumTarjeta() {
			return numTarjeta;
		}

		public void setNumTarjeta(int numTarjeta) {
			this.numTarjeta = numTarjeta;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
}

