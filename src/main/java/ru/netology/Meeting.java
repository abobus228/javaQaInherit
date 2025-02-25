package ru.netology;

public class Meeting extends Task {
    protected String topic;  // Тема обсуждения
    protected String project;  // Название проекта
    protected String start;  // Дата и время старта проекта

    public Meeting(int id, String topic, String project, String start) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }
}
