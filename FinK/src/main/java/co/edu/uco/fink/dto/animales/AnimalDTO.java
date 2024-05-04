package co.edu.uco.fink.dto.animales;

import co.edu.uco.fink.crosscutting.helpers.DateHelper;
import co.edu.uco.fink.crosscutting.helpers.TextHelper;

public class AnimalDTO {

    private int identificador;

    private String serial;

    private String genero;

    private String especie;

    private String raza;

    private String fechaNacimiento;

    public AnimalDTO() {
        setSerial(TextHelper.EMPTY);
        setGenero(TextHelper.EMPTY);
        setEspecie(TextHelper.EMPTY);
        setRaza(TextHelper.EMPTY);
        setFechaNacimiento(DateHelper.defaultDate);
    }

    public AnimalDTO(final int identificador, final String serial, final String genero, final String especie, final String raza, final String fechaNacimiento) {
        setIdentificador(identificador);
        setSerial(serial);
        setGenero(genero);
        setEspecie(especie);
        setRaza(raza);
        setFechaNacimiento(fechaNacimiento);
    }

    public static final AnimalDTO build(){
        return new AnimalDTO();
    }

    public final int getIdentificador() {
        return identificador;
    }

    public final AnimalDTO setIdentificador(final int identificador) {
        this.identificador = identificador;
        return this;
    }

    public final String getSerial() {
        return serial;
    }

    public final AnimalDTO setSerial(final String serial) {
        this.serial = TextHelper.applyTrim(serial);
        return this;
    }

    public final String getGenero() {
        return genero;
    }

    public final AnimalDTO setGenero(final String genero) {
        this.genero = TextHelper.applyTrim(serial);
        return this;
    }

    public final String getEspecie() {
        return especie;
    }

    public final AnimalDTO setEspecie(final String especie) {
        this.especie = TextHelper.applyTrim(especie);
        return this;
    }

    public final String getRaza() {
        return raza;
    }

    public final AnimalDTO setRaza(final String raza) {
        this.raza = TextHelper.applyTrim(raza);
        return this;
    }

    public final String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public final AnimalDTO setFechaNacimiento(final String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }
}
