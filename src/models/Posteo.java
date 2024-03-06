package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Posteo extends Publicacion {
	private String texto;
	private boolean publico;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public Posteo(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico) {
		super(idPublicacion, fecha, hora, creador);
		this.texto = texto;
		this.publico = publico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(publico, texto);
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
		Posteo other = (Posteo) obj;
		return publico == other.publico && Objects.equals(texto, other.texto);
	}

	@Override
	public String toString() {
		return super.toString()+"Posteo [texto=" + texto + ", publico=" + publico + "]";
	}

	@Override
	public boolean contieneTexto(String busco) {
		
		
		
		
		return this.texto.indexOf(busco)!=-1;
	}

}
