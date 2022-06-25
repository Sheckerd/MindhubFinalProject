package com.PatitosdeHule.eCommerce.controllers;


import com.PatitosdeHule.eCommerce.DTOs.InvoiceDTO;
import com.PatitosdeHule.eCommerce.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public Set<InvoiceDTO> getInvoiceDTOSet(){
        return invoiceService.getInvoiceDTO();
    }


}
