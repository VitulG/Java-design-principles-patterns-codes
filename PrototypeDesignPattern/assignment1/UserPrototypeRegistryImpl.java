package PrototypeDesignPattern.assignment1;

import java.util.HashMap;
import java.util.Map;

public class UserPrototypeRegistryImpl implements UserPrototypeRegistry {
    private Map<UserType, User> map = new HashMap<UserType, User>();

    @Override
    public void addPrototype(User user) {
        map.put(user.getType(), user);
    }

    @Override
    public User getPrototype(UserType type) {
        return map.get(type);
    }

    @Override
    public User clone(UserType type) {
        return map.get(type).cloneObject();
    }
}
