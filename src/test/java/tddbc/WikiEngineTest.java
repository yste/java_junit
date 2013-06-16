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
	public void test記法関係なしに文字を返す() {
		assertThat(sut.getText("text"), is("text"));
	}
	
	@Test
	public void testイコールで括られた文字列にH1タグで括られた文字列を返す() {
		assertThat(sut.getText("= TDDBC ="), is("<H1>TDDBC</H1>"));
		assertThat(sut.getText("=TDDBC="), is("<H1>TDDBC</H1>"));
		assertThat(sut.getText("=   TDDBC   ="), is("<H1>TDDBC</H1>"));
		assertThat(sut.getText("= TDD BC ="), is("<H1>TDD BC</H1>"));
		assertThat(sut.getText("= TDD = BC ="), is("<H1>TDD = BC</H1>"));
		assertThat(sut.getText("=\tTDD = BC ="), is("<H1>TDD = BC</H1>"));
		assertThat(sut.getText("= = TDDBC = ="), is("<H1>= TDDBC =</H1>"));
	}
	
	@Test
	public void testイコール2つで括られた文字列にH2タグで括られた文字列を返す() {
		assertThat(sut.getText("== TDDBC =="), is("<H2>TDDBC</H2>"));
		assertThat(sut.getText("==TDDBC=="), is("<H2>TDDBC</H2>"));
		assertThat(sut.getText("==   TDDBC   =="), is("<H2>TDDBC</H2>"));
		assertThat(sut.getText("== TDD BC =="), is("<H2>TDD BC</H2>"));
		assertThat(sut.getText("== TDD = BC =="), is("<H2>TDD = BC</H2>"));
		assertThat(sut.getText("==\tTDD = BC =="), is("<H2>TDD = BC</H2>"));
	}
}
