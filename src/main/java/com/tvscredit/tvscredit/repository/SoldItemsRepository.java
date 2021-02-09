package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.shop.Shop;
import com.tvscredit.tvscredit.models.shop.SoldItems;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SoldItemsRepository extends CrudRepository<SoldItems, Long> {
    public List<SoldItems> findAllByShop(Shop shop);
}
