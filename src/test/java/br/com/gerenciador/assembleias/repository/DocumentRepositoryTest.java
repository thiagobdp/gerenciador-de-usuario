package br.com.gerenciador.assembleias.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gerenciador.assembleias.model.Document;
import br.com.gerenciador.assembleias.model.UserAccreditation;
import br.com.gerenciador.assembleias.repository.DocumentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class DocumentRepositoryTest {

	@Autowired
	private DocumentRepository repository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void findByIdTest() {
		String name = "teste name 01";
		String mimeType = "mimeType 01";
		String content = "content test01";
		Document doc = em.persist(new Document(name, mimeType, content));

		Optional<Document> docPersisted = this.repository.findById(doc.getId());
		Assert.assertTrue(docPersisted.isPresent());
		Assert.assertEquals(docPersisted.get().getName(), name);
		Assert.assertEquals(docPersisted.get().getMimeType(), mimeType);
		Assert.assertEquals(docPersisted.get().getContent(), content);
	}

	@Test
	public void findByNotExistingUserIdTest() {
		Long userId = Long.valueOf(200);

		Optional<Document> docPersisted = this.repository.findById(userId);
		Assert.assertFalse(docPersisted.isPresent());

	}

}
