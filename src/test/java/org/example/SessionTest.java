package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

class SessionTest
{
    @Test
    public void how_mocks_work(){
        // arrange
        ArrayList<String> names = mock(ArrayList.class);
        names.add("Andrew");
        int expectedResult = 3;
        when(names.size()).thenReturn(3);

        // act
        int actualResult = names.size();

        // assert
        assertEquals(expectedResult, actualResult);

        verify(names, times(1)).size();
        verify(names, times(1)).add("Andrew");
    }

    interface IRegister{
        String getDelegate(int idx);

        int getNumberRegistered();
    }

    class Register implements IRegister{
        private ArrayList<String> delegates = new ArrayList<>(); // simulates a DB table

        public Register(){
            delegates.add("Andrew");
            delegates.add("Andje");
            delegates.add("Andy");
        }

        public String getDelegate(int idx){
            return delegates.get(idx-1);
        }

        public int getNumberRegistered(){
            return delegates.size();
        }
    }

    class Course{
        private IRegister reg;

        public Course( IRegister register ){
            reg = register;
        }

        public String getLastPersonRegistered(){
            String result = reg.getDelegate(reg.getNumberRegistered());

            return result;
        }
    }

    @Test
    public void verify_lastName_returned_is_lastName_in_register(){
        // arrange
        IRegister reg =  mock(IRegister.class);
        Course cut = new Course(reg);
        String expectedResult = "Andy";
        when(reg.getDelegate(anyInt())).thenReturn("Andy");

        // act
        String actualResult = cut.getLastPersonRegistered();

        //assert
        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void verify_if_basket_has_correct_items()
    {
        // arrange
        Basket basket = new Basket();
        Item item1 = new Item("Bananas", 6, 0.19); // 1.14
        Item item2 = new Item("Avocado", 3, 0.89); // 2.67
        Item item3 = new Item("Spinach", 1, 1.27); // 1.27
        basket.addItem(item1);
        basket.addItem(item2);
        basket.addItem(item3);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedResult = "";
        try
        {
            expectedResult = objectMapper.writeValueAsString(basket);
        } catch (JsonProcessingException e)
        {
            e.printStackTrace();
        }
        IDataStore dataStore = mock(IDataStore.class);
        when(dataStore.getItemsInDB()).thenReturn(basket);
        Session cut = new Session(dataStore);

        // act
        String actualResult = cut.getItems();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verify_get_total_price_returns_correct_total(){
        // arrange
        IDataStore dataStore = mock(IDataStore.class);
        Session cut = new Session(dataStore);
        Basket basket = mock(Basket.class);

        String expectedResult = "5.08";
        when(basket.getTotal()).thenReturn(Double.valueOf(expectedResult));
        when(dataStore.getItemsInDB()).thenReturn(basket);

        // act
        String actualResult = cut.getTotalPrice();

        // assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verify_last_item_is_returned(){
        // arrange
        IDataStore dataStore = mock(IDataStore.class);
        Session cut = new Session(dataStore);
        Basket basket = mock(Basket.class);
        Item item = new Item("pencil", 1, 1.5);
        String expectedResult = "{\"description\":\"pencil\",\"quantity\":1,\"price\":1.5}";

        when(basket.getLastItem()).thenReturn(item);
        when(dataStore.getItemsInDB()).thenReturn(basket);

        // act
        String actualResult = cut.getTheLastItemSold();

        // assert
        assertEquals(expectedResult, actualResult);
    }


}
