package com.PatitosdeHule.eCommerce.services;

import com.PatitosdeHule.eCommerce.DTOs.InvoiceDTO;
import com.PatitosdeHule.eCommerce.models.Invoice;

import java.util.Set;

public interface InvoiceService {

    void saveInvoices(Invoice invoice);
    Set<InvoiceDTO> getInvoiceDTO();

}
