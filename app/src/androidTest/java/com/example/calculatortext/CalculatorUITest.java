package com.example.calculatortext;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.Espresso.onData;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class CalculatorUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void countSentencesUITest(){
        onView(withId(R.id.editTextInput))
                .perform(typeText("Labas, as esu Matas. Hihi"), closeSoftKeyboard());
        onView(withId(R.id.buttonCalculate))
                .perform(click());
        onView(withId(R.id.textViewResult))
                .check(matches(withText("Rezultatas: 2")));
    }
    @Test
    public void countWordsUITest(){
        onView(withId(R.id.editTextInput))
                .perform(typeText("Sveikas as esu Matas"), closeSoftKeyboard());
        onView(withId(R.id.spinnerMetric))
                .perform(click());
        onData(is("Žodžiai"))
                .perform(click());
        onView(withId(R.id.buttonCalculate))
                .perform(click());
        onView(withId(R.id.textViewResult))
                .check(matches(withText("Rezultatas: 4")));
    }
    @Test
    public void emptyTextUITest(){
        onView(withId(R.id.editTextInput))
                .perform(typeText("Labas."), closeSoftKeyboard());
        onView(withId(R.id.buttonCalculate))
                .perform(click());
        onView(withId(R.id.editTextInput))
                .perform(clearText());
        onView(withId(R.id.buttonCalculate))
                .perform(click());
        onView(withId(R.id.textViewResult))
                .check(matches(withText(R.string.result)));

    }
}
