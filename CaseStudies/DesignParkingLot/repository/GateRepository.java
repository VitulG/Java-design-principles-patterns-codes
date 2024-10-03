package CaseStudies.DesignParkingLot.repository;

import CaseStudies.DesignParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private final Map<Long, Gate> gateMap;

    public GateRepository() {
        gateMap = new HashMap<>();
        gateMap.put(1L, new Gate());
    }

    public Optional<Gate> getGateById(Long gateId) {
        return Optional.of(gateMap.get(gateId));
    }

    public void saveGate(Gate gate) {
        gateMap.put(gate.getId(), gate);
    }
}
