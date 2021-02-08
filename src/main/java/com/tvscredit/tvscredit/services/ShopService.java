package com.tvscredit.tvscredit.services;

import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.shop.Shop;
import com.tvscredit.tvscredit.repository.ShopRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private CustomerService customerService;
    private ShopRepository shopRepository;

    public ShopService(CustomerService customerService, ShopRepository shopRepository) {
        this.customerService = customerService;
        this.shopRepository = shopRepository;
    }

    public Shop addShop(Shop shop, Long customerId){
        Customer customer =customerService.getCustomer(customerId);
        shop.setOwner(customer);
        return shopRepository.save(shop);
    }
}
