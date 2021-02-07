package com.tvscredit.tvscredit.services;

import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;
import com.tvscredit.tvscredit.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private Customer customer;

    CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateElectricity(Long customerId, String url){
        setClassCustomer(customerId);
        customer.setElectricityBillImageUrl(url);
        //extractElectricityBillAmount(customer);
        saveClassCustomer();
    }

    public void updateInstantLoanSurrogates(Long customerId, InstantLoanSurrogates instantLoanSurrogates){
        setClassCustomer(customerId);
        customer.setInstantLoanSurrogates(instantLoanSurrogates);
        saveClassCustomer();
    }

    private void setClassCustomer(Long customerId){
        this.customer = getCustomer(customerId);
    }

    private void saveClassCustomer(){
        customerRepository.save(this.customer);
    }

    public Customer getCustomer(Long customerId){
        return customerRepository.findById(customerId).get();
    }

    //public void extractElectricityBillAmount(Customer customer){};
}
