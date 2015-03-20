package gtu.g12.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registro {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long idReg;
	
	private String emailReg;
	private String passReg;
	private String tipo;
	
	public Registro(String emailReg, String passReg, String tipo){
		this.setEmailReg(emailReg);
		this.setPassReg(passReg);
		this.setTipo(tipo);
	}

	public String getEmailReg() {
		return emailReg;
	}

	public void setEmailReg(String emailReg) {
		this.emailReg = emailReg;
	}

	public String getPassReg() {
		return passReg;
	}

	public void setPassReg(String passReg) {
		this.passReg = passReg;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
