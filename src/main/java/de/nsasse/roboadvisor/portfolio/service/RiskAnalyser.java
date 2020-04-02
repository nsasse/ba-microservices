package de.nsasse.roboadvisor.portfolio.service;

import de.nsasse.roboadvisor.portfolio.model.Enum.ExpectedYield;
import de.nsasse.roboadvisor.portfolio.model.Enum.PortfolioWeighting;
import de.nsasse.roboadvisor.portfolio.model.RiskProfile;

public class RiskAnalyser {

    public PortfolioWeighting analyseRisk(RiskProfile riskProfile) {
        switch (riskProfile.getRiskTolerance()) {
            case HIGH_RISK:
                if (riskProfile.getExpectedYield() == ExpectedYield.YIELD_FIRST) {
                    return PortfolioWeighting.ADVISOR_75;
                } else if (riskProfile.getExpectedYield() == ExpectedYield.BALANCED_YIELD) {
                    return PortfolioWeighting.ADVISOR_50;
                } else {
                    return PortfolioWeighting.ADVISOR_25;
                }
            case MID_RISK:
                if (riskProfile.getExpectedYield() == ExpectedYield.YIELD_FIRST || riskProfile.getExpectedYield() == ExpectedYield.BALANCED_YIELD) {
                    return PortfolioWeighting.ADVISOR_25;
                } else {
                    return PortfolioWeighting.ADVISOR_0;
                }
            case LOW_RISK:
                if (riskProfile.getExpectedYield() == ExpectedYield.YIELD_FIRST) {
                    return PortfolioWeighting.ADVISOR_25;
                } else {
                    return PortfolioWeighting.ADVISOR_0;
                }
            default:
                return PortfolioWeighting.ADVISOR_0;
        }
    }
}
