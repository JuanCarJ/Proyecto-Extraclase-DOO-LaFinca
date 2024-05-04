package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class UnidadMedidaDTO {
    private int identificador;

    private String nombre;

    public UnidadMedidaDTO(){
        setNombre(TextHelper.EMPTY);
    }

    public UnidadMedidaDTO(final int identificador, final String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static final UnidadMedidaDTO build(){
        return new UnidadMedidaDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final UnidadMedidaDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final UnidadMedidaDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}
