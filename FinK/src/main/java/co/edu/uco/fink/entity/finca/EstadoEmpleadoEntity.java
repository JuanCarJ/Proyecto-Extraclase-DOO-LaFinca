package co.edu.uco.fink.entity.finca;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class EstadoEmpleadoEntity {
    private int identificador;
    private String Nombre;

    public EstadoEmpleadoEntity(final int identificador) {
        setIdentificador(identificador);
        setNombre(TextHelper.EMPTY);
    }

    public EstadoEmpleadoEntity(final int identificador, final String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static final EstadoEmpleadoEntity Build(final int identificador){
        return new EstadoEmpleadoEntity(identificador);
    }

    public static final EstadoEmpleadoEntity Build(final int identificador, final String nombre){
        return new EstadoEmpleadoEntity(identificador, nombre);
    }

    protected static final EstadoEmpleadoEntity Build(){ return new EstadoEmpleadoEntity(NumericHelper.ZERO); }

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
        Nombre = TextHelper.applyTrim(nombre);
    }
}
