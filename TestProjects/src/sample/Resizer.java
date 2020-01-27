package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

/*
CURRENTLY NOT IN USE
* */

public class Resizer extends Circle {

    public Resizer(Room parent, double centerX, double centerY, double radius) {
        this.parent = parent;
        setCenterX(centerX);
        setCenterY(centerY);
        setRadius(radius);

        this.setPickOnBounds(true);

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                //parent.Widen(1);
                //parent.Resize();

                event.consume();
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                double newX = (Math.round(event.getX()/25.0) * 25);
                double newY = (Math.round(event.getY()/25.0) * 25);

                if (getId().equals("RIGHT") || getId().equals("LEFT")) {
                    //parent.Widen(Math.abs(newX));
                    //parent.Resize();
                }

                event.consume();
            }
        });

    }

    Room parent;

}
