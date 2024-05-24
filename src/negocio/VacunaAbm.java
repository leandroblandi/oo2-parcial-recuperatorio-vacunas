package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.VacunaDao;
import datos.Vacuna;

public class VacunaAbm {
	private static VacunaAbm instancia = null;
	private VacunaDao vacunaDao;

	private VacunaAbm() {
		this.vacunaDao = VacunaDao.getInstancia();
	}

	public static VacunaAbm getInstancia() {
		if (instancia == null) {
			return new VacunaAbm();
		}
		return instancia;
	}

	public List<Vacuna> traerVacuna(int mesesDesde, int mesesHasta) {
		List<Vacuna> vacunas = vacunaDao.traerVacunas();
		List<Vacuna> vacunasFiltradas = new ArrayList<>();
		LocalDate fechaHoy = LocalDate.of(2020, 5, 1);
		int cantMesesElaboracion = 0;

		for (Vacuna vacuna : vacunas) {
			cantMesesElaboracion = vacuna.calcularMesesDesdeElaboracion(fechaHoy);
			if (cantMesesElaboracion >= mesesDesde && cantMesesElaboracion <= mesesHasta) {
				vacunasFiltradas.add(vacuna);
			}
		}
		return vacunasFiltradas;
	}
}
