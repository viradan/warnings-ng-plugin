package io.jenkins.plugins.analysis.warnings;

import javax.annotation.Nonnull;

import org.kohsuke.stapler.DataBoundConstructor;

import io.jenkins.plugins.analysis.core.model.StaticAnalysisTool;

import hudson.Extension;

import edu.hm.hafner.analysis.parser.violations.KlocWorkAdapter;

/**
 * Provides a parser and customized messages for Klocwork.
 *
 * @author Ullrich Hafner
 */
public class KlocWork extends StaticAnalysisTool {
    static final String ID = "klocwork";

    /** Creates a new instance of {@link KlocWork}. */
    @DataBoundConstructor
    public KlocWork() {
        // empty constructor required for stapler
    }

    @Override
    public KlocWorkAdapter createParser() {
        return new KlocWorkAdapter();
    }

    /** Descriptor for this static analysis tool. */
    @Extension
    public static class Descriptor extends StaticAnalysisToolDescriptor {
        public Descriptor() {
            super(ID);
        }

        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.Violations_Klocwork();
        }
    }
}