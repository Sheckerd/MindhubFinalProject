package com.PatitosdeHule.eCommerce.models;
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
    
    public Client(){}

    public Client(String name, String lastName, String email, String password, String cellPhone) {

        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cellPhone = cellPhone;

    };

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
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
    
    public Set<Invoice> getInvoices() {return invoices;}
    
    public void addAccount (Invoice invoice) {
        invoice.setClient(this);
        invoices.add(invoice);
    }
}
