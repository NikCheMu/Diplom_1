package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    @Parameterized.Parameter(1)
    public String name;

    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameter
    public IngredientType type;

    @Parameterized.Parameters
    public static Object[][] data(){
        String randomName = Utils.getRandomString(10);
        float randomPrice = Utils.getRandomPrice((float) 0, 1000.00F);
        return new Object[][]{
                {IngredientType.FILLING,randomName,randomPrice},
                {IngredientType.SAUCE,randomName,randomPrice}

        };
    }


    @Test
    public void ingridientGetTypeReturnsIngridientType(){
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(type,ingredient.getType());

    }

    @Test
    public void ingridientGetNameReturnsIngridientName(){
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(name,ingredient.getName());
    }

    @Test
    public void ingridientGetPriceReturnsIngridientPrice(){
        Ingredient ingredient = new Ingredient(type,name,price);
        Assert.assertEquals(price,ingredient.getPrice(),0.0);
    }

}
