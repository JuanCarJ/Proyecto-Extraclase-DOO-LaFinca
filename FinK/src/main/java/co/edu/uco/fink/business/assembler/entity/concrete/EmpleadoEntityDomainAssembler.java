package co.edu.uco.fink.business.assembler.entity.concrete;

import co.edu.uco.fink.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.fink.business.domain.EmpleadoDomain;
import co.edu.uco.fink.business.domain.TareaFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.TareaFincaEntity;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoEntityDomainAssembler implements EntityDomainAssembler<EmpleadoDomain, EmpleadoEntity> {

    private static final EntityDomainAssembler <EmpleadoDomain, EmpleadoEntity> instancia = new EmpleadoEntityDomainAssembler();

    public static final EntityDomainAssembler <EmpleadoDomain, EmpleadoEntity> obtenerInstancia(){
        return instancia;
    }


    @Override
    public EmpleadoDomain ensamblarDominio(EmpleadoEntity entity) {
        var empleadoEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, EmpleadoEntity.Build(0));
        return EmpleadoDomain.crear(empleadoEntityTemp.getIdentificador(), empleadoEntityTemp.getDocumento(), empleadoEntityTemp.getEstado());
    }

    @Override
    public EmpleadoEntity ensamblarEntidad(EmpleadoDomain dominio) {
        var empleadoDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio,EmpleadoDomain.crear());
        return EmpleadoEntity.Build(empleadoDomainTemp.getIdentificador(), empleadoDomainTemp.getDocumento(), empleadoDomainTemp.getEstado());
    }

    @Override
    public List<EmpleadoDomain> ensamblarListaDominios(List<EmpleadoEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<EmpleadoEntity>());
        var resultados = new ArrayList<EmpleadoDomain>();

        for (EmpleadoEntity empleadoEntity : listaEntidadesTmp){
            var empleadoDomainTmp = ensamblarDominio(empleadoEntity);
            resultados.add(empleadoDomainTmp);
        }
        return resultados;
    }
}
