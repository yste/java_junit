package tddbc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class WikiEngineTest {

	@Test
	public void test�L�@�֌W�Ȃ��ɕ�����Ԃ�() {
		WikiEngine sut = new WikiEngine();
		assertThat(sut.getText("text"), is("text"));
	}

}
