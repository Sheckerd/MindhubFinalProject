package com.PatitosdeHule.eCommerce.models;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy="client", fetch= FetchType.EAGER)
    private Set<Invoice> invoices = new HashSet();

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String cellPhone;
    private boolean isPremium;

    public Client(){}

    public Client(String name, String lastName, String email, String password, String cellPhone, boolean isPremium) {


        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cellPhone = cellPhone;
        this.isPremium = false;

    };

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @JsonIgnore
    public Set<Invoice> getInvoices() {return invoices;}

    public void addAccount (Invoice invoice) {
        invoice.setClient(this);
        invoices.add(invoice);
    }
}
