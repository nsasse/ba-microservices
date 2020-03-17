package de.nsasse.microadvisor.portfolio.model;

import de.nsasse.microadvisor.portfolio.model.Enum.ExpectedYield;
import de.nsasse.microadvisor.portfolio.model.Enum.RiskTolerance;

public class RiskProfile {

    private ExpectedYield expectedYield;
    private Integer duration;
    private RiskTolerance riskTolerance;

    public RiskProfile() {
    }

    public RiskProfile(ExpectedYield expectedYield, Integer duration, RiskTolerance riskTolerance) {
        this.expectedYield = expectedYield;
        this.duration = duration;
        this.riskTolerance = riskTolerance;
    }

    public ExpectedYield getExpectedYield() {
        return expectedYield;
    }

    public void setExpectedYield(ExpectedYield expectedYield) {
        this.expectedYield = expectedYield;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public RiskTolerance getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(RiskTolerance riskTolerance) {
        this.riskTolerance = riskTolerance;
    }
}
