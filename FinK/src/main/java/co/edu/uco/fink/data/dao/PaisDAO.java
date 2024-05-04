package co.edu.uco.fink.data.dao;

import co.edu.uco.fink.data.dao.general.ActualizarDAO;
import co.edu.uco.fink.data.dao.general.ConsultarDAO;
import co.edu.uco.fink.data.dao.general.CrearDAO;
import co.edu.uco.fink.data.dao.general.EliminarDAO;
import co.edu.uco.fink.entity.PaisEntity;

public interface PaisDAO extends CrearDAO<PaisEntity>, ActualizarDAO<PaisEntity>, EliminarDAO, ConsultarDAO<PaisEntity> {
}
