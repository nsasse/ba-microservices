package de.nsasse.microadvisor.portfolio.model;

import de.nsasse.microadvisor.portfolio.model.Enum.ExpectedYeald;
import de.nsasse.microadvisor.portfolio.model.Enum.RiskTolerance;

public class RiskProfile {

    private ExpectedYeald expectedYeald;
    private Integer duration;
    private RiskTolerance riskTolerance;

    public RiskProfile() {
    }

    public RiskProfile(ExpectedYeald expectedYeald, Integer duration, RiskTolerance riskTolerance) {
        this.expectedYeald = expectedYeald;
        this.duration = duration;
        this.riskTolerance = riskTolerance;
    }

    public ExpectedYeald getExpectedYeald() {
        return expectedYeald;
    }

    public void setExpectedYeald(ExpectedYeald expectedYeald) {
        this.expectedYeald = expectedYeald;
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
