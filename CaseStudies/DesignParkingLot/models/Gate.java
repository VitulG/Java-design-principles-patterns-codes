package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.enums.GateStatus;
import CaseStudies.DesignParkingLot.enums.GateType;

public class Gate extends BaseModel {
    private Long gateNumber;
    private GateType gateType;
    private Operator gateOperator;
    private GateStatus gateStatus;

    public Long getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Long gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getGateOperator() {
        return gateOperator;
    }

    public void setGateOperator(Operator gateOperator) {
        this.gateOperator = gateOperator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
