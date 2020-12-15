package br.com.springcurso.service.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.springcurso.Util.HashUtil;

@RunWith(SpringRunner.class)
public class HashUtilTests {

	@Test
	public void getSecureHashTest() {
		String hash = HashUtil.getSecurehash("123");
		System.out.println("Tamanho da chave: "+hash);
		assertThat(hash.length()).isEqualTo(64);
	}
}
