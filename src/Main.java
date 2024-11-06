import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Notebook model = new NotebookImpl();
        NotebookView view = new NotebookViewImpl();
        NotebookPresenter presenter = new NotebookPresenterImpl(model, view);

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.println("Введите команду: (add, show, day, week, save, load, exit)");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    LocalDateTime dateTime = null;
                    while (dateTime == null) {
                        System.out.println("Введите дату и время (yyyy-MM-dd HH:mm):");
                        try {
                            dateTime = LocalDateTime.parse(scanner.nextLine(), dateTimeFormatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Неверный формат даты и времени. Попробуйте еще раз.");
                        }
                    }
                    System.out.println("Введите описание:");
                    String description = scanner.nextLine();
                    presenter.addNote(dateTime, description);
                    break;
                case "show":
                    presenter.showNotes();
                    break;
                case "day":
                    LocalDate date = null;
                    while (date == null) {
                        System.out.println("Введите дату (yyyy-MM-dd):");
                        try {
                            date = LocalDate.parse(scanner.nextLine(), dateFormatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Неверный формат даты. Попробуйте еще раз.");
                        }
                    }
                    presenter.showNotesForDay(date);
                    break;
                case "week":
                    LocalDate weekDate = null;
                    while (weekDate == null) {
                        System.out.println("Введите дату (yyyy-MM-dd):");
                        try {
                            weekDate = LocalDate.parse(scanner.nextLine(), dateFormatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Неверный формат даты. Попробуйте еще раз.");
                        }
                    }
                    presenter.showNotesForWeek(weekDate);
                    break;
                case "save":
                    System.out.println("Введите имя файла для сохранения:");
                    String saveFile = scanner.nextLine();
                    presenter.saveToFile(saveFile);
                    break;
                case "load":
                    System.out.println("Введите имя файла для загрузки:");
                    String loadFile = scanner.nextLine();
                    presenter.loadFromFile(loadFile);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }
}