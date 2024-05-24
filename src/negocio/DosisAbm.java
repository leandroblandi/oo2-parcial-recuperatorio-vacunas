package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DosisDao;
import datos.Dosis;
import datos.Persona;

public class DosisAbm {
	private static DosisAbm instancia = null;
	private DosisDao dosisDao;

	private DosisAbm() {
		this.dosisDao = DosisDao.getInstancia();
	}

	public static DosisAbm getInstancia() {
		if (instancia == null) {
			return new DosisAbm();
		}
		return instancia;
	}

	public List<Dosis> traerDosis(Persona persona) {
		return dosisDao.traerDosis(persona);
	}

	public List<Dosis> traerDosis(LocalDate desde, LocalDate hasta) {
		return dosisDao.traerDosis(desde, hasta);
	}

	public List<Dosis> traerDosis(LocalDate desde, LocalDate hasta, boolean tieneComorbilidades) {
		List<Dosis> dosis = dosisDao.traerDosis(desde, hasta);
		List<Dosis> dosisFiltradas = new ArrayList<>();

		for (Dosis d : dosis) {
			if (d.getPersona().isTieneComorbilidad()) {
				dosisFiltradas.add(d);
			}
		}

		return dosisFiltradas;
	}
}
