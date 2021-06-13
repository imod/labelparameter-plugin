package org.jvnet.jenkins.plugins.nodelabelparameter;

import org.jvnet.jenkins.plugins.nodelabelparameter.node.NodeEligibility;
import org.jvnet.jenkins.plugins.nodelabelparameter.wrapper.TriggerNextBuildWrapper;

import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;

/**
 * 
 * @author Dominik Bartholdi (imod)
 */
public interface MultipleNodeDescribingParameterDefinition {

    /**
     * Get the requested build result definition
     * 
     * @return
     */
    public String getTriggerIfResult();

    /**
     * The name of the parameter
     * 
     * @return the name of the parameter
     */
    public String getName();

    /**
     * gets the strategy which decides whether a node should be ignored or not 
     * 
     * @return the eligibility definition
     */
    public NodeEligibility getNodeEligibility();

    /**
     * Callback to allow the parameter definition to do a final validation if everything is OK to proceed. Implementations are asked to throw a runtime exception if something is not OK and the build
     * should be stopped.
     * 
     * @param build
     *            build to be validated
     * @param launcher
     *            build launcher
     * @param listener
     *            provides access to the log stream
     */
    public void validateBuild(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener);

    /**
     * Returns the wrapper to trigger the next build
     * 
     * @return <code>null</code> if there is no new build to be triggered.
     */
    public TriggerNextBuildWrapper createBuildWrapper();

}
