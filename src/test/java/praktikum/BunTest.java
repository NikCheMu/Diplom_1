package praktikum;

import org.junit.Assert;
import org.junit.Test;


public class BunTest {


    @Test
    public void bunGetNameReturnsBunName() {
        String bunName = Utils.getRandomString(5);
        float bunPrice = Utils.getRandomPrice((float) 0, 1000.00F);
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void bunGetPriceReturnsBunPrice() {
        String bunName = Utils.getRandomString(5);
        float bunPrice = Utils.getRandomPrice((float) 0, 1000.00F);
        float zeroDelta = 0.00F;
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), zeroDelta);
    }


}
