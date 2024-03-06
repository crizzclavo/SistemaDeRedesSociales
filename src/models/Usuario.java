package models;

import java.time.LocalDate;
import java.util.*;

public class Usuario {
	private int idUsuario;
	private String nombreUsuario;
	private LocalDate fechaAlta;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Usuario(int idUsuario, String nombreUsuario, LocalDate fechaAlta) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.fechaAlta = fechaAlta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaAlta, idUsuario, nombreUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(fechaAlta, other.fechaAlta) && idUsuario == other.idUsuario
				&& Objects.equals(nombreUsuario, other.nombreUsuario);
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", fechaAlta=" + fechaAlta
				+ "]";
	}

}
