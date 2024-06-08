package co.edu.uco.fink.business.assembler.entity.concrete;

import co.edu.uco.fink.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.fink.business.domain.AlmacenProducidoDomain;
import co.edu.uco.fink.business.domain.LugarFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.entity.AlmacenProducidoEntity;
import co.edu.uco.fink.entity.LugarFincaEntity;

import java.util.ArrayList;
import java.util.List;

public class AlmacenProducidoEntityDomainAssembler implements EntityDomainAssembler<AlmacenProducidoDomain, AlmacenProducidoEntity> {

    private static final EntityDomainAssembler<AlmacenProducidoDomain, AlmacenProducidoEntity> instancia = new AlmacenProducidoEntityDomainAssembler();
    private static final EntityDomainAssembler<LugarFincaDomain, LugarFincaEntity> lugarFincaAssembler = new LugarFincaEntityDomainAssembler();


    public static final EntityDomainAssembler<AlmacenProducidoDomain, AlmacenProducidoEntity> obtenerInstancia() {
        return instancia;
    }
    
    @Override
    public AlmacenProducidoDomain ensamblarDominio(AlmacenProducidoEntity entity) {
        var almacenProducidoEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, AlmacenProducidoEntity.Build(0));
        LugarFincaDomain lugarFincadomain = lugarFincaAssembler.ensamblarDominio(almacenProducidoEntityTemp.getLugar());
        return AlmacenProducidoDomain.crear(almacenProducidoEntityTemp.getIdentificador(), almacenProducidoEntityTemp.getNombre(), lugarFincadomain, almacenProducidoEntityTemp.getDescripcion());
    }

    @Override
    public AlmacenProducidoEntity ensamblarEntidad(AlmacenProducidoDomain dominio) {
        var almacenProducidoDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, AlmacenProducidoDomain.crear());
        LugarFincaEntity lugarFincaEntity = lugarFincaAssembler.ensamblarEntidad(almacenProducidoDomainTemp.getLugar());
        return AlmacenProducidoEntity.Build(almacenProducidoDomainTemp.getIdentificador(), almacenProducidoDomainTemp.getNombre(), lugarFincaEntity, almacenProducidoDomainTemp.getDescripcion());
    }

    @Override
    public List<AlmacenProducidoDomain> ensamblarListaDominios(List<AlmacenProducidoEntity> listaEntidades) {
        var listaEntitysTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<AlmacenProducidoEntity>());
        var resultados = new ArrayList<AlmacenProducidoDomain>();

        for (AlmacenProducidoEntity AlmacenProducidoEntity : listaEntitysTmp) {
            var AlmacenProducidoDomainTmp = ensamblarDominio(AlmacenProducidoEntity);
            resultados.add(AlmacenProducidoDomainTmp);
        }
        return resultados;
    }
}
