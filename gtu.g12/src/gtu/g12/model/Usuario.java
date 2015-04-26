package gtu.g12.model;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Usuario implements Serializable {
		private static final long serialVersionUID = 1L;
		
		//El identificador es el usuario, asi nos aseguramos de que el correo es único.
		@PrimaryKey
		@Persistent
		private String usuario;
		@Persistent
		private String password;
		@Persistent
		private String rol;
		
		public Usuario(String usuario, String password, String rol) {
			super();
			this.usuario = usuario;
			this.password = password;
			this.rol = rol;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRol() {
			return rol;
		}
		public void setRol(String rol) {
			this.rol = rol;
		}
}