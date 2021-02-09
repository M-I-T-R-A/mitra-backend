package com.tvscredit.tvscredit.dto.shop;


public class PurchaseOrderDTO {

    private Long customerId;
    private PurchasedItemBillDTO purchasedItemBillDTO;
    private PurchasedItemStockDTO purchasedItemStockDTO;

    public PurchasedItemBillDTO getPurchasedItemBillDTO() {
        return purchasedItemBillDTO;
    }

    public void setPurchasedItemBillDTO(PurchasedItemBillDTO purchasedItemBillDTO) {
        this.purchasedItemBillDTO = purchasedItemBillDTO;
    }

    public PurchasedItemStockDTO getPurchasedItemStockDTO() {
        return purchasedItemStockDTO;
    }

    public void setPurchasedItemStockDTO(PurchasedItemStockDTO purchasedItemStockDTO) {
        this.purchasedItemStockDTO = purchasedItemStockDTO;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
