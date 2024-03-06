package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AvisoGeneral extends Publicacion {

	private String titulo;
	private String cuerpo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public AvisoGeneral(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String titulo,
			String cuerpo) {
		super(idPublicacion, fecha, hora, creador);
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuerpo, titulo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvisoGeneral other = (AvisoGeneral) obj;
		return Objects.equals(cuerpo, other.cuerpo) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return super.toString()+"AvisoGeneral [titulo=" + titulo + ", cuerpo=" + cuerpo + "]";
	}

	@Override
	public boolean contieneTexto(String busco) {
		
		
		
		
		return this.cuerpo.indexOf(busco) !=-1 || this.titulo.indexOf(busco)!=-1;
	}

}
