package fred.custom.crm.core.repositories.springdatajpa.member;

import java.util.Date;

import fred.custom.crm.core.model.member.Member;
import fred.custom.crm.core.model.member.Person;
import fred.custom.crm.core.model.member.Person.Gender;

public class ITMemberUtils {

    public static Member buildMember() {
        Person p = Person.Builder.getInstance().withGender(Gender.MALE).withFirstName("John").withLastName("Doe").build();

        Date now = new Date();
        Member m = Member.Builder.getInstance().withMemberNumber("123456789").withEmployeeNumber("99999").withPerson(p).withCreationDate(now)
                .withLastUpdateDate(now).withLastUpdateUser("test.user").build();

        return m;
    }

}
