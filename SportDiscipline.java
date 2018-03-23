package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportDiscipline {
    private String discipline;
    private List<Athlete> athletes = new ArrayList<>();
    private Map<String, Athlete> athletesMap = new HashMap<>();
    private List<Competition> competitions = new ArrayList<>();

    /**
     * Constructor of sport discipline instance
     * 
     * @param discipline the sport discipline 
     */
    public SportDiscipline(String discipline) {
        this.discipline = discipline;
    }

    /**
     * @return a string representation of a discipline
     */
    public String getDiscipline() {
        return discipline;
    }

    /**
     * Compare two disciplines alphabetically
     * 
     * @return a comparator of disciplines
     */
    public static Comparator<SportDiscipline> compareSportDisciplines() {
        Comparator<SportDiscipline> comp = new Comparator<SportDiscipline>() {
            @Override
            public int compare(SportDiscipline discipline1, SportDiscipline discipline2) {
                return discipline1.getDiscipline().compareTo(discipline2.getDiscipline());
            }
        };
        return comp;
    }

    public String toString() {
        return discipline;
    }

    /**
     * Adds an athlete that plays this discipline
     * 
     * @param id the id of the athlete
     * @param athlete the athlete instance
     */
    public void addAthlete(String id, Athlete athlete) {
        athletes.add(athlete);
        athletesMap.put(id, athlete);
    }

    /**
     * @return a list of athletes that play this discipline
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }

    /**
     * Adds a competition that takes place within this discipline
     * 
     * @param competition a competition instance
     */
    public void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    /**
     * @return a list of competitions 
     */
    public List<Competition> getCompetitions() {
        return competitions;
    }

}