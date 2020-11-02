package agh.cs.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class RectangularMap implements IWorldMap {

    private int width;
    private int height;
    private final List<Animal> animals;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
        this.animals = new ArrayList<>();
    }

    public boolean canMoveTo(Vector2d position){
        position= isEndMap(position);


        if (isOccupied(position)) {
            return false;}
        return true;
    }

    @Override
    public String toString() {
        MapVisualizer mv = new MapVisualizer(this);

        return(mv.draw(new Vector2d(0,0), new Vector2d(this.width-1,this.height-1)));

    }

    @Override
    public boolean place(Animal animal) {
        if (animal.getPosition().getX()>this.width || animal.getPosition().getY()>this.height ) return false;
        if (canMoveTo(animal.getPosition())){
        this.animals.add(animal);
        return true;
        }
        return false;

    }

    @Override
    public void run(MoveDirection[] directions) {

        for(int i=0;i<directions.length ;i++) {
            if(directions[i] != null) {
                animals.get(i%animals.size()).move(directions[i]);
            }
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {

        return(!Objects.isNull(objectAt(position)));
    }

    @Override
    public Object objectAt(Vector2d position) {

        for (Animal animal1: this.animals ) {
            if (position.equals(animal1.getPosition())) {
                return animal1;
            }

        }
        return null;
    }
    public Vector2d isEndMap(Vector2d position){
        if (position.getX() < 0) position.setX(this.getWidth()-1);
        if (position.getX() > (this.getWidth()-1)) position.setX(0);
        if (position.getY() < 0) position.setY(this.getHeight()-1);
        if (position.getY() > (this.getHeight()-1)) position.setY(0);

        return position;

    }

}
