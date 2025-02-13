package com.collectionlist.testpractise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupTest extends Base
{
    @Test(groups = {"sanity"})
    void loginbyEmail()
    {
        System.out.println("Login by Email");
    }
    @Test(groups = {"sanity"})
    void loginByFB(){
        System.out.println("Login by FB");
    }
    @Test(groups = {"sanity"})
    void loginByNumber(){
        System.out.println("Login by Number");
    }
}
