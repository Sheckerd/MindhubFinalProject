package com.PatitosdeHule.eCommerce.services.implement;

import com.PatitosdeHule.eCommerce.DTOs.InvoiceDTO;
import com.PatitosdeHule.eCommerce.models.Invoice;
import com.PatitosdeHule.eCommerce.repositories.InvoiceRepository;
import com.PatitosdeHule.eCommerce.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImplement implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public void saveInvoices(Invoice invoice) {
      invoiceRepository.save(invoice);
    }


    @Override
    public Set<InvoiceDTO> getInvoiceDTO(){
        return invoiceRepository.findAll().stream().map(InvoiceDTO::new).collect(Collectors.toSet());
    }
}
