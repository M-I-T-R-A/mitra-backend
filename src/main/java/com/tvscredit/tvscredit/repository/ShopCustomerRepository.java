package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.person.ShopCustomer;
import com.tvscredit.tvscredit.models.shop.Shop;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ShopCustomerRepository extends CrudRepository<ShopCustomer, Long> {
    public ShopCustomer findByPhoneNumber(String phoneNumber);
    public List<ShopCustomer> findAllByShop(Shop shop);
}
