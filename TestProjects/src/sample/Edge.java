package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Edge extends Line {

    public Edge(Room parent) {
        this.parent = parent;

        makeDraggable();
    }

    public void setOrientation(Direction d) {
        orientation = d;
    }

    public Direction getOrientation() {
        return orientation;
    }

    private void makeDraggable() {
        this.setPickOnBounds(true);

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setFill(Color.RED);

                event.consume();
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double newX = (Math.round(event.getX()/25.0) * 25);
                double newY = (Math.round(event.getY()/25.0) * 25);

                // TODO: Determine if this object should only move in the X direction or only in the Y direction.
                if (getOrientation().equals(Direction.HORIZONTAL)) {
                    setStartY(newY);
                    setEndY(newY);
                }

                if (getOrientation().equals(Direction.VERTICAL)) {
                    setStartX(newX);
                    setEndX(newX);
                }

                event.consume();

            }
        });

    }

    private Room parent;
    public enum Direction {
        HORIZONTAL, VERTICAL;
    }
    private Direction orientation;

}
