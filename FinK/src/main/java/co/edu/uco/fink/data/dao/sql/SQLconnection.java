package co.edu.uco.fink.data.dao.sql;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.DataFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.SQLHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

import java.sql.Connection;

public class SQLconnection {
    private Connection connection;

    protected SQLconnection(final Connection connection) {
        setConnection(connection);
    }

    private final void setConnection(final Connection connection) {
       if (!SQLHelper.isOpen(connection)){
           var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
           var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000027));

           throw new DataFinKException(mensajeTecnico, mensajeUsuario);
       }
        
        this.connection = connection;
    }

    protected final Connection getConnection() {
        return connection;
    }
}
