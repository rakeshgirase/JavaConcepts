package com.exuberant.tutorials.javaconcept.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class StringCounterDemo {
    
    private static Logger logger = LoggerFactory.getLogger(StringCounterDemo.class);

    public static void main(String[] args) {
        String sentence = "My Rakesh Rakesh Rakesh Again Hello Again Hello Hello Hello Rakesh Rakesh Hello Rakesh Again Again Again Again";
        StringTokenizer st = new StringTokenizer(sentence, " ");
        Set<StringCounter> container = new HashSet<>();
        while (st.hasMoreElements()) {
            String str = st.nextElement().toString();
            StringCounter sc = new StringCounter(str);
            if (container.contains(sc)) {
                logger.info("changed");
                sc = getDataFromSet(container, sc);
                sc.increment();
            } else {
                logger.info("Added");
                container.add(sc);
            }
        }
        Set<StringCounter> sortedContainer = new TreeSet<>();
        sortedContainer.addAll(container);
        for (StringCounter sc : sortedContainer) {
            logger.info(String.valueOf(sc));
        }
        /*Set<StringCounter> sortedContainer = new TreeSet<StringCounter>();
		sortedContainer.addAll(container);
		for(StringCounter sc:sortedContainer){
			logger.info(sc);
		}
		Set<StringCounter> scs = new TreeSet<StringCounter>();
		scs.add(new StringCounter("Rakesh", 5));
		scs.add(new StringCounter("akesh", 9));
		scs.add(new StringCounter("Nakesh", 4));
		scs.add(new StringCounter("makesh", 15));
		for(StringCounter sc:scs){
			logger.info(sc);
		}*/
    }

    static StringCounter getDataFromSet(Set<StringCounter> container, StringCounter data) {
        for (StringCounter sc : container) {
            if (sc.equals(data)) {
                return sc;
            }
        }
        return null;
    }
}
