package br.com.alura.refl;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.Endereco;
import br.com.alura.EnderecoFixture;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;
import br.com.alura.PessoaFixture;

public class TransformatorTest {

    Pessoa pessoa = PessoaFixture.buildPessoa();
    Pessoa pessoaSemCpf = PessoaFixture.buildPessoaSemCpf();
    Endereco endereco = EnderecoFixture.buildEndereco();

    @Test
    public void shouldTransform() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        var transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoaDTO.getNome(), pessoa.getNome());
        Assertions.assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());
    }

    @Test
    public void shouldNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            var transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void shouldTransformWhenFieldIsNull() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        var transformator = new Transformator();
        PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoaSemCpf);

        Assertions.assertEquals(pessoaSemCpf.getNome(), pessoaDTOSemCpf.getNome());
        Assertions.assertNull(pessoaDTOSemCpf.getCpf());
    }
}
