package co.edu.uco.fink.business.assembler.entity.concrete;

import co.edu.uco.fink.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.fink.business.domain.EmpleadoDomain;
import co.edu.uco.fink.business.domain.TipoTareaFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.TareaFincaEntity;
import co.edu.uco.fink.entity.TipoEstadoEntity;
import co.edu.uco.fink.entity.TipoTareaFincaEntity;

import java.util.ArrayList;
import java.util.List;

public final class TipoTareaFincaEntityDomainAssembler implements EntityDomainAssembler<TipoTareaFincaDomain, TipoTareaFincaEntity> {

    private static final EntityDomainAssembler <TipoTareaFincaDomain, TipoTareaFincaEntity> instancia = new TipoTareaFincaEntityDomainAssembler();

    public static final EntityDomainAssembler <TipoTareaFincaDomain, TipoTareaFincaEntity> obtenerInstancia(){
        return instancia;
    }

    @Override
    public TipoTareaFincaDomain ensamblarDominio(TipoTareaFincaEntity entity) {
        var tipoTareaFincaEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, TipoTareaFincaEntity.build(0));
        return TipoTareaFincaDomain.crear(tipoTareaFincaEntityTemp.getIdentificador(), tipoTareaFincaEntityTemp.getTipo());
    }

    @Override
    public TipoTareaFincaEntity ensamblarEntidad(TipoTareaFincaDomain dominio) {
        var tipoTareaFincaDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, TipoTareaFincaDomain.crear());
        return TipoTareaFincaEntity.build(tipoTareaFincaDomainTemp.getIdentificador(), tipoTareaFincaDomainTemp.getTipo());
    }

    @Override
    public List<TipoTareaFincaDomain> ensamblarListaDominios(List<TipoTareaFincaEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<TipoTareaFincaEntity>());
        var resultados = new ArrayList<TipoTareaFincaDomain>();

        for (TipoTareaFincaEntity tipoTareaFincaEntity : listaEntidadesTmp){
            var tipoTareaFincaDomainTmp = ensamblarDominio(tipoTareaFincaEntity);
            resultados.add(tipoTareaFincaDomainTmp);
        }
        return resultados;
    }
}
