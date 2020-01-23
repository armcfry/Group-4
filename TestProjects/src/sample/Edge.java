package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Edge extends Line {

    public Edge(Room parent) {
        this.parent = parent;

        startPoint = new double[2];
        endPoint = new double[2];

        makeDraggable();
    }

    public void setOrientation(Direction d) {
        orientation = d;
    }

    public Direction getOrientation() {
        return orientation;
    }

    public void setStartPoint(double[] point) {
        startPoint = point;
    }

    public double[] getStartPoint() {
        return startPoint;
    }

    public void setEndPoint(double[] point) {
        endPoint = point;
    }

    public double[] getEndPoint() {
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
                    startPoint[1] = newY;
                    endPoint[1] = newY;
                    setStartY(startPoint[1]);
                    setEndY(endPoint[1]);
                }

                if (getOrientation().equals(Direction.VERTICAL)) {
                    startPoint[0] = newX;
                    endPoint[0] = newX;
                    setStartX(startPoint[0]);
                    setEndX(endPoint[0]);
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
    private double[] startPoint;
    private double[] endPoint;

}
