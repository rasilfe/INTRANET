package br.com.capsule.FTP.mvc.enums;

public enum Envs {

    PROD(0), HOM(1), DEV(2), QAS(2);

    private final int valor;
    Envs(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
