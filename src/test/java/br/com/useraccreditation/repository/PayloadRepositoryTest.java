package br.com.useraccreditation.repository;

import java.util.Arrays;
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

import br.com.useraccreditation.model.AccreditationTypeEnum;
import br.com.useraccreditation.model.Document;
import br.com.useraccreditation.model.Payload;
import br.com.useraccreditation.repository.DocumentRepository;
import br.com.useraccreditation.repository.PayloadRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class PayloadRepositoryTest {

	@Autowired
	private PayloadRepository payloadRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void findByIdTest() {
		String name = "teste name 01";
		String mimeType = "mimeType 01";
		String content = "content test01";
		Document doc = documentRepository.save(new Document(name, mimeType, content));

		Payload payloadPersisted = em.persist(new Payload(AccreditationTypeEnum.BY_INCOME, Arrays.asList(doc)));

		Optional<Payload> payloadOpt = this.payloadRepository.findById(payloadPersisted.getId());
		Assert.assertTrue(payloadOpt.isPresent());
		Assert.assertEquals(payloadOpt.get().getAccreditationType(), AccreditationTypeEnum.BY_INCOME);
		Assert.assertEquals(payloadOpt.get().getDocuments().get(0).getName(), name);
		Assert.assertEquals(payloadOpt.get().getDocuments().get(0).getContent(), content);
		Assert.assertEquals(payloadOpt.get().getDocuments().get(0).getMimeType(), mimeType);

	}

	@Test
	public void findByNotExistingUserIdTest() {
		Long payloadId = Long.valueOf(2);

		Optional<Payload> payloadPersisted = this.payloadRepository.findById(payloadId);
		Assert.assertFalse(payloadPersisted.isPresent());

	}

}
