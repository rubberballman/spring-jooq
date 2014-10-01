package fred.custom.crm.core.repositories.springdatajpa.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

import fred.custom.crm.core.model.member.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/crm-persistence.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class ITMemberRepositoryTest {

    @Autowired
    private MemberRepository repository;
    
    /**
     * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#save(Object)
     */
    @Test
    public void save() {
        Member member = ITMemberUtils.buildMember();
        member = repository.save(member);
        assertNotNull(member);
        assertNotNull(member.getId());
        assertNotNull(member.getPerson());
        assertNotNull(member.getPerson().getId());
    }
    
}
