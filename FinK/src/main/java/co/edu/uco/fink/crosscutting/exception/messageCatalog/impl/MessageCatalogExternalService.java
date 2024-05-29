package co.edu.uco.fink.crosscutting.exception.messageCatalog.impl;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalog;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.CrosscuttingFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.Mensaje;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;

import java.util.HashMap;
import java.util.Map;

public class MessageCatalogExternalService implements MessageCatalog {

    private final Map<String, Mensaje> mensajes = new HashMap<>();

    @Override
    public final void inicializar() {
        mensajes.clear();
        mensajes.put(CodigoMensaje.M000023.getIdentificador(),
                new Mensaje(CodigoMensaje.M000023, "Se ha presentado un error implementando un insert del pais \"${1}\" en la tabla de \"pais\" de la base de datos Azure SQL..."));
        mensajes.put(CodigoMensaje.M000024.getIdentificador(),
                new Mensaje(CodigoMensaje.M000024, "Se ha presentado un error tratando de realizar un insert del pais \"${1}\" en la tabla de \"pais\" de la base de datos Azure SQL..."));
        mensajes.put(CodigoMensaje.M000025.getIdentificador(),
                new Mensaje(CodigoMensaje.M000025, "El empleado que se está asignando está inactivo"));
        mensajes.put(CodigoMensaje.M000026.getIdentificador(),
                new Mensaje(CodigoMensaje.M000026, "Tarea creada exitosamente"));
    }



    @Override
    public String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
        return obtenerMensaje(codigo, parametros).getContenido();
    }

    @Override
    public final Mensaje obtenerMensaje(CodigoMensaje codigo, final String... parametros) {

        if (ObjectHelper.getObjectHelper().isNUll(codigo)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
            throw new CrosscuttingFinKException(mensajeTecnico, mensajeUsuario);
        }

        if (codigo.isBase()) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,
                    codigo.getIdentificador());
            throw new CrosscuttingFinKException(mensajeTecnico, mensajeUsuario);
        }

        if (!mensajes.containsKey(codigo.getIdentificador())) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,
                    codigo.getIdentificador());
            throw new CrosscuttingFinKException(mensajeTecnico, mensajeUsuario);
        }

        return mensajes.get(codigo.getIdentificador());
    }
}
