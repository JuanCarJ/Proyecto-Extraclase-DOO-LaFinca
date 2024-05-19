package co.edu.uco.fink.dto.fincas;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class EstadoEmpleadoDTO {

    private int identificador;

    private String Nombre;

    public EstadoEmpleadoDTO() {
        setNombre(TextHelper.EMPTY);
    }

    public EstadoEmpleadoDTO(final int identificador, final String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static final EstadoEmpleadoDTO build(){
        return new EstadoEmpleadoDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final EstadoEmpleadoDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getNombre() {
        return Nombre;
    }

    public final EstadoEmpleadoDTO setNombre(final String nombre) {
        Nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}
