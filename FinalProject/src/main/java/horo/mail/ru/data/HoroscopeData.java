package horo.mail.ru.data;
/**
 * Необходимые константы
 */
public enum HoroscopeData {
    listOpen(" dropdown_active"),
    listclose(""),
    three("3"),
    listRuneStatic(""),
    listRuneDynamicBefore(" p-outside-block__content_dynamic js-dynamic"),
    listRuneDynamicAfter(" js-dynamic");

    private final String name;

    HoroscopeData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}