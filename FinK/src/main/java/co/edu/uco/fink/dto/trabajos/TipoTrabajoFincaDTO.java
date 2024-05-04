package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTrabajoFincaDTO {

    private int identificador;

    private String Tipo;

    public TipoTrabajoFincaDTO(){
        setTipo(TextHelper.EMPTY);
    }

    public TipoTrabajoFincaDTO(int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTrabajoFincaDTO build(){
        return new TipoTrabajoFincaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoTrabajoFincaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return Tipo;
    }

    public final TipoTrabajoFincaDTO setTipo(final String tipo) {
        this.Tipo = tipo;
        return this;
    }
}
