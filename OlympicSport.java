package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OlympicSport {
    private String sportsType;
    private List<SportDiscipline> disciplines = new ArrayList<>();

    /**
     * Constructor of an OlympicSport instance
     * 
     * @param sportsType the sport's type
     */
    public OlympicSport(String sportsType) {
        this.sportsType = sportsType;
    }

    /**
     * @return a string representing the sport's type
     */
    public String getSportsType() {
        return sportsType;
    }

    /**
     * @return a list of the sport disciplines associated with this sport
     */
    public List<SportDiscipline> getDisciplines() {
        return disciplines;
    }

    /**
     * Adds a sport discipline to list of disciplines 
     * 
     * @param discipline the discipline to add
     */
    public void addDiscipline(SportDiscipline discipline) {
        disciplines.add(discipline);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sportsType == null) ? 0 : sportsType.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OlympicSport other = (OlympicSport) obj;
        if (sportsType == null) {
            if (other.sportsType != null)
                return false;
        } else if (!sportsType.equals(other.sportsType))
            return false;
        return true;
    }

    /**
     * Compare two olympic sports alphabetically
     * 
     * @return a comparator of two olympic sports
     */
    public static Comparator<OlympicSport> compareOlympicSports() {
        Comparator<OlympicSport> comp = new Comparator<OlympicSport>() {
            @Override
            public int compare(OlympicSport sport1, OlympicSport sport2) {
                return sport1.getSportsType().compareTo(sport2.getSportsType());
            }
        };
        return comp;
    }

    @Override
    public String toString() {
        return sportsType;
    }

}