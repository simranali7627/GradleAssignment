package com.example.demo;

public class Student {

    int Date;
    String Month;
    String Team;
    String PanelName;
    String Round;
    String Skill;

    int Time;
    String CandidateCurrentLocation;
    String CandidatePreferredLocation;
    String CandidateName;


    public void setCandidateCurrentLocation(String candidateCurrentLocation) {
        CandidateCurrentLocation = candidateCurrentLocation;
    }

    public void setCandidateName(String candidateName) {
        CandidateName = candidateName;
    }

    public void setCandidatePreferredLocation(String candidatePreferredLocation) {
        CandidatePreferredLocation = candidatePreferredLocation;
    }

    public void setDate(int date) {
        Date = date;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public void setPanelName(String panelName) {
        PanelName = panelName;
    }

    public void setRound(String round) {
        Round = round;
    }

    public void setSkill(String skill) {
        Skill = skill;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public void setTime(int time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "Student{" +

                ", Date='" + Date + '\'' +
                ", Month='" + Month + '\'' +
                ", Team='" + Team + '\'' +
                ", PanelName='" + PanelName + '\'' +
                ", Round='" + Round + '\'' +
                ", Skill='" + Skill + '\'' +
                ", Time='" + Time + '\'' +
                ", CandidateCurrentLocation='" + CandidateCurrentLocation + '\'' +
                ", CandidatePreferredLocation='" + CandidatePreferredLocation + '\'' +
                ", CandidateName='" + CandidateName + '\'' +
                '}';
    }

    public int getDate() {
        return Date;
    }

    public int getTime() {
        return Time;
    }

    public String getCandidateCurrentLocation() {
        return CandidateCurrentLocation;
    }

    public String getCandidateName() {
        return CandidateName;
    }

    public String getCandidatePreferredLocation() {
        return CandidatePreferredLocation;
    }

    public String getMonth() {
        return Month;
    }

    public String getPanelName() {
        return PanelName;
    }

    public String getRound() {
        return Round;
    }

    public String getSkill() {
        return Skill;
    }

    public String getTeam() {
        return Team;
    }
}
