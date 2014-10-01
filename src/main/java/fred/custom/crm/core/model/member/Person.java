package fred.custom.crm.core.model.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import fred.custom.crm.core.model.BaseEntity;

/**
 * An entity class which contains the information of a single person.
 * 
 * @author Fred
 */
@Entity
@Table(name = "persons")
public class Person implements BaseEntity<Long>, Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = -1704325202506506868L;

    /**
     * This enum lists the possible values for the person's gender.
     * <ul>
     * <li>MALE - The person is a man.</li>
     * <li>FEMALE - The person is a woman.</li>
     * </ul>
     */
    public enum Gender {
        /** Man */
        MALE("M"),
        /** Woman */
        FEMALE("F");

        private final String code;

        Gender(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    /** Unique identifier */
    @Id
    // Sequence name must be preceded by schema name.
//    @SequenceGenerator(name = "personIdSeq", sequenceName = "person_id_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personIdSeq")
//    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    // Used by JPA for optimistic locking
    private int version;

    /** Person name (forename, first name) */
    @Column(name = "first_name", length = 80, nullable = false)
    private String firstName;

    /** Family name */
    @Column(name = "last_name", length = 80, nullable = false)
    private String lastName;

    /**
     * Person's gender.
     * 
     * @see fred.custom.crm.core.model.member.Person.Gender
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    /** Cellular phone number */
    @Column(name = "cell_phone_number", length = 10)
    private String cellPhoneNumber;

    @Column(name = "email", length = 320)
    private String email;

    /** Birth date */
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date birthDate;

    /** Social Security Number */
    @Column(name = "social_insurance_number", length = 9)
    private String socialInsuranceNumber;

    /**
     * Default constructor.
     */
    public Person() {
        // Empty
    }

    /**
     * Minimal constructor with all mandatory values.
     * 
     * @param firstName
     *            The person's first name
     * @param lastName
     *            The person's family name
     * @param gender
     *            The person's gender
     */
    public Person(String firstName, String lastName, Gender gender) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    /**
     * Returns a defensive copy of the field.
     * <p>
     * The caller of this method can do anything they want with the returned <code>Date</code> object, without affecting the internals of this class
     * in any way. Why? Because they do not have a reference to <code>birthDate</code>. Rather, they are playing with a second <code>Date</code> that
     * initially has the same data as <code>birthDate</code>.
     * </p>
     * 
     * @return A defensive copy of the field <code>birthDate</code>
     */
    public Date getBirthDate() {
        return (birthDate == null ? null : new Date(birthDate.getTime()));
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    /**
     * @see fred.custom.crm.core.model.BaseEntity#getId()
     */
    public Long getId() {
        return this.id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    /**
     * @see fred.custom.crm.core.model.BaseEntity#getVersion()
     */
    @Override
    public int getVersion() {
        return this.version;
    }

    /**
     * Make a private copy of the new value passed as parameter. This is the only way to keep the <code>birthDate</code> field private, and shields
     * this class from any changes that the caller may make to the original <code>birthDate</code> object (passed as parameter).
     * 
     * @param birthDate
     *            The new birth date
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = (birthDate == null ? null : new Date(birthDate.getTime()));
    }

    public void setCellPhoneNumber(final String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @see fred.custom.crm.core.model.BaseEntity#setId(Object)
     */
    public void setId(final Long key) {
        this.id = key;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setSocialInsuranceNumber(String socialInsuranceNumber) {
        this.socialInsuranceNumber = socialInsuranceNumber;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {});
    }

    private Person(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.cellPhoneNumber = builder.cellPhoneNumber;
        this.email = builder.email;
        this.birthDate = builder.birthDate;
        this.socialInsuranceNumber = builder.socialInsuranceNumber;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private Gender gender;
        private String cellPhoneNumber;
        private String email;
        private Date birthDate;
        private String socialInsuranceNumber;

        /*
         * public static Builder aPerson(){ return new Builder(); }
         */

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder withCellPhoneNumber(String cellPhoneNumber) {
            this.cellPhoneNumber = cellPhoneNumber;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withSocialInsuranceNumber(String socialInsuranceNumber) {
            this.socialInsuranceNumber = socialInsuranceNumber;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
