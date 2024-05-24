package dao;

import datos.Persona;

public class PersonaDao extends Dao<Persona> {
	private static PersonaDao instancia = null;

	private PersonaDao() {

	}

	public static PersonaDao getInstancia() {
		if (instancia == null) {
			return new PersonaDao();
		}
		return instancia;
	}

	// CU1
	public Persona traerPersona(long documento) {
		Persona persona = null;
		try {
			iniciaOperacion();
			String hql = "from Persona p where p.documento = :documento";
			persona = (Persona) session.createQuery(hql).setParameter("documento", documento).uniqueResult();
		} finally {
			session.close();
		}
		return persona;
	}
}
