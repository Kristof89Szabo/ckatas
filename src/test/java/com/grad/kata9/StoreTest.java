package com.grad.kata9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StoreTest {

    /*

    def test_totals
    assert_equal(  0, price(""))
    assert_equal( 50, price("A"))
    assert_equal( 80, price("AB"))
    assert_equal(115, price("CDBA"))

    assert_equal(100, price("AA"))
    assert_equal(130, price("AAA"))
    assert_equal(180, price("AAAA"))
    assert_equal(230, price("AAAAA"))
    assert_equal(260, price("AAAAAA"))

    assert_equal(160, price("AAAB"))
    assert_equal(175, price("AAABB"))
    assert_equal(190, price("AAABBD"))
    assert_equal(190, price("DABABA"))
  end

  def test_incremental
    co = CheckOut.new(RULES)
    assert_equal(  0, co.total)
    co.scan("A");  assert_equal( 50, co.total)
    co.scan("B");  assert_equal( 80, co.total)
    co.scan("A");  assert_equal(130, co.total)
    co.scan("A");  assert_equal(160, co.total)
    co.scan("B");  assert_equal(175, co.total)
     */

    Map<String, Integer> testBasket;

    @BeforeEach
    void init() {
        testBasket = new HashMap<>();
    }


    @Test
    @DisplayName("Add to basket")
    void test_addToBasket() {
        //given

        //when
        Store.addProduct(testBasket, "A");

        //then
        assertTrue(testBasket.containsKey("A"));
    }

    @Test
    @DisplayName("Calculate empty basket")
    void test_calculateEmptyBasket() {
        //given

        //when

        //then
        assertEquals(0, Store.calculateTotalPrice(testBasket));
    }

    @Nested
    class NoSpecialPrices {

        @Test
        @DisplayName("Calculate one product basket")
        void test_calculateOneProductBasket() {
            //given

            //when
            Store.addProduct(testBasket, "A");
            //then
            assertEquals(50, Store.calculateTotalPrice(testBasket));
        }

        @Test
        @DisplayName("Calculate two product basket")
        void test_calculateTwoProductBasket() {
            //given

            //when
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "B");
            //then
            assertEquals(80, Store.calculateTotalPrice(testBasket));
        }


        @Test
        @DisplayName("Calculate four product basket")
        void test_calculateFourProductBasket() {
            //given

            //when
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "B");
            Store.addProduct(testBasket, "C");
            Store.addProduct(testBasket, "D");
            //then
            assertEquals(115, Store.calculateTotalPrice(testBasket));
        }
    }


    @Nested
    class WithSpecialPrices {

        @Test
        @DisplayName("Calculate two product basket")
        void test_calculateTwoProductBasket() {
            //given

            //when
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");

            //then
            assertEquals(100, Store.calculateTotalPrice(testBasket));
        }

        @Test
        @DisplayName("Calculate three product basket")
        void test_calculateThreeProductBasket() {
            //given

            //when
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");

            //then
            assertEquals(130, Store.calculateTotalPrice(testBasket));
        }

        @Test
        @DisplayName("Calculate four product basket")
        void test_calculateFourProductBasket() {
            //given

            //when
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");

            //then
            assertEquals(180, Store.calculateTotalPrice(testBasket));
        }

        @Test
        @DisplayName("Calculate five product basket")
        void test_calculateFiveProductBasket() {
            //given

            //when
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "A");
            Store.addProduct(testBasket, "B");
            Store.addProduct(testBasket, "B");

            //then
            assertEquals(225, Store.calculateTotalPrice(testBasket));
        }


    }


}
