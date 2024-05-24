package negocio;

import dao.PersonaDao;
import datos.Persona;

public class PersonaAbm {
	private static PersonaAbm instancia = null;
	private PersonaDao personaDao;

	private PersonaAbm() {
		this.personaDao = PersonaDao.getInstancia();
	}

	public static PersonaAbm getInstancia() {
		if (instancia == null) {
			return new PersonaAbm();
		}
		return instancia;
	}

	public Persona traerPersona(long documento) {
		return personaDao.traerPersona(documento);
	}
}
