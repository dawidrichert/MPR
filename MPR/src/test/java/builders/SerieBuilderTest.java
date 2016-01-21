package builders;

import models.*;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class SerieBuilderTest {

    @Test
    public void addPoint_Should_AddPointToList() {
        SerieBuilder serieBuilder = new SerieBuilder();
        Point point1 = new Point(1, 2);
        Point point2 = new Point(5, 4);
        Point point3 = new Point(11, 33);

        ChartSerie chartSerie = serieBuilder.addPoint(point1)
                .addPoint(point2)
                .addPoint(point3)
                .build();

        assertThat(chartSerie.getPoints()).hasSize(3);
        assertThat(chartSerie.getPoints()).contains(point1)
                .contains(point2)
                .contains(point3);
    }

    @Test
    public void withPoints_Should_SetPoints() {
        SerieBuilder serieBuilder = new SerieBuilder();
        Point point1 = new Point(66, 55);

        ChartSerie chartSerie = serieBuilder.withPoints(Collections.singletonList(point1))
                .build();

        assertThat(chartSerie.getPoints()).hasSize(1);
        assertThat(chartSerie.getPoints()).contains(point1);
    }

    @Test
    public void withLabel_Should_SetTitle() {
        SerieBuilder serieBuilder = new SerieBuilder();
        String testLabel = "SuperLabel";

        ChartSerie chartSerie = serieBuilder.withLabel(testLabel)
                .build();

        assertThat(chartSerie.getLabel()).isEqualTo(testLabel);
    }

    @Test
    public void withType_Should_SetType() {
        SerieBuilder serieBuilder = new SerieBuilder();
        SerieType testSerieType = SerieType.Bar;

        ChartSerie chartSerie = serieBuilder.withType(testSerieType)
                .build();

        assertThat(chartSerie.getSerieType()).isEqualTo(testSerieType);
    }

    @Test
    public void build_Should_ReturnCorrectChartSerie() {
        SerieBuilder serieBuilder = new SerieBuilder();
        String testLabel = "Chupakabra";
        SerieType testSerieType = SerieType.Area;

        ChartSerie chartSerie = serieBuilder.withLabel(testLabel)
                .withType(testSerieType)
                .build();

        assertThat(chartSerie.getLabel()).isEqualTo(testLabel);
        assertThat(chartSerie.getSerieType()).isEqualTo(testSerieType);
    }
}
