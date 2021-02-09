package com.tvscredit.tvscredit.repository;

import com.tvscredit.tvscredit.models.shop.PurchasedItemStock;
import com.tvscredit.tvscredit.models.shop.Shop;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PurchasedItemStockRepository extends CrudRepository<PurchasedItemStock, Long> {
    public List<PurchasedItemStock> findAllByShop(Shop shop);
}
