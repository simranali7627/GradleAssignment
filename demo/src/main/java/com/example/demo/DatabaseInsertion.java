package com.example.demo;


import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;
        import java.util.List;

public class  DatabaseInsertion {

    public static void insertEmployees(List<Student> employees) {
        try (Connection connection = DatabaseConnection.getDataSource().getConnection()) {
            connection.setAutoCommit(false); // Enable transaction
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLInsertQuery.INSERT_EMPLOYEE)) {
                for (Student employee : employees) {
                    preparedStatement.setInt(1, employee.getDate());
                    preparedStatement.setString(2, employee.getMonth());
                    preparedStatement.setString(3, employee.getTeam());
                    preparedStatement.setString(4, employee.getPanelName());
                    preparedStatement.setString(5, employee.getRound());
                    preparedStatement.setString(6, employee.getSkill());
                    preparedStatement.setInt(7, employee.getTime());
                    preparedStatement.setString(8, employee.getCandidateCurrentLocation());
                    preparedStatement.setString(9, employee.getCandidatePreferredLocation());
                    preparedStatement.setString(10, employee.getCandidateName());
                    preparedStatement.addBatch();
                }

                preparedStatement.executeBatch();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
