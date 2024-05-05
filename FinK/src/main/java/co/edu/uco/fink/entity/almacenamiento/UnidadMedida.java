package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class UnidadMedidaEntity {

    private int identificador;
    private String nombre;

    private UnidadMedidaEntity(final int identificador) {
        setIdentificador(identificador);
        setNombre(TextHelper.EMPTY);
    }

    private UnidadMedidaEntity(final int identificador, final String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static final UnidadMedidaEntity build(final int identificador){
        return new UnidadMedidaEntity(identificador);
    }

    public static final UnidadMedidaEntity build(final int identificador, final String nombre){
        return new UnidadMedidaEntity(identificador, nombre);
    }

    protected static final UnidadMedidaEntity build(){
        return new UnidadMedidaEntity(ZERO);
    }

    public int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
}
