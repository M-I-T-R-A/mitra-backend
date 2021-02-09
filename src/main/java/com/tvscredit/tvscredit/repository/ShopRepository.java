package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.shop.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
    public Shop findByOwner(Customer owner);
}
