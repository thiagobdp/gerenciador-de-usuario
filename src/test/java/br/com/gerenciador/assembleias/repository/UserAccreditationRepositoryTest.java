package br.com.gerenciador.assembleias.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.gerenciador.assembleias.model.UserAccreditation;
import br.com.gerenciador.assembleias.repository.UserAccreditationRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserAccreditationRepositoryTest {

	@Autowired
	private UserAccreditationRepository repository;

	@Autowired
	private TestEntityManager em;

	@Test
	public void findByUserId() {
		String userId = "user id 01";
		Boolean accreditated = true;
		UserAccreditation user = new UserAccreditation(userId, accreditated);
		em.persist(user);

		UserAccreditation userList = this.repository.findByUserId(userId);
		Assert.assertNotNull(userList);
		Assert.assertEquals(userList.getUserId(), userId);
		Assert.assertEquals(userList.getAccreditaded(), accreditated);
	}

	@Test
	public void findByNotExistingUserId() {
		String userId = "user id 01";

		UserAccreditation userList = this.repository.findByUserId(userId);
		Assert.assertNull(userList);

	}

}
