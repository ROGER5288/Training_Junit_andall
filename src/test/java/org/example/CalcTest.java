package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTest {
//    @ParameterizedTest
//    @CsvSource(
//            {
////                    "10,20,30",
////                    "5,7,12",
////                    "-10.5,10.5,0"
//
//            }
//    )
//
////    @Test
//    void addInvalidStringTest(){
//        Calc calc = new Calc();
//        //double result = calc.add(10,20);
//        //Assertions.assertEquals(30, result);
//        //assertEquals(30, result);
//
//        assertThrows(IllegalArgumentException.class,
//                () -> calc.add("11", "25"));
//    }
@ParameterizedTest
@CsvSource({
        "11, 25",
        "10.5,12.6",
        "'One','Two'",
        "abc, 10",
        "5, xyz",
        "'', 10",
        "'   ', 5",
        "abc, 10",
        "5, xyz",
        "hello, world"
})
void addInvalidString(String a, String b) {

    Calc calc = new Calc();

    Assertions.assertThrows(IllegalArgumentException.class,
            () -> calc.add(a, b));
}

}
