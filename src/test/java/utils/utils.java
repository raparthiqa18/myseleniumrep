package utils;

public class utils {
    public static long getTimestamp(){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long unixTime = System.currentTimeMillis() / 1000L;
        System.out.println(unixTime);

        return unixTime;
    }

}
