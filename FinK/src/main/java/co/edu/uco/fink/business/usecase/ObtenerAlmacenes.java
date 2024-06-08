package co.edu.uco.fink.business.usecase;

import co.edu.uco.fink.business.domain.AlmacenProducidoDomain;
import co.edu.uco.fink.business.domain.FincaDomain;

import java.util.List;

public interface ObtenerAlmacenes {
    List<AlmacenProducidoDomain> obtenerAlmacenes(FincaDomain finca);
}
