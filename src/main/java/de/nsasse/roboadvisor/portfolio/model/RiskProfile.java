package de.nsasse.roboadvisor.portfolio.model;

import de.nsasse.roboadvisor.portfolio.model.Enum.ExpectedYield;
import de.nsasse.roboadvisor.portfolio.model.Enum.RiskTolerance;

public class RiskProfile {

    private RiskTolerance riskTolerance;
    private ExpectedYield expectedYield;
    private Long duration;

    public RiskProfile() {
    }

    public RiskProfile(RiskTolerance riskTolerance, ExpectedYield expectedYield, Long duration) {
        this.riskTolerance = riskTolerance;
        this.expectedYield = expectedYield;
        this.duration = duration;
    }

    public ExpectedYield getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(ExpectedYield expectedYield) {
        this.expectedYield = expectedYield;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public RiskTolerance getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(RiskTolerance riskTolerance) {
        this.riskTolerance = riskTolerance;
    }
}
