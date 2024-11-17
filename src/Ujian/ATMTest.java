package Ujian;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ATMTest {

    private ATM atm;

    
    @BeforeMethod
    public ATM setSaldoAwal(){
        atm = new ATM(1000);
        return atm;
    }

    
    @Test
    public void testLihatSaldo(){
        double actualResult = atm.lihatSaldo();
        double ExpectedResult = 1000;
        Assert.assertEquals(actualResult,ExpectedResult);
    }

    
    @Test
    public void testSetorUang(){
        atm.setorUang(10000);
        double actualResult = atm.lihatSaldo();
        double ExpectedResult = 11000;
        Assert.assertEquals(actualResult,ExpectedResult);
    }

    
    @Test
    public void testSetorUangNegatif(){
        try{
            atm.setorUang(0);
        }catch (Exception e){
            String actualResult = e.getMessage();
            String ExpectedResult = "Jumlah harus lebih besar dari 0";
            Assert.assertEquals(actualResult,ExpectedResult);
        }
    }

    
    @Test
    public void testTarikUang() {
        atm.tarikUang(500);
        double actualResult = atm.lihatSaldo();
        double ExpectedResult = 500;
        Assert.assertEquals(actualResult, ExpectedResult);
    }

    
    @Test
    public void testTarikUangLebihDariSaldo(){
        try{
            atm.tarikUang(200000000);
        }catch (Exception e){
            String actualResult = e.getMessage();
            String ExpectedResult = "Saldo tidak mencukupi";
            Assert.assertEquals(actualResult,ExpectedResult);
        }
    }


    
    @Test
    public void testTarikUangNegatif(){
        try{
            atm.tarikUang(-20000);
        }catch (Exception e){
            String actualResult = e.getMessage();
            String ExpectedResult = "Jumlah harus lebih besar dari 0";
            Assert.assertEquals(actualResult,ExpectedResult);
        }
    }
}