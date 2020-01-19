package br.com.capsule.FTP.mvc.enums;

public enum Types {
    DATABASE(0), TS(1), SMART(2), DFE(3), ONESOURCE(4), TAXONE(5),OTHER(6);

    private final int valor;
    Types(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
