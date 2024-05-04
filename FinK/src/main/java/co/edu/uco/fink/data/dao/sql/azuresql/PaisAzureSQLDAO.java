package co.edu.uco.fink.data.dao.sql.azuresql;

import co.edu.uco.fink.data.dao.PaisDAO;
import co.edu.uco.fink.data.dao.sql.SQLconnection;
import co.edu.uco.fink.entity.PaisEntity;

import java.sql.Connection;
import java.util.List;

public final class PaisAzureSQLDAO extends SQLconnection implements PaisDAO {
    
    public PaisAzureSQLDAO(final Connection connection){
        super(connection);
    }
    @Override
    public final void actualizar(final PaisEntity entidad) {
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("UPDATE Pais");
        sentenciaSQL.append("SET nombre = 'Venezuela");
        sentenciaSQL.append("WHERE id = 1");
    }

    @Override
    public final List<PaisEntity> consultar(final PaisEntity entidad) {
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("SELECT id, nombre");
        sentenciaSQL.append("FROM Pais");
        sentenciaSQL.append("ORDER BY nombre ASC");

        return null;
    }

    @Override
    public final void crear(final PaisEntity entidad) {
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("INSERT INTO Pais(nombre)");
        sentenciaSQL.append("VALUES('Colombia')");
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSQL = new StringBuilder();

        sentenciaSQL.append("DELETE FROM Pais");
        sentenciaSQL.append("WHERE id = 1");
    }
}
