package co.edu.uco.fink.data.dao.sql.azuresql;

import co.edu.uco.fink.data.dao.DepartamentoDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.finca.DepartamentoEntity;

import java.sql.Connection;
import java.util.List;

public final class DepartamentoAzureSQLDAO extends SQLconnection implements DepartamentoDAO {

    public DepartamentoAzureSQLDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void actualizar(DepartamentoEntity entidad) {

    }

    @Override
    public final List<DepartamentoEntity> consultar(final DepartamentoEntity entidad) {
        return null;
    }

    @Override
    public final void crear(final DepartamentoEntity entidad) {

    }

    @Override
    public final void eliminar(final int id) {

    }
}
