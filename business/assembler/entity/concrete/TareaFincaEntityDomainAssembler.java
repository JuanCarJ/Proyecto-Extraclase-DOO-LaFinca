package co.edu.uco.fink.business.assembler.entity.concrete;

import co.edu.uco.fink.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.fink.business.domain.EmpleadoDomain;
import co.edu.uco.fink.business.domain.LugarFincaDomain;
import co.edu.uco.fink.business.domain.TareaFincaDomain;
import co.edu.uco.fink.business.domain.TipoTareaFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.entity.EmpleadoEntity;
import co.edu.uco.fink.entity.LugarFincaEntity;
import co.edu.uco.fink.entity.TareaFincaEntity;
import co.edu.uco.fink.entity.TipoTareaFincaEntity;

import java.util.ArrayList;
import java.util.List;

public class TareaFincaEntityDomainAssembler implements EntityDomainAssembler<TareaFincaDomain, TareaFincaEntity> {

    private static final EntityDomainAssembler<TareaFincaDomain, TareaFincaEntity> instancia = new TareaFincaEntityDomainAssembler();
    private static final EntityDomainAssembler<EmpleadoDomain, EmpleadoEntity> empleadoAssembler = EmpleadoEntityDomainAssembler.obtenerInstancia();
    private static final EntityDomainAssembler<LugarFincaDomain, LugarFincaEntity> lugarFincaAssembler = LugarFincaEntityDomainAssembler.obtenerInstancia();
    private static final EntityDomainAssembler<TipoTareaFincaDomain, TipoTareaFincaEntity> tipoTareaFincaAssembler = TipoTareaFincaEntityDomainAssembler.obtenerInstancia();

    private TareaFincaEntityDomainAssembler(){
        super();
    }

    public static final EntityDomainAssembler<TareaFincaDomain, TareaFincaEntity> obtenerInstancia(){
        return instancia;
    }

    @Override
    public TareaFincaDomain ensamblarDominio(TareaFincaEntity entity) {
        var tareaFincaEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, TareaFincaEntity.Build(0));
        var empleadoDomain = empleadoAssembler.ensamblarDominio(tareaFincaEntityTemp.getEmpleadoAsignado());
        var tipoTareaDomain = tipoTareaFincaAssembler.ensamblarDominio(tareaFincaEntityTemp.getTipoTrabajo());
        var lugarFincaDomain = lugarFincaAssembler.ensamblarDominio(tareaFincaEntityTemp.getLugar());
        return TareaFincaDomain.crear(tareaFincaEntityTemp.getIdentificador(), empleadoDomain, tipoTareaDomain, tareaFincaEntityTemp.getCodigo(), lugarFincaDomain, tareaFincaEntityTemp.getDescripcion());
    }

    @Override
    public TareaFincaEntity ensamblarEntidad(TareaFincaDomain dominio) {
        var tareaFincaDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, TareaFincaDomain.crear());
        var empleadoEntity = empleadoAssembler.ensamblarEntidad(tareaFincaDomainTemp.getEmpleadoAsignado());
        var tipoTareaEntity = tipoTareaFincaAssembler.ensamblarEntidad(tareaFincaDomainTemp.getTipoTrabajo());
        var lugarFincaEntity = lugarFincaAssembler.ensamblarEntidad(tareaFincaDomainTemp.getLugar());
        return TareaFincaEntity.build(tareaFincaDomainTemp.getIdentificador(), empleadoEntity, tipoTareaEntity, tareaFincaDomainTemp.getCodigo(), lugarFincaEntity, tareaFincaDomainTemp.getDescripcion());
    }

    @Override
    public List<TareaFincaDomain> ensamblarListaDominios(List<TareaFincaEntity> listaEntidades) {
        var listaEntidadesTmp = ObjectHelper.getObjectHelper().getDefault(listaEntidades, new ArrayList<>());
        var resultados = new ArrayList<TareaFincaDomain>();

        for (var tareaFincaEntity : listaEntidadesTmp) {
            var lugarFincaDomainTmp = ensamblarDominio((TareaFincaEntity) tareaFincaEntity);
            resultados.add(lugarFincaDomainTmp);
        }
        return resultados;
    }
}
