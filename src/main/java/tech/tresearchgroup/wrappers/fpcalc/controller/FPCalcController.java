package tech.tresearchgroup.wrappers.fpcalc.controller;

import tech.tresearchgroup.wrappers.fpcalc.model.FPCalcOptions;

import java.util.ArrayList;
import java.util.List;

public class FPCalcController {
    public static List<String> getOptions(FPCalcOptions fpCalcOptions) {
        List<String> optionsList = new ArrayList<>();
        if(fpCalcOptions.getFormat() != null) {
            optionsList.add("-format");
            optionsList.add(fpCalcOptions.getFormat());
        }
        if(fpCalcOptions.getRate() != null) {
            optionsList.add("-rate");
            optionsList.add(fpCalcOptions.getRate());
        }
        if(fpCalcOptions.getChannels() != null) {
            optionsList.add("-channels");
            optionsList.add(fpCalcOptions.getChannels());
        }
        if(fpCalcOptions.getLength() != null) {
            optionsList.add("-length");
            optionsList.add(fpCalcOptions.getLength());
        }
        if(fpCalcOptions.getChunk() != null) {
            optionsList.add("-chunk");
            optionsList.add(fpCalcOptions.getChunk());
        }
        if(fpCalcOptions.getAlgorithm() != null) {
            optionsList.add("-algorithm");
            optionsList.add(fpCalcOptions.getAlgorithm());
        }
        if(fpCalcOptions.isOverlap()) {
            optionsList.add("-overlap");
        }
        if(fpCalcOptions.isTs()) {
            optionsList.add("-ts");
        }
        if(fpCalcOptions.isRaw()) {
            optionsList.add("-raw");
        }
        if(fpCalcOptions.isSigned()) {
            optionsList.add("-signed");
        }
        if(fpCalcOptions.isJson()) {
            optionsList.add("-json");
        }
        if(fpCalcOptions.isText()) {
            optionsList.add("-text");
        }
        if(fpCalcOptions.isPlain()) {
            optionsList.add("-plain");
        }
        if(fpCalcOptions.isVersion()) {
            optionsList.add("-version");
        }
        return optionsList;
    }
}
