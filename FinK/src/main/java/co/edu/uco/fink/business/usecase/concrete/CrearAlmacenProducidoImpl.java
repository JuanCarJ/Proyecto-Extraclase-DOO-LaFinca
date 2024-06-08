package co.edu.uco.fink.business.usecase.concrete;

import co.edu.uco.fink.business.assembler.entity.concrete.AlmacenProducidoEntityDomainAssembler;
import co.edu.uco.fink.business.domain.AlmacenProducidoDomain;
import co.edu.uco.fink.business.usecase.CrearAlmacenProducido;
import co.edu.uco.fink.crosscutting.exception.Enums.Lugar;
import co.edu.uco.fink.crosscutting.exception.FinKException;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.fink.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.entity.AlmacenProducidoEntity;
import co.edu.uco.fink.entity.LugarFincaEntity;

import java.util.List;
import java.util.Objects;

public class CrearAlmacenProducidoImpl implements CrearAlmacenProducido {

    private DAOfactory factory;

    public CrearAlmacenProducidoImpl(DAOfactory factory) {
        this.factory = factory;
    }

    public int obtenerlugar(AlmacenProducidoEntity almacenProducido) {
        List<LugarFincaEntity> lugares = factory.getLugarFincaDAO().consultar(almacenProducido.getLugar());

        int id = 0;

        for (LugarFincaEntity lugar : lugares) {
            if (Objects.equals(lugar.getUbicacion(), almacenProducido.getLugar().getUbicacion()) && Objects.equals(lugar.getNomenclatura(), almacenProducido.getLugar().getNomenclatura()) && Objects.equals(lugar.getFinca().getNombre(), almacenProducido.getLugar().getFinca().getNombre())){
                        id = lugar.getIdentificador();
            }
        }

        if (id == 0){
            String mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000041));
            String mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000042));

            throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
        }

        return id;
    }

    public void verificarDatos(AlmacenProducidoEntity almacenProducido) {

        if (Objects.equals(almacenProducido.getNombre(), "") || Objects.equals(almacenProducido.getLugar().getUbicacion(), "") || Objects.equals(almacenProducido.getLugar().getNomenclatura(), "") ||  Objects.equals(almacenProducido.getLugar().getFinca().getNombre(), "")){
            String mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000041));
            String mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000042));

            throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
        }

        List<AlmacenProducidoEntity> almacenes = factory.getAlmacenProducidoDAO().consultar(almacenProducido);

        for (AlmacenProducidoEntity almacen : almacenes) {
            if (Objects.equals(almacen.getNombre(), almacenProducido.getNombre())) {
                String mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000041));
                String mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000042));

                throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
            } else if (Objects.equals(almacen.getLugar(), almacenProducido.getLugar())){
                String mensajeUsuario = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000041));
                String mensajeTecnico = TextHelper.replaceParams(MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000042));

                throw new FinKException(mensajeTecnico, mensajeUsuario, Lugar.BUSINESS);
            }
        }
    }

    @Override
    public void ejecutar(AlmacenProducidoDomain almacen) {
        AlmacenProducidoEntity almacenEntity = AlmacenProducidoEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(almacen);

        almacenEntity.getLugar().setIdentificador(obtenerlugar(almacenEntity));

        verificarDatos(almacenEntity);

        factory.getAlmacenProducidoDAO().crear(almacenEntity);
    }
}
