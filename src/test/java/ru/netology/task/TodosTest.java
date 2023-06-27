package ru.netology.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");


        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_2() {
        Task task = new Task(1);
        SimpleTask simpleTask = new SimpleTask(10, "Энциклопедия животные");

        String[] subtasks = {"Энциклопедия птицы", "Словарь анг", "Знать язык"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                57,
                "Энциклопедия мира",
                "Архаизм",
                "01.09.1944"
        );
        Todos todos = new Todos();

        todos.add(task);
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, true, true, true};
        boolean[] actual = new boolean[4];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Энциклопедия");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_3() {
        SimpleTask simpleTask = new SimpleTask(10, "Пособие  животные");

        String[] subtasks = {"Бизнес с нуля", "Отправить письмо", "Позвонить коллеге"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                100,
                "Английская схема",
                "Обновление ПО",
                "27.06.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        boolean[] expected = {false, false, false};
        boolean[] actual = new boolean[3];

        Task[] arrayTask = todos.findAll();

        for (int i = 0; i < arrayTask.length; i++) {
            actual[i] = arrayTask[i].matches("Верификация");
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_4() {
        SimpleTask simpleTask = new SimpleTask(1, "Энциклопедия животные");

        String[] subtasks = {"Энциклопедия птицы", "Словарь анг", "Знать язык"};
        Epic epic = new Epic(60, subtasks);

        Meeting meeting = new Meeting(
                57,
                "Энциклопедия мира",
                "Архаизм",
                "01.09.1944"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Энциклопедия");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_5() {
        SimpleTask simpleTask = new SimpleTask(10, "Пособие животное");

        String[] subtasks = {"Бизнес с нуля", "Отправить письмо", "Позвонить коллеге"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                100,
                "Английская схема",
                "Обновление ПО",
                "07.06.2023"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Верификация");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test_6() {
        Todos todos = new Todos();
        todos.add(new SimpleTask(9, "Подписать договор"));
        todos.add(new Epic(5, new String[]{"Отправить СМС"}));
        Task[] expected = {new SimpleTask(9, "Подписать договор")};
        Task[] actual = todos.search("договор");
        Assertions.assertArrayEquals(expected, actual);
    }
}