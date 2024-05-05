package co.edu.uco.fink.entity;

import co.edu.uco.fink.crosscutting.helpers.DateHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;
import static co.edu.uco.fink.crosscutting.helpers.NumericHelper.ZERO;

public final class AnimalEntity {

    private int identificador;
    private String serial;
    private String genero;
    private String especie;
    private String raza;
    private String fechaNacimiento;

    private AnimalEntity() {
        setSerial(TextHelper.EMPTY);
        setGenero(TextHelper.EMPTY);
        setEspecie(TextHelper.EMPTY);
        setRaza(TextHelper.EMPTY);
        setFechaNacimiento(DateHelper.defaultDate);
    }

    private AnimalEntity(final int identificador, final String serial, final String genero, final String especie, final String raza, final String fechaNacimiento) {
        setIdentificador(identificador);
        setSerial(serial);
        setGenero(genero);
        setEspecie(especie);
        setRaza(raza);
        setFechaNacimiento(fechaNacimiento);
    }

    public static final AnimalEntity build(){
        return new AnimalEntity();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final AnimalEntity setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getSerial() {
        return serial;
    }

    public final AnimalEntity setSerial(final String serial) {
        this.serial = TextHelper.applyTrim(serial);
        return this;
    }

    public final String getGenero() {
        return genero;
    }

    public final AnimalEntity setGenero(final String genero) {
        this.genero = TextHelper.applyTrim(genero);
        return this;
    }

    public final String getEspecie() {
        return especie;
    }

    public final AnimalEntity setEspecie(final String especie) {
        this.especie = TextHelper.applyTrim(especie);
        return this;
    }

    public final String getRaza() {
        return raza;
    }

    public final AnimalEntity setRaza(final String raza) {
        this.raza = TextHelper.applyTrim(raza);
        return this;
    }

    public final String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public final AnimalEntity setFechaNacimiento(final String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
}
