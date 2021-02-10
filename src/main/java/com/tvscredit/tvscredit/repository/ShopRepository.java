package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.shop.Shop;
import com.tvscredit.tvscredit.models.shop.StockOfItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ShopRepository extends CrudRepository<Shop, Long> {
    public Shop findByOwner(Customer owner);
}
