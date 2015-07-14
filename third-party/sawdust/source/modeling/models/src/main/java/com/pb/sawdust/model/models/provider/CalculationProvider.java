package com.pb.sawdust.model.models.provider;

/**
 * The {@code CalculationProvider} interface is used to specify data providers which hold calculated variables. A calculated
 * variable is one which is composed as a function of other variables held in the provider, and which is generally calculated
 * by the provider. This interface specifies methods which allow access to information about the calculated variables.
 *
 * @author crf <br/>
 *         Started 2/14/11 10:46 AM
 */
public interface CalculationProvider {
    /**
     * Get a {@code VariableCalculation} describing the specified variable. If the specified variable exists in the provider
     * but is not calculated, then the returned {@code VariableCalculation} will indicate this.
     *
     * @param variable
     *        The variable.
     *
     * @return the variable calculation corresponding to {@code variable}.
     *
     * @throws IllegalArgumentException if {@code variable} is not found in this provider.
     */
    VariableCalculation getCalculation(String variable);

    /**
     * Get a {@code VariableCalculation} describing the specified variable in which all arguments will be variables which
     * themselves are not calculated. That is, if the specified variable is a function of other calculated variables, then
     * those variables' calculations will be (fully) resolved and composed into a new {@code VariableCalculation} which
     * only contains non-calculated variables. This method can be useful if a calculation not involving nested calculations
     * is needed, but this may result in inneficiencies (through repeated calculations) if used extensively.
     *
     * @param variable
     *        The variable.
     *
     * @return the variable calculation corresponding to {@code variable}.
     *
     * @throws IllegalArgumentException if {@code variable} is not found in this provider.
     */
    VariableCalculation getResolvedCalculation(String variable);

    /**
     * Returns true if any of the variables this provider contains are actually calculated.  That is, for at least one
     * {@code VariableCalculation} returned by {@link #getCalculation(String)} {@link com.pb.sawdust.model.models.provider.VariableCalculation#isCalculated()}
     * returns {@code true}.
     *
     * @return {@code true} if any of the variables in this provider are calculated, {@code false} if not.
     */
    boolean containsCalculatedVariables();
}