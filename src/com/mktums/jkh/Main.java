package com.mktums.jkh;

import com.mktums.jkh.utils.Pair;

import java.util.*;


public class Main {
    private static User[] users = new User[]{
            new User("Галя", new HashMap<>() {{
                put("hvs", Pair.of(4, .7));
                put("vodootvod", Pair.of(4, .7));
                put("gvs", Pair.of(4, .7));
                put("heating", Pair.of(4, .5));
                put("remont", Pair.of(4, .5));
                put("naem", Pair.of(4, .5));
                put("radio", Pair.of(4, 1.));
                put("domophone", Pair.of(4, 1.));
                put("electricity", Pair.of(4, 1.));
                put("phone", Pair.of(1, 1.));
                put("internet", Pair.of(1, 1.));
            }}),
            new User("Миша", new HashMap<>() {{
                put("hvs", Pair.of(1, 1.));
                put("vodootvod", Pair.of(1, 1.));
                put("gvs", Pair.of(1, 1.));
                put("heating", Pair.of(1, .5));
                put("remont", Pair.of(1, .5));
                put("naem", Pair.of(1, .5));
                put("radio", Pair.of(1, 1.));
                put("domophone", Pair.of(1, 1.));
                put("electricity", Pair.of(1, 1.));
                put("phone", Pair.of(0, 1.));
                put("internet", Pair.of(0, 1.));
            }}),
            new User("Папа", new HashMap<>() {{
                put("hvs", Pair.of(1, 0.7));
                put("vodootvod", Pair.of(1, .7));
                put("gvs", Pair.of(1, .7));
                put("heating", Pair.of(1, .7));
                put("remont", Pair.of(1, .7));
                put("naem", Pair.of(1, .7));
                put("radio", Pair.of(1, .7));
                put("domophone", Pair.of(1, .7));
                put("electricity", Pair.of(1, .7));
                put("phone", Pair.of(1, .7));
                put("internet", Pair.of(1, .7));
            }})
    };

    private static LinkedHashMap<String, Service> serviceList = new LinkedHashMap<>() {{
        put("hvs", new Service("ХВС КПУ"));
        put("vodootvod", new Service("Водоотвод"));
        put("gvs", new Service("ГВС КПУ"));
        put("heating", new Service("Обогрев"));
        put("remont", new Service("Ремонт"));
        put("naem", new Service("Наем"));
        put("radio", new Service("Радио"));
        put("domophone", new Service("Домофон"));
        put("electricity", new Service("Электричество"));
        put("phone", new Service("Телефон"));
        put("internet", new Service("Интернет"));
    }};

    public static void main(String[] args) {
        HashMap<String, Double> data = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<String, Service> service : serviceList.entrySet()) {
            System.out.print(service.getValue().getName() + ": ");
            data.put(service.getKey(), scanner.nextDouble());
        }

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            String service_name = entry.getKey();
            Double total_value = entry.getValue();
            Double share_sum = total_value / Arrays.stream(users).mapToDouble(
                    user -> user.getMetrics().get(service_name)
            ).sum();

            for (User user : users) {
                user.result += user.getMetrics().get(service_name) * share_sum;
            }
        }

        System.out.println("\n");

        for (User user : users) {
            System.out.println(user.name + ": " + (int) Math.ceil(user.result));
        }
    }
}
