package tech.tresearchgroup.wrappers.fpcalc.model;

import lombok.Data;
import picocli.CommandLine;

@Data
public class FPCalcOptions {
    @CommandLine.Option(names = "-format", description = "Set the input format name")
    private String format;

    @CommandLine.Option(names = "-rate", description = "Set the sample rate of the input audio")
    private String rate;

    @CommandLine.Option(names = "-channels", description = "Set the number of channels in the input audio")
    private String channels;

    @CommandLine.Option(names = "-length", description = "Restrict the duration of the processed input audio (default 120)")
    private String length;

    @CommandLine.Option(names = "-chunk", description = "Split the input audio into chunks of this duration")
    private String chunk;

    @CommandLine.Option(names = "-algorithm", description = "Set the algorithm method (default 2)")
    private String algorithm;

    @CommandLine.Option(names = "-overlap", description = "Overlap the chunks slightly to make sure audio on the edges is fingerprinted")
    private boolean overlap;

    @CommandLine.Option(names = "-ts", description = "Output UNIX timestamps for chunked results, useful when fingerprinting real-time audio stream")
    private boolean ts;

    @CommandLine.Option(names = "-raw", description = "Output fingerprints in the uncompressed format")
    private boolean raw;

    @CommandLine.Option(names = "-signed", description = "Change the uncompressed format from unsigned integers to signed (for pg_acoustid compatibility)")
    private boolean signed;

    @CommandLine.Option(names = "-json", description = "Print the output in JSON format")
    private boolean json;

    @CommandLine.Option(names = "-text", description = "Print the output in text format")
    private boolean text;

    @CommandLine.Option(names = "-plain", description = "Print the just the fingerprint in text format")
    private boolean plain;

    @CommandLine.Option(names = "-version", description = "Print version information")
    private boolean version;
}
