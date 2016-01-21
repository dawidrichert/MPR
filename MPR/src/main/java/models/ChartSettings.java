package models;

import java.util.List;

public class ChartSettings {

    private List<ChartSerie> series;
    private String title;
    private String subtitle;
    private boolean haveLegend;
    private ChartType chartType;

    public List<ChartSerie> getSeries() {
        return series;
    }

    public void setSeries(List<ChartSerie> series) {
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isHaveLegend() {
        return haveLegend;
    }

    public void setHaveLegend(boolean haveLegend) {
        this.haveLegend = haveLegend;
    }

    public ChartType getChartType() {
        return chartType;
    }

    public void setChartType(ChartType chartType) {
        this.chartType = chartType;
    }
}
