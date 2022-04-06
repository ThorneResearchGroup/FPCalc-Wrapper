package tech.tresearchgroup.fpcalc;

import lombok.Data;
import picocli.CommandLine;
import tech.tresearchgroup.fpcalc.controller.FPCalcController;
import tech.tresearchgroup.fpcalc.model.FPCalcOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@Data
public class FPCalc implements Callable<Integer> {
    @CommandLine.Parameters(index = "0")
    private String file;

    @CommandLine.ArgGroup
    private FPCalcOptions fpCalcOptions;

    @Override
    public Integer call() {
        List<String> options = new ArrayList<>();
        options.add("fpcalc");
        options.addAll(FPCalcController.getOptions(fpCalcOptions));
        options.add(file);
        execute(options);
        return 0;
    }

    public String getFingerprint() {
        List<String> options = new ArrayList<>();
        options.add("fpcalc");
        options.addAll(FPCalcController.getOptions(fpCalcOptions));
        options.add(file);
        return execute(options);
    }

    public static String execute(List<String> options) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(options);
        System.out.println(options);
        try {
            Process process = processBuilder.start();
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                stringBuilder.append(line);
            }
            reader.close();
            /*
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                System.out.println(line);
            }
            errorReader.close();
             */
            process.waitFor();
            return stringBuilder.toString();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
