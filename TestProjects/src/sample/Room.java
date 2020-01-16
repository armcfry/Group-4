package sample;

import java.awt.*;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import java.math.*;

public class Room extends Group {

    public Room(int width, int height) {
        this.width = width;
        this.height = height;

        room = new Rectangle();
        room.setWidth(width);
        room.setHeight(height);
        room.setX(300);
        room.setY(300);
        room.setFill(javafx.scene.paint.Color.RED);

//        Path path = new Path();
//
//        int startX = 300;
//        int startY = 300;
//
//        MoveTo moveTo = new MoveTo(startX, startY);
//        startY += height;
//        LineTo line1 = new LineTo(startX, startY);
//        startX -= width;
//        LineTo line2 = new LineTo(startX, startY);
//        startY -= height;
//        LineTo line3 = new LineTo(startX, startY);
//        startX += width;
//        LineTo line4 = new LineTo(startX, startY);
//
//        path.getElements().add(moveTo);
//        path.getElements().addAll(line1, line2, line3, line4);


//        Rectangle r = new Rectangle();
//        r.setWidth(this.width);
//        r.setHeight(this.height);
//
        getChildren().add(room);
        //getChildren().add(path);
        makeDraggable();
    }

    public void Remove() {
        if (getChildren().size() > 0) {
            getChildren().remove(0);
        }
    }

    private void makeDraggable() {
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                room.setX(Math.round(event.getSceneX()/50.0) * 50);
                room.setY(Math.round(event.getSceneY()/50.0) * 50);
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                room.setX(Math.round(event.getSceneX()/50.0) * 50);
                room.setY(Math.round(event.getSceneY()/50.0) * 50);
            }
        });
    }

    int width, height;
    Rectangle room;

}
