package edu.kit.informatik;

import java.util.Comparator;

public class IocCode {

    private String country;
    private int id;
    private String ioc;
    private int year;

    /**
     * Constructor of an IocCode instance
     * 
     * @param country country name
     * @param id unique identifiers
     * @param ioc the ioc code 
     * @param year the year it got added in
     */
    public IocCode(String country, int id, String ioc, int year) {
        this.country = country;
        this.id = id;
        this.ioc = ioc;
        this.year = year;
    }

    /**
     * Compares two ioc codes based on the year they got added in and the id
     * 
     * @return a comparator of two ioc codes
     */
    public static Comparator<IocCode> compareIocCodes() {
        Comparator<IocCode> comp = new Comparator<IocCode>() {
            @Override
            public int compare(IocCode IocCode1, IocCode IocCode2) {
                if (IocCode1.getYear() != IocCode2.getYear()) {
                    return Integer.compare(IocCode1.year, IocCode2.year);
                } else {
                    return Integer.compare(IocCode1.id, IocCode2.id);
                }
            }
        };
        return comp;
    }

    /**
     * @return the id of the ioc code
     */
    public int getId() {
        return id;
    }

    /**
     * @return the ioc code
     */
    public String getIoc() {
        return ioc;
    }

    /**
     * @return the year the ioc code got added in
     */
    public int getYear() {
        return year;
    }

    /**
     * @return the country represented by the ioc
     */
    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return year + " " + id + " " + ioc + " " + country;
    }

}