package co.edu.uco.fink.entity.finca;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.dto.fincas.FincaDTO;
import co.edu.uco.fink.dto.fincas.ciudadDTO;

public class FincaEntity {
    private int identificador;
    private String nombre;
    private String direccion;
    private CiudadEntity ciudad;
    private String correo;
    private String telefono;

    public FincaEntity(final int identificador){
        setNombre(TextHelper.EMPTY);
        setDireccion(TextHelper.EMPTY);
        setCiudad(CiudadEntity.build());
        setCorreo(TextHelper.EMPTY);
        setTelefono(TextHelper.EMPTY);
    }

    public FincaEntity(final int identificador, final String nombre, final String direccion, final CiudadEntity ciudad, final String correo, final String telefono) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDireccion(direccion);
        setCiudad(ciudad);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public static final FincaEntity build(final int identificador){
        return new FincaEntity(identificador);
    }

    public static final FincaEntity build(final int identificador, final String nombre, final String direccion, final CiudadEntity ciudad, final String correo, final String telefono) {
        return new FincaEntity(identificador, nombre, direccion, ciudad, correo, telefono);
    }

    protected static final FincaEntity build() { return new FincaEntity(NumericHelper.ZERO); }

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

    public final String getDireccion() {
        return direccion;
    }

    public final void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public final CiudadEntity getCiudad() {
        return ciudad;
    }

    public final void setCiudad(final CiudadEntity ciudad) {
        this.ciudad = ObjectHelper.getObjectHelper().getDefault(ciudad, CiudadEntity.build());
    }

    public final String getCorreo() {
        return correo;
    }

    public final void setCorreo(final String correo) {
        this.correo = TextHelper.applyTrim(correo);
    }

    public final String getTelefono() {
        return telefono;
    }

    public final void setTelefono(final String telefono) {
        this.telefono = telefono;
    }
}
