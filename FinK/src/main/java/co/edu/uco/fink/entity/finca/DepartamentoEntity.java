package co.edu.uco.fink.entity.finca;

import co.edu.uco.fink.crosscutting.helpers.NumericHelper;
import co.edu.uco.fink.crosscutting.helpers.ObjectHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public final class DepartamentoEntity {

    private int id;
    private String nombre;
    private PaisEntity pais;

    private DepartamentoEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
        setPais(PaisEntity.build());
    }

    private DepartamentoEntity(final int id, final String nombre, final PaisEntity pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public static DepartamentoEntity build(final int id){
        return new DepartamentoEntity(id);
    }

    public static DepartamentoEntity build(final int id, final String nombre, final PaisEntity pais){
        return new DepartamentoEntity(id, nombre, pais);
    }

    protected static DepartamentoEntity build(){
        return new DepartamentoEntity(NumericHelper.ZERO);
    }

    public int getId() {
        return id;
    }

    private final void setId(final int id) {
        this.id = id;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public final PaisEntity getPais() {
        return pais;
    }

    private final void setPais(final PaisEntity pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefault(pais, PaisEntity.build());
    }
}
