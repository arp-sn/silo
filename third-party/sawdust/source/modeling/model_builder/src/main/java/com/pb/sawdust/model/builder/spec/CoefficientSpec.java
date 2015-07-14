package com.pb.sawdust.model.builder.spec;

import java.util.Map;

/**
 * The {@code CoefficientSpec} ...
 *
 * @author crf <br/>
 *         Started 4/11/11 4:31 PM
 */
public interface CoefficientSpec {
    static final String DEFAULT_COEFFICIENT_NAME = "{--coefficient--}";
    Map<String,Double> getCoefficient(); //may parse a given coefficient to different model components (such as choices)
}