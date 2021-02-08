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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Customer customer = customerService.saveCustomer(convertToEntity(customerBasicDTO));
        return ResponseEntity.ok(convertToDto1(customer));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerBasicDTO> updateExistingCustomer(@PathVariable Long id, @RequestBody CustomerBasicDTO customerBasicDTO){
        Customer customer = convertToEntity(customerBasicDTO);
        Customer originalCustomer = customerService.getCustomer(id);
        copyNonNullProperties(customer, originalCustomer);
        originalCustomer = customerService.saveCustomer(originalCustomer);
        return ResponseEntity.ok(convertToDto1(originalCustomer));
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
        List<BankAccount> bankAccounts = customerService.getCustomer(id).getAllBankAccounts();
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

    @GetMapping("/loan/instant/current/{id}")
    public ResponseEntity<InstantLoanDTO> getCurrentLoan(@PathVariable Long id){
        return ResponseEntity.ok(convertToDto4(customerService.getInstantLoan(id)));
    }

    @GetMapping("/loan/instant/{id}")
    public ResponseEntity<List<InstantLoanDTO>> getAllLoansOfCustomer(@PathVariable Long id){
        List<InstantLoanDTO> instantLoanDTOS = customerService.getAllInstantLoans(id)
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

    public void copyNonNullProperties(Object source, Object destination){
        BeanUtils.copyProperties(source, destination,
                getNullPropertyNames(source));
    }

    private String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set emptyNames = new HashSet();
        for(java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }

}
