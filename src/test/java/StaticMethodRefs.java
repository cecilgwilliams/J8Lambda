import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static junit.framework.Assert.*;

public class StaticMethodRefs {

    @Test
    public void canRefByMethod(){

        MyExecute.isOn = false;

        Runnable task = MyExecute::go;

        assertFalse(MyExecute.isOn);

        task.run();

        assertTrue(MyExecute.isOn);
    }

    @Test
    public void canRefInline(){

        MyExecute.isOn = false;

        Runnable task = ()-> MyExecute.go();

        assertFalse(MyExecute.isOn);

        task.run();

        assertTrue(MyExecute.isOn);
    }

    @Test
    public void canRefAsMultiLineBlock(){

        MyExecute.isOn = false;

        Runnable task = ()-> {
            MyExecute.go();
        };

        assertFalse(MyExecute.isOn);

        task.run();

        assertTrue(MyExecute.isOn);
    }

    @Test
    @Ignore("Not working yet")
    public void canContsructWithMethodReference(){
       // MyExecute e = MyExecute::new;

        // assertNotNull(e);
    }






    public static class MyExecute {

        private static boolean isOn;

        public static void go(){
            isOn = true;
        }
    }



}
