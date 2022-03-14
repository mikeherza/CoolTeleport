package PluginTest555;


import java.util.*;

public class Permissions {
   static List<String> Admin = new ArrayList<String>();
   static List<String> LowerClass = new ArrayList<String>();



    public static String checkPerms(String name){
        String permCheck = "false";

            for (int i = 0; i < Admin.size(); i++ ) {
                if (name.toLowerCase().equalsIgnoreCase(Admin.get(i))) {
                    permCheck = "admin";
                    return permCheck;
                }
            }

            for (int i = 0; i < LowerClass.size(); i++ ) {
                if (name.toLowerCase().equalsIgnoreCase(LowerClass.get(i))) {
                    permCheck = "lowerclass";
                    return permCheck;
                }
            }

        return permCheck;
    }


    public static void addPerson(String name, String rank){
        if (rank.equalsIgnoreCase("admin")) {
            Admin.add(name);
        }

        if (rank.equalsIgnoreCase("lowerclass")) {
            LowerClass.add(name);

        }

    }

}
