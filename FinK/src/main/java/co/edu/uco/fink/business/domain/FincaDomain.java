package co.edu.uco.fink.business.domain;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import co.edu.uco.fink.entity.FincaEntity;

public class FincaDomain {
    private int id;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public FincaDomain(){
        setNombre(TextHelper.EMPTY);
    }

    public FincaDomain(final int id, final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static final FincaDomain Crear(){
        return new FincaDomain();
    }

    public static final FincaDomain Crear(final int id, final String nombre){
        return new FincaDomain(id, nombre);
    }

    public final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }
}
