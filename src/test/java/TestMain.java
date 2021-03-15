import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "Edet\r\npo\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "Edet\npo\n";
        String actual = outContent.toString().replaceAll("\\r", "");

        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "Luchshe\r\ns\r\numnym\r\npoterjat',\r\nchem\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "Luchshe\ns\numnym\npoterjat',\nchem\n";
        String actual = outContent.toString().replaceAll("\\r", "");

        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "Ne\r\nstydno\r\nne\r\nznat',\r\nstydno\r\nne\r\nuchit'sja\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "Ne\nstydno\nne\nznat',\nstydno\nne\nuchit'sja\n";
        String actual = outContent.toString().replaceAll("\\r", "");

        assertEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "Gladko\r\nbylo\r\nna\r\nbumage, da\r\nzabyli pro ovragi\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "Gladko\nbylo\nna\nbumage, da\nzabyli pro ovragi\n";
        String actual = outContent.toString().replaceAll("\\r", "");

        assertEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "Byloj slavoj boja ne vyigraesh\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        String expected = "Byloj slavoj boja ne vyigraesh\n";
        String actual = outContent.toString().replaceAll("\\r", "");

        assertEquals(expected, actual);
    }

}