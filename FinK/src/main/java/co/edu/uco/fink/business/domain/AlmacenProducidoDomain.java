package co.edu.uco.fink.business.domain;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class AlmacenProducidoDomain {
    private int identificador;
    private String nombre;
    private LugarFincaDomain lugar;
    private String descripcion;

    public AlmacenProducidoDomain(){
        setNombre(TextHelper.EMPTY);
        setLugar(LugarFincaDomain.crear());
        setDescripcion(TextHelper.EMPTY);
    }

    public AlmacenProducidoDomain(final int identificador, final String nombre, final LugarFincaDomain lugar, final String descripcion) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
        setLugar(lugar);
    }

    public static final AlmacenProducidoDomain crear(){
        return new AlmacenProducidoDomain();
    }

    public static final AlmacenProducidoDomain crear(final int identificador, final String nombre, final LugarFincaDomain lugar, final String descripcion) {
        return new AlmacenProducidoDomain(identificador, nombre, lugar, descripcion);
    }

    public final int getIdentificador() {
        return identificador;
    }

    private final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public final LugarFincaDomain getLugar() {
        return lugar;
    }

    private final void setLugar(final LugarFincaDomain lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaDomain.crear());
    }

    public final String getDescripcion() {
        return descripcion;
    }

    private final void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
}
