package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class UnidadMedidaDTO {

    private int identificador;
    private String Nombre;

    public UnidadMedidaDTO (){
        setNombre(TextHelper.EMPTY);
    }

    public UnidadMedidaDTO(final int identificador, final String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static final UnidadMedidaDTO Build() {
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
        return Nombre;
    }

    public final UnidadMedidaDTO setNombre(final String nombre) {
        this.Nombre = TextHelper.applyTrim(nombre);
        return this;
    }
}
