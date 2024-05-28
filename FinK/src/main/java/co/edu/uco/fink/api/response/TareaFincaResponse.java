package co.edu.uco.fink.api.response;

import co.edu.uco.fink.dto.trabajos.TareaFincaDTO;

import java.util.ArrayList;

public class TareaFincaResponse extends Response<TareaFincaDTO>{

    public TareaFincaResponse() {
        setMensajes(new ArrayList<>());
        setDatos(new ArrayList<>());
    }
}
