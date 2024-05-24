package test;

import java.time.LocalDate;
import java.util.List;

import datos.Dosis;
import datos.Persona;
import datos.Vacuna;
import negocio.DosisAbm;
import negocio.PersonaAbm;
import negocio.VacunaAbm;

public class TestRecuperatorio2021 {
	private static PersonaAbm personaAbm = PersonaAbm.getInstancia();
	private static VacunaAbm vacunaAbm = VacunaAbm.getInstancia();
	private static DosisAbm dosisAbm = DosisAbm.getInstancia();

	public static void main(String[] args) {

		Persona persona = personaAbm.traerPersona(33333333);
		System.out.println("1");
		System.out.println(persona);

		List<Vacuna> vacunas = vacunaAbm.traerVacuna(1, 2);
		System.out.println("2");
		System.out.println(vacunas);

		List<Dosis> dosis = dosisAbm.traerDosis(persona);
		System.out.println("3");
		System.out.println(dosis);

		LocalDate desde = LocalDate.of(2020, 6, 1);
		LocalDate hasta = desde.plusDays(14);
		dosis = dosisAbm.traerDosis(desde, hasta);
		System.out.println("4");
		System.out.println(dosis);

		dosis = dosisAbm.traerDosis(desde, hasta, true);
		System.out.println("5");
		System.out.println(dosis);
	}
}
