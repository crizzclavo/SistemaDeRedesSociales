package test;

import java.time.LocalDate;
import java.time.LocalTime;

import models.Sistema;

public class testSistema {

	// Tenes que seguir esto acordate
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sistema = new Sistema();

		try {

			System.out.println("(1)");

			sistema.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1));
			sistema.agregarUsuario("usuarioCreador2", LocalDate.of(2023, 9, 2));
			sistema.agregarUsuario("usuarioCreador3", LocalDate.of(2023, 9, 3));
			sistema.agregarUsuario("usuarioCreador4", LocalDate.of(2023, 9, 4));
			sistema.agregarUsuario("usuarioCreador5", LocalDate.of(2023, 9, 5));

			sistema.agregarUsuario("usuarioLector1", LocalDate.of(2023, 9, 6));
			sistema.agregarUsuario("usuarioLector2", LocalDate.of(2023, 9, 7));
			sistema.agregarUsuario("usuarioLector3", LocalDate.of(2023, 9, 8));

			System.out.println(sistema);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n(2)");
			sistema.agregarPosteo(LocalDate.of(2023, 10, 1), LocalTime.of(10, 00),
					sistema.traerUsuario("usuarioCreador1"), "Que dia es el segundo parcial de OO1?", true);
			sistema.agregarPosteo(LocalDate.of(2023, 10, 5), LocalTime.of(11, 00),
					sistema.traerUsuario("usuarioCreador2"), "Comenten de que pais me estan leyendo", true);
			sistema.agregarPosteo(LocalDate.of(2023, 10, 10), LocalTime.of(12, 00),
					sistema.traerUsuario("usuarioCreador3"), "Hoy nos reunimos en mi casa!", false);

			sistema.agregarAvisoGeneral(LocalDate.of(2023, 10, 15), LocalTime.of(13, 00),
					sistema.traerUsuario("usuarioCreador4"), "Alerta para vecinos de Lanús",
					"Anuncian fuertes lluvias para las 18Hs");

			sistema.agregarAvisoGeneral(LocalDate.of(2023, 10, 20), LocalTime.of(14, 00),
					sistema.traerUsuario("usuarioCreador5"), "Informacion Importante",
					"La facultad permanecera abierta hasta las 20Hs");

			System.out.println(sistema);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		try {
			System.out.println("\n(3)");

			sistema.agregarComentario(111,
					sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 00)),
					sistema.traerUsuario("usuarioLector2"), "Uruguay");
			
			
			sistema.agregarComentario(222,
					sistema.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 00)),
					sistema.traerUsuario("usuarioLector3"), "Chile");
			
			
			sistema.agregarComentario(333,
					sistema.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 1), LocalTime.of(10, 00)),
					sistema.traerUsuario("usuarioLector1"), "No recuerdo");
			
			
			sistema.agregarComentario(444,
					sistema.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 1), LocalTime.of(10, 00)),
					sistema.traerUsuario("usuarioLector2"), "Es el martes 17/10/2023");

			System.out.println(sistema);

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		try {
			System.out.println("\n(4)");

			
			System.out.println(sistema.traerPublicacionesPublicas(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 17)));

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		
		try {
			System.out.println("\n(5)");

			
			System.out.println(sistema.traerComentariosEnPosteosPorUsuario(sistema.traerUsuario("usuarioLector2")));

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		
		try {
			System.out.println("\n(6)");

			
			System.out.println(sistema.traerPublicacionesQueContenganTexto("de"));

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		
		
		try {
			System.out.println("\n(7)");

			sistema.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1));
		

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

		
		try {
			System.out.println("\n(8)");

			sistema.agregarPosteo(LocalDate.of(2023, 10, 1), LocalTime.of(10, 00),
					sistema.traerUsuario("usuarioCreador1"), "Que dia es el segundo parcial de OO1?", true);
		

		}

		catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

}
