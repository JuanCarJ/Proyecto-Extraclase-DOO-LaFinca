package co.edu.uco.fink.crosscutting.exception.messageCatalog.impl;

import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalog;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.custom.CrosscuttingFinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.Mensaje;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;

import java.util.HashMap;
import java.util.Map;

public class MessageCatalogBase implements MessageCatalog {

    private final Map<String, Mensaje> mensajes = new HashMap<>();

    @Override
    public final void inicializar() {

        mensajes.clear();
        mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
                "El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
        mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
                "Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
        mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
                "El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
        mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
                "El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
        mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005,
                "El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes externo..."));
        mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
                "El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes externo..."));
        mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007,
                "Se ha presentado un problema tratando de validar si la coneccion SQL con la fuente  de informacion deseada estaba cerrada..."));
        mensajes.put(CodigoMensaje.M00008.getIdentificador(), new Mensaje(CodigoMensaje.M00008,
                "Se ha presentado un problema INESPERADO tratando de validar si la conexion SQL con la fuente  de informacion deseada estaba cerrada..."));
        mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
                "Se ha intentado intentar el cierre de una conexion SQL que ya estaba cerrada..."));
        mensajes.put(CodigoMensaje.M000010.getIdentificador(), new Mensaje(CodigoMensaje.M000010,
                "Se ha presentado un problema tratando de cerrar la conexion SQL con la fuente deseada..."));
        mensajes.put(CodigoMensaje.M000011.getIdentificador(), new Mensaje(CodigoMensaje.M000011,
                "Se ha presentado un problema INESPERADO tratando de cerrar la conexion SQL con la fuente deseada..."));
        mensajes.put(CodigoMensaje.M000012.getIdentificador(), new Mensaje(CodigoMensaje.M000012,
                "Se ha intentado confirmar una transaccion de una conexion SQL cerrada..."));
        mensajes.put(CodigoMensaje.M000013.getIdentificador(), new Mensaje(CodigoMensaje.M000013,
                "Se ha intentado confirmar una transaccion cuando el autocommit de la conexion con la base de datos estaba activado..."));
        mensajes.put(CodigoMensaje.M000014.getIdentificador(), new Mensaje(CodigoMensaje.M000014,
                "Se ha presentado un problema tratando de confirmar una transaccion SQL, con la fuente de informacion deseada..."));
        mensajes.put(CodigoMensaje.M000015.getIdentificador(), new Mensaje(CodigoMensaje.M000015,
                "Se ha presentado un problema INESPERADO tratando de confirmar una transaccion SQL, con la fuente de informacion deseada..."));
        mensajes.put(CodigoMensaje.M000016.getIdentificador(), new Mensaje(CodigoMensaje.M000016,
                "Se ha intentado cancelar una transaccion de una conexion SQL cerrada..."));
        mensajes.put(CodigoMensaje.M000017.getIdentificador(), new Mensaje(CodigoMensaje.M000017,
                "Se ha intentado cancelar una transaccion cuando el autocommit de la conexion con la base de datos estaba activado..."));
        mensajes.put(CodigoMensaje.M000018.getIdentificador(), new Mensaje(CodigoMensaje.M000018,
                "Se ha presentado un problema tratando de cancelar una transaccion SQL, con la fuente de informacion deseada..."));
        mensajes.put(CodigoMensaje.M000019.getIdentificador(), new Mensaje(CodigoMensaje.M000019,
                "Se ha presentado un problema INESPERADO tratando de cancelar una transaccion SQL, con la fuente de informacion deseada..."));
        mensajes.put(CodigoMensaje.M000020.getIdentificador(), new Mensaje(CodigoMensaje.M000020,
                "Se ha intentado iniciar una transaccion de una conexion SQL cerrada..."));
        mensajes.put(CodigoMensaje.M000021.getIdentificador(), new Mensaje(CodigoMensaje.M000021,
                "Se ha presentado un problema tratando de iniciar una transaccion SQL, con la fuente de informacion deseada..."));
        mensajes.put(CodigoMensaje.M000022.getIdentificador(), new Mensaje(CodigoMensaje.M000022,
                "Se ha presentado un problema INESPERADO tratando de iniciar una transaccion SQL, con la fuente de informacion deseada..."));
    }

    @Override
    public String obtenerContenidoMensaje(CodigoMensaje codigo, String... parametros) {
        return obtenerMensaje(codigo, parametros).getContenido();
    }

    @Override
    public Mensaje obtenerMensaje(CodigoMensaje codigo, String... parametros) {
        if (ObjectHelper.getObjectHelper().isNUll(codigo)){
            var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001, codigo.getIdentificador());
            throw new CrosscuttingFinKException(mensajeTecnico, mensajeUsuario);
        }

        if (!codigo.isBase()){
            var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
            throw new CrosscuttingFinKException(mensajeTecnico, mensajeUsuario);
        }

        if (!mensajes.containsKey(codigo.getIdentificador())){
            var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
            throw new CrosscuttingFinKException(mensajeTecnico, mensajeUsuario);
        }

        return mensajes.get(codigo.getIdentificador());
    }


}
