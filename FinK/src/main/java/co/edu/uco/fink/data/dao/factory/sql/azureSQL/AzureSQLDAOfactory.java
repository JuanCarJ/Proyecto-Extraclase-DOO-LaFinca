package co.edu.uco.fink.data.dao.factory.sql.azureSQL;

import co.edu.uco.fink.crosscutting.helpers.SQLHelper;
import co.edu.uco.fink.data.dao.CiudadDAO;
import co.edu.uco.fink.data.dao.DepartamentoDAO;
import co.edu.uco.fink.data.dao.PaisDAO;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.data.dao.sql.azuresql.CiudadAzureSQLDAO;
import co.edu.uco.fink.data.dao.sql.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.fink.data.dao.sql.azuresql.PaisAzureSQLDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AzureSQLDAOfactory extends DAOfactory {

    private Connection connection;

    public AzureSQLDAOfactory(){
        obtenerConexion();
    }

    @Override
    protected void obtenerConexion() {
        final String connectionURL = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";

        try{
            connection = DriverManager.getConnection(connectionURL);
        } catch (final SQLException exception){
        } catch (final Exception exception){
        }
        // TODO: connectarse a una base de datos azure SQL
    }

    @Override
    public void iniciarTransaccion() {
        SQLHelper.initTransaction(connection);
    }

    @Override
    public void confirmarTransaccion() {
        SQLHelper.commit(connection);
    }

    @Override
    public void cancelarTransaccion() {
        SQLHelper.rollback(connection);
    }

    @Override
    public void cerrarConexion() {
        SQLHelper.close(connection);
    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzureSQLDAO(connection);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzureSQLDAO(connection);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadAzureSQLDAO(connection);
    }
}
