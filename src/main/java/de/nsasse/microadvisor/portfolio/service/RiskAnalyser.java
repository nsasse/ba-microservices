package de.nsasse.microadvisor.portfolio.service;

import de.nsasse.microadvisor.portfolio.model.Enum.ExpectedYeald;
import de.nsasse.microadvisor.portfolio.model.Enum.Portfolioweighting;
import de.nsasse.microadvisor.portfolio.model.Enum.RiskTolerance;

public class RiskAnalyser {

    public Portfolioweighting analyseRisk(RiskTolerance riskTolerance, ExpectedYeald expectedYeald, Integer duration) {

        if (riskTolerance == RiskTolerance.NO_RISK) {
            return Portfolioweighting.ADVISOR_0;
        } else if (riskTolerance == RiskTolerance.LOW_RISK) {
            if (expectedYeald == ExpectedYeald.OUTSTRIPPING_INTEREST) {
                return Portfolioweighting.ADVISOR_0;
            } else {
                return Portfolioweighting.ADVISOR_25;
            }
        } else if (riskTolerance == RiskTolerance.HIGH_RISK && expectedYeald == ExpectedYeald.YEALD_FIRST && duration > 5) {
            return Portfolioweighting.ADVISOR_75;
        } else {
            return Portfolioweighting.ADVISOR_50;
        }
    }
}
