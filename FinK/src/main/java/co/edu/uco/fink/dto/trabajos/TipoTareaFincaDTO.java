package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTareaFincaDTO {

    private int identificador;
    private String Tipo;

    public TipoTareaFincaDTO(){
        setTipo(TextHelper.EMPTY);
    }

    public TipoTareaFincaDTO(int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTareaFincaDTO build(){
        return new TipoTareaFincaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoTareaFincaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return Tipo;
    }

    public final TipoTareaFincaDTO setTipo(final String tipo) {
        this.Tipo = TextHelper.applyTrim(tipo);
        return this;
    }
}
