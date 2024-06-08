package co.edu.uco.fink.api.response;

import co.edu.uco.fink.dto.almacenamiento.AlmacenProducidoDTO;

import java.util.ArrayList;

public class AlmacenProducidoResponse extends Response<AlmacenProducidoDTO>{
    public AlmacenProducidoResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
