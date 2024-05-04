package co.edu.uco.fink.data.dao.sql;

import java.sql.Connection;

public class SQLconnection {
    private Connection connection;

    protected SQLconnection(final Connection connection) {
            this.connection = connection;
    }

    private final void setConnection(final Connection connection) {
        //TODO: validar que la conexión esté abierta
        
        this.connection = connection;
    }

    protected final Connection getConnection() {
        return connection;
    }
}
