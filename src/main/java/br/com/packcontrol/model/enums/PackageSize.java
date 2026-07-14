package br.com.packcontrol.model.enums;

public enum PackageSize {
    ENCOMENDA_GRANDE("ENCOMENDA_GRANDE"),
    ENCOMENDA_PEQUENA("ENCOMENDA_PEQUENA"),
    ENCOMENDA_MEDIA("ENCOMENDA_MEDIA"),
    ENCOMENDA_MUITO_PEQUENA( "ENCOMENDA_MUITO_PEQUENA"),
    NAO_INFORMADO("NAO_INFORMADO");

    private String value;

    PackageSize(String value) {
        this.value = value;
    }

    public static PackageSize defaultOr(PackageSize value){
        return value != null ? value : NAO_INFORMADO;
    }
}
