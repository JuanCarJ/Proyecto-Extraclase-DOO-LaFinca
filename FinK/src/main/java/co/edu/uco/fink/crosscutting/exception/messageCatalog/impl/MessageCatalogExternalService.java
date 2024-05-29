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
        mensajes.put(CodigoMensaje.M000032.getIdentificador(),
                new Mensaje(CodigoMensaje.M000032, "Se ha presentado un problema registrando la información de la nueva tarea."));
        mensajes.put(CodigoMensaje.M000033.getIdentificador(),
                new Mensaje(CodigoMensaje.M000033, "La tarea que se intenta registrar no tiene empleado"));
        mensajes.put(CodigoMensaje.M000034.getIdentificador(),
                new Mensaje(CodigoMensaje.M000034, "Se ha intentado crear una tarea sin un empleado asignado"));
        mensajes.put(CodigoMensaje.M000035.getIdentificador(),
                new Mensaje(CodigoMensaje.M000035, "El empleado que se está asignando no existe en la finca actual"));
        mensajes.put(CodigoMensaje.M000036.getIdentificador(),
                new Mensaje(CodigoMensaje.M000036, "Se ha intentado asignar un empleado que no existe dentro de la finca actual"));
        mensajes.put(CodigoMensaje.M000037.getIdentificador(),
                new Mensaje(CodigoMensaje.M000037, "El empleado que se está asignando está inactivo"));
        mensajes.put(CodigoMensaje.M000038.getIdentificador(),
                new Mensaje(CodigoMensaje.M000038, "Se ha intentado asignar un empleado que no está activo"));
        mensajes.put(CodigoMensaje.M000039.getIdentificador(),
                new Mensaje(CodigoMensaje.M000039, "El tipo de tarea que se intentó ingresar no es valido"));
        mensajes.put(CodigoMensaje.M000040.getIdentificador(),
                new Mensaje(CodigoMensaje.M000040, "Se ha intentado asignar un tipo de tarea que no es valido"));
        mensajes.put(CodigoMensaje.M000041.getIdentificador(),
                new Mensaje(CodigoMensaje.M000041, "El lugar ingresado no existe en la finca"));
        mensajes.put(CodigoMensaje.M000042.getIdentificador(),
                new Mensaje(CodigoMensaje.M000042, "Se ha intentado asignar un lugar que no existe dentro de la finca actual"));
        mensajes.put(CodigoMensaje.M000043.getIdentificador(),
                new Mensaje(CodigoMensaje.M000043, "Se ha presentado un problema tratando de registrar la información de la nueva tarea"));
        mensajes.put(CodigoMensaje.M000044.getIdentificador(),
                new Mensaje(CodigoMensaje.M000044, "Se ha presentado un problema INESPERADO tratando de registrar la nueva tarea en el método ejecutar de la clase CrearTareaFachadaImpl"));

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
