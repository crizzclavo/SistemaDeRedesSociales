package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sistema {
	private List<Usuario> lstUsuarios;
	private List<Publicacion> lstPublicacion;
	private List<Comentario> lstComentarios;

	public Sistema() {
		super();
		this.lstUsuarios = new ArrayList<Usuario>();
		this.lstPublicacion = new ArrayList<Publicacion>();
		this.lstComentarios = new ArrayList<Comentario>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(lstComentarios, lstPublicacion, lstUsuarios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sistema other = (Sistema) obj;
		return Objects.equals(lstComentarios, other.lstComentarios)
				&& Objects.equals(lstPublicacion, other.lstPublicacion)
				&& Objects.equals(lstUsuarios, other.lstUsuarios);
	}

	@Override
	public String toString() {
		return "Sistema [\nlstUsuarios=" + lstUsuarios + "\nlstPublicacion=" + lstPublicacion + "\nlstComentarios="
				+ lstComentarios + "]";
	}

	public Usuario traerUsuario(String nombreUsuario) {

		int i = 0;

		Usuario usuarioEncontrado = null;

		while (i < lstUsuarios.size() && usuarioEncontrado == null) {

			if (nombreUsuario.contentEquals(lstUsuarios.get(i).getNombreUsuario())) {

				usuarioEncontrado = lstUsuarios.get(i);
			}

			i++;

		}

		return usuarioEncontrado;

	}

	public boolean agregarUsuario(String nombreUsuario, LocalDate fechaAlta) throws Exception {

		if (traerUsuario(nombreUsuario) != null)
			throw new Exception("error este usuario ya existe");

		int idUsuario = 1;

		if (lstUsuarios.size() > 0) {
			idUsuario = lstUsuarios.get(lstUsuarios.size() - 1).getIdUsuario() + 1;

		}

		return lstUsuarios.add(new Usuario(idUsuario, nombreUsuario, fechaAlta));

	}

	
	
	public Publicacion traerPublicacion(String nombreUsuario, LocalDate fecha, LocalTime hora) {
		
		int i=0;
		Publicacion publicacion=null;
		
		while (i<lstPublicacion.size() && publicacion==null) {
		   
			
			if(nombreUsuario.equals(lstPublicacion.get(i).getCreador().getNombreUsuario()) 
					&&  fecha.equals(lstPublicacion.get(i).getFecha()) && hora.equals(lstPublicacion.get(i).getHora())) {
				
				
		        publicacion=lstPublicacion.get(i);
			}
			
			i++;
		}
		
		return publicacion;
	}
	
	public boolean agregarPosteo (LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico) throws Exception {
		
		
		if (traerPublicacion(creador.getNombreUsuario(), fecha, hora) != null)
			throw new Exception("error esta publicacion ya existe");

		int idPublicacion= 1;
		
		if(lstPublicacion.size()>0) {
			idPublicacion=lstPublicacion.get(lstPublicacion.size()-1).getIdPublicacion()+1;
			
		}
		
		return lstPublicacion.add(new Posteo (idPublicacion, fecha, hora, creador, texto, publico));
		
	}
	
	public boolean agregarAvisoGeneral(LocalDate fecha, LocalTime hora, Usuario creador, String titulo,
			String cuerpo) throws Exception {
		
		if (traerPublicacion(creador.getNombreUsuario(), fecha, hora) != null)
			throw new Exception("error esta publicacion ya existe");
		
		
		
		int idPublicacion=1;
		
		if(lstPublicacion.size()>0) {
			idPublicacion=lstPublicacion.get(lstPublicacion.size()-1).getIdPublicacion()+1;
			
		}
		
		return lstPublicacion.add( new AvisoGeneral (idPublicacion, fecha, hora, creador, cuerpo, cuerpo));
		
		
	}
	
	public boolean agregarComentario(int identificacion, Publicacion publicacion, Usuario usuario, String texto) {
		int idComentario=1;
		
		if(lstComentarios.size()>0) {
			idComentario=lstComentarios.get(lstComentarios.size()-1).getIdComentario()+1;
		}
		
		
		return lstComentarios.add( new Comentario(idComentario, identificacion, publicacion, usuario, texto));
	}
	
	
	
	
	
	public List<Publicacion> traerPublicacionesPublicas(LocalDate fechaDesde, LocalDate fechaHasta){
		
		List<Publicacion> publicas= new ArrayList();
		
		int i=0;
		
		while(i<lstPublicacion.size()) {
			
			Posteo posteo=null;
			
			
			if(!lstPublicacion.get(i).getFecha().isBefore(fechaDesde) && !lstPublicacion.get(i).getFecha().isAfter(fechaHasta) && lstPublicacion.get(i) instanceof Posteo) {
			
			
				
				posteo=(Posteo) lstPublicacion.get(i);
				
				
				if(posteo.isPublico()) {
				
				
				publicas.add(lstPublicacion.get(i));
				
				}
			}
			
			else if(!lstPublicacion.get(i).getFecha().isBefore(fechaDesde) && !lstPublicacion.get(i).getFecha().isAfter(fechaHasta) && lstPublicacion.get(i) instanceof AvisoGeneral) {
				
				publicas.add(lstPublicacion.get(i));
			}
			
			
			
			i++;
		}
		
		
		
		 return publicas;
	}
	
	
	
	
	
	
	
	
	

	
	

	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}

	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}

	public List<Publicacion> getLstPublicacion() {
		return lstPublicacion;
	}

	public void setLstPublicacion(List<Publicacion> lstPublicacion) {
		this.lstPublicacion = lstPublicacion;
	}

	public List<Comentario> getLstComentarios() {
		return lstComentarios;
	}

	public void setLstComentarios(List<Comentario> lstComentarios) {
		this.lstComentarios = lstComentarios;
	}
	
	
}
