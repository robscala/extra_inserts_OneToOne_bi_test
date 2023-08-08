package org.hibernate.bugs;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class LoginAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Version
    private int version;

    private String name;

    @OneToOne(orphanRemoval=true, cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "ACCOUNTPREFERENCES_ID", foreignKey = @ForeignKey())
    private AccountPreferences accountPreferences = new AccountPreferences();

    @OneToOne(mappedBy = "loginAccount")
    @JoinColumn(name = "OWNER_ID", foreignKey = @ForeignKey())
    private Person owner;

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}