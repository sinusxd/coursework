package org.course.coursework.dto;

public class SearchDTO {
    private String from;
    private String to;
    private String when;
    private String classSelect;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getClassSelect() {
        return classSelect;
    }

    public void setClassSelect(String classSelect) {
        this.classSelect = classSelect;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", when='" + when + '\'' +
                ", classSelect='" + classSelect + '\'' +
                '}';
    }
}