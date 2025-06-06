package br.com.alura;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.refl.Transformator;

public class PessoaService {

    public PessoaDTO list() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO pessoaDTO = new Transformator().transform(pessoa);
        return pessoaDTO;
    }
}
