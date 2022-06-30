package com.PatitosdeHule.eCommerce.repositories;

import com.PatitosdeHule.eCommerce.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
