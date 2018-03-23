package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OlympicGames {

    private Map<String, Admin> admins = new HashMap<>();
    private List<Admin> loggedInUsers = new LinkedList<>();
    private Map<Integer, SportsVenue> sportsVenues = new HashMap<>();
    private List<IocCode> iocCodes = new ArrayList<>();
    private List<OlympicSport> sports = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();

    /**
     * Adds an admin to the system
     * 
     * @param firstName the admin's first name
     * @param lastName the admin's last name
     * @param userName the admin's user name
     * @param passWord the password associated with the user name
     * @throws InputException if the password or the username are invalid
     */
    public void addAdmin(String firstName, String lastName, String userName, String passWord) throws InputException {
        if (userName.length() < 4 || userName.length() > 8) {
            throw new InputException("Please choose a valid username");
        } else if (passWord.length() < 8 || passWord.length() > 12) {
            throw new InputException("Please choose a valid password");
        } else {
            Admin admin = new Admin(firstName, lastName, userName, passWord);
            if (admins.containsKey(userName)) {
                throw new InputException("Username not available ");
            } else {
                admins.put(userName, admin);
            }
        }
    }

    /**
     * Loggs an admin in
     * 
     * @param userName the user name of the admin
     * @param passWord the password associated with the username
     * @throws InputException if user is not registred or the password is wron
     */
    public void loginAdmin(String userName, String passWord) throws InputException {
        if (!admins.containsKey(userName)) {
            throw new InputException("User does not exist yet");
        } else if (!passWord.equals(admins.get(userName).getPassWord())) {
            throw new InputException("Incorrect password");
        } else {
            loggedInUsers.add(admins.get(userName));
        }
    }

    /**
     * Logs an admin out
     * 
     * @throws InputException if there is no admins logged in
     */
    public void logoutAdmin() throws InputException {
        if (loggedInUsers.isEmpty()) {
            throw new InputException("No logged in users");
        } else {
            loggedInUsers.clear();
        }
    }

    /**
     * Adds a sports venue to the system
     * 
     * @param id the id of the sports venue
     * @param countryName the name of the host country 
     * @param location the location of the sports venue
     * @param name the name of the sports venue
     * @param openingYear the year of opening
     * @param seatsNumber the number of seats in the sports venue
     * @throws InputException if the sport venue has been already added
     */
    public void addSportsVenue(int id, String countryName, String location, String name, int openingYear,
            int seatsNumber) throws InputException {
        SportsVenue sportsVenue = new SportsVenue(id, countryName, location, name, openingYear, seatsNumber);
        if (sportsVenues.containsKey(id)) {
            throw new InputException("Sports venue already exists");
        } else {
            sportsVenues.put(id, sportsVenue);
        }

    }

    /**
     * Lists the sports venues in a the country named countryName
     * 
     * @param countryName the country name 
     * @throws InputException if there is a problem with the listing
     */
    public void listSportsVenues(String countryName) throws InputException {
        ArrayList<SportsVenue> sportsVenuesToList = new ArrayList<>();
        int n = 1;
        for (Map.Entry<Integer, SportsVenue> entry : sportsVenues.entrySet()) {
            if (entry.getValue().getCountryname().equals(countryName)) {
                sportsVenuesToList.add(entry.getValue());
            }
        }

        Collections.sort(sportsVenuesToList, SportsVenue.compareSportsVenues());
        for (SportsVenue sportsVenue : sportsVenuesToList) {
            Terminal.printLine(n + " " + sportsVenue);
            n++;
        }

    }

    /**
     * Adds an olympic sport to the system
     * 
     * @param sportsType the type of the olympic sport
     * @param discipline the discipline added
     * @throws InputException if the sport or the discipline alreay added
     */
    public void addOlympicSport(String sportsType, String discipline) throws InputException {
        SportDiscipline sportDiscipline = new SportDiscipline(discipline);
        OlympicSport olympicSport = new OlympicSport(sportsType);
        if (sports.contains(olympicSport)) {
            for (OlympicSport sport : sports) {
                if (sport.equals(olympicSport)) {
                    if (sport.getDisciplines().contains(sportDiscipline)) {
                        throw new InputException("Sport discipline already added");
                    } else {
                        sport.addDiscipline(sportDiscipline);
                    }
                }
            }
        } else {
            olympicSport.addDiscipline(sportDiscipline);
            sports.add(olympicSport);
        }

    }

    /**
     * List the olympic sports present in the system
     * 
     * @throws InputException if there is a problem with the listing
     */
    public void listOlympicSports() throws InputException {
        Collections.sort(sports, OlympicSport.compareOlympicSports());
        for (OlympicSport sport : sports) {
            Collections.sort(sport.getDisciplines(), SportDiscipline.compareSportDisciplines());
            for (SportDiscipline sportDiscipline : sport.getDisciplines()) {
                Terminal.printLine(sport + " " + sportDiscipline);
            }
        }
    }

    /**
     * Adds an ioc code to the country named countryName
     * 
     * @param countryName the name of the country
     * @param id the unique id of the country
     * @param ioc the ioc code
     * @param year the year of the adding
     */
    public void addIocCode(String countryName, int id, String ioc, int year) {
        IocCode iocCode = new IocCode(countryName, id, ioc, year);
        iocCodes.add(iocCode);
        Country country = new Country(countryName, iocCode);
        countries.add(country);
    }

    /**
     * Lists the ioc codes present in the system
     */
    public void listIocCodes() {
        Collections.sort(iocCodes, IocCode.compareIocCodes());
        for (IocCode iocCode : iocCodes) {
            Terminal.printLine(iocCode);
        }
    }

    /**
     * Adds an athlete to the system
     * 
     * @param id the unique identifier of an athlete
     * @param firstName the first name of the athlete
     * @param lastName the last name of the athlete
     * @param countryName the nationality of the athlete
     * @param sport the sport type
     * @param discipline the sorpt discipline
     * @throws InputException if the id is invalid or the sport not present in the system
     */
    public void addAthlete(String id, String firstName, String lastName, String countryName, String sport,
            String discipline) throws InputException {
        OlympicSport olympicSport = new OlympicSport(sport);
        SportDiscipline sportDiscipline = new SportDiscipline(discipline);

        if (id.length() != 4) {
            throw new InputException("Invalid ID");
        }

        if (!sports.contains(olympicSport)) {
            throw new InputException("Sport not registred");
        }

        Athlete athlete = new Athlete(id, firstName, lastName, countryName);
        for (OlympicSport olympicSport1 : sports) {
            if (olympicSport1.getSportsType().equals(sport)) {
                for (SportDiscipline sportDiscipline1 : olympicSport1.getDisciplines()) {
                    if (sportDiscipline1.getDiscipline().equals(discipline)) {
                        sportDiscipline1.addAthlete(id, athlete);
                    }
                }
            }
        }

        for (Country country : countries) {
            if (country.getName().equals(countryName)) {
                country.addAthlete(athlete);
            }
        }

    }

    /**
     * Lists the athletes that play the sport sprot and discipline discipline
     * 
     * @param sport the sport type
     * @param discipline the discipline 
     * @throws InputException if the sport is not registred
     */
    public void summaryAthletes(String sport, String discipline) throws InputException {
        OlympicSport testSport = new OlympicSport(sport);
        SportDiscipline testDiscipline = new SportDiscipline(discipline);
        if (!sports.contains(testSport)) {
            throw new InputException("Sport is not registred");
        }

        for (OlympicSport olympicSport : sports) {
            if (olympicSport.equals(testSport)) {
                for (SportDiscipline sportDiscipline : olympicSport.getDisciplines()) {
                    Collections.sort(sportDiscipline.getAthletes(), Athlete.compareAthletes());
                    for (Athlete athlete : sportDiscipline.getAthletes()) {
                        Terminal.printLine(athlete);
                    }
                }
            }
        }

    }

    /**
     * Adds a competition to the system
     * 
     * @param id the id of the competition
     * @param year the year in which the competition is added
     * @param countryName the name of the country
     * @param sport the sport type
     * @param discipline the discipline
     * @param gold the number of gold medals
     * @param silver the number of silver medals
     * @param bronze the number of bronze medals
     * @throws InputException if the year is invalid
     */
    public void addCompetition(String id, int year, String countryName, String sport, String discipline, int gold,
            int silver, int bronze) throws InputException {
        if (year < 1926 || year > 2018) {
            throw new InputException("Choose a year between 1926 and 2018");
        }

        Competition competition = new Competition(countryName, id, year);
        OlympicSport olympicSport = new OlympicSport(sport);
        SportDiscipline sportDiscipline = new SportDiscipline(discipline);

        for (OlympicSport olympic : sports) {
            if (olympic.equals(olympicSport)) {
                for (SportDiscipline sortDiscipline : olympic.getDisciplines()) {
                    if (sortDiscipline.equals(sortDiscipline)) {
                        for (Athlete athlete : sortDiscipline.getAthletes()) {
                            if (athlete.getId().equals(id)) {
                                athlete.setGoldMedals(gold);
                                athlete.setSilverMedals(silver);
                                athlete.setBronzeMedals(bronze);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Lists the results of the olympic games
     * 
     * @throws InputException if there is a problem with the listing
     */
    public void olympicMedalTable() throws InputException {
        int n = 1;
        Collections.sort(countries, Country.compareCountries());
        for (Country country : countries) {
            country.calculateGoldMedals();
            country.calculateSilverMedals();
            country.calculateBronzeMedals();
            country.calculateMedals();
            Terminal.printLine(n + " " + country);
            n++;

        }
    }

    /**
     * @return a list of the logged in admins
     */
    public List<Admin> getLoggedInUsers() {
        return loggedInUsers;
    }

    /**
     * @param loggedInUsers list of logged in users
     */
    public void setLoggedInUsers(List<Admin> loggedInUsers) {
        this.loggedInUsers = loggedInUsers;
    }
}
