package com.example.demo.util;

public class MemoryHelper {

    private MemoryHelper(){

    }
    public static String info(){

        final StringBuilder sb = new StringBuilder();
        //Getting the runtime reference from system
        final Runtime runtime = Runtime.getRuntime();

        int MB = 1024*1024;

        //Print used memory
        sb.append("Memory>");
        sb.append(" Used:").append((runtime.totalMemory() - runtime.freeMemory()) / MB);

        //Print free memory
        sb.append(" Free:").append(runtime.freeMemory() / MB);

        //Print total available memory
        sb.append(" Total:").append(runtime.totalMemory() / MB);

        //Print Maximum available memory
        sb.append(" Max:").append(runtime.maxMemory() / MB);

        return sb.toString();
    }
}
