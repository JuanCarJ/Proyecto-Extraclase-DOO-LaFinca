package co.edu.uco.fink.business.fachade.concrete;

import co.edu.uco.fink.business.assembler.dto.concrete.TareaFincaDTODomainAssembler;
import co.edu.uco.fink.business.usecase.CrearTarea;
import co.edu.uco.fink.business.usecase.concrete.CrearTareaImpl;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.custom.BusinessFinkException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.data.dao.factory.enums.Factory;
import co.edu.uco.fink.dto.trabajos.TareaFincaDTO;

public class CrearTareaFachadeImpl {

    public DAOfactory factory;

    public CrearTareaFachadeImpl(){
        factory = DAOfactory.getFactory(Factory.POSTGRESQL);
    }

    public final void ejecutar(TareaFincaDTO tarea){
        try{
            factory.iniciarTransaccion();
            var tareaFincaDomain = TareaFincaDTODomainAssembler.obtenerInstancia().ensamblarDominio(tarea);
            CrearTarea useCase = new CrearTareaImpl(factory);
            useCase.ejecutar(tareaFincaDomain);
            factory.confirmarTransaccion();
        } catch (FinKException exception){
            factory.cancelarTransaccion();
            throw exception;
        } catch (Exception exception) {
            factory.cancelarTransaccion();

            var mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000043));
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000044));

            throw new BusinessFinkException(mensajeTecnico, mensajeUsuario);
        } finally {
            factory.cerrarConexion();
        }
    }
}

// guiate del codigo de ejemplo para seguir
