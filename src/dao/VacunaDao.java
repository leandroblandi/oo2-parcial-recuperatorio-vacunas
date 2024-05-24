package dao;

import java.util.List;

import datos.Vacuna;

public class VacunaDao extends Dao<Vacuna> {
	private static VacunaDao instancia = null;

	private VacunaDao() {

	}

	public static VacunaDao getInstancia() {
		if (instancia == null) {
			return new VacunaDao();
		}
		return instancia;
	}

	public List<Vacuna> traerVacunas() {
		List<Vacuna> vacunas = null;
		try {
			iniciaOperacion();
			String hql = "from Vacuna v";
			vacunas = session.createQuery(hql, Vacuna.class).getResultList();
		} finally {
			session.close();
		}
		return vacunas;
	}
}

