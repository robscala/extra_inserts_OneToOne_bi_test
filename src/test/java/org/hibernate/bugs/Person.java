package org.hibernate.bugs;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String firstName;

    @OneToOne(orphanRemoval=true, cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY)
    private LoginAccount loginAccount = new LoginAccount();

    public Person() {
    }

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LoginAccount getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(LoginAccount loginAccount) {
        this.loginAccount = loginAccount;
    }
}
