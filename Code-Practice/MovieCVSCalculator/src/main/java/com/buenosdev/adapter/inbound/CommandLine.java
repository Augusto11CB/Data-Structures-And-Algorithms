package com.buenosdev.adapter.inbound;

import com.buenosdev.adapter.outbond.persistency.MovieRepositoryAdapter;
import com.buenosdev.core.domain.service.MovieService;
import com.buenosdev.core.domain.service.MovieServiceImpl;
import com.buenosdev.core.domain.service.action.AverageDurationCommand;
import com.buenosdev.core.domain.service.action.AverageRatingCommand;
import com.buenosdev.core.domain.service.action.Command;
import com.buenosdev.core.domain.service.action.CommandType;
import com.buenosdev.core.domain.service.action.CountCommand;
import com.buenosdev.core.port.MovieRepositoryPort;
import com.buenosdev.infrastructure.persistency.CsvMovieRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLine {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java CommandLineApp <csv_file_path> <command> [<filter>]");
            return;
        }

        String csvFilePath = args[0];
//        String command = args[1];
//        String filter = args.length > 2 ? args[2] : "";

//        try {
//            Map<CommandType, Command> commands = buildCommand();
//
//            CsvMovieRepository cvsRepository = new CsvMovieRepository(csvFilePath);
//            MovieRepositoryPort movieRepository = new MovieRepositoryAdapter(cvsRepository);
//            MovieService movieService = new MovieServiceImpl(commands, movieRepository);
//
//            // Execute commands
//            Double averageDuration = movieService.executeCommandForMovies(CommandType.AVERAGE_DURATION);
//            Integer count = movieService.executeCommandForMovies(CommandType.COUNT);
//
//            // Print results
//            System.out.println("Average Duration: " + averageDuration);
//            System.out.println("Count: " + count);
//
//        } catch (IOException e) {
//            System.err.println("Failed to load CSV file: " + e.getMessage());
//        }

        Map<CommandType, Command> commands = buildCommand();
        CsvMovieRepository cvsRepository = new CsvMovieRepository(csvFilePath);
        MovieRepositoryPort movieRepository = new MovieRepositoryAdapter(cvsRepository);
        MovieService movieService = new MovieServiceImpl(commands, movieRepository);


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the command type (AVERAGE_DURATION or COUNT): ");
        String commandTypeInput = scanner.nextLine().toUpperCase();

        try {
            CommandType commandType = CommandType.valueOf(commandTypeInput);
            switch (commandType) {
                case AVERAGE_DURATION:
                    Double averageDuration = movieService.executeCommandForMovies(commandType);
                    System.out.println("Average Duration: " + averageDuration);
                    break;
                case COUNT:
                    Integer count = movieService.executeCommandForMovies(commandType);
                    System.out.println("Movie Count: " + count);
                    break;
                default:
                    System.out.println("Invalid command type");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid command type entered. Please enter either AVERAGE_DURATION or COUNT.");
        }
    }



    private static Map<CommandType, Command> buildCommand() {

        Map<CommandType, Command> commands = new HashMap<>();

        var averageCommand = new AverageDurationCommand();
        var averageRatingCommand = new AverageRatingCommand();
        var averageCountCommand = new CountCommand();

        commands.put(averageCommand.getCommandType(), averageCommand);
        commands.put(averageCountCommand.getCommandType(), averageCountCommand);
        commands.put(averageRatingCommand.getCommandType(), averageRatingCommand);

        return commands;
    }
}
