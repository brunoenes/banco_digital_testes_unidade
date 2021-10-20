package com.financa.bancodigital.exception;

public class BancoException extends RuntimeException {

    private static final String ID_INCOMPATIVEL_OBJETO = "O ID do Banco a ser editado é diferente do Código do Objeto";

    private static final String NOME_COMPLETO_VAZIO = "Nome completo não pode ser vazio.";

    private static final String BANCO_NAO_ENCONTRADO = "Banco não encontrado!";

    public BancoException(String message) {
        super(message);
    }

    public static String getIdIncompativelObjeto() {
        return ID_INCOMPATIVEL_OBJETO;
    }

    public static String getNomeCompletoVazio() {
        return NOME_COMPLETO_VAZIO;
    }

    public static String getBancoNaoEncontrado() {
        return BANCO_NAO_ENCONTRADO;
    }

}
