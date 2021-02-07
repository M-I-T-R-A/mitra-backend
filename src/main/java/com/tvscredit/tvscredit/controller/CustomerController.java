package com.tvscredit.tvscredit.controller;

import com.tvscredit.tvscredit.dto.bankaccount.BankAccountDTO;
import com.tvscredit.tvscredit.dto.customer.CustomerBasicDTO;
import com.tvscredit.tvscredit.dto.customer.CustomerInstantLoanSurrogateDTO;
import com.tvscredit.tvscredit.dto.loan.InstantLoanDTO;
import com.tvscredit.tvscredit.models.BankAccount;
import com.tvscredit.tvscredit.models.loans.InstantLoan;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    private ModelMapper modelMapper;

    CustomerController(CustomerService customerService, ModelMapper modelMapper){
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerBasicDTO> addNewCustomer(@RequestBody CustomerBasicDTO customerBasicDTO){
        Customer customer = customerService.addCustomer(convertToEntity(customerBasicDTO));
        return ResponseEntity.ok(convertToDto1(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerBasicDTO> getCustomer(@PathVariable Long id){
        return ResponseEntity.ok(convertToDto1(customerService.getCustomer(id)));
    }

    @PutMapping("/surrogates")
    public ResponseEntity.BodyBuilder updateInstantLoanSurrogates(@RequestBody CustomerInstantLoanSurrogateDTO customerInstantLoanSurrogateDTO){
        customerService.updateInstantLoanSurrogates(customerInstantLoanSurrogateDTO.getId(),
                customerInstantLoanSurrogateDTO.getInstantLoanSurrogates());
        return ResponseEntity.ok();
    }

    @GetMapping("/surrogates/{id}")
    public ResponseEntity<CustomerInstantLoanSurrogateDTO> getInstantLoanSurrogates(@PathVariable Long id){
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok(convertToDto2(customer));
    }

    @PostMapping("/bankaccount/{id}")
    public ResponseEntity<BankAccountDTO> addBankAccountDetail(@RequestBody BankAccountDTO bankAccountDTO, @PathVariable Long id){
        BankAccount bankAccount = customerService.addBankAccount(convertToEntity(bankAccountDTO), id);
        return ResponseEntity.ok(convertToDto3(bankAccount));
    }

    @GetMapping("/bankaccount/{id}")
    public ResponseEntity<List<BankAccountDTO>> getAllBankAccounts(@PathVariable Long id){
        List<BankAccount> bankAccounts = customerService.getCustomer(id).getAllBankAcounts();
        List<BankAccountDTO> bankAccountDTOS = bankAccounts.stream()
                .map(this::convertToDto3)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bankAccountDTOS);
    }

    @PostMapping("/loan/instant/{id}")
    public ResponseEntity<InstantLoanDTO> applyForLoan(@PathVariable Long id, @RequestBody InstantLoanDTO instantLoanDTO){
        InstantLoan instantLoan = customerService.applyForInstantLoan(convertToEntity(instantLoanDTO), id);
        return ResponseEntity.ok(convertToDto4(instantLoan));
    }

    @GetMapping("/loan/instant/{id}")
    public ResponseEntity<List<InstantLoanDTO>> getAllLoansOfCustomer(@PathVariable Long id){
        List<InstantLoanDTO> instantLoanDTOS = customerService.getAllLoans(id)
                .stream()
                .map(this::convertToDto4)
                .collect(Collectors.toList());

        return ResponseEntity.ok(instantLoanDTOS);
    }

    private Customer convertToEntity(CustomerBasicDTO dto){
        return modelMapper.map(dto, Customer.class);
    }

    private BankAccount convertToEntity(BankAccountDTO dto){
        return modelMapper.map(dto, BankAccount.class);
    }

    private InstantLoan convertToEntity(InstantLoanDTO dto){
        return modelMapper.map(dto, InstantLoan.class);
    }

    private CustomerBasicDTO convertToDto1(Customer entity){
        return modelMapper.map(entity, CustomerBasicDTO.class);
    }

    private Customer convertToEntity(CustomerInstantLoanSurrogateDTO dto){
        return modelMapper.map(dto, Customer.class);
    }

    private CustomerInstantLoanSurrogateDTO convertToDto2(Customer entity){
        return modelMapper.map(entity, CustomerInstantLoanSurrogateDTO.class);
    }

    private BankAccountDTO convertToDto3(BankAccount entity){
        return modelMapper.map(entity, BankAccountDTO.class);
    }

    private InstantLoanDTO convertToDto4(InstantLoan entity){
        return modelMapper.map(entity, InstantLoanDTO.class);
    }

}
