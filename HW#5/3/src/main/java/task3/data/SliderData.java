package task3.data;

/**
 * Кнопки слайдера на странице
 */
public enum SliderData {

    Previous("previous"),
    Next("next");

    private final String name;

    SliderData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}