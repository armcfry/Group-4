package sample;

import java.awt.*;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import java.math.*;

/*
 * TODO: Add blue circles for each edge and the center for movement and resizing.
 *  TODO: Clicking and dragging on edge circles should increase width/height by one grid
 *   unit.
 *   TODO: Clicking and dragging on the center circle should move the shape along around in the scene
 * */

public class Room extends Group {

    public Room(int x, int y, int width, int height) {
        this.centerX = x;
        this.centerY = y;
        this.width = width;
        this.height = height;

        // Create the room's outline
        room = new Rectangle();
        room.setWidth(width);
        room.setHeight(height);
        room.setX(centerX - (width / 2.0));
        room.setY(centerY - (height / 2.0));
        room.setFill(Color.TRANSPARENT);
        room.setStroke(Color.BLACK);
        room.setStrokeWidth(1);

        // Instantiate movement circles, but make them invisible
        resizingMarkers = new Circle[5];
        resizingMarkers[0] = new Circle(centerX, centerY, 5);
        resizingMarkers[0].setFill(new Color(0.0, 0.0, 1.0, 0.5));

        resizingMarkers[1] = new Circle(centerX - (width / 2.0), centerY, 5);
        resizingMarkers[1].setFill(new Color(0.0, 0.0, 1.0, 0.5));

        resizingMarkers[2] = new Circle(centerX, centerY + (height / 2.0), 5);
        resizingMarkers[2].setFill(new Color(0.0, 0.0, 1.0, 0.5));

        resizingMarkers[3] = new Circle(centerX + (width / 2.0), centerY, 5);
        resizingMarkers[3].setFill(new Color(0.0, 0.0, 1.0, 0.5));

        resizingMarkers[4] = new Circle(centerX, centerY - (height / 2.0), 5);
        resizingMarkers[4].setFill(new Color(0.0, 0.0, 1.0, 0.5));

        getChildren().addAll(resizingMarkers);

        getChildren().add(room);
        makeDraggable();
    }

    public void Remove() {
        if (getChildren().size() > 0) {
            getChildren().remove(0);
        }
    }

    private void makeDraggable() {

        this.setPickOnBounds(true);

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //room.setX(Math.round(event.getSceneX()));
                //room.setY(Math.round(event.getSceneY()));

                // TODO: Check if the user clicked the room. If so, display all of the circles and detect mouse clicks.
                // TODO: If the user clicks on a circle, determine which one should be affecting the drag function.
                for (Circle cir : resizingMarkers) {
                    if (cir.contains(event.getX(), event.getY())) {
                        /* TODO: Find some way to set a state for the mouse drag handler to determine how to resize
                        *   the shape. */
                    }
                }

                event.consume();
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double newX = (Math.round(event.getX()/25.0) * 25);
                double newY = (Math.round(event.getY()/25.0) * 25);

                room.setX(newX - (width / 2.0));
                room.setY(newY - (height / 2.0));

                // Change the positions of the circles
                resizingMarkers[0].setCenterX(newX);
                resizingMarkers[0].setCenterY(newY);

                resizingMarkers[1].setCenterX(newX - (width / 2.0));
                resizingMarkers[1].setCenterY(newY);

                resizingMarkers[2].setCenterX(newX);
                resizingMarkers[2].setCenterY(newY + (height / 2.0));

                resizingMarkers[3].setCenterX(newX + (width / 2.0));
                resizingMarkers[3].setCenterY(newY);

                resizingMarkers[4].setCenterX(newX);
                resizingMarkers[4].setCenterY(newY - (height / 2.0));

                event.consume();
            }
        });
    }

    int width, height;
    int centerX, centerY;
    Rectangle room;
    Circle[] resizingMarkers;

}
