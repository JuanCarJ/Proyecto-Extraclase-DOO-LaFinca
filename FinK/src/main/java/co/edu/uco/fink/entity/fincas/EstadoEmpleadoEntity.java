package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public class EstadoEmpleadoEntity {

    private int identificador;
    private String nombre;

    public EstadoEmpleadoEntity() {
        setNombre(TextHelper.EMPTY);
    }

    public EstadoEmpleadoEntity(final int identificador, final String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static final EstadoEmpleadoEntity build(){
        return new EstadoEmpleadoEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final EstadoEmpleadoEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final EstadoEmpleadoEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}
