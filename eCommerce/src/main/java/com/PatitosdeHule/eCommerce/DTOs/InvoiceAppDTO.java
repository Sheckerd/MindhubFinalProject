package com.PatitosdeHule.eCommerce.DTOs;
import com.PatitosdeHule.eCommerce.models.*;
import java.time.LocalDateTime;

public class InvoiceAppDTO {

    private PaymentMethods paymentMethods;
    private ShippingType shippingType;


    public InvoiceAppDTO() {
    }

    ;

    public InvoiceAppDTO(PaymentMethods paymentMethods, ShippingType shippingType) {

        this.paymentMethods = paymentMethods;
        this.shippingType = shippingType;

    }

    public PaymentMethods getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(PaymentMethods paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    public void setShippingType(ShippingType shippingType) {
        this.shippingType = shippingType;
    }
}