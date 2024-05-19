package co.edu.uco.fink.data.dao;

import co.edu.uco.fink.data.dao.general.ActualizarDAO;
import co.edu.uco.fink.data.dao.general.ConsultarDAO;
import co.edu.uco.fink.data.dao.general.CrearDAO;
import co.edu.uco.fink.data.dao.general.EliminarDAO;
import co.edu.uco.fink.entity.finca.CiudadEntity;

public interface CiudadDAO extends CrearDAO<CiudadEntity>, ActualizarDAO<CiudadEntity>, EliminarDAO, ConsultarDAO<CiudadEntity> {
}
