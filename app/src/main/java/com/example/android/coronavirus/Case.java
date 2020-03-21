package com.example.android.coronavirus;

public class Case {

    public String country;
    public int cases;
    public int todayCases;
    public int deaths;
    public int todayDeaths;
    public int recovered;
    public int active;
    public int critical;
    public int casePerOneMillion;

    public Case(String country, int cases, int todayCases, int deaths, int todayDeaths, int recovered, int active, int critical, int casePerOneMillion) {

        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
        this.casePerOneMillion = casePerOneMillion;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public void setTodayCases(int todayCases) {
        this.todayCases = todayCases;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setTodayDeaths(int todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setCritical(int critical) {
        this.critical = critical;
    }

    public void setCasePerOneMillion(int casePerOneMillion) {
        this.casePerOneMillion = casePerOneMillion;
    }

    public int getCasePerOneMillion() {
        return casePerOneMillion;
    }

    public String getCountry() {
        return country;
    }

    public int getCases() {
        return cases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getTodayDeaths() {
        return todayDeaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getActive() {
        return active;
    }

    public int getCritical() {
        return critical;
    }
}