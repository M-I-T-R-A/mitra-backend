package com.tvscredit.tvscredit.services;

import com.tvscredit.tvscredit.dto.customer.CustomerBasicDTO;
import com.tvscredit.tvscredit.models.enums.Approval;
import com.tvscredit.tvscredit.models.loans.ApprovedInstantLoan;
import com.tvscredit.tvscredit.models.loans.InstantLoan;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.repository.ApprovedInstantLoanRepository;
import com.tvscredit.tvscredit.repository.InstantLoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private CustomerService customerService;
    private InstantLoanRepository instantLoanRepository;
    private ApprovedInstantLoanRepository approvedInstantLoanRepository;
    private ModelMapper modelMapper;

    public AdminService(CustomerService customerService, InstantLoanRepository instantLoanRepository,
                        ApprovedInstantLoanRepository approvedInstantLoanRepository,
                        ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
        this.instantLoanRepository = instantLoanRepository;
        this.approvedInstantLoanRepository = approvedInstantLoanRepository;
    }

    public Customer getCustomerProfile(Long id){
        return customerService.getCustomer(id);
    }

    public List<CustomerBasicDTO> getAllCustomerWaitingProfiles(){
        List<Customer> allCustomers = customerService.getAllCustomer();
        return allCustomers.stream()
                .filter(customer -> customer.getHaveCurrentLoan() == false &&
                        customerService.getInstantLoan(customer.getId()).getApproval() == Approval.WAITING)
                .map(customer -> modelMapper.map(customer, CustomerBasicDTO.class))
                .collect(Collectors.toList());
    }

    public ApprovedInstantLoan approveLoan(ApprovedInstantLoan approvedInstantLoan, Long loanId){
        InstantLoan instantLoan = instantLoanRepository.findById(loanId).get();
        approvedInstantLoan.setInstantLoan(instantLoan);
        ApprovedInstantLoan newApprovedInstantLoan = approvedInstantLoanRepository.save(approvedInstantLoan);

        instantLoan.setApprovedInstantLoan(newApprovedInstantLoan);
        instantLoan.setApproval(Approval.APPROVED);
        Customer customer = instantLoan.getCustomer();
        customer.setHaveCurrentLoan(true);
        customerService.saveCustomer(customer);
        instantLoanRepository.save(instantLoan);

        return newApprovedInstantLoan;
    }

    public void verifyCustomer(Long id){
        Customer customer = customerService.getCustomer(id);
        customer.setVerified(true);
        customerService.saveCustomer(customer);
    }

    public void rejectLoan(Long loanId){
        InstantLoan instantLoan = instantLoanRepository.findById(loanId).get();

        instantLoan.setApproval(Approval.REJECTED);
        Customer customer = instantLoan.getCustomer();
        customer.setHaveCurrentLoan(false);
        customerService.saveCustomer(customer);
        instantLoanRepository.save(instantLoan);

    }
}
