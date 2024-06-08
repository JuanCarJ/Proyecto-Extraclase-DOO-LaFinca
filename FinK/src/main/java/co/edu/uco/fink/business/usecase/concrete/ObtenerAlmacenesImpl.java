package co.edu.uco.fink.business.usecase.concrete;

import co.edu.uco.fink.business.assembler.entity.concrete.AlmacenProducidoEntityDomainAssembler;
import co.edu.uco.fink.business.assembler.entity.concrete.FincaEntityDomainAssembler;
import co.edu.uco.fink.business.domain.AlmacenProducidoDomain;
import co.edu.uco.fink.business.domain.FincaDomain;
import co.edu.uco.fink.business.usecase.ObtenerAlmacenes;
import co.edu.uco.fink.data.dao.factory.DAOfactory;
import co.edu.uco.fink.entity.AlmacenProducidoEntity;
import co.edu.uco.fink.entity.FincaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObtenerAlmacenesImpl implements ObtenerAlmacenes {

    private DAOfactory factory;

    public ObtenerAlmacenesImpl(DAOfactory factory) {
        this.factory = factory;
    }

    @Override
    public List<AlmacenProducidoDomain> obtenerAlmacenes(FincaDomain finca) {

        FincaEntity fincaEntity = FincaEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(finca);

        List<AlmacenProducidoEntity> almacenes = factory.getAlmacenProducidoDAO().consultar(AlmacenProducidoEntity.Build(0));
        var listaFiltrada = new ArrayList<AlmacenProducidoDomain>();

        for (AlmacenProducidoEntity almacen : almacenes) {
            if (Objects.equals(almacen.getLugar().getFinca().getNombre(), fincaEntity.getNombre())) {
                listaFiltrada.add(AlmacenProducidoEntityDomainAssembler.obtenerInstancia().ensamblarDominio(almacen));
            }
        }

        return listaFiltrada;
    }
}
