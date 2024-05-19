package co.edu.uco.fink.data.dao.factory;

import co.edu.uco.fink.data.dao.CiudadDAO;
import co.edu.uco.fink.data.dao.DepartamentoDAO;
import co.edu.uco.fink.data.dao.PaisDAO;
import co.edu.uco.fink.data.dao.factory.enums.Factory;
import co.edu.uco.fink.data.dao.factory.sql.azureSQL.AzureSQLDAOfactory;

public abstract class DAOfactory {

    public static final DAOfactory getFactory(final Factory factory){

        switch (factory) {
            case AZURE_SQL: {

                return new AzureSQLDAOfactory();

                break;
            }
            case SQL_SERVER: {

                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe configurada una factoria de datos para una base de datos SQL_SERVER";

                throw new DataFinKException(mensajeTecnico, mensajeUsuario);

                break;
            }
            case POSTGRESQL: {

                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe configurada una factoria de datos para una base de datos POSTGRESQL";

                throw new DataFinKException(mensajeTecnico, mensajeUsuario);

                break;
            }
            case MYSQL: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe configurada una factoria de datos para una base de datos MYSQL";

                throw new DataFinKException(mensajeTecnico, mensajeUsuario);

                break;
            }
            case ORACLE: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe configurada una factoria de datos para una base de datos ORACLE";

                throw new DataFinKException(mensajeTecnico, mensajeUsuario);

                break;
            }
            default: {
                return new AzureSQLDAOfactory();
            }
        }

        return null;
    }

    protected abstract void obtenerConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

    public abstract PaisDAO getPaisDAO();

    public abstract DepartamentoDAO getDepartamentoDAO();

    public abstract CiudadDAO getCiudadDAO();

   /* public static void main(String[] args){
        DAOfactory.getFactory(Factory.AZURE_SQL).getPaisDAO().crear(null);
        DAOfactory.getFactory(Factory.AZURE_SQL).getPaisDAO().actualizar(null);
        DAOfactory.getFactory(Factory.AZURE_SQL).getPaisDAO().eliminar(0);
        List<PaisEntity> resultados = DAOfactory.getFactory(Factory.AZURE_SQL).getPaisDAO().consultar(null);
    } */ // TODO
}
