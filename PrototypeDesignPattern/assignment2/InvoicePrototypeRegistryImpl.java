package PrototypeDesignPattern.assignment2;

import java.util.HashMap;
import java.util.Map;

public class InvoicePrototypeRegistryImpl implements InvoicePrototypeRegistry {
    private Map<InvoiceType, Invoice> prototypes = new HashMap<>();

    @Override
    public void addPrototype(Invoice user) {
        prototypes.put(user.getType(), user);
    }

    @Override
    public Invoice getPrototype(InvoiceType type) {
        return prototypes.get(type);
    }

    @Override
    public Invoice clone(InvoiceType type) {
        return prototypes.get(type).cloneObject();
    }
}
