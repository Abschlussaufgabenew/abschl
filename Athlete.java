package edu.kit.informatik;

import java.util.Comparator;

public class Athlete {

    private String id;
    private String firstName;
    private String lastName;
    private String countryName;
    private int medalNumber;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;

    /**
     * Constructor of an anthlete instance
     * 
     * @param id a unique identifier of an athlete
     * @param firstName the first name of the athelete
     * @param lastName the last name of the athlete
     * @param countryName the nationality of the athlete
     */
    public Athlete(String id, String firstName, String lastName, String countryName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countryName = countryName;
    }

    /**
     * @return a string representation of the id 
     */
    public String getId() {
        return id;
    }

    /**
     * @return the athlete's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the athlete's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the athlete's nationality
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @return the number of medals earned by the athlete
     */ 
    public int getMedalNumber() {
        return medalNumber;
    }

    /**
     * @param medalNumber number of medals
     */
    public void setMedalNumber(int medalNumber) {
        this.medalNumber = medalNumber;
    }

    /**
     * @return the number of gold medals won by the athlete
     */
    public int getGoldMedals() {
        return goldMedals;
    }

    /**
     * @param goldMedals number of gold medals to set
     */
    public void setGoldMedals(int goldMedals) {
        this.goldMedals = goldMedals;
    }

    /**
     * @return the number of silver medals won by the athlete
     */
    public int getSilverMedals() {
        return silverMedals;
    }

    /**
     * @param silverMedals number of silver medals
     */
    public void setSilverMedals(int silverMedals) {
        this.silverMedals = silverMedals;
    }

    /**
     * @return the number of bronze medals won by the athlete
     */
    public int getBronzeMedals() {
        return bronzeMedals;
    }

    /**
     * @param bronzeMedals number of bronze medals
     */
    public void setBronzeMedals(int bronzeMedals) {
        this.bronzeMedals = bronzeMedals;
    }

    public String toString() {
        return id + " " + firstName + " " + lastName + " " + medalNumber;
    }

    /**
     * Compares two athletes based on the number of medals and the id of the athletes
     * 
     * @return a comparator of two athletes
     */
    public static Comparator<Athlete> compareAthletes() {
        Comparator<Athlete> comp = new Comparator<Athlete>() {
            @Override
            public int compare(Athlete athlete1, Athlete athlete2) {
                if (athlete1.getMedalNumber() != athlete2.getMedalNumber()) {
                    return Integer.compare(athlete2.medalNumber, athlete1.medalNumber);
                } else {
                    return Integer.compare(Integer.parseInt(athlete1.id), Integer.parseInt(athlete2.id));
                }
            }
        };
        return comp;
    }

}