package sample;

import javafx.event.EventHandler;
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

        for (int i = 0; i < 4; i++) {
            edges[i] = new Edge(this);
        }

        Resize();
        BindEdges();
        RedrawEdges();

        getChildren().addAll(edges);
        makeDraggable();
    }

    public void Remove() {
        if (getChildren().size() > 0) {
            getChildren().remove(0);
        }
    }

    public void BindEdges() {
        edges[0].setStartPoint(edges[3].getEndPoint());
//        edges[0].setEndPoint(edges[1].getStartPoint());

        edges[1].setStartPoint(edges[0].getEndPoint());
//        edges[1].setEndPoint(edges[2].getStartPoint());

        edges[2].setStartPoint(edges[1].getEndPoint());
//        edges[2].setEndPoint(edges[3].getStartPoint());

        edges[3].setStartPoint(edges[2].getEndPoint());
//        edges[3].setEndPoint(edges[0].getStartPoint());
    }

    public void RedrawEdges() {
        edges[0].setStartX(edges[0].getStartPoint()[0]);
        edges[0].setStartY(edges[0].getStartPoint()[1]);
        edges[0].setEndX(edges[0].getEndPoint()[0]);
        edges[0].setEndY(edges[0].getEndPoint()[1]);

        edges[1].setStartX(edges[1].getStartPoint()[0]);
        edges[1].setStartY(edges[1].getStartPoint()[1]);
        edges[1].setEndX(edges[1].getEndPoint()[0]);
        edges[1].setEndY(edges[1].getEndPoint()[1]);

        edges[2].setStartX(edges[2].getStartPoint()[0]);
        edges[2].setStartY(edges[2].getStartPoint()[1]);
        edges[2].setEndX(edges[2].getEndPoint()[0]);
        edges[2].setEndY(edges[2].getEndPoint()[1]);

        edges[3].setStartX(edges[3].getStartPoint()[0]);
        edges[3].setStartY(edges[3].getStartPoint()[1]);
        edges[3].setEndX(edges[3].getEndPoint()[0]);
        edges[3].setEndY(edges[3].getEndPoint()[1]);
    }

    public void Resize() {
        double xDist = width / 2.0;
        double yDist = height / 2.0;

        edges[0].setStartPoint(new double[]{centerX - xDist, centerY - yDist});
        edges[0].setEndPoint(new double[]{centerX + xDist, centerY - yDist});
//        edges[0].setStartX(centerX - (width / 2.0));
//        edges[0].setStartY(centerY - (height / 2.0));
//        edges[0].setEndX(centerX + (width / 2.0));
//        edges[0].setEndY(centerY - (height / 2.0));
        edges[0].setId("TOP");
        edges[0].setStrokeWidth(5);
        edges[0].setFill(Color.BLACK);
        edges[0].setOrientation(Edge.Direction.HORIZONTAL);

        edges[1].setStartPoint(new double[]{centerX + xDist, centerY - yDist});
        edges[1].setEndPoint(new double[]{centerX + xDist, centerY + yDist});
//        edges[1].setStartX(centerX + (width / 2.0));
//        edges[1].setStartY(centerY - (height / 2.0));
//        edges[1].setEndX(centerX + (width / 2.0));
//        edges[1].setEndY(centerY + (height / 2.0));
        edges[1].setId("RIGHT");
        edges[1].setStrokeWidth(5);
        edges[1].setFill(Color.BLACK);
        edges[1].setOrientation(Edge.Direction.VERTICAL);

        edges[2].setStartPoint(new double[]{centerX + xDist, centerY + yDist});
        edges[2].setEndPoint(new double[]{centerX - xDist, centerY + yDist});
//        edges[2].setStartX(centerX + (width / 2.0));
//        edges[2].setStartY(centerY + (height / 2.0));
//        edges[2].setEndX(centerX - (width / 2.0));
//        edges[2].setEndY(centerY + (height / 2.0));
        edges[2].setId("BOTTOM");
        edges[2].setStrokeWidth(5);
        edges[2].setFill(Color.BLACK);
        edges[2].setOrientation(Edge.Direction.HORIZONTAL);

        edges[3].setStartPoint(new double[]{centerX - xDist, centerY + yDist});
        edges[3].setEndPoint(new double[]{centerX - xDist, centerY - yDist});

//        edges[3].setStartX(centerX - (width / 2.0));
//        edges[3].setStartY(centerY + (height / 2.0));
//        edges[3].setEndX(centerX - (width / 2.0));
//        edges[3].setEndY(centerY - (height / 2.0));
        edges[3].setId("LEFT");
        edges[3].setStrokeWidth(5);
        edges[3].setFill(Color.BLACK);
        edges[3].setOrientation(Edge.Direction.VERTICAL);
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
