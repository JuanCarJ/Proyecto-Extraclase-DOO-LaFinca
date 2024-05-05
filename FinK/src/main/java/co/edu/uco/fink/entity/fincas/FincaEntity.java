package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class FincaEntity {

    private int identificador;
    private String nombre;
    private String direccion;
    private CiudadEntity ciudad;
    private String correo;
    private String telefono;

    private FincaEntity() {
        setNombre(TextHelper.EMPTY);
        setDireccion(TextHelper.EMPTY);
        setCiudad(CiudadEntity.build());
        setCorreo(TextHelper.EMPTY);
        setTelefono(TextHelper.EMPTY);
    }

    private FincaEntity(final int identificador, final String nombre, final String direccion, final CiudadEntity ciudad, final String correo, final String telefono) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDireccion(direccion);
        setCiudad(ciudad);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public static final FincaEntity build(){
        return new FincaEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final FincaEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final FincaEntity setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public final String getDireccion() {
        return direccion;
    }

    public final FincaEntity setDireccion(final String direccion) {
        this.direccion = direccion;
        return this;
    }

    public final CiudadEntity getCiudad() {
        return ciudad;
    }

    public final FincaEntity setCiudad(final CiudadEntity ciudad) {
        this.ciudad = ObjectHelper.getObjectHelper().getDefault(ciudad, CiudadEntity.build());
        return this;
    }

    public final String getCorreo() {
        return correo;
    }

    public final FincaEntity setCorreo(final String correo) {
        this.correo = TextHelper.applyTrim(correo);
        return this;
    }

    public final String getTelefono() {
        return telefono;
    }

    public final FincaEntity setTelefono(final String telefono) {
        this.telefono = telefono;
        return this;
    }
}
