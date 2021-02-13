package com.tvscredit.tvscredit.controller;

import com.tvscredit.tvscredit.dto.customer.CustomerBasicDTO;
import com.tvscredit.tvscredit.dto.customer.CustomerDetailDTO;
import com.tvscredit.tvscredit.dto.customer.CustomerLoanDTO;
import com.tvscredit.tvscredit.models.loans.ApprovedInstantLoan;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.services.AdminService;
import com.tvscredit.tvscredit.services.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    private ShopService shopService;

    public AdminController(AdminService adminService, ShopService shopService) {
        this.adminService = adminService;
        this.shopService = shopService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerBasicDTO>> getAllCustomers(){
        return ResponseEntity.ok(adminService.getAllCustomer());
    }

    @GetMapping("/customer/waiting")
    public ResponseEntity<List<CustomerLoanDTO>> getAllPendingCustomers(){
        return ResponseEntity.ok(adminService.getAllCustomerWaitingProfiles());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDetailDTO> getCustomerDetails(@PathVariable Long id){
        Customer customer = adminService.getCustomerProfile(id);
        CustomerDetailDTO customerDetailDTO = new CustomerDetailDTO();

        customerDetailDTO.setCustomer(customer);
        customerDetailDTO.setAllBankAccounts(customer.getAllBankAccounts());
        customerDetailDTO.setAllLoans(customer.getAllLoans());
        customerDetailDTO.setInstantLoanSurrogates(customer.getInstantLoanSurrogates());
        customerDetailDTO.setShop(shopService.getShopOfCustomer(id));

        return ResponseEntity.ok(customerDetailDTO);
    }

    @GetMapping("/customer/reject/{id}")
    public ResponseEntity rejectLoan(@PathVariable Long id){
        adminService.rejectLoan(id);
        System.out.println("reject"+id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/customer/approve/{id}")
    public ResponseEntity approveLoan(@PathVariable Long id, @RequestBody ApprovedInstantLoan approvedInstantLoan){
        adminService.approveLoan(approvedInstantLoan, id);
        System.out.println(approvedInstantLoan.getApprovedAmount());
        System.out.println(id);
        return  ResponseEntity.ok().build();
    }
}
