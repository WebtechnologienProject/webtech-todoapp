package de.htwberlin.webtechtodoapp.entities;

public enum Category {
    MY_DAY("My day"),
    DRINGEND_UND_WICHTIG("Urgent and Important"),
    DRINGEND_UND_UNWICHTIG("Urgent and not important"),
    NICHT_DRINGEND_UND_WICHTIG("Not urgent and important"),
    NICHT_DRINGEND_UND_NICHT_WICHTIG("Not urgent and not important");

    private String textOfCategory;

    Category(String textOfCategory) {
        this.textOfCategory = textOfCategory;
    }

    public String getTextOfCategory() {
        return textOfCategory;
    }

    public static Category fromString(String textOfCategory) {
        for(Category c : Category.values()) {
            if(c.textOfCategory.equalsIgnoreCase(textOfCategory)){
                return c;
            }
        }
        return null;
    }
}
