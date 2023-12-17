package com.example.demo;



import org.knowm.xchart.CategoryChart;
        import org.knowm.xchart.CategoryChartBuilder;
        import org.knowm.xchart.SwingWrapper;
        import org.knowm.xchart.style.Styler;
        import org.knowm.xchart.style.colors.*;

        import java.util.Arrays;
        import java.util.List;

public class ChartGeneration {

    public static void generateChart() {

        // Create Chart
        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("Custom Bar Chart")
                .xAxisTitle("Categories")
                .yAxisTitle("Values")
                .theme(Styler.ChartTheme.GGPlot2)
                .build();

        // Customize Chart
        chart.getStyler().setChartBackgroundColor(ChartColor.getAWTColor(ChartColor.GREY));
        chart.getStyler().setPlotGridLinesColor(ChartColor.getAWTColor(ChartColor.WHITE));
        chart.getStyler().setToolTipsEnabled(true);

        // Customize Series
        chart.getStyler().setSeriesColors(new GGPlot2SeriesColors());
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setHasAnnotations(true);

        // Add Data
        List<String> categories = Arrays.asList("A", "B", "C", "D");
        List<Double> values = Arrays.asList(2.0, 4.0, 1.5, 3.5);

        chart.addSeries("Series 1", categories, values);

        // Display Chart
        new SwingWrapper<>(chart).displayChart();
    }
}
