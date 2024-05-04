package co.edu.uco.fink.data.dao.sql.azuresql;

import co.edu.uco.fink.data.dao.CiudadDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.CiudadEntity;

import java.sql.Connection;
import java.util.List;

public final class CiudadAzureSQLDAO extends SQLconnection implements CiudadDAO {

    public CiudadAzureSQLDAO(Connection connection) {
        super(connection);
    }

    @Override
    public final void actualizar(final CiudadEntity entidad) {

    }

    @Override
    public final List<CiudadEntity> consultar(final CiudadEntity entidad) {
        return null;
    }

    @Override
    public final void crear(final CiudadEntity entidad) {

    }

    @Override
    public final void eliminar(final int id) {

    }
}
