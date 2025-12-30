package com.portfolio.ecomdm.suppliers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliersService {
    public SuppliersService() {}

    public List<SupplierDTO> getSuppliers() {
        ArrayList<SupplierDTO> suppliers = new ArrayList<>();
        SupplierDTO supplier1 = new SupplierDTO("Darkuti", "dhysiam@mail.com", "94g6fd6f8f41f1grg662");
        suppliers.add(supplier1);
        SupplierDTO supplier2 = new SupplierDTO("Julimna", "julimna@mail.com", "rgregever852vdgrgr45e");
        suppliers.add(supplier2);
        SupplierDTO supplier3 = new SupplierDTO("Tairmco", "tairmco@mail.com", "uykykyuktfece7452wgv6852");
        suppliers.add(supplier3);

        return suppliers;
    }
}
