package com.portfolio.ecomdm.dashboard.dto;

import java.util.ArrayList;

public record CustomerGrowthDataDTO(ArrayList<String> months, ArrayList<Integer> newCustomers, ArrayList<Integer> returningCustomers) {
}
