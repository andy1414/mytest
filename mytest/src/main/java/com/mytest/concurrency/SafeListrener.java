package com.mytest.concurrency;

/**
 * Created by admin on 2016/6/12.
 */
public class SafeListrener {
    private final EventListener listener;

    private SafeListrener() {
        listener = new EventListener() {
            public void onEvent(Event event) {
                System.out.println(event.getClass().getName());
            }
        };
    }

    public static SafeListrener newInstance(EventSource source){
        SafeListrener safe = new SafeListrener();
        source.registerListener(safe.listener);
        return safe;
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }
}
