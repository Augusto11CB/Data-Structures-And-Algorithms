package com.buenosdev;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OCM {
    public int solution(String[] visits) {
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < days.length; i++) {
            map.put(days[i], i);
        }

        int count = 0;
        int curWeedId = -1;

        for (String visit : visits) {
            int curDay = map.get(visit);

            if (curWeedId == -1 || curDay <= curWeedId) {
                count++;
                curWeedId = curDay;
            }
        }

        return count;
    }

    public Event read(Long eventId) throws Exception {
        List<Event> events = new ArrayList<>();
        return events.stream()
                .filter(event -> event.id.equals(eventId))
                .findFirst().orElse(null);
    }



    public class Event {
         Long id;
         String name;
         String description;
         LocalDateTime start;
         LocalDateTime end;
    }

}
