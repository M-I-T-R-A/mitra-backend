package com.tvscredit.tvscredit.controller;

import com.tvscredit.tvscredit.dto.customer.CustomerBasicDTO;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerBasicDTO>> getAllCustomers(){
        return ResponseEntity.ok(adminService.getAllCustomer());
    }

    @GetMapping("/customer/waiting")
    public ResponseEntity<List<CustomerBasicDTO>> getAllPendingCustomers(){
        return ResponseEntity.ok(adminService.getAllCustomerWaitingProfiles());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable Long id){
        return ResponseEntity.ok(adminService.getCustomerProfile(id));
    }
}
