package fred.custom.crm.core.repositories.springdatajpa.member;

import org.springframework.data.jpa.repository.JpaRepository;

import fred.custom.crm.core.model.member.Member;

/**
 * Specifies methods used to obtain and modify member related information which is stored in the database.
 * 
 * @author Fred
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    // No additional methods... for now
}
