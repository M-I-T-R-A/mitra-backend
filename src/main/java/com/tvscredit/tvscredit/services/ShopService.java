package com.tvscredit.tvscredit.services;

import com.tvscredit.tvscredit.config.BeanNotNullCopy;
import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.person.ShopCustomer;
import com.tvscredit.tvscredit.models.shop.*;
import com.tvscredit.tvscredit.models.surrogates.InstantLoanSurrogates;
import com.tvscredit.tvscredit.repository.*;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    private CustomerService customerService;
    private ShopRepository shopRepository;
    private SoldItemsRepository soldItemsRepository;
    private ShopCustomerRepository shopCustomerRepository;
    private BeanNotNullCopy beanNotNullCopy;
    private PurchasedItemBillRepository purchasedItemBillRepository;
    private PurchasedItemStockRepository purchasedItemStockRepository;

    public ShopService(CustomerService customerService,
                       ShopCustomerRepository shopCustomerRepository,
                       SoldItemsRepository soldItemsRepository,
                       BeanNotNullCopy beanNotNullCopy,
                       PurchasedItemBillRepository purchasedItemBillRepository,
                       ShopRepository shopRepository,
                       PurchasedItemStockRepository purchasedItemStockRepository) {
        this.customerService = customerService;
        this.soldItemsRepository = soldItemsRepository;
        this.shopRepository = shopRepository;
        this.beanNotNullCopy = beanNotNullCopy;
        this.shopCustomerRepository = shopCustomerRepository;
        this.purchasedItemBillRepository = purchasedItemBillRepository;
        this.purchasedItemStockRepository = purchasedItemStockRepository;
    }

    public Shop addShop(Shop shop, Long customerId){
        Customer customer =customerService.getCustomer(customerId);
        shop.setOwner(customer);
        WareHouse wareHouse = shop.getWareHouse();
        wareHouse.setItemsSet(new HashSet<StockOfItems>());
        shop.setWareHouse(wareHouse);
        return shopRepository.save(shop);
    }

    public Shop updateShop(Shop shop, Long customerId){
        Shop ownerShop = getShopOfCustomer(customerId);
        WareHouse wareHouse = ownerShop.getWareHouse();
        beanNotNullCopy.copyNonNullProperties(shop, ownerShop);
        ownerShop.setOwner(customerService.getCustomer(customerId));
        ownerShop.setWareHouse(wareHouse);
        return shopRepository.save(shop);
    }

    public Shop getShopOfCustomer(Long customerId){
        return shopRepository.findByOwner(customerService.getCustomer(customerId));
    }

    public void updateInventory(StockOfItems stockOfItems, Long customerId){
        Shop shop = getShopOfCustomer(customerId);
        WareHouse wareHouse = shop.getWareHouse();
        Set<StockOfItems> itemsSet = wareHouse.getItemsSet();

        StockOfItems wareHouseItem = wareHouse.isItemPresent(stockOfItems);
        if(wareHouseItem != null){
            itemsSet.remove(wareHouseItem);
        }
        itemsSet.add(stockOfItems);

        wareHouse.setItemsSet(itemsSet);
        shop.setWareHouse(wareHouse);

        shopRepository.save(shop);
    }

    //1 for buy and 2 for sell
    public void updateStocksInWareHouse(StockOfItems stockOfItems, Long customerId, int buySell){
        Shop shop = getShopOfCustomer(customerId);
        WareHouse wareHouse = shop.getWareHouse();

        StockOfItems wareHouseItem = wareHouse.isItemPresent(stockOfItems);
        Set<StockOfItems> itemsSet = wareHouse.getItemsSet();

        if(wareHouseItem != null){
            itemsSet.remove(wareHouseItem);
            if(buySell == 1){
                wareHouseItem.setQuantity(
                        wareHouseItem.getQuantity()+stockOfItems.getQuantity()
                );
            }else{
                wareHouseItem.setQuantity(
                        wareHouseItem.getQuantity()-stockOfItems.getQuantity()
                );
            }
            itemsSet.add(wareHouseItem);
        }else if(buySell == 1){
            itemsSet.add(stockOfItems);
        }

        wareHouse.setItemsSet(itemsSet);
        shop.setWareHouse(wareHouse);

        shopRepository.save(shop);
    }

    public void purchaseStocks(PurchasedItemStock purchasedItemStock, PurchasedItemBill purchasedItemBill, Long customerId){
        Shop shop = getShopOfCustomer(customerId);

        purchasedItemStock.setShop(shop);
        purchasedItemBill.setPurchasedItemStock(purchasedItemStock);
        purchasedItemStock.setPurchasedItemBill(purchasedItemBill);

        InstantLoanSurrogates instantLoanSurrogates = customerService.getInstantLoanSurrogates(customerId);
        List<PurchasedItemBill> billList = instantLoanSurrogates.getBills();
        billList.add(purchasedItemBill);
        instantLoanSurrogates.setBills(billList);
        customerService.updateInstantLoanSurrogates(customerId, instantLoanSurrogates);

        for(StockOfItems items:purchasedItemStock.getStockOfItems()){
            updateStocksInWareHouse(items, customerId, 1);
        }
        purchasedItemBillRepository.save(purchasedItemBill);
    }

    public void soldStocksToCustomer(SoldItems soldItems, Long customerId){

        soldItems.setShop(getShopOfCustomer(customerId));

        Double credit = 0.0, total = 0.0;

        for(StockOfItems itemsDetail:soldItems.getSoldItems()){
            updateStocksInWareHouse((StockOfItems) itemsDetail,
                    soldItems.getShop().getOwner().getId(),
                    2);
            Double currentTotal = itemsDetail.getPricePerUnit() * itemsDetail.getQuantity();
            itemsDetail.setTotalValue(currentTotal);
            total = total + itemsDetail.getTotalValue();
        }

        credit = total - soldItems.getAmountPaid();

        ShopCustomer shopCustomer = shopCustomerRepository.findByPhoneNumber(
                soldItems.getShopCustomer().getPhoneNumber());

        if(shopCustomer != null){
            shopCustomer.setCreditAmount(
                    shopCustomer.getCreditAmount() + credit
            );
            soldItems.setShopCustomer(shopCustomer);
        } else {
            ShopCustomer customer = soldItems.getShopCustomer();
            customer.setCreditAmount(credit);
            soldItems.setShopCustomer(customer);
        }

        soldItemsRepository.save(soldItems);
    }

    public List<SoldItems> getAllSoldItems(Long customerId){
        Shop shop = getShopOfCustomer(customerId);
        return soldItemsRepository.findAllByShop(shop);
    }

    public List<PurchasedItemStock> getAllOrders(Long customerId){
        Shop shop = getShopOfCustomer(customerId);
        return purchasedItemStockRepository.findAllByShop(shop);
    }

    public List<Double> getCreditScoresOfShopCustomers(Long customerId){
        Shop shop = getShopOfCustomer(customerId);
        List<ShopCustomer> shopCustomers = shopCustomerRepository.findAllByShop(shop);

        return shopCustomers.stream()
                .map(shopCustomer -> shopCustomer.getCreditAmount())
                .collect(Collectors.toList());
    }

    public List<StockOfItems> getStockInfoOfShopByProductName(Long customerId, String productName){
        Shop shop = getShopOfCustomer(customerId);
        WareHouse wareHouse = shop.getWareHouse();

        List<StockOfItems> stockOfItemsList = new ArrayList<>();

        for(StockOfItems stockOfItems:wareHouse.getItemsSet()){
            if(FuzzySearch.partialRatio(productName, stockOfItems.getName()) >= 70){
                stockOfItemsList.add(stockOfItems);
            }
        }
        return stockOfItemsList;
    }

    public List<StockOfItems> getStockInfoOfShopByCategory(Long customerId, String category){
        Shop shop = getShopOfCustomer(customerId);
        WareHouse wareHouse = shop.getWareHouse();

        List<StockOfItems> stockOfItemsList = new ArrayList<>();

        for(StockOfItems stockOfItems:wareHouse.getItemsSet()){
            if(stockOfItems.getCategory().equals(category)){
                stockOfItemsList.add(stockOfItems);
            }
        }
        return stockOfItemsList;
    }

}
