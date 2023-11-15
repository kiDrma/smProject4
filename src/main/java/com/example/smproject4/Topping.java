package com.example.smproject4;

public enum Topping {
    SAUSAGE,
    PEPPERONI,
    GREEN_PEPPER,
    ONION,
    MUSHROOM,
    HAM,
    BLACK_OLIVE,
    BEEF,
    SHRIMP,
    SQUID,
    CRAB_MEATS,
    BANANAS,
    ICE_CREAM; // add two more there needs to be 13?

    public static Topping getToppingFromName(String toppingName) {
        String upperCasedName = toppingName.toUpperCase();
        switch (upperCasedName){
            default: return null;
            case "SQUID": return SQUID;
            case "CRAB MEAT": return CRAB_MEATS;
            case "BANANAS": return BANANAS;
            case "ICE CREAM": return ICE_CREAM;
            case "HAM": return HAM;
            case "BLACK OLIVES": return BLACK_OLIVE;
            case "BEEF": return BEEF;
            case "SHRIMP": return SHRIMP;
            case "MUSHROOM": return MUSHROOM;
            case "SAUSAGE": return SAUSAGE;
            case "PEPPERONI": return PEPPERONI;
            case "GREEN PEPPER": return GREEN_PEPPER;
            case "ONION": return ONION;
        }
    }
}
