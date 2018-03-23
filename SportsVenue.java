package edu.kit.informatik;

import java.util.Comparator;

public class SportsVenue {

    private int id;
    private String countryName;
    private String location;
    private String name;
    private int openingYear;
    private int seatsNumber;

    /**
     * Constructor of a sports venue instance
     * 
     * @param id the unique identifier of a sports venue
     * @param countryName the host country name
     * @param location the location of the sportsvenue within a given country
     * @param name the name of sportsvenue
     * @param openingYear the opening year of the sportsvenue
     * @param seatsNumber the number of seats in the sports venue
     */
    public SportsVenue(int id, String countryName, String location, String name, int openingYear, int seatsNumber) {
        this.id = id;
        this.countryName = countryName;
        this.location = location;
        this.name = name;
        this.openingYear = openingYear;
        this.seatsNumber = seatsNumber;
    }

    /**
     * Compares two sports venues based on their number of seats and id
     * 
     * @return a comparator of two sports venues
     */
    public static Comparator<SportsVenue> compareSportsVenues() {
        Comparator<SportsVenue> comp = new Comparator<SportsVenue>() {
            @Override
            public int compare(SportsVenue sportsVenue1, SportsVenue sportsVenue2) {
                if (sportsVenue1.getSeatsNumber() != sportsVenue2.getSeatsNumber()) {
                    return Integer.compare(sportsVenue1.seatsNumber, sportsVenue2.seatsNumber);
                } else {
                    return Integer.compare(sportsVenue1.id, sportsVenue2.id);
                }
            }
        };
        return comp;
    }

    
    @Override
    public String toString() {
        return id + " " + location + " " + seatsNumber;
    }

    /**
     * @return a string representing the country name
     */
    public String getCountryname() {
        return countryName;
    }

    /**
     * @return an integer representing the id 
     */
    public int getId() {
        return id;
    }

    /**
     * @return an integer representing the number of seats 
     */
    public int getSeatsNumber() {
        return seatsNumber;
    }
}