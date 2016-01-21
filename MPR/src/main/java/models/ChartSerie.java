package models;

import java.util.List;

public class ChartSerie {

    private String label;
    private List<Point> points;
    private SerieType serieType;

    public ChartSerie() { }

    public ChartSerie(String label, List<Point> points, SerieType serieType) {
        this.label = label;
        this.points = points;
        this.serieType = serieType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public SerieType getSerieType() {
        return serieType;
    }

    public void setSerieType(SerieType serieType) {
        this.serieType = serieType;
    }
}
