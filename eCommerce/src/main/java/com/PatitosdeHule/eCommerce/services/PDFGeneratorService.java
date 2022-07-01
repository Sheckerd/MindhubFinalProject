package com.PatitosdeHule.eCommerce.services;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;
import org.springframework.security.core.Authentication;
import java.io.IOException;

public interface PDFGeneratorService {

    void PDFGenerator(HttpServletResponse response, Authentication authentication) throws IOException, DocumentException;
}
