package com.Flight.constraints;



public class Constraints {
    public static final String FlightNotFoundException  = "Flight not found with id %d";
    public static final String FLIGHT_LIMIT_EXCEEDED_MESSAGE = "Daily flight limit exceeded: There can be at most 3 flights for airline %s "
            + "between %s and %s";
    public static final String SOURCE_DEST_ERROR_MESSAGE = "You cannot choose the same airport for source and destination.";
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "An illegal argument exception occurred: %s";
    public static final String GENERAL_EXCEPTION_MESSAGE = "A general exception occurred: %s";
}
