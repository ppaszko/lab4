package agh.cs.lab4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnimalTest {
    private RectangularMap map;
    private Animal example = new Animal(map, new Vector2d(2,2));

    @Test
    public void movingForAllCases() {
        assertEquals( new Vector2d(2,2), example.getPosition());
        example.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, example.getOrientation());
        example.move(MoveDirection.BACKWARD);
        assertEquals( new Vector2d(1,2), example.getPosition());
        example.move(MoveDirection.FORWARD);
        example.move(MoveDirection.FORWARD);
        example.move(MoveDirection.FORWARD);
        example.move(MoveDirection.FORWARD);
        assertEquals( new Vector2d(0,2), example.getPosition());
    }

}