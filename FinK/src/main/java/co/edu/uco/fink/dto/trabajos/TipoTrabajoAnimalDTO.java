package co.edu.uco.fink.dto.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTrabajoAnimalDTO {

    private int identificador;

    private String Tipo;

    public TipoTrabajoAnimalDTO(){
        setTipo(TextHelper.EMPTY);
    }

    public TipoTrabajoAnimalDTO(int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTrabajoAnimalDTO build(){
        return new TipoTrabajoAnimalDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoTrabajoAnimalDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return Tipo;
    }

    public final TipoTrabajoAnimalDTO setTipo(final String tipo) {
        this.Tipo = tipo;
        return this;
    }
}
