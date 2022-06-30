package com.PatitosdeHule.eCommerce.DTOs;

import com.PatitosdeHule.eCommerce.models.Client;
import com.PatitosdeHule.eCommerce.models.Invoice;

import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String cellPhone;
    private Set<InvoiceDTO> invoiceSet;
    private boolean isPremium;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.cellPhone = client.getCellPhone();
        this.isPremium = client.isPremium();
        this.invoiceSet = client.getInvoices().stream().map(invoice -> new InvoiceDTO(invoice)).collect(Collectors.toSet());

    }

    public long getId() {
        return id;
    }

    public Set<InvoiceDTO> getInvoiceSet() {
        return invoiceSet;
    }

    public void setInvoiceSet(Set<InvoiceDTO> invoiceSet) {
        this.invoiceSet = invoiceSet;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
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
}
