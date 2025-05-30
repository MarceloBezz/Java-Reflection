package br.com.alura;

public class PessoaFixture {
    public static Pessoa buildPessoa() {
        return new Pessoa(1, "João", "1234");
    }

    public static Pessoa buildPessoaSemCpf() {
        return new Pessoa("Marcelo");
    }
}
