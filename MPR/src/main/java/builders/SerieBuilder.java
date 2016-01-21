package builders;

import models.ChartSerie;
import models.Point;
import models.SerieType;

import java.util.ArrayList;
import java.util.List;

public class SerieBuilder {

    private ChartSerie chartSerie;

    public SerieBuilder() {
        chartSerie = new ChartSerie();
    }

    public SerieBuilder addPoint(Point point) {
        List<Point> points = chartSerie.getPoints();
        if(points == null) {
            points = new ArrayList<Point>();
            chartSerie.setPoints(points);
        }
        points.add(point);
        return this;
    }

    public SerieBuilder withPoints(List<Point> points) {
        chartSerie.setPoints(points);
        return this;
    }

    public SerieBuilder withLabel(String label) {
        chartSerie.setLabel(label);
        return this;
    }

    public SerieBuilder withType(SerieType type) {
        chartSerie.setSerieType(type);
        return this;
    }

    public ChartSerie build() {
        return chartSerie;
    }
}
