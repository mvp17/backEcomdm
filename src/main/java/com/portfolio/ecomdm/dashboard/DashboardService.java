package com.portfolio.ecomdm.dashboard;

import com.portfolio.ecomdm.dashboard.dto.CustomerGrowthDataDTO;
import com.portfolio.ecomdm.dashboard.dto.ProductDataDTO;
import com.portfolio.ecomdm.dashboard.dto.RevenueDataDTO;
import com.portfolio.ecomdm.dashboard.dto.SalesDataDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    public DashboardService() {}

    public List<SalesDataDTO> getSalesData() {
        SalesDataDTO shirts = new SalesDataDTO("Shirts", 1201);
        SalesDataDTO jeans = new SalesDataDTO("Jeans", 900);
        SalesDataDTO shoes = new SalesDataDTO("Shoes", 1500);
        SalesDataDTO hats = new SalesDataDTO("Hats", 400);

        ArrayList<SalesDataDTO> sales = new ArrayList<>();
        sales.add(shirts);
        sales.add(jeans);
        sales.add(shoes);
        sales.add(hats);

        return sales;
    }

    public List<RevenueDataDTO> getRevenueData() {
        RevenueDataDTO jan = new RevenueDataDTO("Jan", 4000);
        RevenueDataDTO feb = new RevenueDataDTO("Feb", 6000);
        RevenueDataDTO mar = new RevenueDataDTO("Mar", 5500);
        RevenueDataDTO apr = new RevenueDataDTO("Apr", 8000);

        ArrayList<RevenueDataDTO> revenue = new ArrayList<>();
        revenue.add(jan);
        revenue.add(feb);
        revenue.add(mar);
        revenue.add(apr);

        return revenue;
    }

    public List<ProductDataDTO> getProductData() {
        ArrayList<ProductDataDTO> productDatumDTOS = new ArrayList<>();
        ProductDataDTO sneakers = new ProductDataDTO("Sneakers", 500, "Shoes");
        productDatumDTOS.add(sneakers);
        ProductDataDTO loafers = new ProductDataDTO("Loafers", 300, "Shoes");
        productDatumDTOS.add(loafers);
        ProductDataDTO boots = new ProductDataDTO("Boots", 220, "Shoes");
        productDatumDTOS.add(boots);
        ProductDataDTO sandals = new ProductDataDTO("Sandals", 180, "Shoes");
        productDatumDTOS.add(sandals);

        ProductDataDTO t = new ProductDataDTO("T-Shirt", 350, "Shirts");
        productDatumDTOS.add(t);
        ProductDataDTO dress = new ProductDataDTO("Dress Shirt", 200, "Shirts");
        productDatumDTOS.add(dress);
        ProductDataDTO polo = new ProductDataDTO("Polo Shirt", 150, "Shirts");
        productDatumDTOS.add(polo);
        ProductDataDTO hoodie = new ProductDataDTO("Hoodie", 100, "Shirts");
        productDatumDTOS.add(hoodie);

        ProductDataDTO denim_jacket = new ProductDataDTO("Denim Jacket", 200, "Jeans");
        productDatumDTOS.add(denim_jacket);
        ProductDataDTO skinny_jeans = new ProductDataDTO("Skinny Jeans", 180, "Jeans");
        productDatumDTOS.add(skinny_jeans);
        ProductDataDTO regular_jeans = new ProductDataDTO("Regular Jeans", 160, "Jeans");
        productDatumDTOS.add(regular_jeans);

        ProductDataDTO cap = new ProductDataDTO("Cap", 150, "Hats");
        productDatumDTOS.add(cap);
        ProductDataDTO beanie = new ProductDataDTO("Beanie", 120, "Hats");
        productDatumDTOS.add(beanie);
        ProductDataDTO fedora = new ProductDataDTO("Fedora", 80, "Hats");
        productDatumDTOS.add(fedora);

        return productDatumDTOS;
    }

    public CustomerGrowthDataDTO getCustomerGrowthData() {
        ArrayList<String> months = new ArrayList<>();
        months.add("Jan"); months.add("Feb"); months.add("Mar"); months.add("Apr");
        ArrayList<Integer> newCustomers = new ArrayList<>();
        newCustomers.add(50); newCustomers.add(120); newCustomers.add(180); newCustomers.add(250);
        ArrayList<Integer> returningCustomers = new ArrayList<>();
        returningCustomers.add(30); returningCustomers.add(90); returningCustomers.add(130); returningCustomers.add(200);

        return new CustomerGrowthDataDTO(months, newCustomers, returningCustomers);
    }
}
