//package com.springbootblog.command;
//
//import org.reflections.Reflections;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
//@Component
////@Profile("!test")
//public class MainRunner implements CommandLineRunner {
//
//    private final String MODUL_NAME = "com.springbootblog.command";
//
//    Logger logger = LoggerFactory.getLogger(MainRunner.class);
//
//    @Override
//    public void run(String... args) throws Exception {
//        Reflections reflections    = new Reflections(MODUL_NAME);
//        Map<String, String> config = new HashMap<>();
//        Scanner scanner            = new Scanner(System.in);
//
//        Set<Class<? extends Command>> commands = reflections.getSubTypesOf(Command.class);
//
//        for (Class<? extends Command> command : commands) {
//            Object objectToInvokeOn = command.getConstructor().newInstance();
//            command.getMethod("configure", HashMap.class).invoke(objectToInvokeOn, (HashMap) config);
//        }
//
//        System.out.println(Arrays.toString(config.keySet().toArray()));
//        System.out.println("choice:");
//        String choice = scanner.next();
//
//        if (config.containsKey(choice)) {
//            for (Class<? extends Command> command : commands) {
//                if(command.getName().equals(MODUL_NAME + choice)) {
//                    Object objectToInvokeOn = command.getConstructor().newInstance();
//                    command.getMethod("execute", Object.class).invoke(objectToInvokeOn, (Object) args);
//                    break;
//                }
//            }
//        }
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("TestDataBuilder");
//        System.out.println("\n");
//        System.out.println("choice:");
//        String choice = scanner.next();
//
//        if ("TestDataBuilder".equals(choice)) {
//            (new TestDataBuilder()).execute();
//        }
//    }
//}
