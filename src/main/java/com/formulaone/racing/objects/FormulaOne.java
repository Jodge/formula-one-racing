package com.formulaone.racing.objects;

/**
 * @author George Otieno
 *
 */
public class FormulaOne {

    private Integer position;
    private String name;
    private String race;
    private Integer points;
    private String url;
    private String raceUrl;
    private String nationality;

    public FormulaOne(Integer position, String name, String race, Integer points, String url, String raceUrl, String nationality) {
        this.position = position;
        this.name = name;
        this.race = race;
        this.points = points;
        this.url = url;
        this.raceUrl = raceUrl;
        this.nationality = nationality;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRaceUrl() {
        return raceUrl;
    }

    public void setRaceUrl(String raceUrl) {
        this.raceUrl = raceUrl;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

}
