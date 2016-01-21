package builders;

import models.ChartSerie;
import models.ChartSettings;
import models.ChartType;

import java.util.ArrayList;
import java.util.List;

public class ChartBuilder {

    private ChartSettings chartSettings;

    public ChartBuilder() {
        chartSettings = new ChartSettings();
    }

    public ChartBuilder addSerie(ChartSerie serie) {
        List<ChartSerie> series = chartSettings.getSeries();
        if(series == null) {
            series = new ArrayList<ChartSerie>();
            chartSettings.setSeries(series);
        }
        series.add(serie);
        return this;
    }

    public ChartBuilder withSeries(List<ChartSerie> series) {
        chartSettings.setSeries(series);
        return this;
    }

    public ChartBuilder withTitle(String title) {
        chartSettings.setTitle(title);
        return this;
    }

    public ChartBuilder withSubtitle(String subtitle) {
        chartSettings.setSubtitle(subtitle);
        return this;
    }

    public ChartBuilder withLegend() {
        chartSettings.setHaveLegend(true);
        return this;
    }

    public ChartBuilder withType(ChartType type) {
        chartSettings.setChartType(type);
        return this;
    }

    public ChartSettings build() {
        return chartSettings;
    }
}
