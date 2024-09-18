package PrototypeDesignPattern.assignment3;

public interface ConfigurationPrototypeRegistry {
    void addPrototype(Configuration user);
    Configuration getPrototype(ConfigurationType type);
    Configuration clone(ConfigurationType type);
}
