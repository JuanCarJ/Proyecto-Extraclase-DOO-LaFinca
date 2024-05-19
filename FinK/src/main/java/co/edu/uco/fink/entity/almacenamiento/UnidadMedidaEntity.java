package co.edu.uco.fink.entity.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class UnidadMedidaEntity {
    private int identificador;
    private String Nombre;

    public UnidadMedidaEntity(final int identificador) {
        setIdentificador(identificador);
        setNombre(TextHelper.EMPTY);
    }

    public UnidadMedidaEntity(final int identificador, final String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static final UnidadMedidaEntity Build(final int identificador) {
        return new UnidadMedidaEntity(identificador);
    }

    public static final UnidadMedidaEntity build(final int identificador, final String nombre) {
        return new UnidadMedidaEntity(identificador, nombre);
    }

    protected static final UnidadMedidaEntity build() { return new UnidadMedidaEntity(NumericHelper.ZERO); }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getNombre() {
        return Nombre;
    }

    public final void setNombre(final String nombre) {
        this.Nombre = TextHelper.applyTrim(nombre);
    }
}
