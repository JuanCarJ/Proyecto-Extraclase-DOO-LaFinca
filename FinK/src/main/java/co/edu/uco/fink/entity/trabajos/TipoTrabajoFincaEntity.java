package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class TipoTrabajoFincaEntity {

    private int identificador;
    private String Tipo;

    private TipoTrabajoFincaEntity(){
        setTipo(TextHelper.EMPTY);
    }

    private TipoTrabajoFincaEntity(int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTrabajoFincaEntity build(){
        return new TipoTrabajoFincaEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final TipoTrabajoFincaEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getTipo() {
        return Tipo;
    }

    public final TipoTrabajoFincaEntity setTipo(final String tipo) {
        this.Tipo = tipo;
        return this;
    }
}
