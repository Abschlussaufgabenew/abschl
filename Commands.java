package edu.kit.informatik;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public enum Commands {

    /**
     * the add-admin command to add an admin to the system
     *
     */
    ADD_ADMIN("add-admin (\\w+);(\\w+);(\\w+);(\\w+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            String firstName = matcher.group(1);
            String lastName = matcher.group(2);
            String userName = matcher.group(3);
            String passWord = matcher.group(4);

            olympicGames.addAdmin(firstName, lastName, userName, passWord);
            Terminal.printLine("OK");
        }

    },

    /**
     * the login-admin command to log an admin in
     *
     */
    LOGIN_ADMIN("login-admin (\\w+);(\\w+)") {

        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            String userName = matcher.group(1);
            String passWord = matcher.group(2);

            olympicGames.loginAdmin(userName, passWord);
            Terminal.printLine("OK");
        }
    },

    /**
     * the logout admin command to log an admin out
     *
     */
    LOGOUT_ADMIN("logout-admin") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            olympicGames.logoutAdmin();
            Terminal.printLine("OK");
        }
    },

    /**
     * the add-sports-venue command to add a sports venue to the system
     *
     */
    ADD_SPORTS_VENUE("add-sports-venue (\\d+);(\\w+);(\\w+);(\\w+);(\\d+);(\\d+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            int id = Integer.parseInt(matcher.group(1));
            String countryName = matcher.group(2);
            String location = matcher.group(3);
            String name = matcher.group(4);
            int openingYear = Integer.parseInt(matcher.group(5));
            int seatsNumber = Integer.parseInt(matcher.group(6));

            olympicGames.addSportsVenue(id, countryName, location, name, openingYear, seatsNumber);
            Terminal.printLine("OK");
        }
    },

    /**
     * the list-sports-venues command to list the sports venues
     *
     */
    LIST_SPORTS_VENUES("list-sports-venues (\\w+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            String countryName = matcher.group(1);

            olympicGames.listSportsVenues(countryName);

        }
    },

    /**
     * the add-olympic-sport command to add an olympic sport to the system
     *
     */
    ADD_OLYMPIC_SPORT("add-olympic-sport (\\w+);(\\w+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {

            String sportsType = matcher.group(1);
            String sportsDiscipline = matcher.group(2);

            olympicGames.addOlympicSport(sportsType, sportsDiscipline);
            Terminal.printLine("OK");
        }
    },

    /**
     * the list-olympic-sports command to list the olympic sports
     *
     */
    LIST_OLYMPIC_SPORTS("list-olympic-sports") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {

            olympicGames.listOlympicSports();

        }
    },

    /**
     * the add-ioc-code command to add an ioc code to the system
     *
     */
    ADD_IOC_CODE("add-ioc-code (\\d+);(\\w+);(\\w+);(\\d+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            int id = Integer.parseInt(matcher.group(1));
            String ioc = matcher.group(2);
            String country = matcher.group(3);
            int year = Integer.parseInt(matcher.group(4));

            olympicGames.addIocCode(country, id, ioc, year);
            Terminal.printLine("OK");
        }
    },

    /**
     * the list-ioc-codes command to list the ioc codes in the system
     *
     */
    LIST_IOC_CODES("list-ioc-codes") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            olympicGames.listIocCodes();
        }
    },

    /**
     * the add-athlete command to add an athlete to the system
     *
     */
    ADD_ATHLETE("add-athlete (\\d+);(\\w+);(\\w+);(\\w+);(\\w+);(\\w+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            String id = matcher.group(1);
            String firstName = matcher.group(2);
            String lastName = matcher.group(3);
            String country = matcher.group(4);
            String sport = matcher.group(5);
            String discipline = matcher.group(6);
            olympicGames.addAthlete(id, firstName, lastName, country, sport, discipline);
            Terminal.printLine("OK");
        }
    },

    /**
     * the summary-athletes command to list the athletes present in the system
     *
     */
    SUMMARY_ATHLETES("summary-athletes (\\w+);(\\w+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {

            String sport = matcher.group(1);
            String discipline = matcher.group(2);
            olympicGames.summaryAthletes(sport, discipline);
        }
    },

    /**
     * the add-competition command to add a competition to the system
     *
     */
    ADD_COMPETITION("add-competition (\\w+);(\\d+);(\\w+);(\\w+);(\\w+);(\\d+);(\\d+);(\\d+)") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {

            String id = matcher.group(1);
            int year = Integer.parseInt(matcher.group(2));
            String countryName = matcher.group(3);
            String sport = matcher.group(4);
            String discipline = matcher.group(5);
            int gold = Integer.parseInt(matcher.group(6));
            int silver = Integer.parseInt(matcher.group(7));
            int bronze = Integer.parseInt(matcher.group(8));

            olympicGames.addCompetition(id, year, countryName, sport, discipline, gold, silver, bronze);
            Terminal.printLine("OK");

        }
    },

    /**
     * the olympic-medal-table command to list the results of the olympic games
     *
     */
    OLYMPIC_MEDAL_TABLE("olympic-medal-table") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            olympicGames.olympicMedalTable();
        }
    },

    /**
     * the reset command to restart the olympic games
     *
     */
    RESET("reset") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            List<Admin> loggedInUsers = olympicGames.getLoggedInUsers();
            olympicGames = new OlympicGames();
            olympicGames.setLoggedInUsers(loggedInUsers);
            Terminal.printLine("OK");
        }
    },

    /**
     * the quit command to quit the programm
     *
     */
    QUIT("quit") {
        @Override
        public void execute(MatchResult matcher, OlympicGames olympicGames) throws InputException {
            isRunning = false;
        }
    };

    private static boolean isRunning = true;
    private Pattern pattern;

    /**
     * Constructs a new command.
     * 
     * @param pattern The regex pattern to use for command validation and processing.
     */
    Commands(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    /**
     * Executes a command 
     * 
     * @param matcher the regex matcher that contains the groups of input of the command 
     * 
     * @param olympicGame the instance of the olympicGames 
     * 
     * @throws InputException if the command contains syntactical or symantical errors.
     */
    public abstract void execute(MatchResult matcher, OlympicGames olympicGame) throws InputException;

    /**
     * Checks if the program is still running or was exited.
     * 
     * @return true if the programm is still running and false otherwise
     */
    public boolean isRunning() {
        return isRunning;
    }

    public static Commands executeMatching(String input, OlympicGames olympicGame) throws InputException {
        for (Commands command : Commands.values()) {
            Matcher matcher = command.pattern.matcher(input);
            if (matcher.matches()) {
                command.execute(matcher, olympicGame);
                return command;
            }
        }

        throw new InputException("not a valid command!");
    }
}