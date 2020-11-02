package agh.cs.lab4;

import org.junit.Assert;
import org.junit.Test;

public class MapTest {

    @Test
    public void mapRunPeriodicTest() {
        String[] args = new String[] {"f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map,new Vector2d(3,4));
        map.place(animal1);
        map.place(animal2);
        map.run(directions);
        Assert.assertEquals("should be animal1", animal1, map.objectAt(new Vector2d(2,2)));
        Assert.assertEquals("should be animal2", animal2, map.objectAt(new Vector2d(3,4)));
        Assert.assertEquals("should be NORTH", animal2.getOrientation(), MapDirection.NORTH);
        Assert.assertEquals("should be NORTH", animal1.getOrientation(), MapDirection.NORTH);
    }
    @Test
    public void mapRunClashingTest() {
        String[] args = new String[] {"r", "b", "f","b" };;
        MoveDirection[] directions = OptionsParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map,new Vector2d(3,4));
        map.place(animal1);
        map.place(animal2);
        map.run(directions);
        Assert.assertEquals("should be anmal2", animal1, map.objectAt(new Vector2d(3,2)));
        Assert.assertEquals("should be animal2", animal2, map.objectAt(new Vector2d(3,3)));
        Assert.assertEquals("should be NORTH", animal2.getOrientation(), MapDirection.NORTH);
        Assert.assertEquals("should be EAST", animal1.getOrientation(), MapDirection.EAST);
    }

    @Test
    public void mapSpawningTest(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map);
        map.place(animal1);
        map.place(animal2);
        Assert.assertEquals("should be animal1", animal1,map.objectAt(new Vector2d (2,2)));

    }



}