package co.edu.uco.fink.business.assembler.dto.concrete;

import co.edu.uco.fink.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.fink.business.domain.AlmacenProducidoDomain;
import co.edu.uco.fink.business.domain.LugarFincaDomain;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.dto.almacenamiento.AlmacenProducidoDTO;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;

import java.util.ArrayList;
import java.util.List;

public class AlmacenProducidoDTODomainAssembler implements DTODomainAssembler<AlmacenProducidoDomain, AlmacenProducidoDTO> {

    private static final DTODomainAssembler<AlmacenProducidoDomain, AlmacenProducidoDTO> instancia = new AlmacenProducidoDTODomainAssembler();
    private static final DTODomainAssembler<LugarFincaDomain, LugarFincaDTO> lugarFincaAssembler = new LugarFincaDTODomainAssembler();


    public static final DTODomainAssembler<AlmacenProducidoDomain, AlmacenProducidoDTO> obtenerInstancia() {
        return instancia;
    }


    @Override
    public AlmacenProducidoDomain ensamblarDominio(AlmacenProducidoDTO dto) {
        var almacenProducidoDTOTemp = ObjectHelper.getObjectHelper().getDefault(dto, AlmacenProducidoDTO.build());
        LugarFincaDomain lugarFincadomain = lugarFincaAssembler.ensamblarDominio(almacenProducidoDTOTemp.getLugar());
        return AlmacenProducidoDomain.crear(almacenProducidoDTOTemp.getIdentificador(), almacenProducidoDTOTemp.getNombre(), lugarFincadomain, almacenProducidoDTOTemp.getDescripcion());
    }

    @Override
    public AlmacenProducidoDTO ensamblarDTO(AlmacenProducidoDomain dominio) {
        var almacenProducidoDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, AlmacenProducidoDomain.crear());
        LugarFincaDTO lugarFincaDTO = lugarFincaAssembler.ensamblarDTO(almacenProducidoDomainTemp.getLugar());
        return AlmacenProducidoDTO.build().setIdentificador(almacenProducidoDomainTemp.getIdentificador()).setNombre(almacenProducidoDomainTemp.getNombre()).setLugar(lugarFincaDTO).setDescripcion(almacenProducidoDomainTemp.getDescripcion());
    }

    @Override
    public List<AlmacenProducidoDTO> ensamblarListaDTO(List<AlmacenProducidoDomain> listaDominios) {
        var listaDominiosTmp = ObjectHelper.getObjectHelper().getDefault(listaDominios, new ArrayList<>());
        var resultados = new ArrayList<AlmacenProducidoDTO>();

        for (var AlmacenProducidoDomain : listaDominiosTmp) {
            var AlmacenProducidoDTOTmp = ensamblarDTO((AlmacenProducidoDomain) AlmacenProducidoDomain);
            resultados.add(AlmacenProducidoDTOTmp);
        }

        return resultados;
    }

    @Override
    public List<AlmacenProducidoDomain> ensamblarListaDominios(List<AlmacenProducidoDTO> listaDtos) {
        var listaDtosTmp = ObjectHelper.getObjectHelper().getDefault(listaDtos, new ArrayList<AlmacenProducidoDTO>());
        var resultados = new ArrayList<AlmacenProducidoDomain>();

        for (AlmacenProducidoDTO AlmacenProducidoDto : listaDtosTmp) {
            var AlmacenProducidoDomainTmp = ensamblarDominio(AlmacenProducidoDto);
            resultados.add(AlmacenProducidoDomainTmp);
        }
        return resultados;
    }
}
