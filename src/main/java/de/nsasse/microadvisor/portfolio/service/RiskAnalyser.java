package de.nsasse.microadvisor.portfolio.service;

import de.nsasse.microadvisor.portfolio.model.Enum.ExpectedYield;
import de.nsasse.microadvisor.portfolio.model.Enum.Portfolioweighting;
import de.nsasse.microadvisor.portfolio.model.Enum.RiskTolerance;

public class RiskAnalyser {

    public Portfolioweighting analyseRisk(RiskTolerance riskTolerance, ExpectedYield expectedYield) {

        switch (riskTolerance) {

            case HIGH_RISK:
                if (expectedYield == ExpectedYield.YIELD_FIRST) {
                    return Portfolioweighting.ADVISOR_75;
                } else if (expectedYield == ExpectedYield.BALANCED_YIELD) {
                    return Portfolioweighting.ADVISOR_50;
                } else {
                    return Portfolioweighting.ADVISOR_25;
                }
            case MID_RISK:
                if (expectedYield == ExpectedYield.YIELD_FIRST || expectedYield == ExpectedYield.BALANCED_YIELD) {
                    return Portfolioweighting.ADVISOR_25;
                } else {
                    return Portfolioweighting.ADVISOR_0;
                }
            case LOW_RISK:
                if (expectedYield == ExpectedYield.YIELD_FIRST) {
                    return Portfolioweighting.ADVISOR_25;
                } else {
                    return Portfolioweighting.ADVISOR_0;
                }
            default:
                return Portfolioweighting.ADVISOR_0;
        }
    }
}
