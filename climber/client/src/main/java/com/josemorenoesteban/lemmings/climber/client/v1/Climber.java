package com.josemorenoesteban.lemmings.climber.client.v1;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public interface Climber {
    static Climber of() {
        Iterator<Climber> servicesIterator = ServiceLoader.load(Climber.class).iterator();
        if (servicesIterator.hasNext()) {
            return servicesIterator.next();
        } else {
            throw new RuntimeException(String.format("%s implementation not found", Climber.class.getName()));
        }
    }
    
    static String getSpec() { return "1.0.0-SNAPSHOT"; }
    String  getVersion();

    Climber question(final String question);
    Climber start(final int position);
    Climber size(final int size);
    List<String> invoke();
}
