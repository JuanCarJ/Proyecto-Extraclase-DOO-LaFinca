package co.edu.uco.fink.business.assembler.dto.concrete;

import co.edu.uco.fink.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.fink.business.domain.EmpleadoDomain;
import co.edu.uco.fink.business.domain.LugarFincaDomain;
import co.edu.uco.fink.business.domain.TareaFincaDomain;
import co.edu.uco.fink.business.domain.TipoTareaFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.fincas.EmpleadoDTO;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;
import co.edu.uco.fink.dto.trabajos.TareaFincaDTO;
import co.edu.uco.fink.dto.trabajos.TipoTareaFincaDTO;

import java.util.ArrayList;
import java.util.List;

public final class TareaFincaDTODomainAssembler implements DTODomainAssembler<TareaFincaDomain, TareaFincaDTO> {

    private static final DTODomainAssembler<TareaFincaDomain, TareaFincaDTO> instancia = new TareaFincaDTODomainAssembler();
    private static final DTODomainAssembler<EmpleadoDomain, EmpleadoDTO> empleadoAssembler = EmpleadoDTODomainAssembler.obtenerInstancia();
    private static final DTODomainAssembler<LugarFincaDomain, LugarFincaDTO> lugarFincaAssembler = LugarFincaDTODomainAssembler.obtenerInstancia();
    private static final DTODomainAssembler<TipoTareaFincaDomain, TipoTareaFincaDTO> tipoTareaAssembler = TipoTareaFincaDTODomainAssembler.obtenerInstancia();

    TareaFincaDTODomainAssembler(){
        super();
    }

    public static final DTODomainAssembler<TareaFincaDomain, TareaFincaDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public TareaFincaDomain ensamblarDominio(TareaFincaDTO dto) {
        var tareaFincaDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new TareaFincaDTO());
        EmpleadoDomain empleadoDomain = empleadoAssembler.ensamblarDominio(tareaFincaDtoTmp.getEmpleadoAsignado());
        LugarFincaDomain lugarFincaDomain = lugarFincaAssembler.ensamblarDominio(tareaFincaDtoTmp.getLugar());
        TipoTareaFincaDomain tipoTareaFincaDomain = tipoTareaAssembler.ensamblarDominio(tareaFincaDtoTmp.getTipoTrabajo());
        return TareaFincaDomain.crear(tareaFincaDtoTmp.getIdentificador(), empleadoDomain, tipoTareaFincaDomain, tareaFincaDtoTmp.getCodigo(), lugarFincaDomain, tareaFincaDtoTmp.getDescripcion());
    }

    @Override
    public TareaFincaDTO ensamblarDTO(TareaFincaDomain dominio){
        var tareaFincaDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, TareaFincaDomain.crear());
        EmpleadoDTO empleadoDTO = empleadoAssembler.ensamblarDTO(tareaFincaDomainTmp.getEmpleadoAsignado());
        TipoTareaFincaDTO tipoTareaFincaDTO = tipoTareaAssembler.ensamblarDTO(tareaFincaDomainTmp.getTipoTrabajo());
        LugarFincaDTO lugarFincaDTO = lugarFincaAssembler.ensamblarDTO(tareaFincaDomainTmp.getLugar());
        return TareaFincaDTO.Build().setIdentificador(tareaFincaDomainTmp.getIdentificador()).setEmpleadoAsignado(empleadoDTO).setTipoTrabajo(tipoTareaFincaDTO).setCodigo(tareaFincaDomainTmp.getCodigo()).setLugar(lugarFincaDTO).setDescripcion(tareaFincaDomainTmp.getDescripcion());
    }

    @Override
    public List<TareaFincaDTO> ensamblarListaDTO(List<TareaFincaDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<>());
        var resultados = new ArrayList<TareaFincaDTO>();

        for (var tareaFincaDomain : listaDominiosTmp) {
            var tareaFincaDTOTmp = ensamblarDTO((TareaFincaDomain) tareaFincaDomain);
            resultados.add(tareaFincaDTOTmp);
        }
        return resultados;
    }

    @Override
    public List<TareaFincaDomain> ensamblarListaDominios(List<TareaFincaDTO> listaDtos) {
        var listaDtosTmp = ObjectHelper.getObjectHelper().getDefault(listaDtos, new ArrayList<TareaFincaDTO>());
        var resultados = new ArrayList<TareaFincaDomain>();

        for (TareaFincaDTO tareaFincaDto : listaDtosTmp) {
            var tareaFincaDomainTmp = ensamblarDominio(tareaFincaDto);
            resultados.add(tareaFincaDomainTmp);
        }
        return resultados;
    }
}
