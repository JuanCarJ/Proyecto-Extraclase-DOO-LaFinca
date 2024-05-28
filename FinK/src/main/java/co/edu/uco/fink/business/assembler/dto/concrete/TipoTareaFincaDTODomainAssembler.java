package co.edu.uco.fink.business.assembler.dto.concrete;

import co.edu.uco.fink.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.fink.business.domain.TipoTareaFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.trabajos.TipoTareaFincaDTO;

import java.util.ArrayList;
import java.util.List;

public class TipoTareaFincaDTODomainAssembler implements DTODomainAssembler<TipoTareaFincaDomain, TipoTareaFincaDTO> {

    private static final DTODomainAssembler<TipoTareaFincaDomain, TipoTareaFincaDTO> instancia = new TipoTareaFincaDTODomainAssembler();

    public static final DTODomainAssembler<TipoTareaFincaDomain, TipoTareaFincaDTO> obtenerInstancia() {
        return instancia;
    }

    @Override
    public TipoTareaFincaDomain ensamblarDominio(TipoTareaFincaDTO dto) {
        var tipotareaFincaDTOTemp = ObjectHelper.getObjectHelper().getDefault(dto, TipoTareaFincaDTO.build());
        return TipoTareaFincaDomain.crear(tipotareaFincaDTOTemp.getIdentificador(), tipotareaFincaDTOTemp.getTipo());
    }

    @Override
    public TipoTareaFincaDTO ensamblarDTO(TipoTareaFincaDomain dominio) {
        var tipoTareaDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, TipoTareaFincaDomain.crear());
        return new TipoTareaFincaDTO(tipoTareaDomainTemp.getIdentificador(), tipoTareaDomainTemp.getTipo());
    }

    @Override
    public List<TipoTareaFincaDTO> ensamblarListaDTO(List<TipoTareaFincaDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<>());
        var resultados = new ArrayList<TipoTareaFincaDTO>();

        for (var tipotareafincaDomain : listaDominiosTmp) {
            var tipoTareaFincaDTOTmp = ensamblarDTO((TipoTareaFincaDomain) tipotareafincaDomain);
            resultados.add(tipoTareaFincaDTOTmp);
        }

        return resultados;
    }

    @Override
    public List<TipoTareaFincaDomain> ensamblarListaDominios(List<TipoTareaFincaDTO> listaDtos) {
        var listaDtosTmp = ObjectHelper.getObjectHelper().getDefault(listaDtos, new ArrayList<TipoTareaFincaDTO>());
        var resultados = new ArrayList<TipoTareaFincaDomain>();

        for (TipoTareaFincaDTO tipoTareaFincaDto : listaDtosTmp) {
            var tipoTareaFincaDomainTmp = ensamblarDominio(tipoTareaFincaDto);
            resultados.add(tipoTareaFincaDomainTmp);
        }
        return resultados;
    }
}
