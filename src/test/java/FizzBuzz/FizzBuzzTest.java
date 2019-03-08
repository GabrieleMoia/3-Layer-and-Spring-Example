package FizzBuzz;

import FizzBuzz.sources.FizzBuzzSoftware;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FizzBuzzTest {

    @Test
    public void numNotDiv() {
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.run(8);
        //then
        Assert.assertEquals("" , result);
    }

    @Test
    public void numDivBy3() {
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.run(3);
        //then
        Assert.assertEquals("Fizz" , result);
    }

    @Test
    public void numDivBy5(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.run(35);
        //then
        Assert.assertEquals("Buzz" , result);
    }

    @Test
    public void numDivBy5And3(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.run(15);
        //then
        Assert.assertEquals("FizzBuzz" , result);
    }

    @Test
    public void numContains3(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(33);
        //then
        Assert.assertEquals("Fizz" , result);
    }

    @Test
    public void numContains5(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(25);
        //then
        Assert.assertEquals("Buzz" , result);
    }

    @Test
    public void numContains3And5(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(53);
        //then
        Assert.assertEquals("FizzBuzz" , result);
    }

    @Test
    public void numContains3ButNotDivBy3(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(37);
        //then
        Assert.assertEquals("Fizz" , result);
    }

    @Test
    public void numContains5ButNotDivBy5(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(52);
        //then
        Assert.assertEquals("Buzz" , result);
    }

    @Test
    public void numContains5AndDivBy5(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(55);
        //then
        Assert.assertEquals("Buzz" , result);
    }

    @Test
    public void numContains3AndDivBy3(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(33);
        //then
        Assert.assertEquals("Fizz" , result);
    }

    @Test
    public void numContains3And5AndDivBy5(){
        FizzBuzzSoftware target = new FizzBuzzSoftware();
        //when
        String result = target.contains(35);
        //then
        Assert.assertEquals("FizzBuzz" , result);
    }
}
