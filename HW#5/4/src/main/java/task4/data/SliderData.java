package task4.data;

/**
 * Кнопки "Влево" и "Вправо" слайдера
 */
public enum SliderData {
    Left("Left"),
    Right("Right");

    private final String name;

    SliderData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}