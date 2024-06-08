package co.edu.uco.fink.business.fachade.concrete;

import co.edu.uco.fink.business.assembler.dto.concrete.AlmacenProducidoDTODomainAssembler;
import co.edu.uco.fink.business.assembler.dto.concrete.FincaDTODomainAssembler;
import co.edu.uco.fink.business.domain.FincaDomain;
import co.edu.uco.fink.business.fachade.ObtenerAlmacenesFachade;
import co.edu.uco.fink.business.usecase.ObtenerAlmacenes;
import co.edu.uco.fink.business.usecase.concrete.ObtenerAlmacenesImpl;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.custom.BusinessFinkException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.data.dao.factory.enums.Factory;
import co.edu.uco.fink.dto.almacenamiento.AlmacenProducidoDTO;
import co.edu.uco.fink.dto.fincas.FincaDTO;

import java.util.List;

public class ObtenerAlmacenesFachadeImpl implements ObtenerAlmacenesFachade {

    private final DAOfactory factory;

    public ObtenerAlmacenesFachadeImpl(){
        factory = DAOfactory.getFactory(Factory.POSTGRESQL);
    }

    @Override
    public List<AlmacenProducidoDTO> ejecutar(FincaDTO finca) {
        try {
            final ObtenerAlmacenes useCase = new ObtenerAlmacenesImpl(factory);
            FincaDomain fincaDomain = FincaDTODomainAssembler.obtenerInstancia().ensamblarDominio(finca);
            var resultados = useCase.obtenerAlmacenes(fincaDomain);
            return AlmacenProducidoDTODomainAssembler.obtenerInstancia().ensamblarListaDTO(resultados);
        } catch (FinKException e){
            throw e;
        } catch (Exception e) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000030);
            var mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000030), "los tipos de estado");

            throw new BusinessFinkException(mensajeTecnico, mensajeUsuario);
        } finally {
            factory.cerrarConexion();
        }
    }
}
