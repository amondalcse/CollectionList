package com.collectionlist.testpractise;

import org.testng.annotations.Test;

public class GroupPaymentTest extends Base
{
    @Test(groups = {"sanity","regression"})
    public void PaymentInRs(){
        System.out.println("Payment for rs");
    }
    @Test(groups = {"sanity","regression"})
    public void PaymentInDollar(){
        System.out.println("Payment for Dollar");
    }
}
