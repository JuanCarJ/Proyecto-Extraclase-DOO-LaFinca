package co.edu.uco.fink.business.assembler.dto.concrete;

import co.edu.uco.fink.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.fink.business.domain.LugarFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;

import java.util.ArrayList;
import java.util.List;

public final class LugarFincaDTODomainAssembler implements DTODomainAssembler<LugarFincaDomain, LugarFincaDTO>{

    private static final DTODomainAssembler<LugarFincaDomain, LugarFincaDTO> instancia = new LugarFincaDTODomainAssembler();

    public static final DTODomainAssembler<LugarFincaDomain, LugarFincaDTO> obtenerInstancia() {
        return instancia;
    }


    @Override
    public LugarFincaDomain ensamblarDominio(LugarFincaDTO dto) {
        var lugarFincaDTOTemp = ObjectHelper.getObjectHelper().getDefault(dto, LugarFincaDTO.build());
        return LugarFincaDomain.crear(lugarFincaDTOTemp.getIdentificador(), lugarFincaDTOTemp.getUbicacion(), lugarFincaDTOTemp.getNomenclatura(), lugarFincaDTOTemp.getFinca());
    }

    @Override
    public LugarFincaDTO ensamblarDTO(LugarFincaDomain dominio) {
        var lugarFincaDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, LugarFincaDomain.crear());
        return new LugarFincaDTO(lugarFincaDomainTemp.getIdentificador(), lugarFincaDomainTemp.getUbicacion(), lugarFincaDomainTemp.getNomenclatura(), lugarFincaDomainTemp.getFinca());
    }

    @Override
    public List<LugarFincaDTO> ensamblarListaDTO(List<LugarFincaDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<>());
        var resultados = new ArrayList<LugarFincaDTO>();

        for (var lugarFincaDomain : listaDominiosTmp) {
            var lugarFincaDTOTmp = ensamblarDTO((LugarFincaDomain) lugarFincaDomain);
            resultados.add(lugarFincaDTOTmp);
        }

        return resultados;
    }

    @Override
    public List<LugarFincaDomain> ensamblarListaDominios(List<LugarFincaDTO> listaDtos) {
        var listaDtosTmp = ObjectHelper.getObjectHelper().getDefault(listaDtos, new ArrayList<LugarFincaDTO>());
        var resultados = new ArrayList<LugarFincaDomain>();

        for (LugarFincaDTO lugarFincaDto : listaDtosTmp) {
            var lugarFincaDomainTmp = ensamblarDominio(lugarFincaDto);
            resultados.add(lugarFincaDomainTmp);
        }
        return resultados;
    }
}
