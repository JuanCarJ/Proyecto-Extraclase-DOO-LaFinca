package co.edu.uco.fink.crosscutting.helpers;

import java.sql.Connection;
import java.sql.SQLException;

public final class SQLHelper {

    private SQLHelper() {
        super();
    }

    public static final boolean IsNull (final Connection connection){
        return ObjectHelper.getObjectHelper().isNUll(connection);
    }

    public static final boolean isOpen(final Connection connection){
        try{
            return !IsNull(connection) && !connection.isClosed();
        } catch (SQLException exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0007)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        } catch (Exception exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0008)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        }
    }

    public static final void close(final Connection connection){
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00009);

                throw new CrosscuttinFinKException(mensajeTecnico, mensajeUsuario);
            }

            connection.close();
        } catch (final CrosscuttingFinKException exception) {
            throw exception;
        } catch (SQLException exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0010)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        } catch (Exception exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0011)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        }
    }

    public static final void commit(final Connection connection){
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00012);

                throw new CrosscuttinFinKException(mensajeTecnico, mensajeUsuario);
            }

            if(connection.getAutoCommit()) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00013);

                throw new CrosscuttinFinKException(mensajeTecnico, mensajeUsuario);
            }

            connection.commit();
        } catch (final CrosscuttingFinKException exception) {
            throw exception;
        } catch (SQLException exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0014)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        } catch (Exception exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0015)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        }
    }

    public static final void rollback(final Connection connection){
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00016);

                throw new CrosscuttinFinKException(mensajeTecnico, mensajeUsuario);
            }

            if(connection.getAutoCommit()) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00017);

                throw new CrosscuttinFinKException(mensajeTecnico, mensajeUsuario);
            }

            connection.rollback();
        } catch (final CrosscuttingFinKException exception) {
            throw exception;
        } catch (SQLException exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0018)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        } catch (Exception exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0019)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        }
    }

    public static final void initTransaction(final Connection connection){
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00020);

                throw new CrosscuttinFinKException(mensajeTecnico, mensajeUsuario);
            }

            connection.setAutoCommit(false);
        } catch (final CrosscuttingFinKException exception) {
            throw exception;
        } catch (SQLException exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0021)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        } catch (Exception exception) {
            var mensajeUsuario = "Ha ocurrido un error llevando a cabo la operación deseada...";  //  TODO: MesageCatalogStrategy.getContenidoMensaje(CodigoMensaje,M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de validar si la conexión SQL con la fuente de infromación deseada estaba cerrada..."; //   TODO: MessaggeCatalogStrategy.getContenidoMensaje(CodigoMensaje.M0022)

            throw new       // TODO: CrossciuttingFinKException(mensajeTecnico, mensajeUsuario, exception)
        }
    }
}
