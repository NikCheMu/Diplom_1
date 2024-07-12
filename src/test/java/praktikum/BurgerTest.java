package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient onion;
    @Mock
    Ingredient meat;
    @Mock
    Ingredient sauce;
    @Mock
    Bun bun;

    @Before
    public void setUp(){
        Mockito.when(onion.getName()).thenReturn("onion");
        Mockito.when(onion.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(onion.getPrice()).thenReturn(1.00F);

        Mockito.when(meat.getName()).thenReturn("meat");
        Mockito.when(meat.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(meat.getPrice()).thenReturn(1.00F);

        Mockito.when(sauce.getName()).thenReturn("sauce");
        Mockito.when(sauce.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(sauce.getPrice()).thenReturn(1.00F);

        Mockito.when(bun.getName()).thenReturn("Bulochka");
        Mockito.when(bun.getPrice()).thenReturn(2.00F);
    }

    @Test
    public void defaultIngredientListIsEmpty(){
        Burger burger = new Burger();
        Assert.assertEquals(new ArrayList<>(),burger.ingredients);
    }


    @Test
    public void addIngredientsToBurger(){
        Burger burger = new Burger();
        burger.addIngredient(onion);
        burger.addIngredient(meat);
        burger.addIngredient(sauce);
        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(onion);
        expectedIngredients.add(meat);
        expectedIngredients.add(sauce);

        Assert.assertEquals(expectedIngredients,burger.ingredients);
    }

    @Test
    public void removeIngredientsFromBurger(){
        Burger burger = new Burger();

        burger.addIngredient(onion);
        burger.addIngredient(meat);
        burger.addIngredient(sauce);

        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(onion);
        expectedIngredients.add(meat);

        burger.removeIngredient(2);

        Assert.assertEquals(expectedIngredients,burger.ingredients);
    }

    @Test
    public void changeIngredientsOrder(){
        Burger burger = new Burger();

        burger.addIngredient(onion);
        burger.addIngredient(meat);
        burger.addIngredient(sauce);

        List<Ingredient> expectedIngredients = new ArrayList<>();
        expectedIngredients.add(sauce);
        expectedIngredients.add(onion);
        expectedIngredients.add(meat);

        burger.moveIngredient(2,0);

        Assert.assertEquals(expectedIngredients,burger.ingredients);
    }

    @Test
    public void settingBuns(){
        Burger burger = new Burger();

        burger.setBuns(bun);

        Assert.assertEquals(bun,burger.bun);
    }

    @Test
    public void getPriceReturnsSumOfBunPriceAndIngredientsPrice(){

        Burger burger = new Burger();

        burger.addIngredient(onion);
        burger.addIngredient(meat);
        burger.addIngredient(sauce);
        burger.setBuns(bun);

        float actualPrice = burger.getPrice();

        Mockito.verify(meat,Mockito.times(1)).getPrice();
        Mockito.verify(onion,Mockito.times(1)).getPrice();
        Mockito.verify(sauce,Mockito.times(1)).getPrice();
        Assert.assertEquals(7.00F,actualPrice,0.00);


    }

    @Test
    public void getReceiptReturnsIngredientsAndBun(){
        Burger burger = new Burger();

        burger.addIngredient(onion);
        burger.addIngredient(meat);
        burger.addIngredient(sauce);
        burger.setBuns(bun);

        String actualReceipt = burger.getReceipt();

        Mockito.verify(meat,Mockito.times(1)).getPrice();
        Mockito.verify(onion,Mockito.times(1)).getPrice();
        Mockito.verify(sauce,Mockito.times(1)).getPrice();

        Mockito.verify(bun,Mockito.times(1)).getPrice();
        Mockito.verify(bun,Mockito.times(2)).getName();

        Mockito.verify(meat,Mockito.times(1)).getName();
        Mockito.verify(onion,Mockito.times(1)).getName();
        Mockito.verify(sauce,Mockito.times(1)).getName();

        Mockito.verify(meat,Mockito.times(1)).getType();
        Mockito.verify(onion,Mockito.times(1)).getType();
        Mockito.verify(sauce,Mockito.times(1)).getType();

        String expectedReceipt = "(==== "+bun.getName()+" ====)\n"
                +"= "+onion.getType().toString().toLowerCase()+" "+onion.getName()+" =\n"
                +"= "+meat.getType().toString().toLowerCase()+" "+meat.getName()+" =\n"
                +"= "+sauce.getType().toString().toLowerCase()+" "+sauce.getName()+" =\n"
                +"(==== "+bun.getName()+" ====)\n"
                +String.format("%nPrice: %f%n", onion.getPrice()+meat.getPrice()+sauce.getPrice()+bun.getPrice()*2);


        Assert.assertEquals(expectedReceipt,actualReceipt);

    }
}
