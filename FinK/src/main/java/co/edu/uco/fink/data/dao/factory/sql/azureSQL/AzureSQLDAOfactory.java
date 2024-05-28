package co.edu.uco.fink.data.dao.factory.sql.azureSQL;

import co.edu.uco.fink.crosscutting.helpers.SQLHelper;
import co.edu.uco.fink.data.dao.*;
import co.edu.uco.fink.data.dao.factory.DAOfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class AzureSQLDAOfactory extends DAOfactory {

    private Connection connection;

    private String host = "ec2-44-209-158-64.compute-1.amazonaws.com";
    private String database = "d6be0iacrla2jt";
    private String user = "ohqbpnkwqkxoly";
    private String password = "fa44911ab8a2ae0393cc9d572c147ecdc3b36d77228d2059351ecccebbf45bcb";


    public AzureSQLDAOfactory(){
        obtenerConexion();
    }

    @Override
    protected void obtenerConexion() {
        final String connectionURL = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";

        try{
            connection = DriverManager.getConnection(connectionURL);
        } catch (final SQLException exception){
            exception.printStackTrace();
        } catch (final Exception exception){
            exception.printStackTrace();
        }
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
    public EmpleadoDAO getEmpleadoDAO() {
        return null;
    }

    @Override
    public LugarFincaDAO getLugarFincaDAO() {
        return null;
    }

    @Override
    public RegistroEstadoTareaDAO getRegistroEstadoTareaDAO() {
        return null;
    }

    @Override
    public SuministroRequeridoDAO getSuministroRequeridoDAO() {
        return null;
    }

    @Override
    public TareaFincaDAO getTareaFincaDAO() {
        return null;
    }

    @Override
    public TipoEstadoDAO getTipoEstadoDAO() {
        return null;
    }

    @Override
    public TipoSuministroDAO getTipoSuministroDAO() {
        return null;
    }

    @Override
    public TipoTareaFincaDAO getTipoTareaFincaDAO() {
        return null;
    }

    @Override
    public FincaDAO getFincaDAO() {
        return null;
    }
}
