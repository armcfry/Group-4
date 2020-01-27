package sample;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.Group;

public class Room extends Group {

    public Room(int x, int y, int width, int height) {
        this.centerX = x;
        this.centerY = y;
        this.width = width;
        this.height = height;

        edges = new Edge[4];

        InitializeEdges();
        RedrawEdges();

        getChildren().addAll(edges);
        makeDraggable();
    }

    private void InitializeEdges() {
        double xDist = (width / 2.0);
        double yDist = (height / 2.0);

        SimPoint point1 = new SimPoint(centerX - xDist, centerY - yDist);
        SimPoint point2 = new SimPoint(centerX + xDist, centerY - yDist);
        SimPoint point3 = new SimPoint(centerX + xDist, centerY + yDist);
        SimPoint point4 = new SimPoint(centerX - xDist, centerY + yDist);

        edges[0] = new Edge(this, point1, point2);
        edges[0].setId("TOP");
        edges[0].setStrokeWidth(5);
        edges[0].setFill(Color.BLACK);
        edges[0].setOrientation(Edge.Direction.HORIZONTAL);

        edges[1] = new Edge(this, point2, point3);
        edges[1].setId("TOP");
        edges[1].setStrokeWidth(5);
        edges[1].setFill(Color.BLACK);
        edges[1].setOrientation(Edge.Direction.VERTICAL);

        edges[2] = new Edge(this, point3, point4);
        edges[2].setId("TOP");
        edges[2].setStrokeWidth(5);
        edges[2].setFill(Color.BLACK);
        edges[2].setOrientation(Edge.Direction.HORIZONTAL);

        edges[3] = new Edge(this, point4, point1);
        edges[3].setId("TOP");
        edges[3].setStrokeWidth(5);
        edges[3].setFill(Color.BLACK);
        edges[3].setOrientation(Edge.Direction.VERTICAL);

    }

    public void Remove() {
        if (getChildren().size() > 0) {
            getChildren().remove(0);
        }
    }

    public void RedrawEdges() {
        edges[0].setStartX(edges[0].getStartPoint().getX());
        edges[0].setStartY(edges[0].getStartPoint().getY());
        edges[0].setEndX(edges[0].getEndPoint().getX());
        edges[0].setEndY(edges[0].getEndPoint().getY());

        edges[1].setStartX(edges[1].getStartPoint().getX());
        edges[1].setStartY(edges[1].getStartPoint().getY());
        edges[1].setEndX(edges[1].getEndPoint().getX());
        edges[1].setEndY(edges[1].getEndPoint().getY());

        edges[2].setStartX(edges[2].getStartPoint().getX());
        edges[2].setStartY(edges[2].getStartPoint().getY());
        edges[2].setEndX(edges[2].getEndPoint().getX());
        edges[2].setEndY(edges[2].getEndPoint().getY());

        edges[3].setStartX(edges[3].getStartPoint().getX());
        edges[3].setStartY(edges[3].getStartPoint().getY());
        edges[3].setEndX(edges[3].getEndPoint().getX());
        edges[3].setEndY(edges[3].getEndPoint().getY());
    }

    private void makeDraggable() {

        this.setPickOnBounds(true);

        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                event.consume();
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                event.consume();
            }
        });
    }

    private int width, height;
    private int centerX, centerY;
    private Edge[] edges;

}
