package com.tvscredit.tvscredit.services;

import com.tvscredit.tvscredit.config.BeanNotNullCopy;
import com.tvscredit.tvscredit.models.BankAccount;
import com.tvscredit.tvscredit.models.enums.Approval;
import com.tvscredit.tvscredit.models.loans.ApprovedInstantLoan;
import com.tvscredit.tvscredit.models.loans.InstantLoan;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.surrogates.Assets;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;
import com.tvscredit.tvscredit.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private InstantLoanRepository instantLoanRepository;
    private BeanNotNullCopy beanNotNullCopy;
    private ApprovedInstantLoanRepository approvedInstantLoanRepository;
    private InstantLoanSurrogatesRepository instantLoanSurrogatesRepository;
    private Customer customer;

    CustomerService(CustomerRepository customerRepository
                    ,BankAccountRepository bankAccountRepository
                    ,BeanNotNullCopy beanNotNullCopy
                    ,InstantLoanRepository instantLoanRepository
                    ,ApprovedInstantLoanRepository approvedInstantLoanRepository
                    ,InstantLoanSurrogatesRepository instantLoanSurrogatesRepository){
        this.customerRepository = customerRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.instantLoanRepository = instantLoanRepository;
        this.beanNotNullCopy = beanNotNullCopy;
        this.approvedInstantLoanRepository = approvedInstantLoanRepository;
        this.instantLoanSurrogatesRepository = instantLoanSurrogatesRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void updateElectricity(Long customerId, String url){
        setClassCustomer(customerId);
        customer.setElectricityBillImageUrl(url);
        //extractElectricityBillAmount(customer);
        saveClassCustomer();
    }

    public Customer getCustomerFromMobileNumber(String phoneNumber){
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    public void updateInstantLoanSurrogates(Long customerId, InstantLoanSurrogates instantLoanSurrogates){
        setClassCustomer(customerId);
        InstantLoanSurrogates customerSurrogates = customer.getInstantLoanSurrogates();

        if(customerSurrogates == null){
            customerSurrogates = instantLoanSurrogates;
            customerSurrogates.setCustomer(customer);
        }else{
            beanNotNullCopy.copyNonNullProperties(instantLoanSurrogates, customerSurrogates);
        }
        instantLoanSurrogatesRepository.save(customerSurrogates);
        customer.setInstantLoanSurrogates(customerSurrogates);
        saveClassCustomer();
    }

    public InstantLoanSurrogates getInstantLoanSurrogates(Long customerId){
        return instantLoanSurrogatesRepository.findByCustomer(getCustomer(customerId));
    }

    public BankAccount addBankAccount(BankAccount bankAccount, Long customerId){
        customer = getCustomer(customerId);
        bankAccount.setPerson(customer);
        BankAccount newBankAccount = bankAccountRepository.save(bankAccount);

        List<BankAccount> bankAccountList = customer.getAllBankAccounts();
        bankAccountList.add(bankAccount);
        customer.setAllBankAccounts(bankAccountList);
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

    public InstantLoan getInstantLoan(Long customerId){
        customer = getCustomer(customerId);
        int lastIndex = customer.getAllLoans().size() - 1;
        return customer.getAllLoans().get(lastIndex);
    }

    public List<InstantLoan> getAllInstantLoans(Long customerId){
        return getCustomer(customerId).getAllLoans();
    }

    private void setClassCustomer(Long customerId){
        this.customer = getCustomer(customerId);
    }

    private Customer saveClassCustomer(){
        return customerRepository.save(this.customer);
    }

    public Customer getCustomer(Long customerId){
        return customerRepository.findById(customerId).get();
    }

    public List<Customer> getAllCustomer(){
        return (List<Customer>) customerRepository.findAll();
    }

    //public void extractElectricityBillAmount(Customer customer){};

}
