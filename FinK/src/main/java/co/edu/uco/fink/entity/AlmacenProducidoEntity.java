package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class AlmacenProducidoEntity {
    private int identificador;
    private String nombre;
    private LugarFincaEntity lugar;
    private String descripcion;

    public AlmacenProducidoEntity(final int identificador){
        setIdentificador(identificador);
        setNombre(TextHelper.EMPTY);
        setLugar(LugarFincaEntity.build());
        setDescripcion(TextHelper.EMPTY);
    }

    public AlmacenProducidoEntity(final int identificador, final String nombre, final LugarFincaEntity lugar, final String descripcion) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
        setLugar(lugar);
    }

    public static final AlmacenProducidoEntity Build(final int identificador, final String nombre, final LugarFincaEntity lugar, final String descripcion) {
        return new AlmacenProducidoEntity(identificador, nombre, lugar, descripcion);
    }

    public static final AlmacenProducidoEntity Build(final int identificador){
        return new AlmacenProducidoEntity(identificador);
    }

    protected static final AlmacenProducidoEntity build(){
        return new AlmacenProducidoEntity(0);
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final void setIdentificador(final int identificador) {
        this.identificador = identificador;
    }

    public final String getNombre() {
        return nombre;
    }

    public final void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public final LugarFincaEntity getLugar() {
        return lugar;
    }

    public final void setLugar(final LugarFincaEntity lugar) {
        this.lugar = ObjectHelper.getObjectHelper().getDefault(lugar, LugarFincaEntity.build());
    }

    public final String getDescripcion() {
        return descripcion;
    }

    public final void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
}
