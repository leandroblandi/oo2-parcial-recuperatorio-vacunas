package dao;

import java.time.LocalDate;
import java.util.List;

import datos.Dosis;
import datos.Persona;

public class DosisDao extends Dao<Dosis> {
	private static DosisDao instancia = null;

	private DosisDao() {

	}

	public static DosisDao getInstancia() {
		if (instancia == null) {
			return new DosisDao();
		}
		return instancia;
	}

	public List<Dosis> traerDosis(Persona persona) {
		List<Dosis> dosis = null;
		try {
			iniciaOperacion();
			String hql = "from Dosis d join fetch d.persona p join fetch d.vacuna v where p.idPersona = :idPersona";
			dosis = session.createQuery(hql, Dosis.class).setParameter("idPersona", persona.getIdPersona())
					.getResultList();
		} finally {
			session.close();
		}
		return dosis;
	}

	public List<Dosis> traerDosis(LocalDate desde, LocalDate hasta) {
		List<Dosis> dosis = null;
		try {
			iniciaOperacion();
			String hql = "from Dosis d join fetch d.persona p join fetch d.vacuna v where d.fecha between :desde and :hasta";
			dosis = session.createQuery(hql, Dosis.class).setParameter("desde", desde).setParameter("hasta", hasta)
					.getResultList();
		} finally {
			session.close();
		}
		return dosis;
	}
}
