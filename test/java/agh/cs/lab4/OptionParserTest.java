package agh.cs.lab4;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class OptionParserTest {
    @Test
    public void parsingStringTable() {
        assertArrayEquals(new MoveDirection[] {MoveDirection.LEFT,MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD,MoveDirection.RIGHT},
                OptionsParser.parse(new String[] {"kkk", "left", "f", "fort","forward", "b ","b","r","rt"}));
    }
}