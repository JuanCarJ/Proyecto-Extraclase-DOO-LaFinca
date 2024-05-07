package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTrabajoAnimalEntity {

    private int identificador;
    private String Tipo;

    private TipoTrabajoAnimalEntity(){
        setTipo(TextHelper.EMPTY);
    }

    private TipoTrabajoAnimalEntity(int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTrabajoAnimalEntity build(){
        return new TipoTrabajoAnimalEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoTrabajoAnimalEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return Tipo;
    }

    public final TipoTrabajoAnimalEntity setTipo(final String tipo) {
        this.Tipo = tipo;
        return this;
    }
}
