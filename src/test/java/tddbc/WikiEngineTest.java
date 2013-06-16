package tddbc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class WikiEngineTest {
	WikiEngine sut;
	
	@Before
	public void setUp() {
		sut = new WikiEngine();
	}

	
	@Test
	public void test�L�@�֌W�Ȃ��ɕ�����Ԃ�() {
		assertThat(sut.getText("text"), is("text"));
	}
	
	@Test
	public void test�C�R�[���Ŋ���ꂽ�������H1�^�O�Ŋ���ꂽ�������Ԃ�() {
		assertThat(sut.getText("= TDDBC ="), is("<H1>TDDBC</H1>"));
		assertThat(sut.getText("=TDDBC="), is("<H1>TDDBC</H1>"));
		assertThat(sut.getText("=   TDDBC   ="), is("<H1>TDDBC</H1>"));
		assertThat(sut.getText("= TDD BC ="), is("<H1>TDD BC</H1>"));
		assertThat(sut.getText("= TDD = BC ="), is("<H1>TDD = BC</H1>"));
		assertThat(sut.getText("=\tTDD = BC ="), is("<H1>TDD = BC</H1>"));
		assertThat(sut.getText("= = TDDBC = ="), is("<H1>= TDDBC =</H1>"));
	}
	
	@Test
	public void test�C�R�[��2�Ŋ���ꂽ�������H2�^�O�Ŋ���ꂽ�������Ԃ�() {
		assertThat(sut.getText("== TDDBC =="), is("<H2>TDDBC</H2>"));
		assertThat(sut.getText("==TDDBC=="), is("<H2>TDDBC</H2>"));
		assertThat(sut.getText("==   TDDBC   =="), is("<H2>TDDBC</H2>"));
		assertThat(sut.getText("== TDD BC =="), is("<H2>TDD BC</H2>"));
		assertThat(sut.getText("== TDD = BC =="), is("<H2>TDD = BC</H2>"));
		assertThat(sut.getText("==\tTDD = BC =="), is("<H2>TDD = BC</H2>"));
	}
}
