package com.example.demo;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Panels {
    String panelName;
    LocalDate interviewDate;

    public Panels(String panelName, LocalDate interviewDate) {
        this.panelName = panelName;
        this.interviewDate = interviewDate;
    }

    Panels() {
    }

    ;


    public void getTopThreePanels(Connection connection) {
        List<Panels> panels = new ArrayList<>();

        String sql = "SELECT panel_name, interview_date FROM panels";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String panelName = resultSet.getString("panel_name");
                LocalDate interviewDate = resultSet.getDate("interview_date").toLocalDate();

                Panels panel = new Panels(panelName, interviewDate);
                panels.add(panel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        // Filter panels for the months of October and November 2023
//        List<Panel> filteredPanels = panels.stream()
//                .filter(panel -> panel.getInterviewDate().getMonthValue() >= 10 && panel.getInterviewDate().getMonthValue() <= 11
//                        && panel.getInterviewDate().getYear() == 2023)
//                .collect(Collectors.toList());
//
//        // Group panels by panel name and count the interviews for each panel
//        Map<String, Long> panelCounts = filteredPanels.stream()
//                .collect(Collectors.groupingBy(Panel::getPanelName, Collectors.counting()));
//
//        // Find the top 3 panels based on the number of interviews
//        List<Map.Entry<String, Long>> top3Panels = panelCounts.entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .limit(3)
//                .collect(Collectors.toList());
    }
}
