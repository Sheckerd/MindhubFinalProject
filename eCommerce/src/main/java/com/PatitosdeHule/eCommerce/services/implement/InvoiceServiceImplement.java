package com.PatitosdeHule.eCommerce.services.implement;

import com.PatitosdeHule.eCommerce.DTOs.InvoiceDTO;
import com.PatitosdeHule.eCommerce.models.Invoice;
import com.PatitosdeHule.eCommerce.repositories.InvoiceRepository;
import com.PatitosdeHule.eCommerce.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
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
    public Set<Invoice> getInvoices() {
        return invoiceRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<InvoiceDTO> getSetInvoiceDTO() {
        return invoiceRepository.findAll().stream().map(InvoiceDTO::new).collect(Collectors.toSet());
    }

    @Override
    public InvoiceDTO getInvoiceDTO(Long id) {
        return invoiceRepository.findById(id).map(InvoiceDTO::new).orElse(null);

    }

    @Override
    public Invoice getLastInvoice() {

        List<Invoice> invoiceList = invoiceRepository.findAll();
        invoiceList.stream().sorted(Comparator.comparing(Invoice::getId)).collect(Collectors.toList());
        return invoiceList.get(invoiceList.size() - 1);

    }


}
