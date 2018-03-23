package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Country {

    private String name;
    private List<Athlete> athletes = new ArrayList<>();
    private IocCode ioc;
    private int gold;
    private int silver;
    private int bronze;
    private int medals;

    /**
     * Constructor of a country instance
     * 
     * @param name the country's name
     * @param ioc the ioc code
     */
    public Country(String name, IocCode ioc) {
        this.name = name;
        this.ioc = ioc;
    }

    /**
     * @return the ioc code of this country
     */
    public IocCode getIoc() {
        return ioc;
    }

    /**
     * @return the country name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the total number of gold medals won by athletes from this country
     */
    public int getGold() {
        return gold;
    }

    /**
     * @param gold number of gold medals
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * @return the total number of silver medals won by athletes from this country
     */
    public int getSilver() {
        return silver;
    }

    /**
     * @param silver number of silver medals
     */
    public void setSilver(int silver) {
        this.silver = silver;
    }

    /**
     * @return the total number of bronze medals won by athletes from this country
     */
    public int getBronze() {
        return bronze;
    }

    /**
     * @param bronze number of bronze medals
     */
    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    /**
     * @return the total number of medals won by athletes from this country
     */
    public int getMedals() {
        return medals;
    }

    /**
     * @param medals number of medals
     */
    public void setMedals(int medals) {
        this.medals = medals;
    }

    /**
     * @param athlete instance to add 
     */
    public void addAthlete(Athlete athlete) {
        athletes.add(athlete);
    }

    /**
     * @param ioc ioc code to add 
     */
    public void setIoc(IocCode ioc) {
        this.ioc = ioc;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Country other = (Country) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    /**
     * Calculates the number of gold medals
     */
    public void calculateGoldMedals() {
        for (Athlete athlete : athletes) {
            gold += athlete.getGoldMedals();
        }
    }

    /**
     * Calculates the number of silver medals
     */
    public void calculateSilverMedals() {
        for (Athlete athlete : athletes) {
            silver += athlete.getSilverMedals();
        }
    }

    /**
     * Calculates the number of bronze medals
     */
    public void calculateBronzeMedals() {
        for (Athlete athlete : athletes) {
            bronze += athlete.getBronzeMedals();
        }
    }

    /**
     * Calculates the number of medals
     */
    public void calculateMedals() {
        medals = gold + silver + bronze;
    }

    /**
     * Compares two country based on the type of medals won by their athletes and their ioc codes
     * 
     * @return a comparator of two countries
     */
    public static Comparator<Country> compareCountries() {
        Comparator<Country> comp = new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                if (country1.getGold() != country2.getGold()) {
                    return Integer.compare(country2.gold, country1.gold);
                } else if (country1.getGold() == country2.getGold() && country1.getSilver() != country2.getSilver()) {
                    return Integer.compare(country2.silver, country1.silver);
                } else if (country1.getGold() == country2.getGold() && country1.getSilver() == country2.getSilver()
                        && country1.getBronze() != country2.getBronze()) {
                    return Integer.compare(country2.bronze, country1.bronze);
                } else {
                    return Integer.compare(country1.getIoc().getId(), country2.getIoc().getId());
                }
            }
        };
        return comp;
    }

    public String toString() {
        return ioc.getId() + " " + ioc.getIoc() + " " + name + " " + gold + " " + silver + " " + bronze + " " + medals;
    }

}
