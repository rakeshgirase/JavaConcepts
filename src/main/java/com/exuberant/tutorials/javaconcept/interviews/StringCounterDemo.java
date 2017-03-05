package com.exuberant.tutorials.javaconcept.interviews;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class StringCounterDemo {
    public static void main(String[] args) {
        String sentense = "My Rakesh Rakesh Rakesh Again Hello Again Hello Hello Hello Rakesh Rakesh Hello Rakesh Again Again Again Again";
        StringTokenizer st = new StringTokenizer(sentense, " ");
        Set<StringCounter> container = new HashSet<StringCounter>();
        while (st.hasMoreElements()) {
            String str = st.nextElement().toString();
            StringCounter sc = new StringCounter(str);
            if (container.contains(sc)) {
                System.out.println("changed");
                sc = getDataFromSet(container, sc);
                sc.increment();
            } else {
                System.out.println("Added");
                container.add(sc);
            }
        }
        Set<StringCounter> sortedContainer = new TreeSet<StringCounter>();
        sortedContainer.addAll(container);
        for (StringCounter sc : sortedContainer) {
            System.err.println(sc);
        }
        /*Set<StringCounter> sortedContainer = new TreeSet<StringCounter>();
		sortedContainer.addAll(container);
		for(StringCounter sc:sortedContainer){
			System.out.println(sc);
		}
		Set<StringCounter> scs = new TreeSet<StringCounter>();
		scs.add(new StringCounter("Rakesh", 5));
		scs.add(new StringCounter("akesh", 9));
		scs.add(new StringCounter("Nakesh", 4));
		scs.add(new StringCounter("makesh", 15));
		for(StringCounter sc:scs){
			System.err.println(sc);
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
