package br.com.packcontrol.model.enums;

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
}
