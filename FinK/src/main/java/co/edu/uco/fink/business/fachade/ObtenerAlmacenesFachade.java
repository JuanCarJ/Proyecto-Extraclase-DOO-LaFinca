package co.edu.uco.fink.business.fachade;

import co.edu.uco.fink.dto.almacenamiento.AlmacenProducidoDTO;
import co.edu.uco.fink.dto.fincas.FincaDTO;

import java.util.List;

public interface ObtenerAlmacenesFachade {
    List<AlmacenProducidoDTO> ejecutar(FincaDTO finca);
}
