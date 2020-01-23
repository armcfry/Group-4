package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Edge extends Line {

    public Edge(Room parent, SimPoint start, SimPoint end) {
        this.parent = parent;

        startPoint = start;
        endPoint = end;

        makeDraggable();
    }

    public void setOrientation(Direction d) {
        orientation = d;
    }

    public Direction getOrientation() {
        return orientation;
    }

    public void setStartPoint(SimPoint point) {
        startPoint = point;
    }

    public SimPoint getStartPoint() {
        return startPoint;
    }

    public void setEndPoint(SimPoint point) {
        endPoint = point;
    }

    public SimPoint getEndPoint() {
        return endPoint;
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
                    startPoint.setY(newY);
                    endPoint.setY(newY);
                    setStartY(startPoint.getY());
                    setEndY(endPoint.getY());
                }

                if (getOrientation().equals(Direction.VERTICAL)) {
                    startPoint.setX(newX);
                    endPoint.setX(newX);
                    setStartX(startPoint.getX());
                    setEndX(endPoint.getX());
                }

                parent.RedrawEdges();

                event.consume();

            }
        });

    }

    private Room parent;
    public enum Direction {
        HORIZONTAL, VERTICAL;
    }
    private Direction orientation;
    private SimPoint startPoint;
    private SimPoint endPoint;

}
