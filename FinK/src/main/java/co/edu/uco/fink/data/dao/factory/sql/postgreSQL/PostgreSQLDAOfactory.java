package co.edu.uco.fink.data.dao.factory.sql.postgreSQL;

import co.edu.uco.fink.crosscutting.helpers.SQLHelper;
import co.edu.uco.fink.data.dao.*;
import co.edu.uco.fink.data.dao.factory.DAOfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PostgreSQLDAOfactory extends DAOfactory {

    private Connection connection;

    public PostgreSQLDAOfactory() { obtenerConexion(); }

    protected void obtenerConexion(){
        try {
            String url = "jdbc:postgresql://viaduct.proxy.rlwy.net:12615/railway";
            String user = "postgres";
            String password = "NupSsFbtiwYHVbMKuTkunrSzqKwraRIq";
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
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
}
