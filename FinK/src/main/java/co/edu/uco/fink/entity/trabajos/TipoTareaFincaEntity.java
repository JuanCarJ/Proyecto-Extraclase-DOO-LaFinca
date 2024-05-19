package co.edu.uco.fink.entity.trabajos;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.trabajos.TipoTareaFincaDTO;

public class TipoTareaFincaEntity {
    private int identificador;
    private String Tipo;

    public TipoTareaFincaEntity(final int identificador){
        setIdentificador(identificador);
        setTipo(TextHelper.EMPTY);
    }

    public TipoTareaFincaEntity(int identificador, final String tipo) {
        setIdentificador(identificador);
        setTipo(tipo);
    }

    public static final TipoTareaFincaEntity build(final int identificador){
        return new TipoTareaFincaEntity(identificador);
    }

    public static final TipoTareaFincaEntity build(int identificador, final String tipo){
        return new TipoTareaFincaEntity(identificador, tipo);
    }

    public static final TipoTareaFincaEntity build() { return new TipoTareaFincaEntity(NumericHelper.ZERO); }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getTipo() {
        return Tipo;
    }

    public final void setTipo(final String tipo) {
        this.Tipo = TextHelper.applyTrim(tipo);
    }
}
