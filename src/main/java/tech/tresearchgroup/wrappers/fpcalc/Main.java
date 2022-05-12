package tech.tresearchgroup.wrappers.fpcalc;

import picocli.CommandLine;
import tech.tresearchgroup.wrappers.fpcalc.controller.FPCalcController;
import tech.tresearchgroup.wrappers.fpcalc.model.FPCalcOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Main implements Callable<Integer> {
    @CommandLine.Parameters(index = "0")
    private String file;

    @CommandLine.ArgGroup
    private FPCalcOptions fpCalcOptions;

    @Override
    public Integer call() {
        List<String> options = new ArrayList<>();
        options.add("fpcalc");
        if(fpCalcOptions != null) {
            options.addAll(FPCalcController.getOptions(fpCalcOptions));
        }
        options.add(file);
        return execute(options);
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }

    public static int execute(List<String> options) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(options);
        System.out.println(options);
        try {
            Process process = processBuilder.start();
            String line;
            /*
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
             */
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
            errorReader.close();
            return process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
