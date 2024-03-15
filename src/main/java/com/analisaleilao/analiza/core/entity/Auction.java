package com.analisaleilao.analiza.core.entity;

import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.List;

public class Auction {

    public enum AuctionType {
        JUDICIAL,
        EXTRA
    }

    public static class AuctionCalculation {
        private BigDecimal auctioneerCommisionPercent;
        private BigDecimal auctioneerCommisionValue;
        private BigDecimal itbiPercent;
        private BigDecimal itbiValue;
        private BigDecimal propertyRegistrationValue; // registro do Imovel
        private BigDecimal lawyerFee;
        private BigDecimal renovationValue;
        private BigDecimal others;

        public BigDecimal getAuctioneerCommisionPercent() {
            return auctioneerCommisionPercent;
        }

        public BigDecimal getAuctioneerCommisionValue() {
            return auctioneerCommisionValue;
        }

        public BigDecimal getItbiPercent() {
            return itbiPercent;
        }

        public BigDecimal getItbiValue() {
            return itbiValue;
        }

        public BigDecimal getPropertyRegistrationValue() {
            return propertyRegistrationValue;
        }

        public BigDecimal getLawyerFee() {
            return lawyerFee;
        }

        public BigDecimal getRenovationValue() {
            return renovationValue;
        }

        public BigDecimal getOthers() {
            return others;
        }
    }

    public static class SalesCalculation {
        private Integer salesDeadlineAmount;
        private BigDecimal iptuMonthlyValue;
        private BigDecimal condoMonthlyValue;

        //private BigDecimal totalMonthly; // total do custo estimado na qtde de meses
        private BigDecimal brokerCommissionPercent;
        private BigDecimal brokerCommissionValue;
        private BigDecimal irPercent;
        private BigDecimal irValue;

        public Integer getSalesDeadlineAmount() {
            return salesDeadlineAmount;
        }

        public BigDecimal getIptuMonthlyValue() {
            return iptuMonthlyValue;
        }

        public BigDecimal getCondoMonthlyValue() {
            return condoMonthlyValue;
        }

        public BigDecimal getBrokerCommissionPercent() {
            return brokerCommissionPercent;
        }

        public BigDecimal getBrokerCommissionValue() {
            return brokerCommissionValue;
        }

        public BigDecimal getIrPercent() {
            return irPercent;
        }

        public BigDecimal getIrValue() {
            return irValue;
        }
    }

    public static class SummaryCalculation {
        private BigDecimal totalCostValue;
        private BigDecimal profitPercent;
        private BigDecimal profitMonthlyPercent;
        private BigDecimal profitValue;

        private Integer partners;

        private BigDecimal investedTotalValue;
        private BigDecimal investedDividedByValue;
        private BigDecimal profitDividedByValue;

        public BigDecimal getTotalCostValue() {
            return totalCostValue;
        }

        public BigDecimal getProfitPercent() {
            return profitPercent;
        }

        public BigDecimal getProfitMonthlyPercent() {
            return profitMonthlyPercent;
        }

        public BigDecimal getProfitValue() {
            return profitValue;
        }

        public Integer getPartners() {
            return partners;
        }

        public BigDecimal getInvestedTotalValue() {
            return investedTotalValue;
        }

        public BigDecimal getInvestedDividedByValue() {
            return investedDividedByValue;
        }

        public BigDecimal getProfitDividedByValue() {
            return profitDividedByValue;
        }
    }

    private final ObjectId id;
    private final String description;

    private BigDecimal firstValue;
    private BigDecimal firstDate;
    private BigDecimal secondValue;
    private BigDecimal secondDate;

    private BigDecimal marketValue;

    private BigDecimal maxAuctionValue;

    private BigDecimal roi;

    private Boolean installments;

    private AuctionType type;

    private BigDecimal iptu;

    private BigDecimal condo;

    private Boolean calcIR;

    private String obs;

    private String link;

    private List<ObjectId> participants;

    public Auction(ObjectId id, String description) {
        this.id = id;
        this.description = description;
    }

    public ObjectId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getFirstValue() {
        return firstValue;
    }

    public BigDecimal getFirstDate() {
        return firstDate;
    }

    public BigDecimal getSecondValue() {
        return secondValue;
    }

    public BigDecimal getSecondDate() {
        return secondDate;
    }

    public BigDecimal getMarketValue() {
        return marketValue;
    }

    public BigDecimal getMaxAuctionValue() {
        return maxAuctionValue;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public Boolean getInstallments() {
        return installments;
    }

    public AuctionType getType() {
        return type;
    }

    public BigDecimal getIptu() {
        return iptu;
    }

    public BigDecimal getCondo() {
        return condo;
    }

    public Boolean getCalcIR() {
        return calcIR;
    }

    public String getObs() {
        return obs;
    }

    public String getLink() {
        return link;
    }

    public List<ObjectId> getParticipants() {
        return participants;
    }
}
