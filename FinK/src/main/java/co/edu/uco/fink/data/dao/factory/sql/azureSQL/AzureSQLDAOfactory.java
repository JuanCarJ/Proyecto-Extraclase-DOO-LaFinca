package co.edu.uco.fink.data.dao.factory.sql.azureSQL;

import co.edu.uco.fink.data.dao.CiudadDAO;
import co.edu.uco.fink.data.dao.DepartamentoDAO;
import co.edu.uco.fink.data.dao.PaisDAO;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.data.dao.sql.azuresql.CiudadAzureSQLDAO;
import co.edu.uco.fink.data.dao.sql.azuresql.DepartamentoAzureSQLDAO;
import co.edu.uco.fink.data.dao.sql.azuresql.PaisAzureSQLDAO;

import java.sql.Connection;

public final class AzureSQLDAOfactory extends DAOfactory {

    private Connection connection;

    public AzureSQLDAOfactory(){
        obtenerConexion();
    }

    @Override
    protected void obtenerConexion() {
        connection = null;
    }

    @Override
    public void iniciarTransaccion() {

    }

    @Override
    public void confirmarTransaccion() {

    }

    @Override
    public void cancelarTransaccion() {

    }

    @Override
    public void cerrarConexion() {

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
