package pl.krakow.uek.pp5.creditcard.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditCardTest {

    public static final int LIMIT = 2000;

    @Test
    public void itAllowsAssigningCreditToCard(){

        CreditCard card = new CreditCard("1234443");

        card.AssignLimit(BigDecimal.valueOf(LIMIT));
        Assert.assertTrue(card.getLiit().equals(BigDecimal.valueOf(LIMIT)));

    }



     @Test

     public void creditBelowGeneralLimitNotPossible(){

        //arrange
         //act
         CreditCard card = new CreditCard("1234443");
         //assert
         try{

             card.AssignLimit(BigDecimal.valueOf(50));
             Assert.fail("exception should be thrown")
;         }catch (CreditbelowLimitException e) {
             Assert.assertTrue(true);
         }
     }
    @Test
    public void withdrawFromCard(){
        CreditCard card1 = new CreditCard("1234-5678");
        CreditCard card2 = new CreditCard("1234-5679");
        card1.AssignLimit(BigDecimal.valueOf(1000));
        card2.AssignLimit(BigDecimal.valueOf(1000));
        card1.withdraw(BigDecimal.valueOf(500));
        card2.withdraw(BigDecimal.valueOf(100));
        Assert.assertEquals(BigDecimal.valueOf(500),card1.getCurrentBalance());
        Assert.assertEquals(BigDecimal.valueOf(900),card2.getCurrentBalance());

    }

    @Test(expected = NotEnoughMoneyException.class)

    public void denyWithdrawBelowBalance(){

        CreditCard card = new CreditCard("1234-5678");
        card.AssignLimit(BigDecimal.valueOf(1000));

        card.withdraw(BigDecimal.valueOf(600));
        card.withdraw(BigDecimal.valueOf(600));



    }

}
