package com.example.calculatortext;
import org.junit.Test;
import org.w3c.dom.Text;

import static org.junit.Assert.assertEquals;

public class TextCalculatorTest {
    @Test
    public void countWordsTest(){
        TextCalculator calculator = new TextCalculator();

        int result = calculator.countWords("Sveikas, as esu Matas");
        assertEquals(4, result);
    }
    @Test
    public void countSentencesTest(){
        TextCalculator calculator = new TextCalculator();

        int result = calculator.countSentences("Sveikas. As esu Matas.");
        assertEquals(2, result);
    }
    @Test
    public void countPunctuationTest(){
        TextCalculator calculator = new TextCalculator();

        int result = calculator.countPunctuation("Sveikas, as esu Matas. HA!");
        assertEquals(7, result);
    }
    @Test
    public void countNumbersTest(){
        TextCalculator calculator = new TextCalculator();

        int result = calculator.countNumbers("Sveiki, man yra 20 metu! 2 0 ");
        assertEquals(3, result);
    }
    @Test
    public void countWordsEmptyTextTest(){
        TextCalculator calculator = new TextCalculator();

        int result = calculator.countWords("");
        assertEquals(0, result);
    }
    @Test
    public void countWordsLithuanianTest() {
        TextCalculator calculator = new TextCalculator();

        int result = calculator.countWords("Ačiū Žąsinas Ąžuolas");
        assertEquals(3, result);
    }
}
