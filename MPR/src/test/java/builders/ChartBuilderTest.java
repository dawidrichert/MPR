package builders;

import models.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ChartBuilderTest {

    @Test
    public void addSerie_Should_AddChartSerieToList() {
        ChartBuilder chartBuilder = new ChartBuilder();
        ChartSerie chartSerie1 = new ChartSerie("MyLabel1",
                Arrays.asList(new Point(1, 2), new Point(4, 5)),
                SerieType.Point);
        ChartSerie chartSerie2 = new ChartSerie("MyLabel2",
                Arrays.asList(new Point(4, 2), new Point(7, 4)),
                SerieType.Bar);

        ChartSettings chartSettings = chartBuilder.addSerie(chartSerie1)
                .addSerie(chartSerie2)
                .build();

        assertThat(chartSettings.getSeries()).hasSize(2);
        assertThat(chartSettings.getSeries()).contains(chartSerie1)
                .contains(chartSerie2);
    }

    @Test
    public void withSeries_Should_SetChartSeries() {
        ChartBuilder chartBuilder = new ChartBuilder();
        ChartSerie chartSerie1 = new ChartSerie("xxx",
                Arrays.asList(new Point(71, 2), new Point(52, 14), new Point(55, 44)),
                SerieType.LinePoint);

        ChartSettings chartSettings = chartBuilder.withSeries(Collections.singletonList(chartSerie1))
                .build();

        assertThat(chartSettings.getSeries()).hasSize(1);
        assertThat(chartSettings.getSeries()).contains(chartSerie1);
    }

    @Test
    public void withTitle_Should_SetTitle() {
        ChartBuilder chartBuilder = new ChartBuilder();
        String testTitle = "SuperTitle";

        ChartSettings chartSettings = chartBuilder.withTitle(testTitle)
                .build();

        assertThat(chartSettings.getTitle()).isEqualTo(testTitle);
    }

    @Test
    public void withSubtitle_Should_SetSubtitle() {
        ChartBuilder chartBuilder = new ChartBuilder();
        String testSubtitle = "SuperSubtitle";

        ChartSettings chartSettings = chartBuilder.withSubtitle(testSubtitle)
                .build();

        assertThat(chartSettings.getSubtitle()).isEqualTo(testSubtitle);
    }

    @Test
    public void withLegend_Should_SetHaveLegendToTrue() {
        ChartBuilder chartBuilder = new ChartBuilder();

        ChartSettings chartSettings = chartBuilder.withLegend()
                .build();

        assertThat(chartSettings.isHaveLegend()).isTrue();
    }

    @Test
    public void withType_Should_SetType() {
        ChartBuilder chartBuilder = new ChartBuilder();
        ChartType testChartType = ChartType.Line;

        ChartSettings chartSettings = chartBuilder.withType(testChartType)
                .build();

        assertThat(chartSettings.getChartType()).isEqualTo(testChartType);
    }

    @Test
    public void build_Should_ReturnCorrectChartSettings() {
        ChartBuilder chartBuilder = new ChartBuilder();
        String testTitle = "Title1";
        String testSubtitle = "Subtitle2";
        ChartType testChartType = ChartType.Bar;

        ChartSettings chartSettings = chartBuilder.withTitle(testTitle)
                .withSubtitle(testSubtitle)
                .withType(testChartType)
                .withLegend()
                .build();

        assertThat(chartSettings.getTitle()).isEqualTo(testTitle);
        assertThat(chartSettings.getSubtitle()).isEqualTo(testSubtitle);
        assertThat(chartSettings.getChartType()).isEqualTo(testChartType);
        assertThat(chartSettings.isHaveLegend()).isTrue();
    }

    @Test
    public void build_Should_ReturnChartSettingsWithHaveLegendSetAsFalse_When_WithLegendIsNotUsed() {
        ChartBuilder chartBuilder = new ChartBuilder();
        String testTitle = "Title1";
        String testSubtitle = "Subtitle2";

        ChartSettings chartSettings = chartBuilder.withTitle(testTitle)
                .withSubtitle(testSubtitle)
                .build();

        assertThat(chartSettings.isHaveLegend()).isFalse();
    }
}
