package br.com.packcontrol.model.enums;

public enum PickedBy {
    MORADOR,
    RECEBEDOR_AUTORIZADO,
    NAO_RETIRADO;

    public static PickedBy defaultOr(PickedBy value){
        return value != null ? value : NAO_RETIRADO;
    }
}
