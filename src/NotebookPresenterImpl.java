import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotebookPresenterImpl implements NotebookPresenter {
    private Notebook model;
    private NotebookView view;

    public NotebookPresenterImpl(Notebook model, NotebookView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void addNote(LocalDateTime dateTime, String description) {
        model.addNote(new NoteImpl(dateTime, description));
        view.displayMessage("Запись добавлена.");
    }

    @Override
    public void showNotes() {
        view.displayNotes(model.getNotes());
    }

    @Override
    public void showNotesForDay(LocalDate date) {
        view.displayNotes(model.getNotesForDay(date));
    }

    @Override
    public void showNotesForWeek(LocalDate date) {
        view.displayNotes(model.getNotesForWeek(date));
    }

    @Override
    public void saveToFile(String filename) {
        model.saveToFile(filename);
        view.displayMessage("Записи сохранены в файл.");
    }

    @Override
    public void loadFromFile(String filename) {
        model.loadFromFile(filename);
        view.displayMessage("Записи загружены из файла.");
    }
}

