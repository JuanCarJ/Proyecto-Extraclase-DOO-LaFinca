package co.edu.uco.fink.dto.almacenamiento;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.LugarFincaDTO;

public class AlmacenProducidoDTO {
    private int identificador;
    private String nombre;
    private LugarFincaDTO lugar;
    private String descripcion;

    public AlmacenProducidoDTO(){
        setNombre(TextHelper.EMPTY);
        setLugar(LugarFincaDTO.build());
        setDescripcion(TextHelper.EMPTY);
    }

    public AlmacenProducidoDTO(final int identificador, final String nombre, final LugarFincaDTO lugar, final String descripcion) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
        setLugar(lugar);
    }

    public static final AlmacenProducidoDTO build(){
        return new AlmacenProducidoDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final AlmacenProducidoDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final AlmacenProducidoDTO setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public final LugarFincaDTO getLugar() {
        return lugar;
    }

    public final AlmacenProducidoDTO setLugar(final LugarFincaDTO lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaDTO.build());
        return this;
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final AlmacenProducidoDTO setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
}
