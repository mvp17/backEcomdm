package com.portfolio.ecomdm.dashboard;

import com.portfolio.ecomdm.dashboard.dto.CustomerGrowthDataDTO;
import com.portfolio.ecomdm.dashboard.dto.ProductDataDTO;
import com.portfolio.ecomdm.dashboard.dto.RevenueDataDTO;
import com.portfolio.ecomdm.dashboard.dto.SalesDataDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/sales")
    public List<SalesDataDTO> getSales() {
        return dashboardService.getSalesData();
    }

    @GetMapping("/revenue")
    public List<RevenueDataDTO> getRevenue() {
        return dashboardService.getRevenueData();
    }

    @GetMapping("/product-data")
    public List<ProductDataDTO> getProductData() {
        return dashboardService.getProductData();
    }

    @GetMapping("/customer-growth")
    public CustomerGrowthDataDTO getCustomerGrowth() {
        return dashboardService.getCustomerGrowthData();
    }
}
