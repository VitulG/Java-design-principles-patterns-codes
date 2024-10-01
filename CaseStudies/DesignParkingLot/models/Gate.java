package CaseStudies.DesignParkingLot.models;

import CaseStudies.DesignParkingLot.enums.GateStatus;
import CaseStudies.DesignParkingLot.enums.GateType;

public class Gate {
    private Long gateId;
    private Long gateNumber;
    private GateType gateType;
    private Operator gateOperator;
    private GateStatus gateStatus;

}
