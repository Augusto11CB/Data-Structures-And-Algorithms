package com.buenosdev;

public enum GridPosition {
    GREEN,
    YELLOW,
    EMPTY;

    public static String getIdPostion(int position) {
        if (GridPosition.EMPTY.ordinal() == position) return "E";
        else if (GridPosition.GREEN.ordinal() == position) return "G";
        else if (GridPosition.YELLOW.ordinal() == position) return "Y";
        throw new RuntimeException("Invalid Position");
    }
}