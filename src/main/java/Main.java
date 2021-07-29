public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        mom.happyBirthday();
        son.happyBirthday();

        try {
            // Не хватает обязательных полей
            Person sister = new PersonBuilder()
                    .setName("Маша")
                    .setAge(18)
                    .build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            Person brother = new PersonBuilder()
                    .setName("Николай")
                    .setSurname("Николаев")
                    .setAge(-100)
                    .build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}