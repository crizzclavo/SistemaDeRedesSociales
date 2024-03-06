package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public abstract class Publicacion {

	private int idPublicacion;
	private LocalDate fecha;
	private LocalTime hora;
	private Usuario creador;

	public int getIdPublicacion() {
		return idPublicacion;
	}

	public void setIdPublicacion(int idPublicacion) {
		this.idPublicacion = idPublicacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creador, fecha, hora, idPublicacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(creador, other.creador) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && idPublicacion == other.idPublicacion;
	}

	public Publicacion(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador) {
		super();
		this.idPublicacion = idPublicacion;
		this.fecha = fecha;
		this.hora = hora;
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Publicacion [idPublicacion=" + idPublicacion + ", fecha=" + fecha + ", hora=" + hora + ", creador="
				+ creador + "]";
	}
	
	public abstract boolean contieneTexto(String busco);
	
	
}
