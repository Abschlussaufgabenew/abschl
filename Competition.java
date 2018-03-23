package edu.kit.informatik;

public class Competition {
    private String id;
    private int year;
    private String country;

    /**
     * Constructor of a competition instance
     * 
     * @param country country name
     * @param id country id
     * @param year year of the competition
     */
    public Competition(String country, String id, int year) {
        this.id = id;
        this.country = country;
        this.year = year;
    }

    /**
     * @return a string representation of the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the year in which the competition got added
     */
    public int getYear() {
        return year;
    }

    /**
     * @return a string representation of the country name
     */
    public String getCountry() {
        return country;
    }

}
