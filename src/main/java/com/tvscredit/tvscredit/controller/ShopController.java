package com.tvscredit.tvscredit.controller;

import com.tvscredit.tvscredit.dto.shop.*;
import com.tvscredit.tvscredit.models.shop.*;
import com.tvscredit.tvscredit.services.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity.BodyBuilder updateWareHouseInventoryOfShop(@PathVariable Long id, @RequestBody List<StockOfItems> stockOfItems){
        shopService.updateInventory(stockOfItems, id);
        return ResponseEntity.ok();
    }

    @PostMapping("/purchase")
    public ResponseEntity.BodyBuilder purchaseStock(@RequestBody PurchaseOrderDTO purchaseOrderDTO){
        PurchasedItemStockDTO purchasedItemStockDTO = purchaseOrderDTO.getPurchasedItemStockDTO();
        PurchasedItemStock purchasedItemStock = convertToEntity(purchasedItemStockDTO);
        PurchasedItemBill purchasedItemBill = convertToEntity(purchaseOrderDTO.getPurchasedItemBillDTO());
        purchasedItemStock.setStockOfItemsUsingList(purchasedItemStockDTO.getStockOfItems());
        shopService.purchaseStocks(purchasedItemStock, purchasedItemBill, purchaseOrderDTO.getCustomerId());
        return ResponseEntity.ok();
    }

    @PostMapping("/sell")
    public ResponseEntity.BodyBuilder sellStock(@RequestBody SoldItemsDTO soldItemsDTO){
        SoldItems soldItems = convertToEntity(soldItemsDTO);
        soldItems.setSoldItemsUsingList(soldItemsDTO.getSoldItems());
        shopService.soldStocksToCustomer(soldItems, soldItemsDTO.getCustomerId());
        return ResponseEntity.ok();
    }

    @GetMapping("/product/info/name")
    public ResponseEntity<List<StockOfItems>> getProductDetailsByName(@RequestParam Long customerId, @RequestParam String name){
        return ResponseEntity.ok(shopService.getStockInfoOfShopByProductName(customerId, name));
    }

    @GetMapping("/product/info/category")
    public ResponseEntity<List<StockOfItems>> getProductDetailsByCategory(@RequestParam Long customerId, @RequestParam String category){
        return ResponseEntity.ok(shopService.getStockInfoOfShopByCategory(customerId, category));
    }

    private Shop convertToEntity(ShopDTO dto){
        return modelMapper.map(dto, Shop.class);
    }

    private PurchasedItemStock convertToEntity(PurchasedItemStockDTO dto){
        return modelMapper.map(dto, PurchasedItemStock.class);
    }

    private PurchasedItemBill convertToEntity(PurchasedItemBillDTO dto){
        return modelMapper.map(dto, PurchasedItemBill.class);
    }

    private SoldItems convertToEntity(SoldItemsDTO dto){
        return modelMapper.map(dto, SoldItems.class);
    }

    private ShopDTO convertToDto1(Shop entity){
        return modelMapper.map(entity, ShopDTO.class);
    }
}
