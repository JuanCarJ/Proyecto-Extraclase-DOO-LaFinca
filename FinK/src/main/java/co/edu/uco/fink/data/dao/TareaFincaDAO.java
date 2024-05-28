package co.edu.uco.fink.data.dao;

import co.edu.uco.fink.data.dao.general.ActualizarDAO;
import co.edu.uco.fink.data.dao.general.ConsultarDAO;
import co.edu.uco.fink.data.dao.general.CrearDAO;
import co.edu.uco.fink.entity.TareaFincaEntity;

public interface TareaFincaDAO extends CrearDAO<TareaFincaEntity>, ActualizarDAO<TareaFincaEntity>, ConsultarDAO<TareaFincaEntity> {
}
