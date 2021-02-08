package com.tvscredit.tvscredit.services;

import com.tvscredit.tvscredit.models.BankAccount;
import com.tvscredit.tvscredit.models.enums.Approval;
import com.tvscredit.tvscredit.models.loans.ApprovedInstantLoan;
import com.tvscredit.tvscredit.models.loans.InstantLoan;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;
import com.tvscredit.tvscredit.repository.ApprovedInstantLoanRepository;
import com.tvscredit.tvscredit.repository.BankAccountRepository;
import com.tvscredit.tvscredit.repository.CustomerRepository;
import com.tvscredit.tvscredit.repository.InstantLoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private InstantLoanRepository instantLoanRepository;
    private ApprovedInstantLoanRepository approvedInstantLoanRepository;
    private Customer customer;

    CustomerService(CustomerRepository customerRepository
                    ,BankAccountRepository bankAccountRepository
                    ,InstantLoanRepository instantLoanRepository
                    ,ApprovedInstantLoanRepository approvedInstantLoanRepository){
        this.customerRepository = customerRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.instantLoanRepository = instantLoanRepository;
        this.approvedInstantLoanRepository = approvedInstantLoanRepository;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void updateElectricity(Long customerId, String url){
        setClassCustomer(customerId);
        customer.setElectricityBillImageUrl(url);
        //extractElectricityBillAmount(customer);
        saveClassCustomer();
    }

    public void updateInstantLoanSurrogates(Long customerId, InstantLoanSurrogates instantLoanSurrogates){
        setClassCustomer(customerId);
        InstantLoanSurrogates customerSurrogates = customer.getInstantLoanSurrogates();
        BeanUtils.copyProperties(instantLoanSurrogates, customerSurrogates);
        customer.setInstantLoanSurrogates(customerSurrogates);
        saveClassCustomer();
    }

    public BankAccount addBankAccount(BankAccount bankAccount, Long customerId){
        customer = getCustomer(customerId);
        bankAccount.setPerson(customer);
        BankAccount newBankAccount = bankAccountRepository.save(bankAccount);

        List<BankAccount> bankAccountList = customer.getAllBankAcounts();
        bankAccountList.add(bankAccount);
        customer.setAllBankAcounts(bankAccountList);
        customerRepository.save(customer);

        return newBankAccount;
    }

    public InstantLoan applyForInstantLoan(InstantLoan instantLoan, Long customerId){
        customer = getCustomer(customerId);
        instantLoan.setCustomer(customer);
        InstantLoan createdInstantLoan = instantLoanRepository.save(instantLoan);

        List<InstantLoan> allLoans = customer.getAllLoans();
        allLoans.add(instantLoan);
        customerRepository.save(customer);

        return createdInstantLoan;
    }

    public InstantLoan getLoan(Long customerId){
        customer = getCustomer(customerId);
        int lastIndex = customer.getAllLoans().size() - 1;
        return customer.getAllLoans().get(lastIndex);
    }

    public List<InstantLoan> getAllLoans(Long customerId){
        return getCustomer(customerId).getAllLoans();
    }

//    public ApprovedInstantLoan approveLoan(ApprovedInstantLoan approvedInstantLoan, Long loanId){
//        InstantLoan instantLoan = instantLoanRepository.findById(loanId).get();
//        approvedInstantLoan.setInstantLoan(instantLoan);
//        ApprovedInstantLoan newApprovedInstantLoan = approvedInstantLoanRepository.save(approvedInstantLoan);
//
//        instantLoan.setApprovedInstantLoan(newApprovedInstantLoan);
//        instantLoan.setApproval(Approval.APPROVED);
//        customer = instantLoan.getCustomer();
//        customer.setHaveCurrentLoan(Boolean.TRUE);
//        customerRepository.save(customer);
//        instantLoanRepository.save(instantLoan);
//
//        return newApprovedInstantLoan;
//    }
//
//    public void rejectLoan(Long loanId){
//        InstantLoan instantLoan = instantLoanRepository.findById(loanId).get();
//
//        instantLoan.setApproval(Approval.REJECTED);
//        customer = instantLoan.getCustomer();
//        customer.setHaveCurrentLoan(Boolean.FALSE);
//        customerRepository.save(customer);
//        instantLoanRepository.save(instantLoan);
//
//    }

    private void setClassCustomer(Long customerId){
        this.customer = getCustomer(customerId);
    }

    private Customer saveClassCustomer(){
        return customerRepository.save(this.customer);
    }

    public Customer getCustomer(Long customerId){
        return customerRepository.findById(customerId).get();
    }

    //public void extractElectricityBillAmount(Customer customer){};
}
