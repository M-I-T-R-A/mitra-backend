package com.tvscredit.tvscredit.models.surrogates;

import com.tvscredit.tvscredit.models.person.Customer;
import com.tvscredit.tvscredit.models.shop.PurchasedItemBill;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class InstantLoanSurrogates extends BaseSurrogates{

    @Override
    public void setBills(List<PurchasedItemBill> bills) {
        for (PurchasedItemBill bill:bills){
            bill.setInstantLoanSurrogates(this);
        }
        super.setBills(bills);
    }

}
