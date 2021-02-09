package com.tvscredit.tvscredit.controller;

import com.tvscredit.tvscredit.dto.shop.PurchaseOrderDTO;
import com.tvscredit.tvscredit.dto.shop.PurchasedItemBillDTO;
import com.tvscredit.tvscredit.dto.shop.PurchasedItemStockDTO;
import com.tvscredit.tvscredit.dto.shop.ShopDTO;
import com.tvscredit.tvscredit.models.shop.PurchasedItemBill;
import com.tvscredit.tvscredit.models.shop.PurchasedItemStock;
import com.tvscredit.tvscredit.models.shop.Shop;
import com.tvscredit.tvscredit.models.shop.StockOfItems;
import com.tvscredit.tvscredit.services.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private ShopService shopService;
    private ModelMapper modelMapper;

    public ShopController(ShopService shopService,
                          ModelMapper modelMapper) {
        this.shopService = shopService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/{id}")
    public ResponseEntity<ShopDTO> addShop(@PathVariable Long id, @RequestBody ShopDTO shopDTO){
        return ResponseEntity.ok(convertToDto1(shopService.addShop(convertToEntity(shopDTO), id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getShop(@PathVariable Long id){
        return ResponseEntity.ok(convertToDto1(shopService.getShopOfCustomer(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopDTO> updateShop(@PathVariable Long id, @RequestBody ShopDTO shopDTO){
        return ResponseEntity.ok(convertToDto1(shopService.updateShop(convertToEntity(shopDTO), id)));
    }

    @PutMapping("/warehouse/item/{id}")
    public ResponseEntity.BodyBuilder updateWareHouseInventoryOfShop(@PathVariable Long id, @RequestBody StockOfItems stockOfItems){
        shopService.updateInventory(stockOfItems, id);
        return ResponseEntity.ok();
    }

    @PostMapping("/purchase")
    public ResponseEntity.BodyBuilder purchaseStock(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        PurchasedItemStock purchasedItemStock = convertToEntity(purchaseOrderDTO.getPurchasedItemStockDTO());
        PurchasedItemBill purchasedItemBill = convertToEntity(purchaseOrderDTO.getPurchasedItemBillDTO());
        purchasedItemStock.setStockOfItems(new HashSet<>(purchaseOrderDTO.getPurchasedItemStockDTO().getStockOfItems()));
        shopService.purchaseStocks(purchasedItemStock, purchasedItemBill, purchaseOrderDTO.getCustomerId());
        return ResponseEntity.ok();
    }

    @PostMapping("/sell")

    private Shop convertToEntity(ShopDTO dto){
        return modelMapper.map(dto, Shop.class);
    }

    private PurchasedItemStock convertToEntity(PurchasedItemStockDTO dto){
        return modelMapper.map(dto, PurchasedItemStock.class);
    }

    private PurchasedItemBill convertToEntity(PurchasedItemBillDTO dto){
        return modelMapper.map(dto, PurchasedItemBill.class);
    }

    private ShopDTO convertToDto1(Shop entity){
        return modelMapper.map(entity, ShopDTO.class);
    }
}
