package co.edu.uco.fink.data.dao.factory;

import co.edu.uco.fink.data.dao.CiudadDAO;
import co.edu.uco.fink.data.dao.DepartamentoDAO;
import co.edu.uco.fink.data.dao.PaisDAO;

public abstract class DAOfactory {

    protected abstract void obtenerConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

    public abstract PaisDAO getPaisDAO();

    public abstract DepartamentoDAO getDepartamentoDAO();

    public abstract CiudadDAO getCiudadDAO();
}
