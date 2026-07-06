package br.com.packcontrol.model.enums;

import java.util.Arrays;

public enum DoormanShift {

    DIA("DIA"),
    TARDE("TARDE"),
    NOITE("NOITE"),
    MADRUGADA("MADRUGADA"),
    NAO_INFORMADO("NAO_INFORMADO");

    private String value;

    DoormanShift(String value) {
        this.value = value;
    }

    public static DoormanShift defaultOr(DoormanShift value){
        return value != null ? value : NAO_INFORMADO;
    }

    public static DoormanShift fromValue(String value) {
        return Arrays.stream(DoormanShift.values())
                .filter(shift -> shift.value.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Turno inválido: " + value));
    }
}
