import java.time.LocalDate;
import java.time.LocalDateTime;

public interface NotebookPresenter {
    void addNote(LocalDateTime dateTime, String description);
    void showNotes();
    void showNotesForDay(LocalDate date);
    void showNotesForWeek(LocalDate date);
    void saveToFile(String filename);
    void loadFromFile(String filename);
}
