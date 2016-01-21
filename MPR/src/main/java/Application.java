import builders.ChartBuilder;
import models.ChartSettings;
import models.ChartType;

public class Application {

    public static void main(String args[]) {

        ChartBuilder buildChart = new ChartBuilder();
        ChartSettings chart =
                buildChart.withTitle("Zarobki Pracowników")
                        .withSubtitle("rok 2015")
                        .withType(ChartType.Bar)
                        .withLegend()
                        .build();
    }
}
