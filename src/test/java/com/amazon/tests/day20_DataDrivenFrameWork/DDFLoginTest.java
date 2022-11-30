package com.amazon.tests.day20_DataDrivenFrameWork;

import com.amazon.pages.DashboardPage;
import com.amazon.pages.LoginPages;
import com.amazon.tests.TestBase;
import com.amazon.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){

        // ExcelUtil classından bir object oluşturacağız
        // iki parametre gireyoruz; file path and sayfa(sheet) adı

        ExcelUtil qaTeam3= new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");

        String[][] dataArray = qaTeam3.getDataArrayWithoutFirstRow(); // 1. satır hariç dedik. your name, password gibi titleler

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void loginTestWithDDF(String email, String password, String YourName){

        LoginPages loginPages = new LoginPages();
        DashboardPage dashboardPage = new DashboardPage();

        loginPages.loginWithParameter(email,password);
        String actualName = dashboardPage.userNames(YourName);
        String exceptedName = YourName;

        Assert.assertEquals(actualName,exceptedName);

    }






}
