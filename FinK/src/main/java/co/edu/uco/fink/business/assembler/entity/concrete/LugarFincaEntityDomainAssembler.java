package co.edu.uco.fink.business.assembler.entity.concrete;

import co.edu.uco.fink.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.fink.business.domain.EmpleadoDomain;
import co.edu.uco.fink.business.domain.FincaDomain;
import co.edu.uco.fink.business.domain.LugarFincaDomain;
import co.edu.uco.fink.business.domain.TareaFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.FincaEntity;
import co.edu.uco.fink.entity.LugarFincaEntity;
import co.edu.uco.fink.entity.TareaFincaEntity;

import java.util.ArrayList;
import java.util.List;

public class LugarFincaEntityDomainAssembler implements EntityDomainAssembler<LugarFincaDomain, LugarFincaEntity> {

    private static final EntityDomainAssembler <LugarFincaDomain, LugarFincaEntity> instancia = new LugarFincaEntityDomainAssembler();
    private static final EntityDomainAssembler<FincaDomain, FincaEntity> fincaAssembler = FincaEntityDomainAssembler.obtenerInstancia();


    public static final EntityDomainAssembler <LugarFincaDomain, LugarFincaEntity> obtenerInstancia(){
        return instancia;
    }


    @Override
    public LugarFincaDomain ensamblarDominio(LugarFincaEntity entity) {
        var lugarFincaEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, LugarFincaEntity.build(0));
        var fincaDomain = fincaAssembler.ensamblarDominio(lugarFincaEntityTemp.getFinca());
        return LugarFincaDomain.crear(lugarFincaEntityTemp.getIdentificador(), lugarFincaEntityTemp.getUbicacion(), lugarFincaEntityTemp.getNomenclatura(), fincaDomain);
    }

    @Override
    public LugarFincaEntity ensamblarEntidad(LugarFincaDomain dominio) {
        var lugarFincaDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio,LugarFincaDomain.crear());
        var fincaEntity = fincaAssembler.ensamblarEntidad(lugarFincaDomainTemp.getFinca());
        return LugarFincaEntity.build(lugarFincaDomainTemp.getIdentificador(), lugarFincaDomainTemp.getUbicacion(), lugarFincaDomainTemp.getNomenclatura(), fincaEntity);
    }

    @Override
    public List<LugarFincaDomain> ensamblarListaDominios(List<LugarFincaEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<LugarFincaEntity>());
        var resultados = new ArrayList<LugarFincaDomain>();

        for (LugarFincaEntity lugarFincaEntity : listaEntidadesTmp){
            var lugarFincaDomainTmp = ensamblarDominio(lugarFincaEntity);
            resultados.add(lugarFincaDomainTmp);
        }
        return resultados;
    }
}
