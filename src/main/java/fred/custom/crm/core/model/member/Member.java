package fred.custom.crm.core.model.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import fred.custom.crm.core.model.BaseEntity;

/**
 * An entity class which contains the information of a single member.
 * 
 * @author Fred
 */
@Entity
@Table(name = "members")
public class Member implements BaseEntity<Long>, Serializable {

    /** Serial version UID */
    private static final long serialVersionUID = 1502742707197902956L;

    @Id
    // Sequence name must be preceded by schema name.
//    @SequenceGenerator(name = "memberIdSeq", sequenceName = "member_id_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberIdSeq")
//    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    protected int version;

    @Column(name = "member_number", nullable = false, updatable = false, unique = true)
    private String memberNumber;

    @Column(name = "employee_number", nullable = false, unique = true)
    private String employeeNumber;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id", columnDefinition = "BIGINT")
    private Person person;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false, updatable = false)
    private Date creationDate;

    @Column(name = "last_update_user", nullable = false)
    private String lastUpdateUser;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date", nullable = false)
    private Date lastUpdateDate;

    /**
     * Returns a defensive copy of the field.
     * <p>
     * The caller of this method can do anything they want with the returned <code>Date</code> object, without affecting the internals of this class
     * in any way. Why? Because they do not have a reference to <code>creationDate</code>. Rather, they are playing with a second <code>Date</code>
     * that initially has the same data as <code>creationDate</code>.
     * </p>
     * 
     * @return A defensive copy of the field <code>creationDate</code>
     */
    public Date getCreationDate() {
        return (creationDate == null ? null : new Date(creationDate.getTime()));
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * @see fred.custom.crm.core.model.BaseEntity#getId()
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * Returns a defensive copy of the field.
     * <p>
     * The caller of this method can do anything they want with the returned <code>Date</code> object, without affecting the internals of this class
     * in any way. Why? Because they do not have a reference to <code>lastUpdateDate</code>. Rather, they are playing with a second <code>Date</code>
     * that initially has the same data as <code>lastUpdateDate</code>.
     * </p>
     * 
     * @return A defensive copy of the field <code>lastUpdateDate</code>
     */
    public Date getLastUpdateDate() {
        return (lastUpdateDate == null ? null : new Date(lastUpdateDate.getTime()));
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public Person getPerson() {
        return person;
    }

    /**
     * @see fred.custom.crm.core.model.BaseEntity#getVersion()
     */
    @Override
    public int getVersion() {
        return this.version;
    }

    /**
     * Make a private copy of the new value passed as parameter. This is the only way to keep the <code>creationDate</code> field private, and shields
     * this class from any changes that the caller may make to the original <code>creationDate</code> object (passed as parameter).
     * 
     * @param creationDate
     *            The new creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = (creationDate == null ? null : new Date(creationDate.getTime()));
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * @see fred.custom.crm.core.model.BaseEntity#setId(java.lang.Object)
     */
    @Override
    public void setId(Long key) {
        this.id = key;
    }

    /**
     * Make a private copy of the new value passed as parameter. This is the only way to keep the <code>lastUpdateDate</code> field private, and
     * shields this class from any changes that the caller may make to the original <code>lastUpdateDate</code> object (passed as parameter).
     * 
     * @param lastUpdateDate
     *            The new last update date
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = (lastUpdateDate == null ? null : new Date(lastUpdateDate.getTime()));
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {});
    }

    private Member(Builder builder) {
        this.id = builder.id;
        this.memberNumber = builder.memberNumber;
        this.employeeNumber = builder.employeeNumber;
        this.person = builder.person;
        this.creationDate = builder.creationDate;
        this.lastUpdateUser = builder.lastUpdateUser;
        this.lastUpdateDate = builder.lastUpdateDate;
    }

    public static class Builder {
        private Long id;
        private String memberNumber;
        private String employeeNumber;
        private Person person;
        private Date creationDate;
        private String lastUpdateUser;
        private Date lastUpdateDate;

        /*
         * public static Builder aMember(){ return new Builder(); }
         */

        public static Builder getInstance() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withMemberNumber(String memberNumber) {
            this.memberNumber = memberNumber;
            return this;
        }

        public Builder withEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder withPerson(Person person) {
            this.person = person;
            return this;
        }

        public Builder withCreationDate(Date creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        public Builder withLastUpdateUser(String lastUpdateUser) {
            this.lastUpdateUser = lastUpdateUser;
            return this;
        }

        public Builder withLastUpdateDate(Date lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}
