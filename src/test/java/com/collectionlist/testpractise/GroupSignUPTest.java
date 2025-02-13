package com.collectionlist.testpractise;

import org.testng.annotations.Test;

public class GroupSignUPTest extends Base
{
    @Test(groups = "regression")
    public void SignupByEmail() {
        System.out.print("Signup by Email");
    }
    @Test(groups = "regression")
    public void SignupByphone() {
        System.out.print("Signup by Phone");
    }
    @Test(groups = "regression")
    public void SignupByFb() {
        System.out.print("Signup by FB");
    }
}
