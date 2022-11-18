package uz.pdp.enums;

public enum Season implements Russian{
    WINTER("Qish"),
    SPRING("Bahor"),
    SUMMER("Yoz"),
    AUTUMN("Kuz");
    String nameUz;

    Season(String nameUz) {
        this.nameUz = nameUz;
    }

    public String getNameUz() {
        return nameUz;
    }

    public void setNameUz(String nameUz) {
        this.nameUz = nameUz;
    }

    @Override
    public String nameRu() {
        String ru=switch (this){
            case WINTER -> "Zima";
            case SPRING -> "Vesna";
            case SUMMER -> "Leto";
            case AUTUMN -> "Osen";
            default -> null;
        };
        return ru;
    }
}
