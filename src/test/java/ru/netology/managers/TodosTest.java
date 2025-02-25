package ru.netology.managers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {

    @Test  // Добавление в список задач разных типов
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test  // Один запрос из списка подходит
    public void shouldReturnArrayTasksWithSuitableQueryOne() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test  // Все запросы из списка подходит
    public void shouldReturnArrayTasksWithSuitableQueryAll() {
        SimpleTask simpleTask = new SimpleTask(5, "Запрос");
        SimpleTask simpleTask1 = new SimpleTask(3, "Запрос");
        SimpleTask simpleTask2 = new SimpleTask(4, "Запрос");

        String[] subtasks = {"Запрос", "Запрос", "Запрос"};
        Epic epic = new Epic(55, subtasks);
        Epic epic1 = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Запрос",
                "Приложение Запрос",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(epic1);
        todos.add(meeting);

        Task[] expected = {simpleTask, simpleTask1, simpleTask2, epic, epic1, meeting};
        Task[] actual = todos.search("Запрос");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test  // Нет подходящих запросов из списка
    public void shouldReturnArrayTasksWithSuitableQueryNull() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("privet");
        Assertions.assertArrayEquals(expected, actual);
    }

}
