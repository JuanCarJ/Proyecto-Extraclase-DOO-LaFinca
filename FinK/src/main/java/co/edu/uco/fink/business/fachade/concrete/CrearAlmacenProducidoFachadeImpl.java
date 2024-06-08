package co.edu.uco.fink.business.fachade.concrete;

import co.edu.uco.fink.business.assembler.dto.concrete.AlmacenProducidoDTODomainAssembler;
import co.edu.uco.fink.business.assembler.dto.concrete.TareaFincaDTODomainAssembler;
import co.edu.uco.fink.business.usecase.CrearAlmacenProducido;
import co.edu.uco.fink.business.usecase.CrearTarea;
import co.edu.uco.fink.business.usecase.concrete.CrearAlmacenProducidoImpl;
import co.edu.uco.fink.business.usecase.concrete.CrearTareaImpl;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.custom.BusinessFinkException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.data.dao.factory.enums.Factory;
import co.edu.uco.fink.dto.almacenamiento.AlmacenProducidoDTO;
import co.edu.uco.fink.dto.trabajos.TareaFincaDTO;

public class CrearAlmacenProducidoFachadeImpl {

    public DAOfactory factory;

    public CrearAlmacenProducidoFachadeImpl(){
        factory = DAOfactory.getFactory(Factory.POSTGRESQL);
    }

    public final void ejecutar(AlmacenProducidoDTO almacen){
        try{
            factory.iniciarTransaccion();
            var almacenProducidoDomain = AlmacenProducidoDTODomainAssembler.obtenerInstancia().ensamblarDominio(almacen);
            CrearAlmacenProducido useCase = new CrearAlmacenProducidoImpl(factory);
            useCase.ejecutar(almacenProducidoDomain);
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
